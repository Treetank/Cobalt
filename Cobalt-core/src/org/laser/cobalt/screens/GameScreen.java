package org.laser.cobalt.screens;

import org.laser.cobalt.CobaltGame;

import com.badlogic.gdx.Screen;

public class GameScreen implements Screen {
	private CobaltGame game;

	public GameScreen(CobaltGame cobaltGame) {
		this.game = cobaltGame;
	}

	@Override
	public void render(float delta) {
		game.update(delta);
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
