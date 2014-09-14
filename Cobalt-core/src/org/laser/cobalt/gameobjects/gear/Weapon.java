package org.laser.cobalt.gameobjects.gear;

import org.laser.cobalt.CobaltBasics;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.Equipable;
import org.laser.cobalt.helpers.types.CombatStats;
import org.laser.cobalt.helpers.types.ImageProperties;

public class Weapon extends Equipable {

	protected final float baseDamage, attackSpeed;

	public Weapon(TextureIndex texture, CombatStats stats, float damage, float speed) {
		super(new ImageProperties(0, 0, CobaltBasics.WEAPON_HEIGHT, CobaltBasics.WEAPON_WIDTH), texture, stats);
		this.baseDamage = damage;
		this.attackSpeed = speed;
	}

	public float getBaseDamage() {
		return baseDamage;
	}

	public float getAttackSpeed() {
		return attackSpeed;
	}

}
