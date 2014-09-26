package org.laser.cobalt.helpers.types;

import org.laser.cobalt.gameobjects.gear.Equipable;

public class Reward {

	private int experience, gold, redGems, blueGems, diamonds;
	private Equipable weapon, chestPiece;

	public Reward() {
		experience = 0;
		gold = 0;
		redGems = 0;
		blueGems = 0;
		diamonds = 0;
		weapon = null;
		chestPiece = null;
	}

	public Equipable getChestPiece() {
		return chestPiece;
	}

	public void setChestPiece(Equipable chestPiece) {
		this.chestPiece = chestPiece;
	}

	public Equipable getWeapon() {
		return weapon;
	}

	public void setWeapon(Equipable weapon) {
		this.weapon = weapon;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getRedGems() {
		return redGems;
	}

	public void setRedGems(int redGems) {
		this.redGems = redGems;
	}

	public int getBlueGems() {
		return blueGems;
	}

	public void setBlueGems(int blueGems) {
		this.blueGems = blueGems;
	}

	public int getDiamonds() {
		return diamonds;
	}

	public void setDiamonds(int diamonds) {
		this.diamonds = diamonds;
	}
}
