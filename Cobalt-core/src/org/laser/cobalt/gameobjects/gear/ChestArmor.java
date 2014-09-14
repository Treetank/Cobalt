package org.laser.cobalt.gameobjects.gear;

import org.laser.cobalt.CobaltBasics;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.Equipable;
import org.laser.cobalt.helpers.types.CombatStats;
import org.laser.cobalt.helpers.types.ImageProperties;

public class ChestArmor extends Equipable {

	protected final float armorValue;

	public ChestArmor(TextureIndex texture, CombatStats stats, float armorValue) {
		super(new ImageProperties(0, 0, CobaltBasics.ARMOR_HEIGHT, CobaltBasics.ARMOR_WIDTH), texture, stats);
		this.armorValue = armorValue;
	}

	public float getArmorValue() {
		return armorValue;
	}
}
