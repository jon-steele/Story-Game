package performers;

import logic.Random;

/**
 * Spider queen is the queen of all spiders
 * @author Jon Steele
 */
public class SpiderQueen extends Monster {
	
	/**
	 *The spiderqueen constructor calls for the superclass constructor to add her hitpoints and damage
	 */
	public SpiderQueen() {
		super(
			50,  // hitPoints
			12 // strength
		);
	}
	
	/**
	 * A basic attack for the SpiderQueen type of monster.
	 * 
	 * @param plyr
	 *   The person the user is using to play the game.
	 * 
	 * @return
	 *   An array of strings, describing the results of a SpiderQueen attack on the player.
	 */
	@Override
	public String[] attack(Player plyr) {
		int attackDamage = Random.rand(5) + strength;
		plyr.damageHitPoints(attackDamage);
		return new String[] { "Spider Queen attacked you for " + attackDamage + " damage!" };
	}
	
	/**
	 * A more descriptive result to go along with a SpiderQueen's unique spell (or ability) to cast.
	 * 
	 * @param plyr
	 *   The person the user is using to play the game.
	 * 
	 * @return
	 *   An array of strings, describing the results of a SpiderQueen's spell on the player.
	 */
	@Override
	public String[] castSpell(Player plyr) {
		plyr.damageHitPoints(14);
		return new String[] {
			"The Spider Queen leaps at you and belches stinky fire out of its mouth!",
			"The stench of the fire chokes you, its flames burn you, and you take " + 14 + " damage!"
		};
	}
	
	/**
	 * The SpiderQueen gains 2 health from defending
	 * 
	 * @return String[] containing info on the defend
	 */
	@Override
	public String[] defend() {
		hitPoints = hitPoints + 6;
		return new String[] {"The Spider Queen coils up in defense",
							 "It gains 6 points of health in anticipation of your attack"};
	};
	
	/**
	 * Get a SpiderQueen description.
	 * 
	 * @return
	 *   A short phrase describing a SpiderQueen. You could randomize descriptions
	 *   to be unique for different instances in different ways.
	 */
	@Override
	public String getDescription() {
		return "the Spider Queen";
	}
}