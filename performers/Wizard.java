package performers;

import logic.Random;

/**
 * Wizards are the most powerful at casting, but are weak with their attack. their hitpoints are average
 * it can attack 2 enemies at once
 * @author Jon Steele
 *
 */
public class Wizard extends Player {
	
	/**
	 *wizard constructor fills hitpoints, strength, wisdom, defense, and max hitpoint variables
	 */
	public Wizard() {
		super(
			45,  // hitPoints
			4, // strength
			10, //wisdom
			8, //defense
			45// max hitpoints
		);
		}
	//attack does damage equal to strength to 2 monsters
	@Override
	public String[] attack(Monster... monsters) {
		String[] results = new String[monsters.length + 1];
		int i = 1;
		int simultaneousAttack = 2; //how many monsters player can attack per turn
		results[0] = "Wizard attack!";
		
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
		results[0] = "Wizard spell!";
		
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
			String[] results = {"Wizard casts a protective barrier!", "Wizard's hit points increase by "
								+ regenHealth +"!"};
		return (results);
		}

}
