package logic;

import java.util.ArrayList;

import graphics.Point2D;
import performers.*; // a shorthand for importing *all* classes from another package
/**
 * This is the class that will manage all the data of the game that needs to
 * be shared between the Game instance, and the Narrator class.
 * It was created so that you would not have to set up as many parameters when
 * creating your own methods in the project code.
 * 
 * @author Dr Russell Campbell
 *
 */
public class DataManager {
	private static String userName;
	// Memory address pointers to share data of the game.
	private static Player plyr;
	private static int N_MONSTERS = 5;
	private static ArrayList<Monster> monsters;
	
	/**
	 * This will create an instance of the subclass type of player for the user to control.
	 * 
	 * @param choice
	 *   Which kind of person the user chose to play as.
	 *
	 * @return
	 *   An instance of the subclass type of player chosen.
	 */
	public static Player createPlayer(int choice) {
		switch (PlayerType.values()[choice]) {
			case WARRIOR:
				return new Warrior();
			case WIZARD:
				return new Wizard();
			case ORC:
				return new Orc();
			case ELF:
				return new Elf();
		}
		return null;
	}
	
	/**
	 * A monster factory. Could create any number of any type of monsters you design.
	 * Either design this code to be random, or set things up in your own way.
	 * 
	 * @param monsters
	 *   A collection to store the monsters inside, so we can use them later in Game.
	 * 
	 * @param num
	 *   The number of monsters to create and add to the monsters collection.
	 */
	public static void createMonsters(ArrayList<Monster> monsters, int num) {
		DataManager.monsters = monsters;
		N_MONSTERS = num;
		// Generate a bunch of random monsters the player must defeat.
		for (int i = 0; i < N_MONSTERS; i++) {
			// If you had two different types of monster subclasses.
			int monsterType = Random.rand(6);
			switch (monsterType) {
				case 0:
					monsters.add(new Blob());
					break;
				case 1:
					monsters.add(new Rat());
					break;
				case 2:
					monsters.add(new Cyclopes());
					break;
				case 3:
					monsters.add(new Gorgon());
					break;
				case 4:
					monsters.add(new Manticore());
					break;
				case 5:
					monsters.add(new Werewolf());
					break;
				// Add more of your own different monster subclasses.
			}
		}
		// Notice that we do not need to return anything, because the monsters collection
		// was connected back in the Game class, so we can just use what was added above.
	}
	
	/**
	 * This is meant to be used by the Narrator to get a description of all the
	 * montsers currently inside the monsters collection.
	 *
	 * @return
	 *   An array of strings that describes the monsters stored in a collection.
	 */
	public static String[] describeMonsters() {
		String[] monsterDescriptions = new String[N_MONSTERS];
		//for (Monster mnstr : monsters) 
		for (int i = 0; i < N_MONSTERS; i++){
			monsterDescriptions[i] = monsters.get(i).getDescription();
		}
		return monsterDescriptions;
	}
	
	/**
	 * This is meant to be used by the Game class to set a pointer to a shared
	 * montsers collection. It is faster to just share a memory address rather
	 * than copy everything inside the collection. You need to call this in Game
	 * if you change the monsters collection to a new collection later.
	 * 
	 * @param monsters
	 *   A collection to store the monsters inside, so we can use them later in Game.
	 */
	public static void setMonsters(ArrayList<Monster> monsters) {
		DataManager.monsters = monsters;
	}
	
	/**
	 * This is meant to be used by the Game class to get a pointer to the
	 * montsers collection in case we need it. It is faster to just share
	 * a memory address rather than copy everything inside the collection.
	 *
	 * @return
	 *   A pointer to the collection of montsers.
	 */
	public static ArrayList<Monster> getMonsters() {
		return monsters;
	}
	
	/**
	 * Store the name the user entered at the beginning of the game.
	 * 
	 * @param userName
	 *   The name the user entered.
	 */
	public static void setUserName(String userName) {
		DataManager.userName = userName;
	}
	
	/**
	 * This is meant to be used by the Narrator, so they can welcome the user.
	 * You could imagine other reasons to call this method.
	 *
	 * @return
	 *   The string name the user entered.
	 */
	public static String getUserName() {
		return userName;
	}
	
	/**
	 * This is meant to be used by the tell() method of Narrator to avoid
	 * a NullPointerException near the beginning of the game.
	 *
	 * @return
	 *   A boolean value for whether the private Player is set 
	 *   to an instance (<code>true</code>).
	 */
	public static boolean isPlayerChosen() {
		return plyr != null;
	}
	
	/**
	 * Used by Game class to share the player instance with Narrator.
	 * 
	 * @param plyr
	 *   Meant to be the instance the user chose that was created earlier.
	 */
	public static void setPlayer(Player plyr) {
		DataManager.plyr = plyr;
	}
	
	/**
	 * This is meant to be used by the Narrator to check whether to skip to the end
	 * of the story.
	 *
	 * @return
	 *   The value <code>true</code> means the player has no hit points left and
	 *   so the game should skip to the end.
	 */
	public static boolean isPlayerDead() {
		return plyr.isDead();
	}
	
	public static void addBoss() {
		monsters.add(new KingOgre());
	}
	
}