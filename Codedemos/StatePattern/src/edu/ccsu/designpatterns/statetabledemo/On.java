/**
 * 
 */
package edu.ccsu.designpatterns.statetabledemo;

/**
 * @author cw1491
 *
 */
class On extends BaseLightState {
	public On(){
		super();
	}

	@Override
	protected void activate(ProgrammableLights lights) {
		System.out.println("On");
		lights.setLightBrightness(100);
	}
}
