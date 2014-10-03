package org.laser.cobalt.screens;

import org.laser.cobalt.CobaltMain;
import org.laser.cobalt.helpers.renderers.CobaltRenderer;

import com.badlogic.gdx.Screen;

public class GameScreen implements Screen {

	private CobaltMain mainGame;
	private CobaltRenderer renderer;

	public GameScreen(CobaltMain mainGame) {
		this.mainGame = mainGame;
		this.renderer = mainGame.getRenderer();
	}

	public void setRenderer(CobaltRenderer renderer) {
		this.renderer = renderer;
	}

	@Override
	public void render(float delta) {
		renderer.render(delta);
		mainGame.update(delta);
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
