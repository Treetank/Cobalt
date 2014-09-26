package org.laser.cobalt.screens;

import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.helpers.inputhandlers.GameSelectInputHandler;
import org.laser.cobalt.interfaces.IRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class GameSelectScreen implements Screen {

	private IRenderer renderer;

	public GameSelectScreen(CobaltGame game) {
		this.renderer = game.getRenderer();

		Gdx.input.setInputProcessor(new GameSelectInputHandler(game));
	}

	@Override
	public void render(float delta) {
		renderer.render(delta);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
