package org.laser.cobalt.gameobjects;

import org.laser.cobalt.CobaltBasics.ItemIndex;
import org.laser.cobalt.gameobjects.gear.Equipable;
import org.laser.cobalt.gameobjects.gear.armor.LightPlate;
import org.laser.cobalt.gameobjects.gear.armor.NoChestArmor;
import org.laser.cobalt.gameobjects.gear.weapons.BareHands;
import org.laser.cobalt.gameobjects.gear.weapons.Sword;
import org.laser.cobalt.helpers.types.SerializingData.InventoryData;

import com.badlogic.gdx.utils.Json;

public class Inventory {

	private Sword sword;
	private LightPlate lightPlate;
	private BareHands bareHands;
	private NoChestArmor noChest;
	private int gold, redGems, blueGems, diamonds;

	public Inventory() {
		sword = (Sword) Equipable.ItemCreator(ItemIndex.SWORD, 0);
		lightPlate = (LightPlate) Equipable.ItemCreator(ItemIndex.LIGHT_CHEST_PLATE, 0);
		bareHands = (BareHands) Equipable.ItemCreator(ItemIndex.BARE_HANDS, 0);
		noChest = (NoChestArmor) Equipable.ItemCreator(ItemIndex.NO_CHEST_PLATE, 0);
		gold = 0;
		redGems = 0;
		blueGems = 0;
		diamonds = 0;
	}

	public String save() {
		InventoryData data = new InventoryData();
		data.setGold(getGold());
		data.setRed(getRedGems());
		data.setBlue(getBlueGems());
		data.setDiamond(getDiamonds());
		data.setLightPlateJson(getLightPlate().save());
		data.setSwordJson(getSword().save());
		data.setNoChestJson(getNoChestArmor().save());
		data.setBareHandsJson(getBareHands().save());
		Json json = new Json();
		return json.toJson(data);
	}

	public void load(String loadString) {
		if (loadString != null && loadString != "") {
			Json json = new Json();
			InventoryData data = json.fromJson(InventoryData.class, loadString);
			resetCurrency();
			addCurrency(data.getGold(), data.getRed(), data.getBlue(), data.getDiamond());
			addItem(Equipable.load(data.getLightPlateJson()));
			addItem(Equipable.load(data.getSwordJson()));
			addItem(Equipable.load(data.getNoChestJson()));
			addItem(Equipable.load(data.getBareHandsJson()));
		} else
			loadNew();
	}

	public void loadNew() {
		resetCurrency();
		sword = (Sword) Equipable.ItemCreator(ItemIndex.SWORD, 0);
		lightPlate = (LightPlate) Equipable.ItemCreator(ItemIndex.LIGHT_CHEST_PLATE, 0);
		bareHands = (BareHands) Equipable.ItemCreator(ItemIndex.BARE_HANDS, 0);
		noChest = (NoChestArmor) Equipable.ItemCreator(ItemIndex.NO_CHEST_PLATE, 0);
	}

	public void addItem(Equipable item) {
		switch (item.getItemIndex()) {
		case BARE_HANDS:
			bareHands = (BareHands) item;
			break;
		case LIGHT_CHEST_PLATE:
			lightPlate = (LightPlate) item;
			break;
		case NO_CHEST_PLATE:
			noChest = (NoChestArmor) item;
			break;
		case SWORD:
			sword = (Sword) item;
			break;
		default:
			break;

		}
	}

	public void resetCurrency() {
		gold = 0;
		redGems = 0;
		blueGems = 0;
		diamonds = 0;
	}

	public void addCurrency(int g, int r, int b, int d) {
		gold += g;
		redGems += r;
		blueGems += b;
		diamonds += d;
	}

	public int getGold() {
		return gold;
	}

	public int getRedGems() {
		return redGems;
	}

	public int getBlueGems() {
		return blueGems;
	}

	public int getDiamonds() {
		return diamonds;
	}

	public Sword getSword() {
		return sword;
	}

	public LightPlate getLightPlate() {
		return lightPlate;
	}

	public BareHands getBareHands() {
		return bareHands;
	}

	public NoChestArmor getNoChestArmor() {
		return noChest;
	}
}
