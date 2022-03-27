package story;
import performers.Monster;
import performers.GiantSpider;
import performers.SpiderQueen;
import java.util.ArrayList;

/**
 * The spidernest is southeast of the shack. it has 5 giant spiders and the spider queen.
 * @author Jon Steele
 *
 */
public class SpiderNest extends Location {
	/**
	 * spidernest constructor puts 5 spiders and the spider queen into its monsters arraylist
	 */
	SpiderNest(){
	monsters = new ArrayList<Monster>();
	monsters.add(new GiantSpider(1));
	monsters.add(new GiantSpider(2));
	monsters.add(new GiantSpider(3));
	monsters.add(new GiantSpider(4));
	monsters.add(new GiantSpider(5));
	monsters.add(new SpiderQueen());
	}
	@Override
	public String locationNarrative() {
		String narrative = "You jog after the small spiders into the forest. After a solid 10 minutes of jogging, they dissapear from "
				+ "your sight. 'Weird,' you think to yourself. It is getting pretty dark out, the only lightsource you have is the "
				+ "full moon above. It flickers on and off between tree branches. The cool breeze sends a chill down your spine, something "
				+ "evil lurks. Eight red eyes peer at you in the darkness. They grow bigger as they come nearer. A huge spider, about the "
				+ "size of a dog sits at the edge of the moonlight. It rubs its legs together, then runs up the nearest tree. As your eyes follow him up the tree, "
				+ "to your horror, countless red eyes look back, filling all the branches around you. One enormous spider sits directly in front of you."
				+ " its stature comparable to that of a bear. You are paralyzed with fear as they surround you, voices chittering to one another. "
				+ "You snap out of it and back up into a tree, preparing for your last fight. They lunge!";
		return narrative;
	}

	@Override
	public String[] options() {
		String[] options = {"Examine the Spider Queen"};
		return options;
	}

}
