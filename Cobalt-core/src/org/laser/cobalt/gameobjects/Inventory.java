package org.laser.cobalt.gameobjects;

import org.laser.cobalt.gameobjects.gear.armor.LightPlate;
import org.laser.cobalt.gameobjects.gear.weapons.Sword;
import org.laser.cobalt.helpers.types.SerializingData.InventoryData;

import com.badlogic.gdx.utils.Json;

public class Inventory {

	private Sword sword;
	private LightPlate lightPlate;
	private int gold, redGems, blueGems, diamonds;

	public Inventory() {
		sword = new Sword(0);
		lightPlate = new LightPlate(0);
		gold = 0;
		redGems = 0;
		blueGems = 0;
		diamonds = 0;
	}

	public String save() {
		InventoryData data = new InventoryData();
		data.gold = getGold();
		data.red = getRedGems();
		data.blue = getBlueGems();
		data.diamond = getDiamonds();
		data.lightPlateJson = getLightPlate().save();
		data.swordJson = getSword().save();
		Json json = new Json();
		return json.toJson(data);
	}

	public void load(String loadString) {
		Json json = new Json();
		InventoryData data = json.fromJson(InventoryData.class, loadString);
		resetCurrency();
		addCurrency(data.gold, data.red, data.blue, data.diamond);
		addItem(Equipable.load(data.lightPlateJson));
		addItem(Equipable.load(data.swordJson));
	}

	public void addItem(Equipable item) {

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
}
