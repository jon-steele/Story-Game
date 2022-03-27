package story;
import performers.Monster;
import performers.Blob;
import java.util.ArrayList;
import items.RustySword;

/**
 * The docks are south of the old camp and the stream, and north of the mansion. There is a rusty sword here,
 * along with 4 blobs
 * @author Jon Steele
 *
 */
public class Docks extends Location {

	Docks(){
		locationItem = new RustySword();
		monsters = new ArrayList<Monster>();
		monsters.add(new Blob(1));
		monsters.add(new Blob(2));
		monsters.add(new Blob(3));
		monsters.add(new Blob(4));
	}
	@Override
	public String locationNarrative() {
		String narrative = "Ahead, the path and stream converge at some docks, harbouring a few small fishing boats. "
				+ "You hop up onto the closest dock, observing the "
				+ "stream, which has now widened to about 40 feet across. The sun sets in the horizon, and a soft breeze "
				+ "brings chills down your spine. "
				+ "A small fishing hut lie by the waters, you approach "
				+ "to check it out. You try the door, it is unlocked. You step inside, and are hit with an old, musty smell of "
				+ "fish guts and rotten wood. Sitting on the counter you find a Rusty Sword... Cool! Stowing it away, "
				+ "you step back outside and "
				+ "are greeted by 4 giant green Blobs!";
		return narrative;
	}

	@Override
	public String[] options() {
		String[] options = {"Hop in the boat and head downstream", "Follow the smoke plume"};
		return options;
	}

}
