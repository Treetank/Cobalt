package org.laser.cobalt.gameobjects.gear.armor;

import static org.laser.cobalt.CobaltBasics.StatMetrics.GearStats.ChestArmorStats.NoChestStats.LEVEL_1_AGILITY;
import static org.laser.cobalt.CobaltBasics.StatMetrics.GearStats.ChestArmorStats.NoChestStats.LEVEL_1_DEFENSE;
import static org.laser.cobalt.CobaltBasics.StatMetrics.GearStats.ChestArmorStats.NoChestStats.LEVEL_1_INTELLECT;
import static org.laser.cobalt.CobaltBasics.StatMetrics.GearStats.ChestArmorStats.NoChestStats.LEVEL_1_STAMINA;
import static org.laser.cobalt.CobaltBasics.StatMetrics.GearStats.ChestArmorStats.NoChestStats.LEVEL_1_STRENGTH;
import static org.laser.cobalt.CobaltBasics.StatMetrics.GearStats.ChestArmorStats.NoChestStats.LEVEL_1_VITALITY;

import org.laser.cobalt.CobaltBasics.ItemIndex;
import org.laser.cobalt.gameobjects.gear.ChestArmor;
import org.laser.cobalt.helpers.types.CombatStats;

public class NoChestArmor extends ChestArmor {

	public NoChestArmor(int level) {
		super(null, new CombatStats(LEVEL_1_STRENGTH, LEVEL_1_AGILITY, LEVEL_1_INTELLECT, LEVEL_1_STAMINA, LEVEL_1_VITALITY), level, LEVEL_1_DEFENSE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void levelUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public ItemIndex setupItemIndex() {
		return ItemIndex.NO_CHEST_PLATE;
	}

}
