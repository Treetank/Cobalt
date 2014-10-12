package org.laser.cobalt.gameworld;

import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.gameobjects.levels.GameLevel;
import org.laser.cobalt.helpers.types.World;

public class GameWorld {

	protected CobaltGame game;
	protected World world;
	protected GameLevel level;

	public GameWorld(CobaltGame game) {
		oldConstructor(game);
		// TODO newConstructor(game);
	}

	@Deprecated
	public void oldConstructor(CobaltGame game) {
		this.game = game;
		this.world = game.getWorld();
		game.setLevel(world.getLevel());
	}

	public void newConstructor(CobaltGame game) {

	}

	public void respawnHero() {
		world.getHero().getStats().heal(-1);
		world.getHero().stop();
		game.ChangeLevel(null);
	}

	public void update(float delta) {
		if (world.getHero().isDead()) {
			respawnHero();
		}
	}

	public World getWorld() {
		return world;
	}
}
