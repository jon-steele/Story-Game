package story;

import performers.*;
import items.*;
import java.util.Arrays;
import java.util.ArrayList;
import format.Billboard;
import logic.DataManager;

/**
 * This class takes care of describing what is happening in the story events of our game.
 * It is much easier to keep track of all the parts of our story in one place: this class.
 * Each chapter creates a new area based off off the players decisions
 * @author Jon Steele
 */
public class Narrator {
	// There is only one interactive story, so all methods are static.
	private final static int MAX_LINE_WIDTH = Billboard.getMaxLineWidth();
	private final static int FINAL_CHAPTER = 7;
	private static int chapter = 0;
	private static DataManager data;
	public static Location currentLocation;
	public static Location lastLocation;
	public static Item foundItem;
	public static ArrayList<Monster> monsters;
	public static String[] choices;
	public static int nextAreaChoice;//players choice after every area
	public static int ending; //players experience 1 of 3 endings
	
	// If everything is static, then we never need a constructor.
	// All variables only store one primitive value, or one instance of an object.
	// All methods can execute on the shared variables above.
	
	/**
	 * Connect to the same data instance used by the Game. So the Narrator can know
	 * what the player's name is, and whether they have died or not.
	 * 
	 * @param data
	 *   Should pass in the same data instance used by the Game.
	 */
	public static void setData(DataManager data) {
		Narrator.data = data; // instance shared by Game, Narrator
	}
	
	/**
	 * A helper method to convert a string into an array of strings for
	 * display within a Billboard instance.
	 *
	 * @param prose
	 *   The part of the story to break into substring lines.
	 *
	 * @return
	 *   The array of string elements that results from breaking
	 *   up the narrative string into lines of maximum length to fit
	 *   within a Billboard instance.
	 */

	public static String[] splitStringforBillboard(String prose) {
		int len = prose.length();
		// Always round up, because leftover chars will need 
		// to be in the last line.
		int width = (Billboard.getMaxLineWidth()-1);
		int lines = (int)Math.ceil((double)len / width);
		String[] result = new String[lines];
		int i;
		for (i = 0; i < lines-1; i++) {
			result[i] = prose.substring((i*width), ((i+1)*width));
			}
			result[lines-1] = prose.substring(i*width, prose.length());
		return result;
		}
	
	/**
	 * A method to get the different parts of our story. Each time this method is
	 * executed, the chapter number advances by one value. Extend the given code,
	 * or you could design your story to behave in a completely different way if 
	 * you want. For example, creating descriptions of your story or character 
	 * dialogue as strings in an array or collection, and choosing parts of it 
	 * in different ways, perhaps partly random.
	 *
	 * @return
	 *   An array of string descriptions.
	 */
	public static String[] tell() {
		if (data.isPlayerChosen() && data.isPlayerDead()) {
			chapter = FINAL_CHAPTER;
		}
		
		// we will not need break statements if we return instead
		switch (chapter++) {
			case 0:
				return begin();
			case 1:
				return chapter1();
			case 2:
				return chapter2();
			case 3:
				return chapter3();
			case 4:
				return chapter4();
			case 5:
				return chapter5();
			case 6:
				return chapter6();
			case FINAL_CHAPTER:
				return end(); // change the number for FINAL_CHAPTER as part of your design
			default:
				return new String[] { "No chapter content. (this message is for help with debugging)" };
		}
	}
	
	/**
	 * this method starts off the story
	 * @return
	 * returns a String[] containing the information about the setting
	 */
	private static String[] begin() {
		String[] intro = {
			"Hello, " + data.getUserName() + "!",
			"",
			"--- DARK DEPTHS ---",
			"", 
			"You begin your journey in a clearing in the woods. ",
			"Your father had taken you here as a boy to practice",
			" swordplay, you feel as though returning would bring",
			" you peace."};
		return (intro);
	}

	/**
	 * Each chapter creates a currentLocation based off of the lastLocation and the players decision(nextAreaChoice).
	 * @return
	 * it returns a string[] containing the narrative of that location.
	 */
	private static String[] chapter1() {
		currentLocation = new Clearing();
		
		monsters = currentLocation.getMonsters();//gets the monsters from this area
		foundItem = currentLocation.getLocationItem();//Adds item found in this area to founditem
		choices = currentLocation.options(); //Options on where to go next
		String prose = currentLocation.locationNarrative();//gets the narrative of the area
		lastLocation = currentLocation;
		currentLocation = null;
		return splitStringforBillboard(prose);
	}
	
	/**
	 * Each chapter creates a currentLocation based off of the lastLocation and the players decision(nextAreaChoice).
	 * @return
	 * it returns a string[] containing the narrative of that location.
	 */
	private static String[] chapter2() {
		monsters = null;		
		if (nextAreaChoice == 0)
			currentLocation = new Pond();
		if (nextAreaChoice == 1)
			currentLocation = new Path();
		
		monsters = currentLocation.getMonsters();//gets the monsters from this area
		foundItem = currentLocation.getLocationItem();//Adds item found in this area to founditem
		choices = currentLocation.options(); //Options on where to go next
		String prose = currentLocation.locationNarrative();//gets the narrative of the area
		lastLocation = currentLocation;
		currentLocation = null;
		return splitStringforBillboard(prose);
	}
	
