package items;

/**
 * The God Potion boosts the players strength, health, and wisodom by 10 points.
 * 
 * @author Jon Steele
 *
 */
public class GodPotion extends Potion{

	int attackBonus = 10;
	int healthBonus = 10;
	int wisdomBonus = 10;
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
		
		return ("God Potion");
	}
	
	public String getInfo() {
		
		return("You gargle down the God Potion, increasing your strength, wisdom, and health all by 10 points");
	}
}
