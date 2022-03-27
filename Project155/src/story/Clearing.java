package story;

import java.util.ArrayList;
import performers.Monster;
import performers.Manticore;
/**
 * Clearing is the starting location, one manticore lives here.
 * @author Jon Steele
 *
 */
public class Clearing extends Location {
	/**
	 * constructor places a manticore into its monsters arraylist
	 */
	Clearing(){
		monsters = new ArrayList<Monster>();
		monsters.add(new Manticore());
	}
	
	@Override
	public String locationNarrative() {
		String narrative = "Your father was an adventurer. You always looked up "+
				"to him, that is, until he left... "
				+ "He used to travel these areas, you wonder if hes still out there,"
				+ " lost, or worse. Out of the corner of your eye you notice a plume of smoke, "
				+ "reaching toward the sky. Peculiar, not many dare explore this area. "+
				"You hear a twig crack to your right and you snap out "+
				"of your thoughts. "+
				"You see a manticore in the bushes, stalking you. It pounces!";
		return narrative;
	}

	@Override
	public String[] options() {
		String[] options = {"Follow the smoke plume", "Follow the path into the forest"};
		return options;
	}

}
