package org.laser.cobalt.gameworld;

import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.CobaltMain;
import org.laser.cobalt.helpers.types.World;

public class GameWorld {

	private CobaltMain mainGame;
	protected CobaltGame game;
	protected World world;

	public GameWorld(CobaltGame game) {
		this.game = game;
		this.world = game.getWorld();
		game.setLevel(world.getLevel());
	}

	public GameWorld(CobaltMain cobaltMain) {
		mainGame = cobaltMain;
		world = new World();
	}

	public void update(float delta) {
	}

	public World getWorld() {
		return world;
	}

	public void loadSuperHero() {

	}

	public void loadHero() {

	}

	public void loadNewHero() {
		world.loadNew();
	}

	public void save() {

	}
}
