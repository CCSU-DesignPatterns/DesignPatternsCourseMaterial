package edu.ccsu.designpatterns.pvz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Simple game Singleton that keeps track of a list of plants and zombies that can be a subject for
 * observation of game events. When new game pieces are added to the game if they are observers they
 * are added to the list of items observing the game. If the game piece is destroyed it is removed
 * from observing the game events.
 * 
 * @author Chad Williams
 *
 */
public class Game implements GameSubject {
  private Random rand = new Random(128);
  private static Game instance = null;
  private Set<GameEventObserver> observers = null;

  private List<Zombie> zombies = null;
  private List<Plant> plants = null;
  private List<GamePiece> allPieces = null;

  private Game() {
    zombies = new ArrayList();
    plants = new ArrayList();
    allPieces = new ArrayList();
    observers = new HashSet();
  }

  /** Get the instance of the game */
  public static Game getInstance() {
    if (instance == null) {
      instance = new Game();
    }
    return instance;
  }

  /** Add the game piece to the game attaching it as an observer if it is an observer */
  public void addGamePiece(GamePiece piece) {
    if (piece instanceof Zombie) {
      zombies.add((Zombie) piece);
    } else {
      plants.add((Plant) piece);
    }
    allPieces.add(piece);
    if (piece instanceof GameEventObserver) {
      attachObserver((GameEventObserver) piece);
    }
  }

  /** Keep going through all pieces telling them to do actions until one side wins */
  public void playGame() {
    // This set of loops is a bit funky since as the iteration is occuring the list may
    // be mutated by a game piece being destroyed
    while (true) {
      int index = 0;
      while (index < allPieces.size()) {
        GamePiece piece = allPieces.get(index);
        piece.doAction();
        index++;
      }
    }
  }

  /** Game piece attacks a random game piece of the other type (plant/zombie) */
  void attack(GamePiece attacker, int damage) {
    GamePiece target = getTarget(attacker);
    System.out.println(attacker + " attacks " + target);
    target.attacked(damage);
    notify(new Event(attacker, EventType.ATTACK));
  }

  /** Bonus attack is done by the attacker on a random game piece of the other type */
  void bonusAttack(GamePiece attacker, int damage) {
    GamePiece target = getTarget(attacker);
    System.out.println(attacker + " bonus attacks " + target);
    target.attacked(damage);
    notify(new Event(attacker, EventType.BONUS_ATTACK));
  }

  private GamePiece getTarget(GamePiece attacker) {
    GamePiece target = null;
    if (attacker instanceof Zombie) {
      target = plants.get(rand.nextInt(plants.size()));
    } else {
      target = zombies.get(rand.nextInt(zombies.size()));
    }
    return target;
  }

  /**
   * The specified piece has been destroyed so remove it from the game and it no longer should be an
   * observer
   */
  void pieceDestroyed(GamePiece piece) {
    if (piece instanceof GameEventObserver) {
      detachObserver((GameEventObserver) piece);
    }
    allPieces.remove(piece);
    if (piece instanceof Zombie) {
      zombies.remove(piece);
      if (zombies.size() == 0) {
        System.out.println("Plants win!");
        System.exit(0);
      }
    } else {
      plants.remove(piece);
      if (plants.size() == 0) {
        System.out.println("Zombies win!");
        System.exit(0);
      }
    }
    notify(new Event(piece, EventType.DESTROYED));
  }

  @Override
  public void attachObserver(GameEventObserver observer) {
    observers.add(observer);
  }

  @Override
  public void detachObserver(GameEventObserver observer) {
    observers.remove(observer);

  }

  /**
   * This method notifies all Observers of this class which is the Subject in the pattern.
   * 
   * @param event Event that should be broadcast to all Observers
   */
  private void notify(Event event) {
    for (GameEventObserver observer : observers) {
      observer.eventOccurred(event);
    }
  }
}
