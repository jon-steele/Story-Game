package logic;
import items.*;

import javax.swing.SwingUtilities;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import graphics.Drawable;
import graphics.Box;
import graphics.Circle;
import graphics.Fuzzy;
import gui.AnimatedGUI;
import gui.Panel2D;
import performers.Player;
import performers.Monster;
import story.Narrator;

/**
 * This is the class that will manage all parts of the game, bringing them together.
 * Its execution sets up the application window, begins other threads for animation,
 * and loops through the story of the game until the user either wins or loses.
 * 
 * @author Jon Steele
 *
 */
public class Game {
	
	// Only need one instance of each piece of the game, so they can all be static.
	
	// For the main application window for our program.
	private static AnimatedGUI window;
	// For the separate execution of our game logic.
	private static Thread gameThread;
	// For controlling the sharing of information between parts of our game.
	private static InputManager in = new InputManager();
	private static OutputManager out = new OutputManager();
	private static DataManager data = new DataManager();
	
	// For performers within our game that can do various interesting things.
	private static Player plyr;
	private static ArrayList<Monster> monsters;
	// How many monsters the player must defeat.
	private static int N_MONSTERS = 1;
	
	/**
	 * This is where the game begins.
	 */
	public void play() {
		
		setupApplicationWindow();
		setupAnimations();
		
		GameThread gameThread = new GameThread();
		in.setGameThread(gameThread);
		window.getPanelIO().setGameThread(gameThread);
		gameThread.start(); // begins execution of gameLoop method
		
		// Take special note of the small size of each method.
		// Small methods are easier to understand and debug.
	}
	
