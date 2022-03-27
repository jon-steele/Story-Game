package story;
import java.util.ArrayList;
import performers.Monster;
import performers.Werewolf;
import performers.Wolf;
/**
 * The wolfden lies southeast of the mansion, and southwest of the shack. it holds 5 wolves, and the werewolf.
 * 
 * @author Jon Steele
 *
 */
public class WolfDen extends Location {
	/**
	 * the wolfden constructor creates 5 wolves and a werewolf, and puts them into its monsters arraylist
	 */
	WolfDen(){
		monsters = new ArrayList<Monster>();
		monsters.add(new Wolf(1));
		monsters.add(new Wolf(2));
		monsters.add(new Wolf(3));
		monsters.add(new Wolf(4));
		monsters.add(new Wolf(5));
		monsters.add(new Werewolf());
	}
	@Override
	public String locationNarrative() {
		String narrative = "You trail the prints in the mud. Darkness surrounds you as you move silently under the trees. "
				+ "you continue until you reach a clearing ahead. A huge, grassy field stretches across your vision. The "
				+ "ground lay flat, except for one sole hill in the middle. Atop its peak, a single wolf looks onward. It "
				+ "raises its snout to the full moon and lets out a creepy howl. One by one, you hear tens of wolves howl "
				+ "back, all around you. "
				+ "Their cries freak you out, but you want to find what creature made these huge paw prints. The prints point towards "
				+ "the hill, so you trudge onwards into the grass. It surrounds you at your waist, and you begin "
				+ "to fear that something is in the grass. Sooner than later, you arrive at the hill. "
				+ "The grass gives way to dirt and rocks. You have lost sight of the tracks. An eerie feeling washes over you, and "
				+ "your arm hairs stand on end. You hear a deep growl right behind you. You turn and face an enormous Beast. "
				+ "Its form resembles a human, but it stands at about 7 feet. Its mouth is stained red with blood, contrasting against its white fur."
				+ " Its hands are the size of baseball gloves bearing 4 inch "
				+ "long claws. Fear suffocates you. "
				+ "It gnashes its teeth, and out of the corner of your eye, several wolves emerge from the grass at the edge of the"
				+ " clearing, low to the ground, snarling. You prepare for your last fight!";
		return narrative;
	}

	@Override
	public String[] options() {
		String[] choices = {"Examine the white Werewolf"};
		return choices;
	}

}
