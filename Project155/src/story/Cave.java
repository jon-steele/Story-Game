package story;

import java.util.ArrayList;
import performers.Monster;
import performers.KingOgre;
import performers.Gorgon;
import performers.Manticore;
import performers.Cyclopes;
/**
 * The cave lies south of the mansion, and west of the wolf den. Inside, it holds 2 cyclopes, 2 gorgons, a manticore,
 * and the king ogre.
 * @author Jon Steele
 *
 */
public class Cave extends Location {
	/**
	 * cave constructor creates all the monsters for this area.
	 * 
	 */
	Cave(){
		monsters = new ArrayList<Monster>();
		monsters.add(new Cyclopes(1));
		monsters.add(new Cyclopes(2));
		monsters.add(new Gorgon(1));
		monsters.add(new Gorgon(2));
		monsters.add(new Manticore());
		monsters.add(new KingOgre());
	}
	
	@Override
	public String locationNarrative() {
		String narrative = "The light grows brighter and brighter, eventually revealing a cave dug out of a hillside. "
				+ "curiousity peaked, you continue inside. Torches lighting the way, the tunnel narrows as it twists and "
				+ "turns deeper and deeper into the earth. You hear voices. You creep toward it's source. Peering around "
				+ "the corner reveals an opening; a fire burns bright and you smell cooked meat. You count 6 monsters, "
				+ "one of which is an enormous Ogre wearing a gold crown bearing jewels. He is holding a severed arm, "
				+ "attempting to chew the the fingers off, but is having difficulty due to the leather glove still on its hand. "
				+ "At the worst possible moment, you sneeze. 6 heads snap towards you in unison.";
		return narrative;
	}

	@Override
	public String[] options() {
		String[] options = {"Examine the cave"};
		return options;
	}

}
