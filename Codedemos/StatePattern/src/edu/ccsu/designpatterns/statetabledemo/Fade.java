/**
 * 
 */
package edu.ccsu.designpatterns.statetabledemo;

/**
 * @author cw1491
 *
 */
class Fade extends BaseLightState {
	public Fade(){
		super();
	}
	
	protected void activate(ProgrammableLights lights) {
		System.out.println("Fade");
		try {
			for (int i=100;i>=0;i--) {
				lights.setLightBrightness(i);
				Thread.sleep(10);
			}
		}catch(InterruptedException ie) {
			lights.setLightBrightness(0);
		}
		
	}
}
