package org.laser.cobalt.helpers.types;

import org.laser.cobalt.CobaltBasics.Damage;

public class DamageArray {

	protected int physical, fire, water, earth, lightning;

	public DamageArray() {
		physical = 0;
		fire = 0;
		water = 0;
		earth = 0;
		lightning = 0;
	}

	public void addDamage(Damage damageType, int amount) {
		switch (damageType) {
		case PHYSICAL:
			modifyPhysical(amount);
			break;
		case FIRE:
			modifyFire(amount);
			break;
		case WATER:
			modifyWater(amount);
			break;
		case EARTH:
			modifyEarth(amount);
			break;
		case LIGHTNING:
			modifyLightning(amount);
			break;
		default:
			break;
		}
	}

	private void modifyPhysical(int amount) {
		physical += amount;
	}

	private void modifyFire(int amount) {
		fire += amount;
	}

	private void modifyWater(int amount) {
		water += amount;
	}

	private void modifyEarth(int amount) {
		earth += amount;
	}

	private void modifyLightning(int amount) {
		lightning += amount;
	}

	public int getDamage(Damage damageType) {
		switch (damageType) {
		case PHYSICAL:
			return getPhysical();
		case FIRE:
			return getFire();
		case WATER:
			return getWater();
		case EARTH:
			return getEarth();
		case LIGHTNING:
			return getLightning();
		default:
			return getAllDamage();
		}
	}

	private int getPhysical() {
		return physical;
	}

	private int getFire() {
		return fire;
	}

	private int getWater() {
		return water;
	}

	private int getEarth() {
		return earth;
	}

	private int getLightning() {
		return lightning;
	}

	private int getAllDamage() {
		return getPhysical() + getFire() + getWater() + getEarth() + getLightning();
	}
}
