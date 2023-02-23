package performers;
import logic.Random;
/**
 * Manticores have high strength, but low hitpoints
 * @author Jon Steele
 *
 */
public class Manticore extends Monster{
	
	/**
	 * Manticores constructor calls superclass constructor to add stats
	 * 
	 */
	public Manticore() {
			super(
				6,  // hitPoints
				Random.rand(4) + 12 // strength
			);
		}
	/**
	 * constructor class to pass through stats, including a variable instanceOf to distinguish between duplicate monsters
	 * 
	 * @param instanceOf
	 * the number of the monster
	 */
	public Manticore(int instanceOf) {
		// *If* you call the superclass constructor, make sure you call it first.
		super(
			6,  // hitPoints
			Random.rand(4) + 12,
			instanceOf// strength
		);
		// Then initialize other variables after...
	}
	
		/**
		 * A basic attack for the Manticore type of monster.
		 * 
		 * @param plyr
		 *   The person the user is using to play the game.
		 * 
		 * @return
		 *   An array of strings, describing the results of a Manticore attack on the player.
		 */
		@Override
		public String[] attack(Player plyr) {
			plyr.damageHitPoints(strength);
			return new String[] { "Manticore attacked you for " + strength + " damage!" };
		}
		
		/**
		 * A more descriptive result to go along with a Manticore's unique spell (or ability) to cast.
		 * 
		 * @param plyr
		 *   The person the user is using to play the game.
		 * 
		 * @return
		 *   An array of strings, describing the results of a Manticore's spell on the player.
		 */
		@Override
		public String[] castSpell(Player plyr) {
			plyr.damageHitPoints(7);
			return new String[] {
				"A Manticore leaps from above, and slashes your chest!",
				"The cut is deep, and begins to seep blood, you take " + 7 + " damage!"
			};
		}
		
		/**
		 * The Manticore gains 1 health from defending
		 * 
		 * @return String[] containing info on the defend
		 */
		@Override
		public String[] defend() {
			hitPoints = hitPoints + 1;
			return new String[] {"The Manticore cowers in defense",
								 "It gains 1 point of health"};
		};
		
		/**
		 * Get a Manticore description.
		 * 
		 * @return
		 *   A short phrase describing a Manticore. You could randomize descriptions
		 *   to be unique for different instances in different ways.
		 */
		@Override
		public String getDescription() {
			return getInstance() + " Manticore";
		}
}
