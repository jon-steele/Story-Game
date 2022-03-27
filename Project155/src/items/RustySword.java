package items;

/**
 * The rusty sword boosts players strength by 5 points
 * 
 * @author Jon Steele
 *
 */
public class RustySword extends Weapon{

	int attackBonus = 5;	
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
		
		return ("Rusty Sword");
	}
	
	public String getInfo() {
		
		return("Your Rusty Sword was placed in your sheath, boosting your attack by 5 damage!");
	}
	
}
