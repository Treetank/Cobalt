package org.laser.cobalt.gameobjects.gear.weapons;

import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.gear.Weapon;
import org.laser.cobalt.helpers.types.CombatStats;

public class Sword extends Weapon {

	public Sword() {
		super(TextureIndex.SWORD, new CombatStats(5, 0, 0, 5, 0), 1, 1);
		// TODO Auto-generated constructor stub
	}

}