	/**
	 * Each chapter creates a currentLocation based off of the lastLocation and the players decision(nextAreaChoice).
	 * @return
	 * it returns a string[] containing the narrative of that location.
	 */
	private static String[] chapter3() {
		monsters = new ArrayList<Monster>();
		if (lastLocation instanceof Path) {
			
			if (nextAreaChoice == 0)
				currentLocation = new Stream();
			else if (nextAreaChoice == 1)
				currentLocation = new AbandonedCamp();
		}
		
		else if (lastLocation instanceof Pond) {
			
			if (nextAreaChoice == 0)
				currentLocation = new Stream();
			else if (nextAreaChoice == 1)
				currentLocation = new Bog();
		}
		
		monsters = currentLocation.getMonsters();//gets the monsters from this area
		foundItem = currentLocation.getLocationItem();//Adds item found in this area to founditem
		choices = currentLocation.options(); //Options on where to go next
		String prose = currentLocation.locationNarrative();//gets the narrative of the area
		lastLocation = currentLocation;
		currentLocation = null;
		return splitStringforBillboard(prose);
	}
	
	/**
	 * Each chapter creates a currentLocation based off of the lastLocation and the players decision(nextAreaChoice).
	 * @return
	 * it returns a string[] containing the narrative of that location.
	 */
	private static String[] chapter4() {
		monsters = null;
		if (lastLocation instanceof AbandonedCamp) 
			currentLocation = new Docks();
	
		else if (lastLocation instanceof Stream) {
			
			if (nextAreaChoice == 0)
				currentLocation = new DeerKill();
			
			else if (nextAreaChoice == 1)
				currentLocation = new Docks();
		}
		
		else if (lastLocation instanceof Bog) 
			currentLocation = new DeerKill();
		
		monsters = currentLocation.getMonsters();//gets the monsters from this area
		foundItem = currentLocation.getLocationItem();//Adds item found in this area to founditem
		choices = currentLocation.options(); //Options on where to go next
		String prose = currentLocation.locationNarrative();//gets the narrative of the area
		lastLocation = currentLocation;
		currentLocation = null;
		return splitStringforBillboard(prose);
	}
	/**
	 * Each chapter creates a currentLocation based off of the lastLocation and the players decision(nextAreaChoice).
	 * @return
	 * it returns a string[] containing the narrative of that location.
	 */
	private static String[] chapter5() {
		monsters = null;
		if (lastLocation instanceof Docks) {
			if (nextAreaChoice == 0)
				currentLocation = new Mansion();
			else if (nextAreaChoice == 1)
				currentLocation = new Shack();
		}
		
		else if (lastLocation instanceof DeerKill) {
			if (nextAreaChoice == 0)
				currentLocation = new Shack();
			else if (nextAreaChoice == 1)
				currentLocation = new Mansion();
		}	
		
		monsters = currentLocation.getMonsters();//gets the monsters from this area
		foundItem = currentLocation.getLocationItem();//Adds item found in this area to founditem
		choices = currentLocation.options(); //Options on where to go next
		String prose = currentLocation.locationNarrative();//gets the narrative of the area
		lastLocation = currentLocation;
		currentLocation = null;
		return splitStringforBillboard(prose);
	}
	
	/**
	 * Each chapter creates a currentLocation based off of the lastLocation and the players decision(nextAreaChoice).
	 * @return
	 * it returns a string[] containing the narrative of that location.
	 */
	private static String[] chapter6() {
		monsters = null;
		if (lastLocation instanceof Mansion) {
			if (nextAreaChoice == 0) {
				currentLocation = new Cave();
				ending = 1;
			}
			else if (nextAreaChoice == 1) {
				currentLocation = new WolfDen();
				ending = 2;
			}
		}
		
		else if (lastLocation instanceof Shack) {
			if (nextAreaChoice == 0) { 
				currentLocation = new SpiderNest();
				ending = 3;
			}
			else if (nextAreaChoice == 1) {
				currentLocation = new WolfDen();
			ending = 2;	
			}
		}	
		
		monsters = currentLocation.getMonsters();//gets the monsters from this area
		foundItem = currentLocation.getLocationItem();//Adds item found in this area to founditem
		choices = currentLocation.options(); //Options on where to go next
		String prose = currentLocation.locationNarrative();//gets the narrative of the area
		lastLocation = currentLocation;
		currentLocation = null;
		return splitStringforBillboard(prose);
	}
	
	
	
	
	/**
	 * the end method gives the player the final message of their story
	 * @return
	 * a string[] containing the ending information
	 */
	public static String[] end() {
		String end;
		if (data.isPlayerDead()) 
			end = 
				"Your player has died..." +
				"Thank you for playing!";
		else {
			end = finalScene(ending);	
		}
		
		return splitStringforBillboard(end);
	}
	
