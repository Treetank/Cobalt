package org.laser.cobalt.helpers.types;

public class MobStats {

	private float hp, damage, exp;
	private StaticMobStats statics;

	public MobStats(StaticMobStats statics, float hp, float damage, float exp) {
		this.statics = statics;
		this.hp = hp;
		this.damage = damage;
		this.exp = exp;
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
