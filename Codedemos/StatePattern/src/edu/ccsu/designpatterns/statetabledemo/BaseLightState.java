package edu.ccsu.designpatterns.statetabledemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that provides the logic for all state transitions via lookup table.
 * 
 * @author Chad Williams
 *
 */
abstract class BaseLightState implements LightState {
	/**
	 * Note this particular implementation takes advantage of all state's 
	 * not having any internal state, if internal state was required instead you
	 * could instantiate a new instance each time.
	 */
	private static Map<String, BaseLightState> stateLookupMap = null;
	
	static void loadLookupMap(String csvFilename) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, IllegalArgumentException, SecurityException{
		String line;
        BufferedReader br = new BufferedReader(new FileReader(csvFilename));
        stateLookupMap = new HashMap<String,BaseLightState>();
        // discard header
        br.readLine();
		while ((line = br.readLine()) != null) {
			String[] stateMapEntries = line.split(",");
			String key = stateMapEntries[0]+"-"+stateMapEntries[1];
			BaseLightState state = (BaseLightState)Class.forName(BaseLightState.class.getPackageName()+"."+stateMapEntries[2]).getConstructor().newInstance();
			stateLookupMap.put(key, state);
        }
	}

	BaseLightState() {
		// If the lookup Map hasn't been loaded just put a simple on/off transition in the map
		if (stateLookupMap == null) {
			stateLookupMap = new HashMap<String,BaseLightState>();
			stateLookupMap.put(Off.class.getSimpleName()+"-click", new On());
			stateLookupMap.put(On.class.getSimpleName()+"-click", new Off());
		}
	}

	private BaseLightState getNextState(String event, ProgrammableLights lights) {
		String key = this.getClass().getSimpleName() + "-" + event;
		BaseLightState nextState = this;
		if (stateLookupMap.containsKey(key)) {
			nextState = stateLookupMap.get(key);
		}
		nextState.activate(lights);
		return nextState;
	}

	public LightState click(ProgrammableLights lights) {
		return getNextState("click", lights);
	}

	public LightState doubleClick(ProgrammableLights lights) {
		return getNextState("doubleClick", lights);
	}

	protected abstract void activate(ProgrammableLights lights);
}
