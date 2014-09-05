package org.laser.cobalt.gameworld;

import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.gameobjects.GameLevel;
import org.laser.cobalt.gameobjects.levels.FirstLevel;
import org.laser.cobalt.gameobjects.levels.SecondLevel;
import org.laser.cobalt.gameobjects.levels.ThirdLevel;
import org.laser.cobalt.helpers.types.World;

public class GameWorld {

	private GameLevel level;
	private World world;

	public GameWorld(World world) {
		this.world = world;
		setLevel(world.getLevel());
	}

	public void update(float delta) {
		level.update(delta);
		if (world.getHero().isDead()) {
			respawnHero();
		}
	}

	public GameLevel getLevel() {
		return level;
	}

	public World getWorld() {
		return world;
	}

	public void respawnHero() {
		world.getHero().getStats().heal(world.getHero().getStats().getStatics().MaxHp());
		changeLevel(level.getLevelIndex());
	}

	public void setLevel(LevelIndex level) {
		switch (level) {
		case IMP_PATH:
			this.level = new SecondLevel(this);
			break;
		case STARTING_PATH:
			this.level = new FirstLevel(this);
			break;
		case CREEPER_PATH:
			this.level = new ThirdLevel(this);
			break;
		default:
			this.level = new FirstLevel(this);
			break;
		}
	}

	public void changeLevel(LevelIndex level) {
		setLevel(level);
		world.setLevel(level);
		world.setLevelPosition(0);
		world.getHero().move(50);
	}
}
