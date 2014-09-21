package org.laser.cobalt.gameobjects.gear.weapons;

import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.gear.Weapon;
import org.laser.cobalt.helpers.types.CombatStats;
import org.laser.cobalt.helpers.types.DamageArray;

import com.badlogic.gdx.utils.Json;

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
	public void load(String loadString) {
		Json json = new Json();
		EquipableData data = json.fromJson(EquipableData.class, loadString);
		level = data.getLevel();
	}
}
