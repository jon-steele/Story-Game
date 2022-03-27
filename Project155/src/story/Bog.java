package story;

import java.util.ArrayList;
import performers.Monster;
import performers.Blob;
/**
 * The bog lies south of the pond, and just north of the fresh deer kill. It houses 3 blobs
 * @author Jon Steele
 *
 */
public class Bog extends Location {
	/**
	 * bog constructor creates 3 blobs and adds them to monsters arraylist
	 */
	Bog(){
		monsters = new ArrayList<Monster>();
		monsters.add(new Blob(1));
		monsters.add(new Blob(2));
		monsters.add(new Blob(3));
	}
	
	@Override
	public String locationNarrative() {
		String narrative = "As you follow the smoke in the sky, the dry forest turns to wet marsh. Your feet begin "
				+ "to sink deeper and deeper into the ground with each step. Toads croak nearby, puddles form at your feet. "
				+ "You step down, and your foot sinks deep into the mud, stuck. Three hideous blobs emerge from the waters. "
				+ "Panicked, you hastily pull yourself out of the mud and whip around just as they reach you. ";
		return narrative;
	}

	@Override
	public String[] options() {
		String[] options = {"Continue to follow the smoke"};
		return options;
	}

}
