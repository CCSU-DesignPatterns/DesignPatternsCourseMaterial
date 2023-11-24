package edu.ccsu.designpatterns.pvz;

/**
 * This demo of the the Observer pattern that occurs in Plants vs Zombies Heroes where one type of
 * zombie (a Mime) observes the game and if any game piece does a bonus attack it mimics it and also
 * carries out a bonus attack
 * 
 * @author Chad Williams
 *
 */
public class Main {

  /**
   * Simple demo of observer pattern inspired by Plants vs Zombies Heroes
   * 
   * @param args No arguments needed
   */
  public static void main(String[] args) {
    Game.getInstance().attachObserver(new ConsoleEventObserver(EventType.DESTROYED));
    Game.getInstance().addGamePiece(new Plant("Pea Shooter1", 1, 1));
    Game.getInstance().addGamePiece(new Mime("Mime1", 4, 2));
    Game.getInstance().addGamePiece(new Plant("Pea Shooter2", 1, 1));
    Game.getInstance().addGamePiece(new Zombie("Zombie1", 1, 1));
    Game.getInstance().addGamePiece(new RepeatShooter("Repeat Shooter", 4, 1));
    Game.getInstance().addGamePiece(new Plant("Pea Shooter3", 1, 1));
    Game.getInstance().addGamePiece(new Plant("Strong Pea Shooter3", 6, 6));
    Game.getInstance().playGame();
  }

}
