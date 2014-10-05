package org.laser.cobalt.gameobjects.gear;

import org.laser.cobalt.CobaltBasics.ItemIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.Drawable;
import org.laser.cobalt.gameobjects.gear.armor.LightPlate;
import org.laser.cobalt.gameobjects.gear.armor.NoChestArmor;
import org.laser.cobalt.gameobjects.gear.weapons.BareHands;
import org.laser.cobalt.gameobjects.gear.weapons.Sword;
import org.laser.cobalt.helpers.types.PrimaryStats;
import org.laser.cobalt.helpers.types.ImageProperties;
import org.laser.cobalt.helpers.types.SerializingData.EquipableData;

import com.badlogic.gdx.utils.Json;

public abstract class Equipable extends Drawable {

	protected final PrimaryStats stats;
	protected final ItemIndex itemIndex;
	protected int level;

	public Equipable(ImageProperties ip, TextureIndex texture, PrimaryStats stats, int level) {
		super(ip, texture);
		this.stats = stats;
		this.level = level;
		itemIndex = setupItemIndex();
	}

	public static Equipable ItemCreator(ItemIndex item, int level) {
		Equipable retVal;
		switch (item) {
		case BARE_HANDS:
			retVal = new BareHands(level);
			break;
		case LIGHT_CHEST_PLATE:
			retVal = new LightPlate(level);
			break;
		case NO_CHEST_PLATE:
			retVal = new NoChestArmor(level);
			break;
		case SWORD:
			retVal = new Sword(level);
			break;
		default:
			retVal = null;
			break;
		}
		return retVal;
	}

	public String save() {
		EquipableData data = new EquipableData();
		data.setLevel(getLevel());
		data.setItem(setupItemIndex());
		Json json = new Json();
		return json.toJson(data);
	}

	public PrimaryStats getStats() {
		return stats;
	}

	public int getLevel() {
		return level;
	}

	public static Equipable load(String loadString) {
		Json json = new Json();
		EquipableData data = json.fromJson(EquipableData.class, loadString);
		return Equipable.ItemCreator(data.getItem(), data.getLevel());
	}

	public ItemIndex getItemIndex() {
		return itemIndex;
	}

	public abstract void levelUp();

	public abstract ItemIndex setupItemIndex();
}
