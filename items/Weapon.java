package items;

/**
 * The weapon class is used as a parent class to all swords in the game
 * 
 * @author Jon Steele
 *
 */
public class Weapon implements Item{
		
		int attackBonus;	
		int[] newStats = new int[3];
		String name;

		public int[] useItem(int strength, int wisdom, int health) {
			newStats[0] = strength + attackBonus;			
			return newStats;
		}
		//method that returns name of the item
		public String getName() {
			return ("Weapon");
		}
		
		public String getInfo() {
			return("This Item Does Nothing");
		}

}