	/**
	 * Checks if the Narrator is ready to end its story.
	 * This helps Game know what to do next. Perhaps you
	 * could check similarly for other chapters?
	 *
	 * @return
	 *   Returns <code>true</code> if the Narrator is currently about 
	 *   to tell the final chapter in the story, and <code>false</code> otherwise.
	 */
	public static boolean isAtFinalChapter() {
		return chapter == FINAL_CHAPTER;
	}
	
	/**
	 * combines 2 string arrays into 1 string array.
	 * @param first
	 * the first string[]
	 * @param second
	 * the second string[]
	 * @return
	 * a new string[] containing the information from both
	 */
	private static String[] combine(String[] first, String[] second) {
		// Copy the first, and make enough extra space for the second.
		String[] combined = Arrays.copyOf(first, first.length + second.length);
		// Copy the second into the extra space.
		System.arraycopy(second, 0, combined, first.length, second.length);
		return combined;
	}
	/**
	 * used to check which chapter the player is in
	 * @return
	 * integer of the chapters
	 */
	public static int getChapter() {
		return chapter;
	}
	
	/**
	 * returns the players decision to go to the next area
	 * @param areaChoice
	 * areaChoice is where the player wishes to go 
	 * @return
	 * areaChoice, so the game class can see where the player goes
	 */
	public static int nextAreaChoice(int areaChoice) {
		nextAreaChoice = areaChoice;
		return areaChoice;
	}
	
	/**
	 * Final scene, just a way to organize the 3 endings
	 * @param end
	 * end is an int, either 1, 2, or 3 based off of your choices in the game
	 * @return
	 * a String ending the story
	 */
	public static String finalScene(int end) {
		String endResults = "";
		if (end == 1) {
			endResults = "The cold, wet cavern lie still at last. It remains silent with the exception of the crackling fire. while examining "
					+ "the bodies and monster blood strewn everywhere, your eyes meet a cross etched in the stone wall. You think back to "
					+ "the note you read in the mansion... Could it be? You begin to dig with your hands, dirt piling up behind you "
					+ "for what feels like hours, until you feel something hard... A wood structure. Excited, you dig faster and faster, "
					+ "unearthing the wooden casket. You open the door, and a skeleton, decorated in golden armour stares up at you. "
					+ "Golden coins, necklaces, gemstones, crowns, and weapons fill the casket to the brim. You greedily fill your pouch with "
					+ "as much gold as it can hold, excited with your incredible find. You close the "
					+ "casket back up, and push all the dirt back into the hole, making sure it looks natural as you wish to return for more."
					+ " When you turn around, you notice the fire has burnt out, even though there is still wood on it. Too exausted to care, "
					+ "its time for you to head back to the outside world to "
					+ "find some water and food. You climb the winding tunnels back up towards the entrance. Unable to see any sunlight "
					+ "through the tunnel, you become uneasy... You arrive at the mouth of the cavern, but the entranceway has collapsed, with no "
					+ "other way out. A single ray of sunlight escapes through a crack in the mountain of rocks... You fall to your knees, "
					+ "the claustriphobia and panic setting in...";
		}
		else if (end == 2) {
			endResults = "The Werewolf's chest still rises and falls, but only faintly. You approach cautiously. In the distance "
					+ "you see the sun crack the horizon, its orange glow warms the air. As the sun inces higher and higher, the werewolf "
					+ "begins to shrink, claws, teeth, and fur retracting. You meet the man's gaze, and are overwhelmed with emotion; it is "
					+ "your father. His eyes welt with tears, sparkling in the sunlight, and he smiles at you. "
					+ "He murmurs \"I'm sorry.\" He tries to continue, his lips forming words but no sound escapes. You hold him tightly,"
					+ " tears flowing down your face, dripping from your cheekbones. You tell him its gonna be okay, that you love him. He nods, "
					+ "carefully examining your face one last time before his eyes stare into the distance, lifeless. ";
		}
		else if (end == 3) {
			endResults = "Spider bodies throw everywhere, you begin moving towards the queen. Your feet crunch on the ground "
					+ "as you accidentally step on giant spider legs. She lay on her back, her 8 hairy legs curled up into a ball above "
					+ "her. Up close, you can see she has been wounded many times. She has long scars all over her abdomen and "
					+ "face, indicating she has been in her fair share of fights. You decide that you shouldn't linger, as more "
					+ "spiders could be nearby, so you turn around and start heading back. You wonder why you ended up here, "
					+ "what gods could be toying with your fate. You look up at the full moon, it glows above a sheet of dark "
					+ "clouds, calming you. Suddenly, your foot shoots straight through the ground and you fall into a pit! Dazed, you "
					+ "come to and find yourself "
					+ "suspended in the air by a thick web. It takes a moment for you to realize what happened, but then you begin "
					+ "to panick, struggling against the sticky web, ultimately entagling yourself further. Hundreds of red eyes gleam at the edge "
					+ "of the pit, eager for revenge. The begin to scurry down the sides of the pit, and "
					+ "you let out one last scream. ";
		}
		
		return (endResults);
	}
	
}