package performers;

import logic.Random;

/**
 * Giant spiders are relatively weak to other monsters, but can potentially pack some venom that does a lot
 * of damage. their strength varies from 2 - 12
 * @author Baby_Giraffe
 */
public class GiantSpider extends Monster {
	
	/**
	 * GiantSpider constructor calls superclass constructor to fill the stats hitpoints and strength
	 */
	public GiantSpider() {
		super(
			5,  // hitPoints
			(Random.rand(10) + 2) // strength
		);
	}
	/**
	 * constructor class, including a variable instanceOf to distinguish between duplicate monsters
	 * 
	 * @param instanceOf
	 * the number of the monster
	 */
	public GiantSpider(int instanceOf) {
		super(
			5,  // hitPoints
			(Random.rand(10) + 2),
			instanceOf// strength
		);
	}
	
	/**
	 * A basic attack for the GiantSpider type of monster.
	 * 
	 * @param plyr
	 *   The person the user is using to play the game.
	 * 
	 * @return
	 *   An array of strings, describing the results of a GiantSpider attack on the player.
	 */
	@Override
	public String[] attack(Player plyr) {
		plyr.damageHitPoints(strength);
		return new String[] { "Giant Spider attacked you for " + strength + " damage!" };
	}
	
	/**
	 * A more descriptive result to go along with a GiantSpider's unique spell (or ability) to cast.
	 * 
	 * @param plyr
	 *   The person the user is using to play the game.
	 * 
	 * @return
	 *   An array of strings, describing the results of a GiantSpider's spell on the player.
	 */
	@Override
	public String[] castSpell(Player plyr) {
		plyr.damageHitPoints(3);
		return new String[] {
			"A Giant Spider leaps at you and stabs its fangs deep into your leg!",
			"The wound burns deep and you take " + 3 + " damage!"
		};
	}
	
	/**
	 * The GiantSpider gains 2 health from defending
	 * 
	 * @return String[] containing info on the defend
	 */
	@Override
	public String[] defend() {
		hitPoints = hitPoints + 2;
		return new String[] {"The GiantSpider coils up in defense",
							 "It gains 2 points of health in anticipation of your attack"};
	};
	
	/**
	 * Get a GiantSpider description.
	 * 
	 * @return
	 *   A short phrase describing a GiantSpider. You could randomize descriptions
	 *   to be unique for different instances in different ways.
	 */
	@Override
	public String getDescription() {
		return getInstance() + " Giant Spider";
	}
}