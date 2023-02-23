package items;

/**
 * Strength potion boosts the players strength by 12
 * 
 * @author Jon Steele
 *
 */
public class StrengthPotion extends Potion{
	int attackBonus = 12;
	int healthBonus = 0;
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
		
		return ("Strength Potion");
	}
	
	public String getInfo() {
		
		return("You sip your Strength Potion... Your strength is increased by 12 points");
	}
	
}
