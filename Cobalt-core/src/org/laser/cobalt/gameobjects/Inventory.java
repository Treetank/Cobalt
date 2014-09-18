package org.laser.cobalt.gameobjects;

import org.laser.cobalt.gameobjects.gear.armor.LightPlate;
import org.laser.cobalt.gameobjects.gear.weapons.Sword;

public class Inventory {

	private Sword sword;
	private LightPlate lightPlate;

	public Inventory() {
		sword = null;
		lightPlate = null;
	}

	public void addItem(Equipable item) {

	}

	public Sword getSword() {
		return sword;
	}

	public LightPlate getLightPlate() {
		return lightPlate;
	}
}
