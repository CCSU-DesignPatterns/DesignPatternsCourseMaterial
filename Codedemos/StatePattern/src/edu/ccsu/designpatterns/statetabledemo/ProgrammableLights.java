/**
 * 
 */
package edu.ccsu.designpatterns.statetabledemo;

/**
 * These lights represent the Context for the State pattern
 * 
 * @author Chad Williams
 *
 */
public class ProgrammableLights {
	private LightState curState = new Off();
	private int lightBrightness = 0;
	
	public ProgrammableLights() {
		
	}
	
	public void click() {
		curState = curState.click(this);
	}
	
	public void doubleClick() {
		curState = curState.doubleClick(this);
	}
	
	void setLightBrightness(int newBrightness) {
		System.out.println("brightness: "+newBrightness);
		this.lightBrightness = newBrightness;
	}
}
