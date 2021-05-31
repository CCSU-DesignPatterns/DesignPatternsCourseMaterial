/**
 * 
 */
package edu.ccsu.designpatterns.statetabledemo;

/**
 * Demo of State pattern using lookup table for transitions
 * 
 * @author Chad Williams
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Load the state table
		try {
			String stateTableMapFilename = "src/resources/StateTableMap.csv";
			BaseLightState.loadLookupMap(stateTableMapFilename);
		}catch(Exception e) {
			System.err.println("Problem loading StateTableMap.csv, will use a default table");
			e.printStackTrace();
		}
		
		// Demo the lights
		ProgrammableLights lights = new ProgrammableLights();
		lights.click();
		lights.click();
		lights.click();
		lights.click();
		lights.doubleClick();
		lights.doubleClick();

	}

}
