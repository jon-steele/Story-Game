package items;

/**
 * Steelsword boosts the players strength by 10
 * 
 * @author Jon Steele
 *
 */
public class SteelSword extends Weapon{
	
	int attackBonus = 10;	
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
		return ("Steel Sword");
	}
	
	public String getInfo() {
		return("Your Steel Sword was placed inside your sheath, boosting your attack by 10 damage!");
	}
	
}
