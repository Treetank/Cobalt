package org.laser.cobalt.gameobjects;

import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.helpers.types.MobStats;
import org.laser.cobalt.helpers.types.TextureCollection;

public class Hero extends Mob {

	private float velocity;

	public Hero(float x, MobStats ms) {
		super(x, new TextureCollection(TextureIndex.HERO, TextureIndex.HERO_ATTACKING, TextureIndex.EXPLOSION), ms);
	}
	
	public float getVelocity() {
		return velocity;
	}
	
	public void moveRight() {
		velocity = stats.getStatics().MoveSpeed();
	}
	
	public void moveLeft() {
		velocity = -stats.getStatics().MoveSpeed();
	}
	
	public void stop() {
		velocity = 0;
	}
	
	public boolean isDead() {
		return stats.Hp() == 0;
	}
}
