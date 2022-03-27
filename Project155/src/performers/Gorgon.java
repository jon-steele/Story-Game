package performers;

import logic.Random;
/**
 * A gorgon is a female monster with snakes for hair. They have 10 hitpoints, and their 
 * strength varies from 5-9
 * @author Jon Steele
 *
 */
public class Gorgon extends Monster{
		
	public Gorgon() {
			super(
				10,  // hitPoints
				(Random.rand(4)+5) // strength
			);
		}
	/**
	 * constructor class, including a variable instanceOf to distinguish between duplicate monsters
	 * 
	 * @param instanceOf
	 * the number of the monster
	 */
	public Gorgon(int instanceOf) {
			// *If* you call the superclass constructor, make sure you call it first.
			super(
				10,  // hitPoints
				(Random.rand(4)+5),
				instanceOf// strength
			);
			// Then initialize other variables after...
		}
		/**
		 * A basic attack for the Gorgon type of monster.
		 * 
		 * @param plyr
		 *   The person the user is using to play the game.
		 * 
		 * @return
		 *   An array of strings, describing the results of a Gorgon attack on the player.
		 */
		@Override
		public String[] attack(Player plyr) {
			plyr.damageHitPoints(strength);
			return new String[] { "Gorgon attacked you for " + strength + " damage!" };
		}
		
		/**
		 * A more descriptive result to go along with a Gorgon's unique spell (or ability) to cast.
		 * 
		 * @param plyr
		 *   The person the user is using to play the game.
		 * 
		 * @return
		 *   An array of strings, describing the results of a Gorgon's spell on the player.
		 */
		@Override
		public String[] castSpell(Player plyr) {
			plyr.damageHitPoints(5);
			return new String[] {
				"The Gorgon's snakes spew acid onto your leg, causing your pants to melt away!",
				"The burning of the acid damages you, and you take " + 5 + " damage!"
			};
		}
		
		/**
		 * The Gorgon gains 2 health from defending
		 * 
		 * @return String[] containing info on the defend
		 */
		@Override
		public String[] defend() {
			hitPoints = hitPoints + 2;
			return new String[] {"The Gorgon coils up in defense",
								 "It gains 2 points of health in anticipation of your attack"};
		};
		
		/**
		 * Get a Gorgon description.
		 * 
		 * @return
		 *   A short phrase describing a Gorgon. You could randomize descriptions
		 *   to be unique for different instances in different ways.
		 */
		@Override
		public String getDescription() {
			return getInstance() + " Gorgon";
		}
	
}
