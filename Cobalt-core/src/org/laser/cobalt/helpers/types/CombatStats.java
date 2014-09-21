package org.laser.cobalt.helpers.types;

import org.laser.cobalt.helpers.types.SerializingData.CombatStatsData;

import com.badlogic.gdx.utils.Json;

public class CombatStats {

	protected int strength, agility, intellect, stamina, vitality;

	public CombatStats(int strength, int agility, int intellect, int stamina, int vitality) {
		this.strength = strength;
		this.agility = agility;
		this.intellect = intellect;
		this.stamina = stamina;
		this.vitality = vitality;
	}

	public String save() {
		CombatStatsData data = new CombatStatsData();
		data.strength = getStrength();
		data.agility = getAgility();
		data.intellect = getIntellect();
		data.stamina = getStamina();
		data.vitality = getVitality();
		Json json = new Json();
		return json.toJson(data);
	}

	public void load(String loadString) {
		Json json = new Json();
		CombatStatsData data = json.fromJson(CombatStatsData.class, loadString);
		setStrength(data.strength);
		setAgility(data.agility);
		setIntellect(data.intellect);
		setStamina(data.stamina);
		setVitality(data.vitality);
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
