package org.laser.cobalt.gameworld;

import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.gameobjects.GameLevel;
import org.laser.cobalt.helpers.types.World;

public class GameWorld {

	protected GameLevel level;
	protected World world;

	public GameWorld(World world) {
		this.world = world;
		setLevel(world.getLevel());
	}

	public void update(float delta) {
		level.update(delta);
	}

	public GameLevel getLevel() {
		return level;
	}

	public World getWorld() {
		return world;
	}

	public void setLevel(LevelIndex level) {
	}

	public void changeLevel(LevelIndex level) {
	}
}
