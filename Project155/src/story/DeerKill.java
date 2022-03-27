package story;
import java.util.ArrayList;
import performers.Monster;
import performers.Wolf;
/**
 * Deerkill sits south of the bog and the stream, and north of the shack.
 * 4 wolves are here
 * @author Jon Steele
 *
 */
public class DeerKill extends Location {
	/**
	 * constructor puts 4 wolves into is monsters arraylist
	 */
	DeerKill() {
		monsters = new ArrayList<Monster>();
		monsters.add(new Wolf(1));
		monsters.add(new Wolf(2));
		monsters.add(new Wolf(3));
		monsters.add(new Wolf(4));
	}
	@Override
	public String locationNarrative() {
		String narrative = "As you approach the plume of smoke in the sky, you stumble upon a dead deer. "
				+ "Its body still warm, blood flows from some puncture holes in its neck. Something killed it. "
				+ "The sky begins to dim as the sun dissapears behind the horizon and "
				+ "fear begins to set in. Whatever killed the deer will be with you in the dark. "
				+ "You feel eyes on the back of your head. Turning around, 4 wolves meet your gaze "
				+ "standing still in a semicircle around you. They begin their approach, ready to collect another meal. "
				+ "Unable to run, you stand and prepare to defend yourself. ";
		return narrative;
	}

	@Override
	public String[] options() {
		String[] options = {"Continue to follow the smoke", "Follow the sound of gushing water"};
		return options;
	}

}
