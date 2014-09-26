package org.laser.cobalt.gameobjects.gear;

import org.laser.cobalt.CobaltBasics;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.helpers.types.CombatStats;
import org.laser.cobalt.helpers.types.DamageArray;
import org.laser.cobalt.helpers.types.ImageProperties;

public abstract class Weapon extends Equipable {

	protected final float attackSpeed;
	protected final DamageArray baseDamage;


	public Weapon(TextureIndex texture, CombatStats stats, int level, float speed) {
		super(new ImageProperties(0, 0, CobaltBasics.WEAPON_HEIGHT, CobaltBasics.WEAPON_WIDTH), texture, stats, level);
		baseDamage = setupDamage();
		this.attackSpeed = speed;
	}

	public DamageArray getBaseDamage() {
		return baseDamage;
	}

	public float getAttackSpeed() {
		return attackSpeed;
	}

	protected abstract DamageArray setupDamage();
}
