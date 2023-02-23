package items;

/**
 * Iron sword boosts the players strength by 8
 * 
 * @author Jon Steele
 *
 */
public class IronSword extends Weapon{

	int attackBonus = 8;	
	int[] newStats = new int[3];
	String name;

	public int[] useItem(int strength, int wisdom, int health) {
		newStats[0] = strength + attackBonus;
		newStats[1] = wisdom;	
		newStats[2] = health;
		return newStats;
	}
	//method that returns name of the item
	public String getName() {
		
		return ("Iron Sword");
	}
	
	public String getInfo() {
		
		return("Your Iron Sword was placed in your sheath, boosting your attack by 8 damage!");
	}
}
