package org.laser.cobalt.gameobjects.gear;

import static org.laser.cobalt.CobaltBasics.ImageMetrics.ARMOR_HEIGHT;
import static org.laser.cobalt.CobaltBasics.ImageMetrics.ARMOR_WIDTH;

import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.helpers.types.CombatStats;
import org.laser.cobalt.helpers.types.ImageProperties;

public abstract class ChestArmor extends Equipable {

	protected final float armorValue;

	public ChestArmor(TextureIndex texture, CombatStats stats, int level, float armorValue) {
		super(new ImageProperties(0, 0, ARMOR_HEIGHT, ARMOR_WIDTH), texture, stats, level);
		this.armorValue = armorValue;
	}

	public float getArmorValue() {
		return armorValue;
	}
}
