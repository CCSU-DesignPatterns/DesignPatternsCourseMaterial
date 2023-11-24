/**
 * An example of the Observer patterns inspired by
 * https://plantsvszombies.fandom.com/wiki/Plants_vs._Zombies_Heroes
 * 
 * The set up is there are plants and zombies on the board the game is the subject and it can be
 * observed for Attack, Bonus Attack, and Destroyed events.
 * 
 * The way this game works is the game iterates through the game pieces tells them to do actions.
 * When a plant does an action it attacks a random zombie, and when a zombie does an action it
 * attacks a random plant.
 * 
 * Plants have a special type of plant RepeatShooter that after attacking will do a bonus attack.
 * 
 * Zombies have a special type of zombie, a Mime, that usually doesn't do a bonus attack, but if it
 * observes a bonus attack it will do a bonus attack. However, to prevent an infinite loop it does a
 * bonus attack for anything that does a bonus attack EXCEPT another Mime.
 */
package edu.ccsu.designpatterns.pvz;
