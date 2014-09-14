package org.laser.cobalt.helpers.renderers;

import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.DeviceInfo;
import org.laser.cobalt.gameworld.GameWorld;
import org.laser.cobalt.helpers.AssetLoader;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class CobaltRenderer {

	protected CobaltGame game;
	protected GameWorld gameWorld;
	protected OrthographicCamera cam;
	protected ShapeRenderer shapeRenderer;
	protected SpriteBatch batcher;
	protected BitmapFont font;

	public CobaltRenderer(CobaltGame game) {
		this.game = game;
		this.gameWorld = game.getGameWorld();

		cam = new OrthographicCamera();
		shapeRenderer = new ShapeRenderer();
		batcher = new SpriteBatch();
		font = AssetLoader.font;

		cam.setToOrtho(false, DeviceInfo.gameWidth, DeviceInfo.gameHeight);
		shapeRenderer.setProjectionMatrix(cam.combined);
		batcher.setProjectionMatrix(cam.combined);
		font.setColor(Color.WHITE);
		font.setScale(0.4f, 0.4f);
	}

	public void RoundRectangle(float x1, float y1, float x2, float y2, float w) {
		shapeRenderer.circle(x1 + w, y1 + w, w);
		shapeRenderer.circle(x1 + w, y2 - w, w);
		shapeRenderer.circle(x2 - w, y1 + w, w);
		shapeRenderer.circle(x2 - w, y2 - w, w);
		shapeRenderer.rect(x1 + w, y1, x2 - x1 - 2 * w, w);
		shapeRenderer.rect(x1, y1 + w, w, y2 - y1 - 2 * w);
		shapeRenderer.rect(x1 + w, y2 - w, x2 - x1 - 2 * w, w);
		shapeRenderer.rect(x2 - w, y1 + w, w, y2 - y1 - 2 * w);
		shapeRenderer.setColor(0, 0, 0, 1);
		shapeRenderer.circle(x1 + 2 * w, y1 + 2 * w, w);
		shapeRenderer.circle(x1 + 2 * w, y2 - 2 * w, w);
		shapeRenderer.circle(x2 - 2 * w, y1 + 2 * w, w);
		shapeRenderer.circle(x2 - 2 * w, y2 - 2 * w, w);
	}

	public boolean isNear(float x1, float width1, float x2, float width2) {
		if (x1 > x2 - width1 && x1 < x2 + width2) {
			return true;
		}
		return false;
	}
}
