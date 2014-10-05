package org.laser.cobalt.helpers.renderers;

import static org.laser.cobalt.CobaltBasics.GameSelectMetrics.FONT_HEIGHT_OFFSET;
import static org.laser.cobalt.CobaltBasics.GameSelectMetrics.LOAD_X1;
import static org.laser.cobalt.CobaltBasics.GameSelectMetrics.LOAD_X2;
import static org.laser.cobalt.CobaltBasics.GameSelectMetrics.LOAD_Y1;
import static org.laser.cobalt.CobaltBasics.GameSelectMetrics.LOAD_Y2;
import static org.laser.cobalt.CobaltBasics.GameSelectMetrics.NEW_X1;
import static org.laser.cobalt.CobaltBasics.GameSelectMetrics.NEW_X2;
import static org.laser.cobalt.CobaltBasics.GameSelectMetrics.NEW_Y1;
import static org.laser.cobalt.CobaltBasics.GameSelectMetrics.NEW_Y2;
import static org.laser.cobalt.CobaltBasics.GameSelectMetrics.SUPER_X1;
import static org.laser.cobalt.CobaltBasics.GameSelectMetrics.SUPER_X2;
import static org.laser.cobalt.CobaltBasics.GameSelectMetrics.SUPER_Y1;
import static org.laser.cobalt.CobaltBasics.GameSelectMetrics.SUPER_Y2;

import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.interfaces.IRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameSelectRenderer extends CobaltRenderer implements IRenderer {

	public GameSelectRenderer(CobaltGame game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		shapeRenderer.begin(ShapeType.Filled);
		drawRectangles();
		shapeRenderer.end();
		batcher.begin();
		batcher.enableBlending();
		drawText();
		batcher.end();
	}

	public void drawRectangles() {
		RoundRectangle(NEW_X1, NEW_Y1, NEW_X2, NEW_Y2, 2);
		RoundRectangle(LOAD_X1, LOAD_Y1, LOAD_X2, LOAD_Y2, 2);
		RoundRectangle(SUPER_X1, SUPER_Y1, SUPER_X2, SUPER_Y2, 2);
	}

	public void drawText() {
		font.draw(batcher, "NEW GAME", NEW_X1 + FONT_HEIGHT_OFFSET, NEW_Y1 + FONT_HEIGHT_OFFSET);
		font.draw(batcher, "CONTINUE", LOAD_X1 + FONT_HEIGHT_OFFSET, LOAD_Y1 + FONT_HEIGHT_OFFSET);
		font.draw(batcher, "LOAD SUPER", SUPER_X1 + FONT_HEIGHT_OFFSET, SUPER_Y1 + FONT_HEIGHT_OFFSET);
	}
}
