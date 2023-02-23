package story;
import items.StrengthPotion;
import performers.Manticore;
import performers.Monster;
import java.util.ArrayList;

/**
 * The Stream lies directly south of the clearing, southeast of the path, and southwest of the pond. 
 * 3 manticores are here, and a strength potion.
 * @author Jon Steele
 *
 */
public class Stream extends Location {
	/**
	 * stream constructor creates 3 manticores and a strength potion
	 * 
	 */
	Stream(){
		locationItem = new StrengthPotion();
		monsters = new ArrayList<Monster>();
		monsters.add(new Manticore(1));
		monsters.add(new Manticore(2));
		monsters.add(new Manticore(3));
	}
	
	@Override
	public String locationNarrative() {
		String narrative = "You find an upturned boat sitting in the middle of the stream, redirecting the flow of water around it. "
				+ "Another intact one sits on the edge of the water, holding a rucksack. Curious, you head for the pack. "
				+ "when you pick it up, it feels light, opening the flap reveals a potion vial containing red liquid. You stow it "
				+ "away in your own pack. As you turn around, you are knocked to the ground, with a Manticore snapping its teeth inches from "
				+ "your face. You slam your fist into its eye and spin around onto your feet. Another Manticore to your left pounces!"; 
		return narrative;
	}

	@Override
	public String[] options() {
		String[] options = {"Head towards the smoke plume", "Get in the boat and head downstream"};
		return options;
	}

}
