package items;

/**
 * The Saphhire staff boost the players wisdom by 10
 * 
 * @author Jon Steele
 *
 */
public class SapphireStaff extends Staff{

	int wisdomBonus = 10;
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
		
		return("Sapphire Staff");
	}
	
	public String getInfo() {
		
		return("You equip your Sapphire Staff, increasing your casting abilities by 10 damage!");
	}
}
