package org.laser.cobalt.gameobjects.npcs;

import org.laser.cobalt.CobaltBasics.EnemyIndex;
import org.laser.cobalt.gameobjects.Mob;
import org.laser.cobalt.gameobjects.npcs.enemies.Creeper;
import org.laser.cobalt.gameobjects.npcs.enemies.Imp;
import org.laser.cobalt.gameobjects.npcs.enemies.Slime;
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

	public static Mob EnemyCreator(EnemyIndex enemy, float position) {
		Mob retVal = null;
		switch (enemy) {
		case SLIME:
			retVal = new Slime(position);
			break;
		case IMP:
			retVal = new Imp(position);
			break;
		case CREEPER:
			retVal = new Creeper(position);
			break;
		default:
			break;
		}
		return retVal;
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