package org.laser.cobalt.gameobjects.gear.weapons;

import org.laser.cobalt.gameobjects.gear.Weapon;
import org.laser.cobalt.helpers.types.CombatStats;

public class BareHands extends Weapon {

	public BareHands() {
		super(null, new CombatStats(0, 0, 0, 0, 0), 1, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void levelUp() {
		// TODO Auto-generated method stub

	}
	
	@Oveeride
	protected DamageArray setupDamage() {
		return null;
	}

}
