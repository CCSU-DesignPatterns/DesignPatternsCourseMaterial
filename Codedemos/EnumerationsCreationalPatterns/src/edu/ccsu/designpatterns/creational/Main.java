package edu.ccsu.designpatterns.creational;

/**
 * Demo of use of creational patterns
 */
public class Main {
  public static void main(String[] args){
    MazeCreator mazeCreator = new CODMazeCreator();
    Maze maze = mazeCreator.createMaze();
    System.out.println(maze.toString());

    mazeCreator = new HPMazeCreator();
    maze = mazeCreator.createMaze();
    System.out.println(maze.toString());
  }
}
