package org.laser.cobalt.gameobjects.gear.weapons;

import org.laser.cobalt.CobaltBasics.ItemIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.gear.Weapon;
import org.laser.cobalt.helpers.types.CombatStats;
import org.laser.cobalt.helpers.types.DamageArray;

public class Sword extends Weapon {

	public Sword(int level) {
		super(TextureIndex.SWORD, new CombatStats(5, 0, 0, 5, 0), level, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void levelUp() {

	}

	@Override
	protected DamageArray setupDamage() {
		return null;
	}

	@Override
	public ItemIndex getItemIndex() {
		return ItemIndex.SWORD;
	}
}
