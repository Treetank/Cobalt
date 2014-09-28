package org.laser.cobalt.gameobjects;

import static org.laser.cobalt.CobaltBasics.ImageMetrics.MOB_SQUARE_SIZE;
import static org.laser.cobalt.CobaltBasics.ImageMetrics.TERRAIN_HEIGHT;

import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.gear.ChestArmor;
import org.laser.cobalt.gameobjects.gear.Equipable;
import org.laser.cobalt.gameobjects.gear.Weapon;
import org.laser.cobalt.gameobjects.gear.armor.NoChestArmor;
import org.laser.cobalt.gameobjects.gear.weapons.BareHands;
import org.laser.cobalt.helpers.DamageCalculator;
import org.laser.cobalt.helpers.types.ImageProperties;
import org.laser.cobalt.helpers.types.MobStats;
import org.laser.cobalt.helpers.types.Reward;
import org.laser.cobalt.helpers.types.TextureCollection;

public abstract class Mob extends Drawable {

	protected float swingTimer, beingHitTimer;
	protected TextureIndex beingHitImage;
	protected TextureCollection textureCollection;
	protected MobStats stats;
	protected ChestArmor chestArmor;
	protected Weapon weapon;

	public Mob(float x, TextureCollection tc, MobStats ms) {
		super(new ImageProperties(x, TERRAIN_HEIGHT, MOB_SQUARE_SIZE, MOB_SQUARE_SIZE), tc.Base());
		textureCollection = tc;
		stats = ms;
		swingTimer = 0;
		beingHitTimer = 0;
		equip(new NoChestArmor(1));
		equip(new BareHands(1));
	}

	public void update(float position, float delta) {
		super.update(position);
		if (swingTimer > 0) {
			swingTimer -= delta;
			if (swingTimer <= 0) {
				texture = textureCollection.Base();
			}
		}
		if (beingHitTimer > 0) {
			beingHitTimer -= delta;
			if (stats.Hp() <= 0 && beingHitTimer <= 0) {
				die();
			}
		}
	}

	public void swing(Mob mob) {
		if (!(swingTimer > 0)) {
			swingTimer = weapon.getAttackSpeed();
			if (swingHit(mob)) {
				receiveReward(mob.takeHit(DamageCalculator.CalculateDamage(this, mob), textureCollection.Damage()));
			}
			texture = textureCollection.Swinging();
		}
	}

	public Reward takeHit(int damage, TextureIndex hitImage) {
		beingHitImage = hitImage;
		beingHitTimer = 0.5f;
		if (stats.takeDamage(damage)) {
			return generateReward();
		} else {
			return null;
		}
	}

	public void die() {
	}

	public void respawn() {
		stats.heal(stats.getStatics().MaxHp());
		returnToBase();
	}

	public boolean takingDamage() {
		return beingHitTimer > 0;
	}

	public TextureIndex takingDamageImage() {
		return beingHitImage;
	}

	public void equip(Equipable item) {
		if (item instanceof Weapon) {
			unEquip(weapon);
			weapon = (Weapon) item;
		} else if (item instanceof ChestArmor) {
			unEquip(chestArmor);
			chestArmor = (ChestArmor) item;
		}
		stats.addToBonusStats(item.getStats());
	}

	public void unEquip(Equipable item) {
		if (item != null) {
			stats.removeBonusStats(item.getStats());
		}
	}

	public MobStats getStats() {
		return stats;
	}

	protected boolean swingHit(Mob mob) {
		return true;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public ChestArmor getChestArmor() {
		return chestArmor;
	}

	public abstract void receiveReward(Reward reward);

	protected abstract Reward generateReward();
}
