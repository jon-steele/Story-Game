package performers;
import items.Item;
import java.util.ArrayList;

import graphics.Point2D;

/**
 * A superclass for organizing the common code of all kinds of player subclasses.
 * An abstract class cannot be initialized, so initialize subclasses of it instead.
 * For subclasses, we are forced to write the code of the abstract methods.
 * For regular methods in the superclass, we get to use these in any subclass,
 * without having to write them in the subclasses again and again.
 */
public abstract class Player {
	protected int MAX_HIT_POINTS;
	// Package-protected means it can be used by other classes in the same package.
	protected int hitPoints;
	protected int strength;
	protected int wisdom;
	protected int defense;
	protected Item currentItem;
	protected int currentItemSlot;
	protected ArrayList<Item> inventory = new ArrayList<Item>();
	/**
	 * This superclass constructor should take care of common setup for 
	 * creating instances of *any subclass* of person th e player chooses. 
	 * So calling super() for any subclass constructors saves you from 
	 * writing this code again.
	 *   
	 * @param hitPoints
	 *   The number of points a player has to stay alive.
	 *   
	 * @param strength
	 *   A basic measure of the amount of strength a player has. This could
	 *   be used to help calculate attack damage to hit points of monsters.
	 *   
	 * @param wisdom
	 *   A basic measure of the amount of wisdom a player has. This could be
	 *   used to help calculate the amount of spell effects.
	 */
	public Player(int hitPoints, int strength, int wisdom, int defense, int MAX_HIT_POINTS) {
		this.hitPoints = hitPoints;
		this.strength = strength;
		this.wisdom = wisdom;
		this.defense = defense;
		this.MAX_HIT_POINTS = MAX_HIT_POINTS;
		ArrayList<Item> inventory = new ArrayList<Item>();
	}
	

	
	/**
	 * A method to get the maximum possible hit points for the player. 
	 * You could use this value to help you calculate results for 
	 * situations you design.
	 * 
	 * @return
	 *   An integer for the largest possible hit points of the player.
	 */
	public int getMaxHitPoints() {
		return MAX_HIT_POINTS;
	}
	
	/**
	 * To find out the current hit points status of the player.
	 * 
	 * @return
	 *   An integer for the current hit point value.
	 */
	public int getHitPoints() {
		return hitPoints;
	}
	
	/**
	 * Decreases hit points of this player.
	 * 
	 * @param damage
	 *   The amount of damage this player is receiving.
	 */
	public void damageHitPoints(int damage) {
		if (hitPoints > damage)
			hitPoints -= damage;
		else
			hitPoints = 0;
	}
	
	/**
	 * To find out the strength of the player.
	 * 
	 * @return
	 *   An integer for the strength of the player.
	 */
	public int getStrength() {
		return strength;
	}
	
	/**
	 * To find out the wisdom of the player.
	 * 
	 * @return
	 *   An integer for the wisdom of the player.
	 */
	public int getWisdom() {
		return wisdom;
	}
	
