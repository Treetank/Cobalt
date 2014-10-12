package org.laser.cobalt.helpers;

import org.laser.cobalt.CobaltBasics.Damage;
import org.laser.cobalt.gameobjects.Mob;

import com.badlogic.gdx.Gdx;

public class DamageCalculator {

	public static int CalculateDamage(Mob attacker, Mob defender) {
		int retVal = 0;
		retVal += calcPhysical(attacker, defender);
		Gdx.app.log("DamageCalculator", attacker.toString() + " against " + defender.toString() + " does " + retVal + " damage.");
		return retVal;
	}

	private static int calcPhysical(Mob attacker, Mob defender) {
		int retVal = 0;
		retVal += attacker.getWeapon().getBaseDamage().getDamage(Damage.PHYSICAL) * attacker.getPrimaryStats().getStrength();
		retVal -= defender.getChestArmor().getArmorValue() * (defender.getPrimaryStats().getStrength() + defender.getPrimaryStats().getAgility());
		if (retVal < 0)
			retVal = 0;
		return retVal;
	}
}
