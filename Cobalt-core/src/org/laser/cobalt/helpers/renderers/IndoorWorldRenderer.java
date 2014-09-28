package org.laser.cobalt.helpers.renderers;

import static org.laser.cobalt.CobaltBasics.GameWindowMetrics.SCREEN_HEIGHT;
import static org.laser.cobalt.CobaltBasics.GameWindowMetrics.SCREEN_WIDTH;
import static org.laser.cobalt.CobaltBasics.ImageMetrics.STOREFRONT_HEIGHT;
import static org.laser.cobalt.CobaltBasics.StoreMetrics.FONT_HEIGHT_OFFSET;
import static org.laser.cobalt.CobaltBasics.StoreMetrics.GREETING_WINDOW_BOTTOM;
import static org.laser.cobalt.CobaltBasics.StoreMetrics.OPTION_GAP;
import static org.laser.cobalt.CobaltBasics.StoreMetrics.OPTION_HEIGHT;
import static org.laser.cobalt.CobaltBasics.StoreMetrics.OPTION_WIDTH;

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
		font.draw(batcher, level.getGreeting(), 15, SCREEN_HEIGHT - 15);
		if (level.optionIsAvailable(0)) {
			font.draw(batcher, level.getOptions()[0], 15, STOREFRONT_HEIGHT + OPTION_GAP * 2 + OPTION_HEIGHT + FONT_HEIGHT_OFFSET);
		}
		if (level.getOptions().length > 1 && level.optionIsAvailable(1)) {
			font.draw(batcher, level.getOptions()[1], 15 + OPTION_WIDTH + OPTION_GAP, STOREFRONT_HEIGHT + OPTION_GAP * 2 + OPTION_HEIGHT + FONT_HEIGHT_OFFSET);
		}
		if (level.getOptions().length > 2 && level.optionIsAvailable(2)) {
			font.draw(batcher, level.getOptions()[2], 15, STOREFRONT_HEIGHT + OPTION_GAP + FONT_HEIGHT_OFFSET);
		}
		font.draw(batcher, "EXIT", 15 + OPTION_WIDTH + OPTION_GAP, STOREFRONT_HEIGHT + OPTION_GAP + FONT_HEIGHT_OFFSET);
		batcher.end();

		shapeRenderer.begin(ShapeType.Filled);
		drawGreeting();
		if (level.optionIsAvailable(0)) {
			drawOptionOne();
		}
		if (level.getOptions().length > 1 && level.optionIsAvailable(1)) {
			drawOptionTwo();
		}
		if (level.getOptions().length > 2 && level.optionIsAvailable(2)) {
			drawOptionThree();
		}
		drawOptionFour();
		shapeRenderer.end();
	}

	public void drawGreeting() {
		RoundRectangle(5, GREETING_WINDOW_BOTTOM, SCREEN_WIDTH - 5, SCREEN_HEIGHT - 5, 2);
	}

	public void drawOptionOne() {
		RoundRectangle(5, STOREFRONT_HEIGHT + OPTION_GAP * 2 + OPTION_HEIGHT, 5 + OPTION_WIDTH, STOREFRONT_HEIGHT + OPTION_HEIGHT * 2 + OPTION_GAP * 2, 2);
	}

	public void drawOptionTwo() {
		RoundRectangle(5 + OPTION_WIDTH + OPTION_GAP, STOREFRONT_HEIGHT + OPTION_GAP * 2 + OPTION_HEIGHT, 5 + OPTION_WIDTH * 2 + OPTION_GAP, STOREFRONT_HEIGHT
				+ OPTION_HEIGHT * 2 + OPTION_GAP * 2, 2);
	}

	public void drawOptionThree() {
		RoundRectangle(5, STOREFRONT_HEIGHT + OPTION_GAP, 5 + OPTION_WIDTH, STOREFRONT_HEIGHT + OPTION_HEIGHT + OPTION_GAP, 2);
	}

	public void drawOptionFour() {
		RoundRectangle(5 + OPTION_WIDTH + OPTION_GAP, STOREFRONT_HEIGHT + OPTION_GAP, 5 + OPTION_WIDTH * 2 + OPTION_GAP, STOREFRONT_HEIGHT + OPTION_HEIGHT
				+ OPTION_GAP, 2);
	}
}
