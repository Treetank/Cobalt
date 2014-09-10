package org.laser.cobalt.gameworld;

import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.helpers.types.World;

public class GameWorld {

	protected CobaltGame game;
	protected World world;

	public GameWorld(CobaltGame game) {
		this.game = game;
		this.world = game.getWorld();
		game.SetLevel(world.getLevel());
	}

	public void update(float delta) {
	}

	public World getWorld() {
		return world;
	}
}
