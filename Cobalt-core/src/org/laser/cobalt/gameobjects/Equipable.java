package org.laser.cobalt.gameobjects;

import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.helpers.types.CombatStats;
import org.laser.cobalt.helpers.types.ImageProperties;

import com.badlogic.gdx.utils.Json;

public abstract class Equipable extends Drawable {

	protected final CombatStats stats;
	protected int level;

	protected class EquipableData {
		private final int level;

		public EquipableData(int level) {
			this.level = level;
		}

		public int getLevel() {
			return level;
		}

	}

	public Equipable(ImageProperties ip, TextureIndex texture, CombatStats stats, int level) {
		super(ip, texture);
		this.stats = stats;
		this.level = level;
	}

	public String save() {
		EquipableData data = new EquipableData(level);
		Json json = new Json();
		return json.toJson(data);
	}

	public abstract void load(String loadString);

	public CombatStats getStats() {
		return stats;
	}

	public int getLevel() {
		return level;
	}

	public abstract void levelUp();
}
