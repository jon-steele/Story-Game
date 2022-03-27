package performers;

import logic.Random;
/**
 * the Cyclopes is a big brute with one eye. They have lots of hitPoints, but damage low
 * @author Jon Steele
 *
 */
public class Cyclopes extends Monster{
	/**
	 * Cyclopes's have lots of health, average attack
	 * Constructor passes through hitpoints and strength to superclass constructor
	 */
		public Cyclopes() {
			// *If* you call the superclass constructor, make sure you call it first.
			super(
				15,  // hitPoints
				8 // strength
			);
			// Then initialize other variables after...
		}
		/**
		 * constructor class, including a variable instanceOf to distinguish between duplicate monsters
		 * 
		 * @param instanceOf
		 * the number of the monster
		 */
		public Cyclopes(int instanceOf) {
			// *If* you call the superclass constructor, make sure you call it first.
			super(
				15,  // hitPoints
				8,
				instanceOf// strength
			);
			// Then initialize other variables after...
		}
		
		/**
		 * A basic attack for the Cyclopes type of monster.
		 * 
		 * @param plyr
		 *   The person the user is using to play the game.
		 * 
		 * @return
		 *   An array of strings, describing the results of a Cyclopes attack on the player.
		 */
		@Override
		public String[] attack(Player plyr) {
			plyr.damageHitPoints(Random.rand(strength));
			return new String[] { "Cyclopes attacked you for " + strength + " damage!" };
		}
		
		/**
		 * A more descriptive result to go along with a Cyclopes's unique spell (or ability) to cast.
		 * 
		 * @param plyr
		 *   The person the user is using to play the game.
		 * 
		 * @return
		 *   An array of strings, describing the results of a Cyclopes's spell on the player.
		 */
		@Override
		public String[] castSpell(Player plyr) {
			plyr.damageHitPoints(4);
			return new String[] {
				"A Cyclopes coils back then throws a haymaker!",
				"The punch throws you onto the ground, taking " + 4 + " damage!"
			};
		}
		
		/**
		 * The Cyclopes only gains 1 health from defending
		 * 
		 * @return String[] containing info on the defend
		 */
		@Override
		public String[] defend() {
			hitPoints = hitPoints + 1;
			return new String[] {"The Cyclops raises its arms in defense!",
								 "It gains 1 points of health in anticipation of your attack"};
		};
		
		/**
		 * Get a Cyclopes description.
		 * 
		 * @return
		 *   A short phrase describing a Cyclopes. You could randomize descriptions
		 *   to be unique for different instances in different ways.
		 */
		@Override
		public String getDescription() {
			return getInstance() + " Cyclopes";
		}
}
