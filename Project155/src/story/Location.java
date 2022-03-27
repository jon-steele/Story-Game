package story;
import java.util.ArrayList;
import performers.*;
import items.*;

/**
 * Location is an abstract class for all real locations to inherit the methods from
 * @author Jon Steele
 *
 */
public abstract class Location {

	protected ArrayList<Monster> monsters;
	protected Item locationItem;
	
	/**
	 * locationNarrative holds the description of the area
	 * 
	 * @return
	 * returns a string narrating the discovery of this location
	 */
	public abstract String locationNarrative();
	
	/**
	 * options holds the possible locations to move to 
	 * 
	 * @return
	 * returns a string array with different options that lead to different locations
	 */
	public abstract String[] options();
	
	/**
	 * getMonsters returns the monsters in this area
	 * @return
	 * an arraylist holding all the monsters in this area.
	 */
	public ArrayList<Monster> getMonsters(){
		return monsters;
	}
	
	/**
	 * getLocationItem returns the item found at this location
	 * @return
	 * Item locationItem
	 */
	public Item getLocationItem() {
		return locationItem;
	}
	
	
	
	
}
