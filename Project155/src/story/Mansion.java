package story;
import performers.Monster;
import items.SapphireStaff;
import performers.Gorgon;
import performers.Manticore;
import java.util.ArrayList;
/**
 * Mansion sits south of the docks, and west of the shack. Inside, there are 3 gorgons, 2 manticores, and a 
 * saphhire staff
 * @author Jon Steele
 *
 */
public class Mansion extends Location {
	/**
	 * the constructor fills monsters arraylist with 3 gorgons, 2 manticores, and puts a saphhirestaff into locationitem.
	 * 
	 */
	Mansion(){
		locationItem = new SapphireStaff();
		monsters = new ArrayList<Monster>();
		monsters.add(new Gorgon(1));
		monsters.add(new Gorgon(2));
		monsters.add(new Gorgon(3));
		monsters.add(new Manticore(1));
		monsters.add(new Manticore(2));
	}
	@Override
	public String locationNarrative() {
		String narrative = "The forest makes way for a clearing. The stream's shoreline meets a boat skid, which lies at the end "
				+ "of a short path. The other end path leads to a Mansion. Its paint worn and cracked, windows shattered and stained, "
				+ "this mansion hasn't seen life in years. You stumble up the steps to its entryway and step inside, as the door "
				+ "is unhinged. The floorboards groan as if they cannot bear your weight. Each room on the ground floor holds "
				+ "nothing but dust. You continue your search upstairs. You find the same to be true, until you find the master"
				+ " bedroom. Stepping inside, dust particles kick up into the air, suspended in the moonlight through the window. "
				+ "The bedroom holds a bed, nightstand, and desk. Sitting on the desk is a Saphhire Staff. You pick it up, its white bleached "
				+ "wood contrasts against the blue gemstone at its crest. You just barely notice a paper laying on the desk, as it is "
				+ "covered "
				+ "in a thick layer of dust. It Reads: \"Dark are the depths, " +
				"Tired, I rest, Morals shall cleft, Lest that I stir.\""
				+ "Perplexed, you turn to the doorway to leave, but are greeted by a head of Snakes, who begin hissing. A gorgon and "
				+ "her accomplices have joined your snooping!";
		return narrative;
	}

	@Override
	public String[] options() {
		String[] options = {"Follow the light at the edge of the clearing", "Follow some giant paw prints into the Forest"};
		return options;
	}

}
