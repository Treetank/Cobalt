package org.laser.cobalt.gameobjects;

import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.helpers.types.CombatStats;
import org.laser.cobalt.helpers.types.ImageProperties;

public class Equipable extends Drawable {

	protected final CombatStats stats;

	public Equipable(ImageProperties ip, TextureIndex texture, CombatStats stats) {
		super(ip, texture);
		this.stats = stats;
	}

	public CombatStats getStats() {
		return stats;
	}
}
