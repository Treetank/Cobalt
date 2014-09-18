package org.laser.cobalt.helpers.types;

public class MobStats {

	private float hp, damage, exp;
	private StaticMobStats statics;
	private CombatStats baseStats, bonusStats;

	public MobStats(StaticMobStats statics, float hp, float damage, float exp, CombatStats combatStats) {
		this.statics = statics;
		this.hp = hp;
		this.damage = damage;
		this.exp = exp;
		baseStats = combatStats;
		bonusStats = new CombatStats(0, 0, 0, 0, 0);
	}

	public float getBaseStrength() {
		return baseStats.getStrength();
	}

	public float getBaseAgility() {
		return baseStats.getAgility();
	}

	public float getBaseIntellect() {
		return baseStats.getIntellect();
	}

	public float getBaseStamina() {
		return baseStats.getStamina();
	}

	public float getBaseVitality() {
		return baseStats.getVitality();
	}

	public float getStrength() {
		return baseStats.getStrength() + bonusStats.getStrength();
	}

	public float getAgility() {
		return baseStats.getAgility() + bonusStats.getAgility();
	}

	public float getIntellect() {
		return baseStats.getIntellect() + bonusStats.getIntellect();
	}

	public float getStamina() {
		return baseStats.getStamina() + bonusStats.getStamina();
	}

	public float getVitality() {
		return baseStats.getVitality() + bonusStats.getVitality();
	}

	public void setStrength(float strength) {
		baseStats.setStrength(strength);
	}

	public void setAgility(float agility) {
		baseStats.setAgility(agility);
	}

	public void setIntellect(float intellect) {
		baseStats.setIntellect(intellect);
	}

	public void setStamina(float stamina) {
		baseStats.setStamina(stamina);
	}

	public void setVitality(float vitality) {
		baseStats.setVitality(vitality);
	}

	public float getBonusStrength() {
		return bonusStats.getStrength();
	}

	public void setBonusStrength(float bonusStrength) {
		bonusStats.setStrength(bonusStrength);
	}

	public float getBonusAgility() {
		return bonusStats.getAgility();
	}

	public void setBonusAgility(float bonusAgility) {
		bonusStats.setAgility(bonusAgility);
	}

	public float getBonusIntellect() {
		return bonusStats.getIntellect();
	}

	public void setBonusIntellect(float bonusIntellect) {
		bonusStats.setIntellect(bonusIntellect);
	}

	public float getBonusStamina() {
		return bonusStats.getStamina();
	}

	public void setBonusStamina(float bonusStamina) {
		bonusStats.setStamina(bonusStamina);
	}

	public float getBonusVitality() {
		return bonusStats.getVitality();
	}

	public void setBonusVitality(float bonusVitality) {
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

	public float Hp() {
		return hp;
	};

	public float Damage() {
		return damage;
	};

	public float Exp() {
		return exp;
	};

	public boolean takeDamage(float damage) {
		hp -= damage;
		if (hp < 0) {
			hp = 0;
		}
		return hp == 0;
	}

	public void heal(float healing) {
		if (healing < 0) {
			hp = statics.MaxHp();
		} else {
			hp += healing;
			if (hp > statics.MaxHp()) {
				hp = statics.MaxHp();
			}
		}
	}

	public void setDamage(float damage) {
		this.damage = damage;
	}

	public void addExp(float exp) {
		this.exp += exp;
	}

	public StaticMobStats getStatics() {
		return statics;
	}

	public void setStatics(StaticMobStats statics) {
		this.statics = statics;
	}
}
