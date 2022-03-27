package story;
import performers.Monster;
import performers.Blob;
import java.util.ArrayList;
import items.GodPotion;
/**
 * the pond lies southeast of the clearing, and is north of the bog. It has 2 blobs hiding in its waters. 
 * It also has a godpotion laying around somewhere.
 * @author Jon Steele
 *
 */
public class Pond extends Location {
	/**
	 * The pond constructor fills the mosnters arraylist with 2 blobs, and creates a godpotion
	 */
	Pond(){
		monsters = new ArrayList<Monster>();
		monsters.add(new Blob(1));
		monsters.add(new Blob(2));
		locationItem = new GodPotion();
	}
	
	@Override
	public String locationNarrative() {
		String narrative = "The trees in the forest open up to a large pond, its surface covered with green algae and "
				+ "cattails protruding from its waters. The sun beats down from above. At one end of the pond "
				+ "a wooden canoe rests at the shore. At the other, "
				+ "the pond flows into a stream, just wide enough for a small boat to pass. You approach the canoe, and find a "
				+ "dead adventurer, his bones clutching a potion vial containing a golden liquid. You slip it out of his grasp, "
				+ "as he won't be needing it, and place it in your pouch. You hear a splash and turn around just in time to defend "
				+ "yourself against two green, semitranslucent blobs with floating animal bones visible inside them. You "
				+ "prepare to fight!";
		return narrative;
	}

	@Override
	public String[] options() {
		String[] options = {"Take the canoe and head downstream", "Continue following the plume of smoke in the sky"};
		return options;
	}

}
