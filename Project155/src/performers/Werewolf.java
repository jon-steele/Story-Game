package performers;

import logic.Random;
/**
 * Werewolves are rare in the game, they have 30 hitpoints, and their strength is at 15. Their attacks are 
 * random, and could do 1 damage, or 16.
 * @author Jon Steele
 *
 */
public class Werewolf extends Monster{
		
	public Werewolf() {
			super(
				45,  // hitPoints
				15 // strength
			);
				}
		
		/**
		 * A basic attack for the Werewolf type of monster.
		 * 
		 * @param plyr
		 *   The person the user is using to play the game.
		 * 
		 * @return
		 *   An array of strings, describing the results of a Werewolf attack on the player.
		 */
		@Override
		public String[] attack(Player plyr) {
			int attackDamage = Random.rand(strength)+1;
			plyr.damageHitPoints(attackDamage);
			return new String[] { "Werewolf attacked you for " + attackDamage + " damage!" };
		}
		
		/**
		 * A more descriptive result to go along with a Werewolf's unique spell (or ability) to cast.
		 * 
		 * @param plyr
		 *   The person the user is using to play the game.
		 * 
		 * @return
		 *   An array of strings, describing the results of a Werewolf's spell on the player.
		 */
		@Override
		public String[] castSpell(Player plyr) {
			plyr.damageHitPoints(18);
			return new String[] {
				"A Werewolf pounces at your heels, clamping its jaws onto your calf!",
				"You shake it off, but your calf is shot with pain, and you take " + 17 + " damage!"
			};
		}
		
		/**
		 * The Werewolf gains 2 health from defending
		 * 
		 * @return String[] containing info on the defend
		 */
		@Override
		public String[] defend() {
			hitPoints = hitPoints + 2;
			return new String[] {"The Werewolf cowers in defense",
								 "It gains 2 points of health in anticipation of your attack"};
		};
		
		/**
		 * Get a Werewolf description.
		 * 
		 * @return
		 *   A short phrase describing a Werewolf. You could randomize descriptions
		 *   to be unique for different instances in different ways.
		 */
		@Override
		public String getDescription() {
			return "a Werewolf";
		}

}
