package org.laser.cobalt.gameobjects;

import org.laser.cobalt.gameobjects.gear.armor.LightPlate;
import org.laser.cobalt.gameobjects.gear.weapons.Sword;

import com.badlogic.gdx.utils.Json;

public class Inventory {

	private Sword sword;
	private LightPlate lightPlate;
	private int gold, redGems, blueGems, diamonds;

	private class InventoryData {
		private final int gold, red, blue, diamond;
		private final String lightPlateJson, swordJson;

		public InventoryData(int gold, int red, int blue, int diamond, String lightPlateJson, String swordJson) {
			this.gold = gold;
			this.red = red;
			this.blue = blue;
			this.diamond = diamond;
			this.lightPlateJson = lightPlateJson;
			this.swordJson = swordJson;
		}

		public int getGold() {
			return gold;
		}

		public int getRedGems() {
			return red;
		}

		public int getBlueGems() {
			return blue;
		}

		public int getDiamonds() {
			return diamond;
		}

		public String getLightPlateJson() {
			return lightPlateJson;
		}

		public String getSwordJson() {
			return swordJson;
		}
	}

	public Inventory() {
		sword = null;
		lightPlate = null;
		gold = 0;
		redGems = 0;
		blueGems = 0;
		diamonds = 0;
	}

	public String save() {
		InventoryData data = new InventoryData(getGold(), getRedGems(), getBlueGems(), getDiamonds(), getLightPlate().save(), getSword().save());
		Json json = new Json();
		return json.toJson(data);
	}

	public void load(String loadString) {
		Json json = new Json();
		InventoryData data = json.fromJson(InventoryData.class, loadString);
		resetCurrency();
		addCurrency(data.getGold(), data.getRedGems(), data.getBlueGems(), data.getDiamonds());
		getLightPlate().load(data.getLightPlateJson());
		getSword().load(data.getSwordJson());
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
