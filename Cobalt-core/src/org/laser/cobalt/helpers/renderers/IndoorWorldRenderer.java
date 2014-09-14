package org.laser.cobalt.helpers.renderers;

import org.laser.cobalt.CobaltBasics;
import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.gameobjects.levels.IndoorGameLevel;
import org.laser.cobalt.helpers.AssetLoader;
import org.laser.cobalt.interfaces.IRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class IndoorWorldRenderer extends CobaltRenderer implements IRenderer {

	public IndoorWorldRenderer(CobaltGame game) {
		super(game);
	}

	@Override
	public void render(float delta) {
		IndoorGameLevel level = (IndoorGameLevel) game.getLevel();

		TextureRegion tempRegion = null;
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		switch (level.getTerrainTexture()) {
		case IN_HOSPITAL:
			tempRegion = AssetLoader.storefront;
			break;
		default:
			tempRegion = AssetLoader.storefront;
			break;
		}
		batcher.begin();
		batcher.disableBlending();
		batcher.draw(tempRegion, 0, 0);
		batcher.enableBlending();
		font.draw(batcher, level.getGreeting(), 15, CobaltBasics.GAME_SCREEN_HEIGHT - 15);
		batcher.end();

		shapeRenderer.begin(ShapeType.Filled);
		drawGreeting();
		drawOptionOne();
		drawOptionTwo();
		drawOptionThree();
		drawOptionFour();
		shapeRenderer.end();
	}

	public void drawGreeting() {
		RoundRectangle(5, CobaltBasics.STOREFRONT_GREETING_WINDOW_BOTTOM, CobaltBasics.GAME_SCREEN_WIDTH - 5, CobaltBasics.GAME_SCREEN_HEIGHT - 5, 2);
	}

	public void drawOptionOne() {
		RoundRectangle(5, CobaltBasics.STOREFRONT_HEIGHT + CobaltBasics.STOREFRONT_OPTION_GAP * 2 + CobaltBasics.STOREFRONT_OPTION_HEIGHT,
				5 + CobaltBasics.STOREFRONT_OPTION_WIDTH, CobaltBasics.STOREFRONT_HEIGHT + CobaltBasics.STOREFRONT_OPTION_HEIGHT * 2
						+ CobaltBasics.STOREFRONT_OPTION_GAP * 2, 2);
	}

	public void drawOptionTwo() {
		RoundRectangle(5 + CobaltBasics.STOREFRONT_OPTION_WIDTH + CobaltBasics.STOREFRONT_OPTION_GAP, CobaltBasics.STOREFRONT_HEIGHT
				+ CobaltBasics.STOREFRONT_OPTION_GAP * 2 + CobaltBasics.STOREFRONT_OPTION_HEIGHT, 5 + CobaltBasics.STOREFRONT_OPTION_WIDTH * 2
				+ CobaltBasics.STOREFRONT_OPTION_GAP, CobaltBasics.STOREFRONT_HEIGHT + CobaltBasics.STOREFRONT_OPTION_HEIGHT * 2
				+ CobaltBasics.STOREFRONT_OPTION_GAP * 2, 2);
	}

	public void drawOptionThree() {
		RoundRectangle(5, CobaltBasics.STOREFRONT_HEIGHT + CobaltBasics.STOREFRONT_OPTION_GAP, 5 + CobaltBasics.STOREFRONT_OPTION_WIDTH,
				CobaltBasics.STOREFRONT_HEIGHT + CobaltBasics.STOREFRONT_OPTION_HEIGHT + CobaltBasics.STOREFRONT_OPTION_GAP, 2);
	}

	public void drawOptionFour() {
		RoundRectangle(5 + CobaltBasics.STOREFRONT_OPTION_WIDTH + CobaltBasics.STOREFRONT_OPTION_GAP, CobaltBasics.STOREFRONT_HEIGHT
				+ CobaltBasics.STOREFRONT_OPTION_GAP, 5 + CobaltBasics.STOREFRONT_OPTION_WIDTH * 2 + CobaltBasics.STOREFRONT_OPTION_GAP,
				CobaltBasics.STOREFRONT_HEIGHT + CobaltBasics.STOREFRONT_OPTION_HEIGHT + CobaltBasics.STOREFRONT_OPTION_GAP, 2);
	}
}
