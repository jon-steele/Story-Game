package items;

/**
 * The item class is a template to base all other items off of. It does nothing
 * 
 * @author Jon Steele
 *
 */
public interface Item {

		//this method takes the players stats and modifies them based on the item
		abstract int[] useItem(int strength, int wisdom, int health);
		
		//method that returns name of the item
		abstract String getName();
		
		//this method returns a string explaining what the item did
		abstract String getInfo();
		
		
		
	}
