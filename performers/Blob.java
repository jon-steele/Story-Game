package performers;

import logic.Random;

/**
 * A Blob is a green ball of goo. They widely vary, the strongest can have hitpoints and strength of 11, and the weakest 
 * can have hitpoints and strength of 1 and 1
 */
public class Blob extends Monster {
	
	/**
	 * To create a Blob, the superclass constructor is called.
	 * 
	 */
	public Blob() {
		super(
			Random.rand(10) + 1,  // hitPoints
			Random.rand(10) + 1 // strength
		);
	}
	/**
	 * constructor class, including a variable instanceOf to distinguish between duplicate monsters
	 * 
	 * @param instanceOf
	 * the number of the monster
	 */
	public Blob(int instanceOf) {
		super(
			Random.rand(10) + 1,  // hitPoints
			Random.rand(10) + 1,
			instanceOf// strength
		);
	}
	
	/**
	 * A basic attack for the Blob type of monster.
	 * 
	 * @param plyr
	 *   The person the user is using to play the game.
	 * 
	 * @return
	 *   An array of strings, describing the results of a Blob attack on the player.
	 */
	@Override
	public String[] attack(Player plyr) {
		plyr.damageHitPoints(strength);
		return new String[] { "Blob attacked you for " + strength + " damage!" };
	}
	
	/**
	 * A more descriptive result to go along with a Blob's unique spell to cast.
	 * 
	 * @param plyr
	 *   The person the user is using to play the game.
	 * 
	 * @return
	 *   An array of strings, describing the results of a Blob spell on the player.
	 */
	@Override
	public String[] castSpell(Player plyr) {
		plyr.damageHitPoints(4);
		return new String[] {
			"A Blob pulses with what seems like excitement and unleashes a blast of energy!",
			"The blast of energy waves over you, and you take " + 4 + " damage!"
		};
	}
	
	@Override
	public String[] defend() {
		hitPoints = hitPoints + 3;
		return new String[] {"The Blob compacts itself to defend an attack",
							 "It gains 3 points of health in anticipation of your attack"};
	};
	
	/**
	 * Get a Blob description.
	 * 
	 * @return
	 *   A short phrase describing a Blob. You could randomize descriptions
	 *   to be unique for different instances in different ways.
	 */
	@Override
	public String getDescription() {
		return getInstance() + " Blob";
	}
}