/**
 * 
 */
package edu.ccsu.designpatterns.statetabledemo;

/**
 * @author cw1491
 *
 */
public class Flashing extends BaseLightState {
	public Flashing(){
		super();
	}
	
	protected void activate(ProgrammableLights lights) {
		System.out.println("Flashing");
		try {
			// Would really want to do this via a separate thread to allow it to continue to blink
			for (int i=0;i<5;i++) {
				lights.setLightBrightness(0);
				Thread.sleep(100);
				lights.setLightBrightness(100);
			}
		}catch(InterruptedException ie) {
			lights.setLightBrightness(100);
		}
		
	}
}
