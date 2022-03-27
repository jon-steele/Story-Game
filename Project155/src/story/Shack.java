package story;
import java.util.ArrayList;
import performers.Wolf;
import performers.Rat;
import performers.Monster;
import items.SteelSword;

/**
 * The shack lies south of the deer kill, and east of the mansion. There are 5 wolves here, and a steel sword.
 * @author Jon Steele
 *
 */
public class Shack extends Location {
	/**
	 * Shack constructor puts 5 wolves into its monsters arraylist, and creates a steel sword
	 */
	Shack(){
		locationItem = new SteelSword();
		monsters = new ArrayList<Monster>();
		monsters.add(new Wolf(1));
		monsters.add(new Wolf(2));
		monsters.add(new Wolf(3));
		monsters.add(new Wolf(4));
		monsters.add(new Wolf(5));
	}
	
	@Override
	public String locationNarrative() {
		String narrative = "You trudge onwards. The stars glint overhead, and the full moon stares down at you. Your body begins to shiver. "
				+ "Luckily, you have arrived at the source of the smoke. At the base of the smoke plume, nestled between the trees, you "
				+ "see a wooden shack. The smoke, now faintly, is flowing from its chimney. Eager to warm yourself, you jog up to the door, which"
				+ " is completely open. On the inside of the door you see 4 deep grooves, as if a tiger had scratched it. This has you worried as to what "
				+ "happened to the owner of the Shack. Nonetheless, "
				+ "the source of the smoke is everything you had hoped it'd be; a nice, cozy, furnished resting place to spend the night. You begin to "
				+ "search the place for food, starting with the cupboards. In the first set of cupboards you pull out a Steel Sword. It looks very similar to "
				+ "the one your father let you play with as a child. You stow it in your pouch. Next, you open the second set of cupboards, and a spider bursts out, "
				+ "screeching at you. It scurries through"
				+ " the door, jumps over a puddle outside, and heads into the forest. You notice an abnormally large footprint in the puddle. Curious, you kneel down"
				+ " to check it out. 5 toes that span over a foot, with claws on each end, you shudder. You hear a wolf howl behind you. You stand, and find yourself "
				+ "surrounded by 5 white wolves, each low to the ground, with fur standing up on their backs. They snarl at you and inch closer. You take a couple steps back, "
				+ "then one lunges at you!";
		return narrative;
	}

	@Override
	public String[] options() {
		String[] options = {"Follow the spider into the woods", "Follow the paw prints into the woods"};
		return options;
	}

}
