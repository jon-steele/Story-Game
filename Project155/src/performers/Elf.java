package performers;

import logic.Random;
/**
 * Elves are the most deadly players in the game. They have the highest strength, and the second highest
 * wisdom. However, they have the lowest hit points, at 35, and the lowest defense, at 4.
 * @author Jon Steele
 *
 */
public class Elf extends Player {

	/**
	 *elf constructor fills hitpoints, strength, wisdom, defense, and max hitpoint variables
	 */
	public Elf() {
		super(
			35,  // hitPoints
			10, // strength
			8, //wisdom
			4, //defense
			35// max hitpoints
		);
	}
	//elf attack does damage (equal to strength) to up to 3 monsters
	@Override
		public String[] attack(Monster... monsters) {
			String[] results = new String[monsters.length + 1];
			int i = 1;
			int simultaneousAttack = 3; //how many monsters player can attack per turn
			results[0] = "Elf attack!";
			
			// damages 3 monsters passed in.
			for (Monster mnstr : monsters) {
				if (i < (simultaneousAttack + 1)) {
				int damage = strength;
				mnstr.damageHitPoints(damage);
				// Describe stats on this monster.
				results[i] = 
					"- hit " + 
					mnstr.getDescription() + 
					" with " + 
					damage + 
					" damage;" +
					" it has " + 
					mnstr.getHitPoints() +
					" hit points remaining.";
				}
				else {
					results[i] = mnstr.getDescription() + " has " + mnstr.getHitPoints() + "hit points remaining.";
				}
				i++;
			}
			return results;
		}

	//castspell randomly damages all monsters
	@Override
	public String[] castSpell(Monster... monsters) {
		String[] results = new String[monsters.length + 1];
		int i = 1;
		results[0] = "Elf spell!";
		
		// damage every monster passed in.
		for (Monster mnstr : monsters) {
			
			// Design your own calculations.
			int damage = Random.rand(wisdom) + 2;
			mnstr.damageHitPoints(damage);
			// Describe stats on this monster.
			results[i] = 
				"- hit " + 
				mnstr.getDescription() + 
				" with " + 
				damage + 
				" damage;" +
				" it has " + 
				mnstr.getHitPoints() +
				" hit points remaining.";
			i++;	
		}

		
		return results;
	}
	@Override
	public String[] defend() {
		int pointsDifference = MAX_HIT_POINTS - hitPoints;
		int regenHealth = 0;
		
		if (pointsDifference >= defense) {
			regenHealth = defense;
			hitPoints = hitPoints + regenHealth;
		}	
		else if (pointsDifference < defense && pointsDifference > 0) {
			regenHealth = pointsDifference;
			hitPoints = hitPoints + regenHealth;
		}
			String[] results = {"Elf cowers from the attacks!", "Elf's cowardice increases his hit points by "
								+ regenHealth +"!"};
		return (results);
		}

}
