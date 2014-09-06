package org.laser.cobalt.gameworld;

import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.gameobjects.levels.FirstLevel;
import org.laser.cobalt.gameobjects.levels.SecondLevel;
import org.laser.cobalt.gameobjects.levels.ThirdLevel;
import org.laser.cobalt.helpers.types.World;

public class OutdoorGameWorld extends GameWorld {

	public OutdoorGameWorld(World world) {
		super(world);
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		if (world.getHero().isDead()) {
			respawnHero();
		}
	}

	public void respawnHero() {
		world.getHero().getStats().heal(world.getHero().getStats().getStatics().MaxHp());
		changeLevel(level.getLevelIndex());
	}

	@Override
	public void setLevel(LevelIndex level) {
		super.setLevel(level);
		switch (level) {
		case STARTING_PATH:
			this.level = new FirstLevel(this);
			break;
		case IMP_PATH:
			this.level = new SecondLevel(this);
			break;
		case CREEPER_PATH:
			this.level = new ThirdLevel(this);
			break;
		case HOSPITAL:
			this.level = new ThirdLevel(this);
			break;
		default:
			this.level = new FirstLevel(this);
			break;
		}
	}

	@Override
	public void changeLevel(LevelIndex level) {
		setLevel(level);
		world.setLevel(level);
		world.setLevelPosition(0);
		world.getHero().move(50);
	}
}
