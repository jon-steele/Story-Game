package performers;

import logic.Random;
	/**
	 * Wolves are quite variable, with hitpoints and strength ranging widely. the strongest possible wolf will have
	 * 11 hitpoints and 9 strength
	 * 
	 * @author Jon Steele
	 */
public class Wolf extends Monster{

	/**
	 * wolf constructor calls on its superclass constructor to randomly generate wolf stats
	 */
	public Wolf() {
			super(
				(Random.rand(5)+6),  // hitPoints
				Random.rand(3)+6 // strength
			);
		}
	/**
	 * constructor class to pass through stats, including a variable instanceOf to distinguish between duplicate monsters
	 * 
	 * @param instanceOf
	 * the number of the monster
	 */
	public Wolf(int instanceOf) {
		// *If* you call the superclass constructor, make sure you call it first.
		super(
			(Random.rand(5)+6),  // hitPoints
			Random.rand(3)+6,
			instanceOf// strength
		);
		// Then initialize other variables after...
	}
		
		/**
		 * A basic attack for the Wolf type of monster.
		 * 
		 * @param plyr
		 *   The person the user is using to play the game.
		 * 
		 * @return
		 *   An array of strings, describing the results of a Wolf attack on the player.
		 */
		@Override
		public String[] attack(Player plyr) {
			plyr.damageHitPoints(strength);
			return new String[] { "Wolf attacked you for " + strength + " damage!" };
		}
		
		/**
		 * A more descriptive result to go along with a Wolf's unique spell (or ability) to cast.
		 * 
		 * @param plyr
		 *   The person the user is using to play the game.
		 * 
		 * @return
		 *   An array of strings, describing the results of a Wolf's spell on the player.
		 */
		@Override
		public String[] castSpell(Player plyr) {
			plyr.damageHitPoints(6);
			return new String[] {
				"A Wolf pounces at your heels, clamping its jaws onto your calf!",
				"You shake it off, but your calf is shot with pain, and you take " + 6 + " damage!"
			};
		}
		
		/**
		 * The Wolf gains 2 health from defending
		 * 
		 * @return String[] containing info on the defend
		 */
		@Override
		public String[] defend() {
			hitPoints = hitPoints + 2;
			return new String[] {"The Wolf growls in defense",
								 "It gains 2 points of health in anticipation of your attack"};
		};
		
		/**
		 * Get a Wolf description.
		 * 
		 * @return
		 *   A short phrase describing a Wolf. You could randomize descriptions
		 *   to be unique for different instances in different ways.
		 */
		@Override
		public String getDescription() {
			return getInstance() + " Wolf";
		}

}
