package org.laser.cobalt.gameworld;

import org.laser.cobalt.CobaltGame;

public class OutdoorGameWorld extends GameWorld {

	public OutdoorGameWorld(CobaltGame game) {
		super(game);
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		if (world.getHero().isDead()) {
			respawnHero();
		}
	}

	public void respawnHero() {
		world.getHero().getStats().heal(-1);
		game.ChangeLevel(null);
	}
}
