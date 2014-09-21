package org.laser.cobalt.gameobjects;

import org.laser.cobalt.helpers.types.MobStats;
import org.laser.cobalt.helpers.types.Reward;
import org.laser.cobalt.helpers.types.TextureCollection;

public abstract class Npc extends Mob {

	protected float respawnSpeed, respawnTimer;

	public Npc(float x, TextureCollection tc, MobStats ms) {
		super(x, tc, ms);
		respawnSpeed = 5;
		respawnTimer = 0;
	}

	@Override
	public void update(float position, float delta) {
		super.update(position, delta);
		if (respawnTimer > 0) {
			respawnTimer -= delta;
			if (respawnTimer < 0) {
				respawn();
			}
		}
	}

	@Override
	public void die() {
		respawnTimer = respawnSpeed;
		move(-500);
	}

	@Override
	public void receiveReward(Reward reward) {

	}

}
