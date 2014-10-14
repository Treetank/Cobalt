package org.laser.cobalt.helpers.renderers;

import static org.laser.cobalt.CobaltBasics.DeathSplashValues.SPLASH_X;
import static org.laser.cobalt.CobaltBasics.DeathSplashValues.SPLASH_Y;

import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.helpers.AssetLoader;
import org.laser.cobalt.interfaces.IRenderer;

public class GameOverRenderer extends CobaltRenderer implements IRenderer {

	public GameOverRenderer(CobaltGame game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(float delta) {
		batcher.begin();
		batcher.enableBlending();
		batcher.draw(AssetLoader.deathSplash, SPLASH_X, SPLASH_Y);
		batcher.end();
	}

}
