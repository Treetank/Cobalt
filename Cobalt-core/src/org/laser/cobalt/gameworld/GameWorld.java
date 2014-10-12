package org.laser.cobalt.gameworld;

import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.gameobjects.levels.GameLevel;
import org.laser.cobalt.helpers.types.World;

public class GameWorld {

	protected CobaltGame game;
	protected World data;
	protected GameLevel level;

	public GameWorld(CobaltGame game) {
		this.game = game;
		oldConstructor(game);
		// TODO newConstructor(game);
	}

	@Deprecated
	public void oldConstructor(CobaltGame game) {
		this.data = game.getWorld();
		game.setLevel(data.getLevel());
	}

	public void newConstructor(CobaltGame game) {
		this.data = new World();
	}

	public void respawnHero() {
		data.getHero().getStats().heal(-1);
		data.getHero().stop();
		game.ChangeLevel(null);
	}

	public void update(float delta) {
		oldUpdate(delta);
		// TODO newUpdate(delta);
	}

	public void newUpdate(float delta) {
		data.update(delta);
	}

	@Deprecated
	public void oldUpdate(float delta) {
		if (data.getHero().isDead()) {
			respawnHero();
		}
	}

	public World getWorldData() {
		return data;
	}
}
