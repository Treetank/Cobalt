package org.laser.cobalt.gameobjects.gear.armor;

import org.laser.cobalt.gameobjects.gear.ChestArmor;
import org.laser.cobalt.helpers.types.CombatStats;

import com.badlogic.gdx.utils.Json;

public class NoChestArmor extends ChestArmor {

	public NoChestArmor() {
		super(null, new CombatStats(0, 0, 0, 0, 0), 1, 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void levelUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void load(String loadString) {
		Json json = new Json();
		EquipableData data = json.fromJson(EquipableData.class, loadString);
		level = data.getLevel();
	}

}
