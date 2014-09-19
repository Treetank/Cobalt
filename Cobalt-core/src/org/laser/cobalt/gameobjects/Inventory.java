package org.laser.cobalt.gameobjects;

import org.laser.cobalt.gameobjects.gear.armor.LightPlate;
import org.laser.cobalt.gameobjects.gear.weapons.Sword;

public class Inventory {

	private Sword sword;
	private LightPlate lightPlate;
	private int gold, redGems, blueGems, diamonds;

	public Inventory() {
		sword = null;
		lightPlate = null;
	}

	public void addItem(Equipable item) {

	}
	
	public void addCurrency(int g, int r, int b, int d) {
		gold += g;
		redGems += r;
		blueGems += b;
		diamonds += d;
	}
	
	public int getGold () {return gold;}
	
	public int getRedGems () {return redGems;}
	
	public int getBlueGems() {return blueGems;}

	public int getDiamonds() {return diamonds;}
	
	public Sword getSword() {
		return sword;
	}

	public LightPlate getLightPlate() {
		return lightPlate;
	}
}
