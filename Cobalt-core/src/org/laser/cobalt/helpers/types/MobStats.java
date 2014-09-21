package org.laser.cobalt.helpers.types;

import org.laser.cobalt.helpers.types.SerializingData.MobStatsData;

import com.badlogic.gdx.utils.Json;

public class MobStats {

	private int hp, damage, exp;
	private StaticMobStats statics;
	private CombatStats baseStats, bonusStats;

	public MobStats(StaticMobStats statics, int hp, int damage, int exp, CombatStats combatStats) {
		this.statics = statics;
		this.hp = hp;
		this.damage = damage;
		this.exp = exp;
		baseStats = combatStats;
		bonusStats = new CombatStats(0, 0, 0, 0, 0);
	}

	public String save() {
		MobStatsData data = new MobStatsData();
		data.hp = Hp();
		data.damage = Damage();
		data.exp = Exp();
		data.staticsJson = statics.save();
		data.combatJson = baseStats.save();
		Json json = new Json();
		return json.toJson(data);
	}

	public void load(String loadString) {
		Json json = new Json();
		MobStatsData data = json.fromJson(MobStatsData.class, loadString);
		this.hp = data.hp;
		this.damage = data.damage;
		this.exp = data.exp;
		this.statics = StaticMobStats.load(data.staticsJson);
		baseStats.load(data.combatJson);
	}

	public int getBaseStrength() {
		return baseStats.getStrength();
	}

	public int getBaseAgility() {
		return baseStats.getAgility();
	}

	public int getBaseIntellect() {
		return baseStats.getIntellect();
	}

	public int getBaseStamina() {
		return baseStats.getStamina();
	}

	public int getBaseVitality() {
		return baseStats.getVitality();
	}

	public int getStrength() {
		return baseStats.getStrength() + bonusStats.getStrength();
	}

	public int getAgility() {
		return baseStats.getAgility() + bonusStats.getAgility();
	}

	public int getIntellect() {
		return baseStats.getIntellect() + bonusStats.getIntellect();
	}

	public int getStamina() {
		return baseStats.getStamina() + bonusStats.getStamina();
	}

	public int getVitality() {
		return baseStats.getVitality() + bonusStats.getVitality();
	}

	public void setStrength(int strength) {
		baseStats.setStrength(strength);
	}

	public void setAgility(int agility) {
		baseStats.setAgility(agility);
	}

	public void setIntellect(int intellect) {
		baseStats.setIntellect(intellect);
	}

	public void setStamina(int stamina) {
		baseStats.setStamina(stamina);
	}

	public void setVitality(int vitality) {
		baseStats.setVitality(vitality);
	}

	public int getBonusStrength() {
		return bonusStats.getStrength();
	}

	public void setBonusStrength(int bonusStrength) {
		bonusStats.setStrength(bonusStrength);
	}

	public int getBonusAgility() {
		return bonusStats.getAgility();
	}

	public void setBonusAgility(int bonusAgility) {
		bonusStats.setAgility(bonusAgility);
	}

	public int getBonusIntellect() {
		return bonusStats.getIntellect();
	}

	public void setBonusIntellect(int bonusIntellect) {
		bonusStats.setIntellect(bonusIntellect);
	}

	public int getBonusStamina() {
		return bonusStats.getStamina();
	}

	public void setBonusStamina(int bonusStamina) {
		bonusStats.setStamina(bonusStamina);
	}

	public int getBonusVitality() {
		return bonusStats.getVitality();
	}

	public void setBonusVitality(int bonusVitality) {
		bonusStats.setVitality(bonusVitality);
	}

	public void addToBonusStats(CombatStats stats) {
		bonusStats.setStrength(bonusStats.getStrength() + stats.getStrength());
		bonusStats.setAgility(bonusStats.getAgility() + stats.getAgility());
		bonusStats.setIntellect(bonusStats.getIntellect() + stats.getIntellect());
		bonusStats.setStamina(bonusStats.getStamina() + stats.getStamina());
		bonusStats.setVitality(bonusStats.getVitality() + stats.getVitality());
	}

	public void removeBonusStats(CombatStats stats) {
		bonusStats.setStrength(bonusStats.getStrength() - stats.getStrength());
		bonusStats.setAgility(bonusStats.getAgility() - stats.getAgility());
		bonusStats.setIntellect(bonusStats.getIntellect() - stats.getIntellect());
		bonusStats.setStamina(bonusStats.getStamina() - stats.getStamina());
		bonusStats.setVitality(bonusStats.getVitality() - stats.getVitality());
	}

	public int Hp() {
		return hp;
	};

	public int Damage() {
		return damage;
	};

	public int Exp() {
		return exp;
	};

	public boolean takeDamage(int damage) {
		hp -= damage;
		if (hp < 0) {
			hp = 0;
		}
		return hp == 0;
	}

	public void heal(int healing) {
		if (healing < 0) {
			hp = statics.MaxHp();
		} else {
			hp += healing;
			if (hp > statics.MaxHp()) {
				hp = statics.MaxHp();
			}
		}
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public void addExp(int exp) {
		this.exp += exp;
	}

	public StaticMobStats getStatics() {
		return statics;
	}

	public void setStatics(StaticMobStats statics) {
		this.statics = statics;
	}
}
