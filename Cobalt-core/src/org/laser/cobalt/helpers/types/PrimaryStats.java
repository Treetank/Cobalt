package org.laser.cobalt.helpers.types;

import org.laser.cobalt.helpers.types.SerializingData.PrimaryStatsData;

import com.badlogic.gdx.utils.Json;

public class PrimaryStats extends SavableData {

	private int strength, agility, intellect, stamina, vitality;

	public PrimaryStats() {
		setStats(0, 0, 0, 0, 0);
	}

	public PrimaryStats(int strength, int agility, int intellect, int stamina, int vitality) {
		setStats(strength, agility, intellect, stamina, vitality);
	}

	public void setStats(int strength, int agility, int intellect, int stamina, int vitality) {
		this.strength = strength;
		this.agility = agility;
		this.intellect = intellect;
		this.stamina = stamina;
		this.vitality = vitality;
	}

	@Override
	public String save() {
		PrimaryStatsData data = new PrimaryStatsData();
		data.setStrength(this.strength);
		data.setAgility(this.agility);
		data.setIntellect(this.intellect);
		data.setStamina(this.stamina);
		data.setVitality(this.vitality);
		Json json = new Json();
		return json.toJson(data);
	}

	@Override
	public void loadNew() {
		setStats(0, 0, 0, 0, 0);
	}

	@Override
	public void loadData(String loadString) {
		Json json = new Json();
		PrimaryStatsData data = json.fromJson(PrimaryStatsData.class, loadString);
		setStats(data.getStrength(), data.getAgility(), data.getIntellect(), data.getStamina(), data.getVitality());
	}

	public void addStats(PrimaryStats stats) {
		this.strength += stats.strength;
		this.agility += stats.agility;
		this.intellect += stats.intellect;
		this.stamina += stats.stamina;
		this.vitality += stats.vitality;
	}

	public void removeStats(PrimaryStats stats) {
		this.strength -= stats.strength;
		if (this.strength > 0)
			this.strength = 0;
		this.agility -= stats.agility;
		if (this.agility > 0)
			this.agility = 0;
		this.intellect -= stats.intellect;
		if (this.intellect > 0)
			this.intellect = 0;
		this.stamina -= stats.stamina;
		if (this.stamina > 0)
			this.stamina = 0;
		this.vitality -= stats.vitality;
		if (this.vitality > 0)
			this.vitality = 0;
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
