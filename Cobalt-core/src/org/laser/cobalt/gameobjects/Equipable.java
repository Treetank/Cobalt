package org.laser.cobalt.gameobjects;

import org.laser.cobalt.CobaltBasics.ItemIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.factories.EquipableFactory;
import org.laser.cobalt.helpers.types.CombatStats;
import org.laser.cobalt.helpers.types.ImageProperties;
import org.laser.cobalt.helpers.types.SerializingData.EquipableData;

import com.badlogic.gdx.utils.Json;

public abstract class Equipable extends Drawable {

	protected final CombatStats stats;
	protected final ItemIndex itemIndex;
	protected int level;

	public Equipable(ImageProperties ip, TextureIndex texture, CombatStats stats, int level) {
		super(ip, texture);
		this.stats = stats;
		this.level = level;
		itemIndex = getItemIndex();
	}

	public String save() {
		EquipableData data = new EquipableData();
		data.level = getLevel();
		data.item = getItemIndex();
		Json json = new Json();
		return json.toJson(data);
	}

	public CombatStats getStats() {
		return stats;
	}

	public int getLevel() {
		return level;
	}

	public abstract void levelUp();

	public static Equipable load(String loadString) {
		Json json = new Json();
		EquipableData data = json.fromJson(EquipableData.class, loadString);
		return EquipableFactory.ItemCreator(data.item, data.level);
	}

	public abstract ItemIndex getItemIndex();
}
