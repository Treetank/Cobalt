package org.laser.cobalt.gameobjects.gear.armor;

import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.gear.ChestArmor;
import org.laser.cobalt.helpers.types.CombatStats;

import com.badlogic.gdx.utils.Json;

public class LightPlate extends ChestArmor {

	public LightPlate(int level) {
		super(TextureIndex.LIGHT_CHEST_PLATE, new CombatStats(5, 0, 0, 15, 5), level, 10);
		// TODO Auto-generated constructor stub
	}

	public void levelUp() {

	}

	@Override
	public void load(String loadString) {
		Json json = new Json();
		EquipableData data = json.fromJson(EquipableData.class, loadString);
		level = data.getLevel();
	}
}
