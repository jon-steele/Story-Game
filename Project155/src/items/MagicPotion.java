package items;

/**
 * magic potion boosts the players wisdom by 10
 * 
 * @author Jon Steele
 *
 */
public class MagicPotion extends Potion{

	int attackBonus = 0;
	int healthBonus = 0;
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
		
		return ("Magic Potion");
	}
	
	public String getInfo() {
		
		return("You sip the Magic Potion, increasing your wisdom by 10 points");
	}
	
}
