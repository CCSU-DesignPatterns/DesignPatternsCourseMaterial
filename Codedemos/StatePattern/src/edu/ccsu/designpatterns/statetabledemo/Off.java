package edu.ccsu.designpatterns.statetabledemo;

/**
 * @author cw1491
 *
 */
class Off extends BaseLightState {
	public Off(){
		super();
	}
	
	protected void activate(ProgrammableLights lights) {
		System.out.println("Off");
		lights.setLightBrightness(0);
	}
}
