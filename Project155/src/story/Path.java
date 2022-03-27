package story;
import java.util.ArrayList;

import performers.Monster;
import performers.GiantSpider;

/**
 * Path lies southwest of the clearing, it has 2 giant spiders.
 * @author Jon Steele
 *
 */
public class Path extends Location {
	/**
	 * path constructor places 2 spiders in monsters arrayList
	 */
	Path(){
		monsters = new ArrayList<Monster>();
		monsters.add(new GiantSpider(1));
		monsters.add(new GiantSpider(2));
	}
	@Override
	public String locationNarrative() {
		String narrative = "You meander down the winding path, deeper into the forest. It grows dark underneath the canopy of the trees, sheltering "
				+ "you from the intense sun. "
				+ "Thick cobwebs dangle from the canopy above, floating in the subtle wind. "
				+ "You can hear the sound of water churning in the distance, along with singing birds. Suddenly, the birds become silent. "
				+ "You whip your head around in a circle, anticipating a predator in the area. Nothing happens. You continue to walk, cautiously"
				+ " this time. Suddenly, 2 enormous spiders leap down from the trees, blocking the path!";
		return narrative;
	}

	@Override
	public String[] options() {
		String[] options = {"Follow the sound of water", "Continue following the path"};
		// TODO Auto-generated method stub
		return options;
	}

}
