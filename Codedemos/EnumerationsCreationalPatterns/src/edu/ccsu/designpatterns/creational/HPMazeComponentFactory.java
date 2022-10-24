package edu.ccsu.designpatterns.creational;

import java.util.List;

/**
 * Example concrete factory of Abstract Factory
 * @author Chad Williams
 */
public class HPMazeComponentFactory implements MazeComponentFactory {
	public Wall makeWall() {
		return new HPWall();
	}

	public Door makeDoor(List<? extends Room> rooms) {
		return new MagicDoor(rooms);
	}

	@Override
	public Room makeRoom(int roomNumber) {
		return new HPRoom(roomNumber);
	}
}
