package org.laser.cobalt.gameobjects;

import org.laser.cobalt.CobaltBasics;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.helpers.types.ImageProperties;
import org.laser.cobalt.helpers.types.MobStats;
import org.laser.cobalt.helpers.types.TextureCollection;

public class Mob extends Drawable {

	protected float swingTimer, beingHitTimer;
	protected TextureIndex beingHitImage;
	protected TextureCollection textureCollection;
	protected MobStats stats;

	public Mob(float x, TextureCollection tc, MobStats ms) {
		super(new ImageProperties (x, CobaltBasics.TERRAIN_HEIGHT, CobaltBasics.MOB_SQUARE_SIZE, CobaltBasics.MOB_SQUARE_SIZE), tc.Base());
		textureCollection = tc;
		stats = ms;
		swingTimer = 0;
		beingHitTimer = 0;
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
			swingTimer = stats.getStatics().SwingSpeed();
			stats.addExp(mob.takeHit(stats.Damage(), textureCollection.Damage()));
			texture = textureCollection.Swinging();
		}
	}

	public float takeHit(float damage, TextureIndex hitImage) {
		beingHitImage = hitImage;
		beingHitTimer = 0.5f;
		if (stats.takeDamage(damage)) {
			return stats.Exp();
		} else {
			return 0;
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

	public MobStats getStats() {
		return stats;
	}
}
