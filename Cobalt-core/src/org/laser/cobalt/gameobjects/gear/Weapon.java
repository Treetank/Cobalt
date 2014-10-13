package org.laser.cobalt.gameobjects.gear;

import static org.laser.cobalt.CobaltBasics.ImageMetrics.WEAPON_HEIGHT;
import static org.laser.cobalt.CobaltBasics.ImageMetrics.WEAPON_WIDTH;

import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.helpers.types.DamageArray;
import org.laser.cobalt.helpers.types.ImageProperties;
import org.laser.cobalt.helpers.types.PrimaryStats;

public abstract class Weapon extends Equipable {

	protected final float attackSpeed, range;
	protected final DamageArray baseDamage;

	public Weapon(TextureIndex texture, PrimaryStats stats, int level, float speed, float range) {
		super(new ImageProperties(0, 0, WEAPON_HEIGHT, WEAPON_WIDTH), texture, stats, level);
		this.range = range;
		baseDamage = setupDamage();
		this.attackSpeed = speed;
	}

	public DamageArray getBaseDamage() {
		return baseDamage;
	}

	public float getAttackSpeed() {
		return attackSpeed;
	}

	public float getRange() {
		return range;
	}

	protected abstract DamageArray setupDamage();
}
