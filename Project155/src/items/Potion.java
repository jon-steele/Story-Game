package items;

/**
 * The potion class is a template for all other potions to be based off of
 * 
 * @author Jon Steele
 *
 */
public class Potion implements Item{
	
	int attackBonus;
	int healthBonus;
	int wisdomBonus;
	int[] newStats = new int[3];
	String name;

	public int[] useItem(int strength, int wisdom, int health) {
		newStats[0] = strength + attackBonus;
		newStats[1] = wisdom + wisdomBonus;
		newStats[2] = health + healthBonus;
		
		return newStats;
	}
	//method that returns name of the item
	public String getName() {
		
		return ("Potion");
	}
	
	public String getInfo() {
		
		return("This Item doesn't do anything");
	}
	

}

