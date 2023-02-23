package performers;

import logic.Random;

/**
 * Everybody knows what a Rat is.
 * The rat's hitpoints vary from 5-9, and their strength is always 4
 */
public class Rat extends Monster {
	
	/**
	 * To create a Rat, the superclass constructor is called to give the rat hitpoints and damage.
	 */
	public Rat() {
		super(
			(Random.rand(4)+5),  // hitPoints
			4 // strength
		);
	}
	
	/**
	 * constructor class to pass through stats, including a variable instanceOf to distinguish between duplicate monsters
	 * 
	 * @param instanceOf
	 * the number of the monster
	 */
	public Rat(int instanceOf) {
		// *If* you call the superclass constructor, make sure you call it first.
		super(
			(Random.rand(4)+5),  // hitPoints
			4,
			instanceOf// strength
		);
		// Then initialize other variables after...
	}
	
	/**
	 * A basic attack for the Rat type of monster.
	 * 
	 * @param plyr
	 *   The person the user is using to play the game.
	 * 
	 * @return
	 *   An array of strings, describing the results of a Rat attack on the player.
	 */
	@Override
	public String[] attack(Player plyr) {
		plyr.damageHitPoints(strength);
		return new String[] { "Rat attacked you for " + strength + " damage!" };
	}
	
	/**
	 * A more descriptive result to go along with a Rat's unique spell (or ability) to cast.
	 * 
	 * @param plyr
	 *   The person the user is using to play the game.
	 * 
	 * @return
	 *   An array of strings, describing the results of a Rat's spell on the player.
	 */
	@Override
	public String[] castSpell(Player plyr) {
		plyr.damageHitPoints(3);
		return new String[] {
			"A Rat leaps at you and belches stinky fire out of its mouth!",
			"The stench of the fire chokes you, its flames burn you, and you take " + 3 + " damage!"
		};
	}
	
	/**
	 * The Rat gains 2 health from defending
	 * 
	 * @return String[] containing info on the defend
	 */
	@Override
	public String[] defend() {
		hitPoints = hitPoints + 2;
		return new String[] {"The Rat coils up in defense",
							 "It gains 2 points of health in anticipation of your attack"};
	};
	
	/**
	 * Get a Rat description.
	 * 
	 * @return
	 *   A short phrase describing a Rat. You could randomize descriptions
	 *   to be unique for different instances in different ways.
	 */
	@Override
	public String getDescription() {
		return getInstance() + " Rat";
	}
}