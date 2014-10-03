package org.laser.cobalt.helpers.types;

import org.laser.cobalt.helpers.types.SerializingData.PrimaryStatData;

import com.badlogic.gdx.utils.Json;

public class PrimaryStat {

	private int base, bonus;

	public PrimaryStat() {
	}

	public int getBase() {
		return base;
	}

	public int getBonus() {
		return bonus;
	}

	public int getStat() {
		return base + bonus;
	}

	public void setBase(int newBase) {
		base = newBase;
	}

	public void setBonus(int newBonus) {
		bonus = newBonus;
	}

	public String save() {
		PrimaryStatData data = new PrimaryStatData();
		data.setBase(this.base);
		data.setBonus(this.bonus);
		Json json = new Json();
		return json.toJson(data);
	}

	public void load(String loadString) {
		if (loadString != null & loadString != "") {
			Json json = new Json();
			PrimaryStatData data = json.fromJson(PrimaryStatData.class, loadString);
			this.base = data.getBase();
			this.bonus = data.getBonus();
		} else
			loadNew();
	}

	public void loadNew() {
		base = 0;
		bonus = 0;
	}
}
