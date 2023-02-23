package story;

import java.util.ArrayList;
import performers.Monster;
import performers.Rat;
import items.JadeStaff;
/**
 * Abandoned camp lies next to the path, before the docks, to the southwest of the clearing. 
 * @author Jon Steele
 *
 */
public class AbandonedCamp extends Location {
	/**
	 * abandonedcamp constructor fills monsters array with rats, and creates a jadestaff
	 */
	AbandonedCamp(){
		locationItem = new JadeStaff();
		monsters = new ArrayList<Monster>();
		monsters.add(new Rat(1));
		monsters.add(new Rat(2));
		monsters.add(new Rat(3));
	}
	
	@Override
	public String locationNarrative() {
		String narrative = "You continue to follow the path up to a small camp. "
				+ "Nobody greets you, but you decide to look around anyways. "
				+ "There are 3 tents surrounding a pile of ashes in the center. The air smells awful. With kitchenware"
				+ " sprawled all over the ground, you begin to ponder where the owners are. "
				+ "Out of curiousity, you peer into the first tent. Next to the sleeping bag there is a Jade Staff. "
				+ "You pick it up and stow it away. "
				+ "You open the flap of the second, revealing a single leather glove. You circle around to the third "
				+ "and pull the canvas flap. "
				+ "To your horror, you find a pile of human bones being picked clean by 3 enourmous rats. They turn"
				+ " to you and shriek! ";
		return narrative;
	}

	@Override
	public String[] options() {
		String[] options = {"Continue down the path"};
		return options;
	}

}
