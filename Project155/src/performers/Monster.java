package performers;

import graphics.Point2D;

/**
 * A superclass for all of our monsters in the game.
 * An abstract class cannot be initialized, so initialize subclasses of it instead.
 * For subclasses, we are forced to write the code of the abstract methods.
 * For regular methods in the superclass, we get to use these in any subclass,
 * without having to write them in the subclasses again and again.
 */
public abstract class Monster {
	protected int hitPoints;
	protected int strength;
	int instanceOfMonster = 0;
	String instance;//used to label the duplicate monsters first, second, ect...
	
	/**
	 * Every monster should have hit points, and some strength.
	 * But, this is really up to your own design, and you can change these to keep track
	 * of different data that is common to all your monsters.
	 * 
	 * @param hitPoints
	 *   An amount of damage a monster must have removed before dying.
	 * @param strength
	 *   An amount of physical ability a moster has.

	 */
	public Monster(int hitPoints, int strength) {
		this.hitPoints = hitPoints;
		this.strength = strength;
	}
	
	/**
	 * same method as above, but parameterized with the instance variable
	 * 
	 * @param hitPoints
	 * 	hitpoints a monster can take
	 * @param strength
	 * damage a monster is capable of 
	 *   @param instance
	 *   the number of this monster 
	 */
	public Monster(int hitPoints, int strength, int instance) {
		this.hitPoints = hitPoints;
		this.strength = strength;
		instanceOfMonster = instance;
	}
	
	/**
	 * Decreases hit points of this montser.
	 * 
	 * @param damage
	 *   The amount of damage this monster will receive to reduce its hit points.
	 */
	public void damageHitPoints(int damage) {
		if (hitPoints > damage)
			hitPoints -= damage;
		else
			hitPoints = 0;
	}
	
	/**
	 * Returns the hit points of this monster.
	 *
	 * @return
	 *   The hit points of this monster.
	 */
	public int getHitPoints() {
		return hitPoints;
	}
	
	/**
	 * Checks whether this montser is dead or still alive.
	 * 
	 * @return
	 *   A value of <code>true</code> if this monster has no hit points, 
	 *   and <code>false</code> otherwise.
	 */
	public boolean isDead() {
		return hitPoints == 0;
	}
	
	/**
	 * Each subclass monster should have a unique attack.
	 * 
	 * @param plyr
	 *   Access to the player instance so you can control it from inside a monster.
	 * 
	 * @return
	 *   An array of strings, describing the results of this monster attack on the player.
	 */
	public abstract String[] attack(Player plyr);
	
	/**
	 * Each monster has different defensive bonuses
	 * 
	 * @return
	 */
	
	public abstract String[] defend();
	/**
	 * Each subclass monster should have a unique spell to cast.
	 * 
	 * @param plyr
	 *   Access to the player instance so you can control it from inside a monster.
	 * 
	 * @return
	 *   An array of strings, describing the results of this monster spell on the player.
	 */
	public abstract String[] castSpell(Player plyr);
	
	/**
	 * Get a description of the kind of subclass of this monster.
	 * 
	 * @return
	 *   The kind of subclass of this monster in the form of a description in
	 *   the context of the story.
	 */
	public abstract String getDescription();
	
	/**
	 * labels the monster's instance String based off of in instanceOfMonster
	 * 
	 * @return
	 * String returning first, second, ect. if 0 is entered, it returns a blank ""
	 */
	public String getInstance() {
		if (instanceOfMonster == 0)
			instance = "";
		else if (instanceOfMonster == 1)
			instance = "first";
		else if (instanceOfMonster == 2)
			instance = "second";
		else if (instanceOfMonster == 3)
			instance = "third";
		else if (instanceOfMonster == 4)
			instance = "fourth";
		else if (instanceOfMonster == 5)
			instance = "fifth";
		else if (instanceOfMonster == 6)
			instance = "sixth";
		
		return instance;
	}
	
}