	private void setupApplicationWindow() {
		
		// our main application
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					window = new AnimatedGUI();
				}
			});
		} catch (InterruptedException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		// Connect GUI to the rest of our program.
		out.setPanelIO(window.getPanelIO());
		out.setPanelStats(window.getPanelStats());
		in.setPanelIO(window.getPanelIO());
	}
	
	private void setupAnimations() {
		// Now we have interfaces to let us collect objects that are NOT related.
		// This allows us to call the methods on each object in the collection described in Drawable.
		ArrayList<Drawable> actors = new ArrayList<Drawable>();
		actors.add(
			new Box(3, 25, 28, 6, 6, Panel2D.ORANGE)
		);
		actors.get(0).setParent(window.getPanel2D());
		window.getPanel2D().setActors(actors);
		
		// Can still change actors after connecting with Panel2D.
		actors.add(
			new Circle(10, 10, 3, 4, Panel2D.BLUE)
		);
		
		actors.add(
			new Fuzzy(20, 10)
		);
		
		// Fuzzy doesn't share static parentPanel with the other Shapes,
		// because it is not a subclass of Shape, so we have to set it separately.
		actors.get(2).setParent(window.getPanel2D());
		
		window.beginAnimation(); // same concepts as in Assignment 2
	}
	
	/**
	 * The basic program flow-of-control for our game.
	 * You could design your own flow-of-control if you want to make
	 * a completely different game. The basic flow here is for every iteration
	 * to interact with the user, and then process their choices until the user
	 * either achieves their goal, or fails.
	 */
	static void gameLoop() {
		start();
		
		while (Narrator.getChapter() != 7) {
			iteration(); // designed for Narrator to advance one chapter each iteration
			if (plyr.isDead())
				break;
		}
		finish();
	}
	
	/*
	 * The start of the game. Initialize and connect any part of the game that should 
	 * be set up before the iteration loop.
	 */
	private static void start() {
		Narrator.setData(data);
		data.setUserName(in.getInputString("Please enter your name, traveller! (enter below)"));
		// Needed to store the user's name in data, because there is no Player intsance created yet.
		// This is because the user still has to choose which subclass of Player they want to be.
		int choice = 0;
		out.printFancyIO(Narrator.tell());
		in.pause();
		boolean reDoChoice = true;
		
		//loops player choice until they enter a valid number
		while (reDoChoice = true) {
		reDoChoice = false;
		
		choice = in.getPlayerChoice();
	
		if (in.validateUserChoice(choice, 4) == false)
			reDoChoice = true;
		else
			break;
		}
		
		plyr = data.createPlayer(choice);		
		data.setPlayer(plyr);
		out.printInfoIO(in.getHistory(0));
		
		in.pause();
		Chest starter = new Chest();
		plyr.addItem(starter.getItem());
		out.printFancyIO(
				" __________", 
				" /\\____;;___\\", 
				"| /         /",
				"`. ())oo() .", 
				" |\\(%()*^^()^\\", 
				" | \\---------|",
				" \\ |    ))   |", 
				"  \\|_________|",
				"Your father's chest sits beneath a lonely Juniper tree",
				"you peer inside and see his old "+
				starter.getInfo(),
				"You stow it away."
				);
		in.pause();
		
		monsters = new ArrayList<Monster>();
	}
	
	/*
	 * This method is the part of the game that can be repeated. The basic
	 * idea is to give the player a choice, and then process that choice
	 * towards some kind of goal. Attacking monsters is a <b>very</b> common 
	 * theme in many games.
	 */
	private static void iteration() {

		// Describe some interesting events.
		out.printFancyIO(Narrator.tell());
		if (Narrator.foundItem != null)
			plyr.addItem(Narrator.foundItem);
		in.pause();
		monsters = Narrator.monsters;//narrator tells game which monsters to add
		data.setMonsters(monsters);
		playerPrintStats();
		monsterPrintStats();
		in.pause();
		
		// Player and monsters take turns attacking each other until either has no hit points.
		while (!monsters.isEmpty()) {

			playerAction();
			// You could design attacks on a random number of randomly chosen monsters.
			monsterActions();
			
			out.printInfoIO("You have " + plyr.getHitPoints() + " hit points left.");
			
			out.clearStats();
			playerPrintStats();
			monsterPrintStats();
			in.pause(); // give user time to absorb reading output of actions
			
			// No need to loop if player has no hit points remaining.
			if (plyr.isDead()) {
				Narrator.end();
				return;
			}
		}
		
		out.printInfoIO("----------\\\\ YOU DEFEATED ALL THE MONSTERS! //----------");
		out.clearStats();
		in.pause();
		plyr.resetHealth();
		int nextChoice = 0;
		boolean reDoChoice = true;
		
		//forces player to keep entering numbers until choice is valid
		while(reDoChoice == true) {
			reDoChoice = false;
		
			in.promptForChoice("Choose where to go next:", Narrator.choices);
			nextChoice = Narrator.nextAreaChoice(in.getInputInt("Which do you choose?"));
			
			if (in.validateUserChoice(nextChoice, (Narrator.choices.length)) == false)
				reDoChoice = true;
			else
				break;
		}

	}
	
	private static void finish() {
		// You could have different endings described in the Narrator.
		out.printFancyIO(Narrator.end());
		in.pause();
		out.printFancyIO("~~~ THE END ~~~");	
		return;
	}
	
	// Let the player decide what they want to do in a monster battle.
	private static void playerAction() {
		boolean reDoChoice = true;
		int choice = 0;
		String[] results = new String[] { "no actions processed yet" };
		String[] attackInfo = new String [] {"no attacks processed yet"};
		
		while (reDoChoice == true) {
		choice = in.getActionChoice();
		reDoChoice = false;

		//trips reDoChoice to be true if the player entered an incorrect value.
		if (in.validateUserChoice(choice, 4) == false) {
			reDoChoice = true;
			}
		}	
		
		switch (Actions.values()[choice]) {

			case ITEM:
				
					// Checks if inventory is empty
					if (plyr.getInventorySize() == 0) {
						out.printInfoIO("You have nothing in your Inventory");
						in.pause();
						playerAction();
						break;
					}
					
					// If not, then it lists the items in inventory and prompts user to choose
					else {
					in.promptForChoice("Choose an Item in your inventory", plyr.chooseItem());
					plyr.selectItem(in.getInputInt("Which do you choose?"));
					Item current = plyr.getCurrentItem();

					results = plyr.useCurrentItem();
					
						//if the player equipped a sword, the player will then attack					
						
						if (current.getName() == "Rusty Sword" || current.getName() == "Iron Sword" || 
								current.getName() == "Steel Sword"){
							
								if (monsters.size() >= 2)
									attackInfo = plyr.attack(monsters.get(0), monsters.get(1));
								else
									attackInfo = plyr.attack(monsters.get(0));
								String[] concatenatedResults = combineStringArrays(results, attackInfo);
								results = concatenatedResults;
						}
						
						// if the player equipped a staff, the player will then castSpell()
						else if (current.getName() == "Jade Staff" || current.getName() == "Amethyst Staff" || 
								current.getName() == "Sapphire Staff") {
							
								if (monsters.size() >= 6)
									attackInfo = plyr.castSpell(monsters.get(0), monsters.get(1), monsters.get(2),
											monsters.get(3), monsters.get(4), monsters.get(5));
								else if (monsters.size() == 5)
									attackInfo = plyr.castSpell(monsters.get(0), monsters.get(1), monsters.get(2),
											monsters.get(3), monsters.get(4));
								else if (monsters.size() == 4)
									attackInfo = plyr.castSpell(monsters.get(0), monsters.get(1), monsters.get(2),
											monsters.get(3));
								else if (monsters.size() == 3)
									attackInfo = plyr.castSpell(monsters.get(0), monsters.get(1), monsters.get(2));
								else if (monsters.size() == 2)
									attackInfo = plyr.castSpell(monsters.get(0), monsters.get(1));
								else if (monsters.size() == 1)
									attackInfo = plyr.castSpell(monsters.get(0));
								String[] concatenatedResults = combineStringArrays(results, attackInfo);
								results = concatenatedResults;
						}
						else {
							current = null;
						}
						//concatenating the information from useCurrentItem() and attack()
						


						current = null;
						break;
					}
				
			case DEFEND:
				if (!plyr.checkIfMaxHealth()){
					results = plyr.defend();
					break;	}
				else {
					out.printInfoIO("You are at max health! Attack the enemy!");
					in.pause();
					playerAction();
					break;
				}
				
			case ATTACK:
				
				if (monsters.size() > 2)
					results = plyr.attack(monsters.get(0), monsters.get(1));
				else
					results = plyr.attack(monsters.get(0));
				break;
				
			case CAST:		
				if (monsters.size() >= 6)
					results = plyr.castSpell(monsters.get(0), monsters.get(1), monsters.get(2),
							monsters.get(3), monsters.get(4), monsters.get(5));
				else if (monsters.size() == 5)
					results = plyr.castSpell(monsters.get(0), monsters.get(1), monsters.get(2),
							monsters.get(3), monsters.get(4));
				else if (monsters.size() == 4)
					results = plyr.castSpell(monsters.get(0), monsters.get(1), monsters.get(2),
							monsters.get(3));
				else if (monsters.size() == 3)
					results = plyr.castSpell(monsters.get(0), monsters.get(1), monsters.get(2));
				else if (monsters.size() == 2)
					results = plyr.castSpell(monsters.get(0), monsters.get(1));
				else if (monsters.size() == 1)
					results = plyr.castSpell(monsters.get(0));
				break;
		}
		out.printInfoIO(results);
		}
	
	// Clean up the monsters collection, and let remaining monsters do some actions.
	private static void monsterActions() {
		
		removeDefeatedMonsters();
		
		for (Monster mnstr : monsters) {
			String[] results;
			int mnstr_choice = Random.rand(3)+1; // +1 a way to omit ITEM choice
			switch (Actions.values()[mnstr_choice]) {
				case DEFEND:
					results = mnstr.defend();
					out.printInfoIO(results);
					break;
				case ATTACK:
					results = mnstr.attack(plyr);
					out.printInfoIO(results);
					break;
				case CAST:
					results = mnstr.castSpell(plyr);
					out.printInfoIO(results);
					break;
			}
			// No need to keep attacking if player has no hit points remaining.
			if (plyr.isDead()) {
				// Narrator will give details of losing the game elsewhere.
				return;
			}
		}
	}
	
	// Monsters with zero hit points should be removed from the monsters collection.
	private static void removeDefeatedMonsters() {
		ArrayList<Monster> temp = new ArrayList<Monster>();
		for (Monster mnstr : monsters)
			if (!mnstr.isDead()) temp.add(mnstr); // this avoids needing iterators
		monsters = temp;
		data.setMonsters(monsters); // update references to other parts of the game
	}
	
	// You could add code to print other statistics about the player.
	private static void playerPrintStats() {
		out.printInfoStats(
			data.getUserName() + "'s hit points: " + plyr.getHitPoints()
		);
		out.printBlankLineStats();
	}
	
	// Prints the stats of remaining monsters---again, you could design more statistics.
	private static void monsterPrintStats() {
		if (!monsters.isEmpty()) {
			String[] results = new String[monsters.size()];
			int k = 0;
			for (Monster mnstr : monsters) {
				results[k++] = 
					"The " + 
					mnstr.getDescription() + 
					" remains with " + 
					mnstr.getHitPoints() + 
					" hit points left.";
			}
			out.printInfoStats(results);
		}
	}
	
	/**
	 * Method that concatenates 2 string arrays into one String array
	 * 
	 * @param first
	 * the first array you want added into the String array
	 * @param second
	 * the second array you want added into the String array
	 * @return
	 * a string array containing the contents of the first and second string arrays
	 */
	public static String[] combineStringArrays(String[] first, String[] second) {
		int concatenatedSize = first.length + second.length;
		String[] result = new String[concatenatedSize];
		for (int i = 0; i < first.length; i++)
			result[i] = first[i];
		for (int i = 0; i < second.length; i++)
			result[(first.length)+i] = second[i];
		return result;
		
	}
}