package performers;

import logic.Random;

/**
 * King ogre is a brute, he has the most health out of any monster, but has a relatively low attack.
 * @author Jon Steele
 *
 */
public class KingOgre extends Monster{
	/**
	 * king ogre constructor adds stats to superclass constructor so he has hitpoints and strength
	 */
	public KingOgre() {
		super(
			60,  // hitPoints
			9 // strength
		);
	}
	
	/**
	 * A basic attack for the Ogre type of monster.
	 * 
	 * @param plyr
	 *   The person the user is using to play the game.
	 * 
	 * @return
	 *   An array of strings, describing the results of a Ogre attack on the player.
	 */
	@Override
	public String[] attack(Player plyr) {
		plyr.damageHitPoints(Random.rand(strength)+ 4);
		return new String[] { "Ogre attacked you for " + strength + " damage!" };
	}
	
	/**
	 * A more descriptive result to go along with a Ogre's unique spell (or ability) to cast.
	 * 
	 * @param plyr
	 *   The person the user is using to play the game.
	 * 
	 * @return
	 *   An array of strings, describing the results of a Ogre's spell on the player.
	 */
	@Override
	public String[] castSpell(Player plyr) {
		plyr.damageHitPoints(13);
		return new String[] {
			"The Ogre swings his giant club against the walls of ",
			 "the cavern, dropping loose rocks on your head!",
			"Dazed, you continue to battle, but take " + 13 + " damage!"
		};
	}
	
	/**
	 * The Ogre gains 2 health from defending
	 * 
	 * @return String[] containing info on the defend
	 */
	@Override
	public String[] defend() {
		hitPoints = hitPoints + 8;
		return new String[] {"The Ogre coils up in defense",
							 "It gains 8 points of health in anticipation of your attack"};
	};
	
	/**
	 * Get a Ogre description.
	 * 
	 * @return
	 *   A short phrase describing a Ogre. You could randomize descriptions
	 *   to be unique for different instances in different ways.
	 */
	@Override
	public String getDescription() {
		return "the Ogre King";
	}
	
}
