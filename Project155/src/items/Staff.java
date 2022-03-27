package items;

/**
 * This class is a template for all other staffs to be based off of... It does not do anything.
 * 
 * @author Jon Steele
 *
 */
public class Staff implements Item{
	
	int wisdomBonus;
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
		
		return("Staff");
	}
	
	public String getInfo() {
		
		return("This item does nothing");
	}
	
	
}
