/**
 * 
 */
package edu.ccsu.designpatterns.statetabledemo;

/**
 * Light state that can be modified by click or double click
 * 
 * @author Chad Williams
 *
 */
public interface LightState {
	public LightState click(ProgrammableLights lights);
	public LightState doubleClick(ProgrammableLights lights);
}
