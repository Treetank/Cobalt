package org.laser.cobalt.helpers.types;

public class MobStats {

	private float hp, damage, exp;
	private StaticMobStats statics;
	private float strength, agility, intellect, stamina, vitality;
	private float bonusStrength, bonusAgility, bonusIntellect, bonusStamina, bonusVitality;

	public MobStats(StaticMobStats statics, float hp, float damage, float exp, float strength, float agility, float intellect, float stamina, float vitality) {
		this.statics = statics;
		this.hp = hp;
		this.damage = damage;
		this.exp = exp;
		this.strength = strength;
		this.agility = agility;
		this.intellect = intellect;
		this.stamina = stamina;
		this.vitality = vitality;
		bonusStrength = 0;
		bonusAgility = 0;
		bonusIntellect = 0;
		bonusStamina = 0;
		bonusVitality = 0;
	}

	public float getBaseStrength() {
		return strength;
	}

	public float getBaseAgility() {
		return agility;
	}

	public float getBaseIntellect() {
		return intellect;
	}

	public float getBaseStamina() {
		return stamina;
	}

	public float getBaseVitality() {
		return vitality;
	}

	public float getStrength() {
		return strength + bonusStrength;
	}

	public float getAgility() {
		return agility + bonusAgility;
	}

	public float getIntellect() {
		return intellect + bonusIntellect;
	}

	public float getStamina() {
		return stamina + bonusStamina;
	}

	public float getVitality() {
		return vitality + bonusVitality;
	}

	public void setStrength(float strength) {
		this.strength = strength;
	}

	public void setAgility(float agility) {
		this.agility = agility;
	}

	public void setIntellect(float intellect) {
		this.intellect = intellect;
	}

	public void setStamina(float stamina) {
		this.stamina = stamina;
	}

	public void setVitality(float vitality) {
		this.vitality = vitality;
	}

	public float getBonusStrength() {
		return bonusStrength;
	}

	public void setBonusStrength(float bonusStrength) {
		this.bonusStrength = bonusStrength;
	}

	public float getBonusAgility() {
		return bonusAgility;
	}

	public void setBonusAgility(float bonusAgility) {
		this.bonusAgility = bonusAgility;
	}

	public float getBonusIntellect() {
		return bonusIntellect;
	}

	public void setBonusIntellect(float bonusIntellect) {
		this.bonusIntellect = bonusIntellect;
	}

	public float getBonusStamina() {
		return bonusStamina;
	}

	public void setBonusStamina(float bonusStamina) {
		this.bonusStamina = bonusStamina;
	}

	public float getBonusVitality() {
		return bonusVitality;
	}

	public void setBonusVitality(float bonusVitality) {
		this.bonusVitality = bonusVitality;
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
