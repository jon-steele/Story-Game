package items;

/**
 * jade staff boosts the players wisdom by 5 when useItem() is called
 * 
 * @author Jon Steele
 *
 */
public class JadeStaff extends Staff{

	int wisdomBonus = 5;
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
		
		return("Jade Staff");
	}
	
	public String getInfo() {
		
		return("You equip your Jade Staff, boosting your casting abilities by 5 damage!");
	}
}
