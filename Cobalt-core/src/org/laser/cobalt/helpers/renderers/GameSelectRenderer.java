package org.laser.cobalt.helpers.renderers;

import org.laser.cobalt.CobaltBasics;
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
		RoundRectangle(CobaltBasics.GAME_SELECT_NEW_X1, CobaltBasics.GAME_SELECT_NEW_Y1, CobaltBasics.GAME_SELECT_NEW_X2, CobaltBasics.GAME_SELECT_NEW_Y2, 2);
		RoundRectangle(CobaltBasics.GAME_SELECT_LOAD_X1, CobaltBasics.GAME_SELECT_LOAD_Y1, CobaltBasics.GAME_SELECT_LOAD_X2, CobaltBasics.GAME_SELECT_LOAD_Y2,
				2);
		RoundRectangle(CobaltBasics.GAME_SELECT_SUPER_X1, CobaltBasics.GAME_SELECT_SUPER_Y1, CobaltBasics.GAME_SELECT_SUPER_X2,
				CobaltBasics.GAME_SELECT_SUPER_Y2, 2);
	}

	public void drawText() {
		font.draw(batcher, "NEW GAME", CobaltBasics.GAME_SELECT_NEW_X1 + CobaltBasics.FONT_HEIGHT_OFFSET, CobaltBasics.GAME_SELECT_NEW_Y1
				+ CobaltBasics.FONT_HEIGHT_OFFSET);
		font.draw(batcher, "CONTINUE", CobaltBasics.GAME_SELECT_LOAD_X1 + CobaltBasics.FONT_HEIGHT_OFFSET, CobaltBasics.GAME_SELECT_LOAD_Y1
				+ CobaltBasics.FONT_HEIGHT_OFFSET);
		font.draw(batcher, "LOAD SUPER", CobaltBasics.GAME_SELECT_SUPER_X1 + CobaltBasics.FONT_HEIGHT_OFFSET, CobaltBasics.GAME_SELECT_SUPER_Y1
				+ CobaltBasics.FONT_HEIGHT_OFFSET);
	}
}
