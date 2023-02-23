package items;

/**
 * The health potion increases the player's hit points by 25
 * 
 * @author Jon Steele
 *
 */
public class HealthPotion extends Potion{

	int attackBonus = 0;
	int healthBonus = 25;
	int wisdomBonus = 0;
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
		
		return ("Health Potion");
	}
	
	public String getInfo() {
		
		return("You chug the health potion, raising your hit points by " + healthBonus);
	}
	
}
