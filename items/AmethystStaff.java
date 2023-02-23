package items;

/**
 * An amethyst staff boosts the player's wisdom, so their casting abilities are better
 * @author Jon Steele
 */
public class AmethystStaff extends Staff{

	int wisdomBonus = 8;
	int[] newStats = new int[3];
	String name;

	public int[] useItem(int strength, int wisdom, int health) {
		newStats[0] = strength;
		newStats[1] = wisdom + wisdomBonus;		
		newStats[2] = health;	
		return newStats;
	}
	//method that returns name of the item
	public String getName() {
		
		return("Amethyst Staff");
	}
	
	public String getInfo() {
		
		return("You equip your Amethyst Staff, boosting your casting abilities by 8 damage!");
	}
}
