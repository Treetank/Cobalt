package org.laser.cobalt.gameobjects;

import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.helpers.types.CombatStats;
import org.laser.cobalt.helpers.types.ImageProperties;

public abstract class Equipable extends Drawable {

	protected final CombatStats stats;
	protected int level;
	
	private class EquipableData {
		
	}

	public Equipable(ImageProperties ip, TextureIndex texture, CombatStats stats, int level) {
		super(ip, texture);
		this.stats = stats;
		this.level = level;
	}

	public CombatStats getStats() {
		return stats;
	}
	
	public int getLevel() {return level;}
	
	public abstract void levelUp();
}
