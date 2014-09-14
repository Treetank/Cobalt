package org.laser.cobalt.helpers.types;

public class CombatStats {

	protected float strength, agility, intellect, stamina, vitality;

	public CombatStats(float strength, float agility, float intellect, float stamina, float vitality) {
		this.strength = strength;
		this.agility = agility;
		this.intellect = intellect;
		this.stamina = stamina;
		this.vitality = vitality;
	}

	public float getStrength() {
		return strength;
	}

	public void setStrength(float strength) {
		this.strength = strength;
	}

	public float getAgility() {
		return agility;
	}

	public void setAgility(float agility) {
		this.agility = agility;
	}

	public float getIntellect() {
		return intellect;
	}

	public void setIntellect(float intellect) {
		this.intellect = intellect;
	}

	public float getStamina() {
		return stamina;
	}

	public void setStamina(float stamina) {
		this.stamina = stamina;
	}

	public float getVitality() {
		return vitality;
	}

	public void setVitality(float vitality) {
		this.vitality = vitality;
	}

}