	/**
	 * To change the value of the player's current hit points.
	 * 
	 * @param hitPoints
	 *   The value to save as the current hit points.
	 */
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}
	
	/**
	 * To change the value of the player's strength.
	 * 
	 * @param strength
	 *   The value to save as the player's strength.
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	/**
	 * To change the value of the player's wisdom.
	 * 
	 * @param wisdom
	 *   The value to save as the player's wisdom.
	 */
	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	/**
	 * Checks whether this monster is dead or still alive.
	 * 
	 * @return
	 *   A value of <code>true</code> if this player has no hit points, 
	 *   and <code>false</code> otherwise.
	 */
	public boolean isDead() {
		return hitPoints <= 0;
	}
	
	/**
	 * Adds whatever item into this players inventory
	 * 
	 * 
	 * @param newItem
	 */
	public void addItem(Item newItem) {
		inventory.add(newItem);
	}
	
	/**
	 * Every kind of player should implement their own version of an attack.
	 * 
	 * @param monsters
	 *   The attack should affect one, some, or all of the monsters. 
	 *   You decide how this should be implemented in subclasses.
	 * 
	 * @return
	 *   An array of strings, describing the results of this player attack on the monsters.
	 */
	public abstract String[] attack(Monster... monsters);
	
	/**
	 * Every kind of player should implement their own version of a spell to cast.
	 * 
	 * @param monsters
	 *   The spell should affect one, some, or all of the monsters. 
	 *   You decide how this should be implemented in subclasses.
	 * 
	 * @return
	 *   An array of strings, describing the results of this player spell on the monsters.
	 */
	public abstract String[] castSpell(Monster...monsters);
	
	
	/**
	 * This method regenerates the player's health, based off of their defense stat. 
	 * It is optimized so it will not exceed the max hit point limit.
	 * 
	 * @return
	 * 	an arraylist of items, the inventory
	 */
	public abstract String[] defend();
	
	public ArrayList<Item> getInventory(){
		return (inventory);
	}
	
	/**
	 * method that returns a specific item in inventory
	 * @param choice
	 * 	this integer is the position of the desired item in its inventory 
	 * 
	 * @return
	 * 	Item inide inventory at the position of int choice
	 */
	public Item getItem(int choice) {
		return inventory.get(choice);
	}
	
	public Item getCurrentItem() {
		return (currentItem);
	}
	
	/**
	 * method that finds the size of inventory for other classes
	 * 
	 * @return
	 * 	an int of the size of arraylist inventory
	 */
	public int getInventorySize() {
		int size = inventory.size();
		return size;
	}
	
	/**
	 * returns a concatenated String[] containing all info of all items
	 * 
	 * @return
	 * 	a String[] where each new string is a different item in the inventory
	 */
	public String[] chooseItem() {
		
		String[] itemsToPick = new String[getInventorySize()];
		
		for (int i = 0; i < getInventorySize(); i++) {
			itemsToPick[i] = ": " + inventory.get(i).getName();
		}
					
			return (itemsToPick);
		}
	
	/**
	 * method that selects the first item in the inventory
	 */
	public void selectItem() {
		if (getInventorySize() == 0) {}
		else if (getInventorySize() < 0) {
			currentItem = inventory.get(0);
		}
	}
	/**
	 * This method selects the item that is passed into the method
	 * @param choice
	 * int choice determines which item in the inventory should be held as 'current', in preparation
	 * to be used.
	 */
	public void selectItem(int choice) {
		currentItem = inventory.get((choice));
		currentItemSlot = (choice);
	}
	
	/**
	 * this uses the item "currentItem", applies its attack/wisdom/health bonus to the player's stats, 
	 * and then deletes the item.
	 * @return
	 * 	returns a string[] explaining what the item did
	 */
	public String[] useCurrentItem() {
		
		setStats(currentItem.useItem(strength, wisdom, hitPoints));
		inventory.remove(currentItemSlot);
		
		String[] itemInfo = new String[2];
		itemInfo[0] = currentItem.getName() + " has been used!"; 
		itemInfo[1] = currentItem.getInfo(); 
		currentItem = null;
		
		return(itemInfo);
	}
	
	/**
	 * this sets the hitPoints, strength, and wisdom stats of the player, altered by an item
	 * @param stats
	 */
	public void setStats(int[] stats) {
		strength = stats[0];
		wisdom = stats[1];
		hitPoints = stats[2];
		
	}
	
	/**
	 * This method returns true if the player is at max health.
	 * this is used in game.java to check if the player is able to defend and regen some health
	 * 
	 * @return
	 * boolean value, true if the player is at max health, false if not
	 */
	public boolean checkIfMaxHealth() {
		boolean maxxed;
		if (hitPoints >= MAX_HIT_POINTS)
			maxxed = true;
		else
			maxxed = false;

		return maxxed;
	}
	
	/**
	 * resets players health to max_hit_points for next fight
	 * 
	 */
	public void resetHealth() {
		hitPoints = MAX_HIT_POINTS;
	}
	
	
}
	
	
