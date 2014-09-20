package org.laser.cobalt.helpers.types;

import com.badlogic.gdx.utils.Json;

public class CombatStats {

	protected int strength, agility, intellect, stamina, vitality;

	private class CombatStatsData {
		private final int strength, agility, intellect, stamina, vitality;

		public CombatStatsData(int strength, int agility, int intellect, int stamina, int vitality) {
			this.strength = strength;
			this.agility = agility;
			this.intellect = intellect;
			this.stamina = stamina;
			this.vitality = vitality;
		}

		public int getVitality() {
			return vitality;
		}

		public int getStamina() {
			return stamina;
		}

		public int getIntellect() {
			return intellect;
		}

		public int getAgility() {
			return agility;
		}

		public int getStrength() {
			return strength;
		}
	}

	public CombatStats(int strength, int agility, int intellect, int stamina, int vitality) {
		this.strength = strength;
		this.agility = agility;
		this.intellect = intellect;
		this.stamina = stamina;
		this.vitality = vitality;
	}

	public String save() {
		CombatStatsData data = new CombatStatsData(getStrength(), getAgility(), getIntellect(), getStamina(), getVitality());
		Json json = new Json();
		return json.toJson(data);
	}

	public void load(String loadString) {
		Json json = new Json();
		CombatStatsData data = json.fromJson(CombatStatsData.class, loadString);
		setStrength(data.getStrength());
		setAgility(data.getAgility());
		setIntellect(data.getIntellect());
		setStamina(data.getStamina());
		setVitality(data.getVitality());
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getIntellect() {
		return intellect;
	}

	public void setIntellect(int intellect) {
		this.intellect = intellect;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getVitality() {
		return vitality;
	}

	public void setVitality(int vitality) {
		this.vitality = vitality;
	}

}
