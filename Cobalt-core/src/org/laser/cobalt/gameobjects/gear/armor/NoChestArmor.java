package org.laser.cobalt.gameobjects.gear.armor;

import org.laser.cobalt.CobaltBasics.ItemIndex;
import org.laser.cobalt.gameobjects.gear.ChestArmor;
import org.laser.cobalt.helpers.types.CombatStats;

public class NoChestArmor extends ChestArmor {

	public NoChestArmor(int level) {
		super(null, new CombatStats(0, 0, 0, 0, 0), level, 0);
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
