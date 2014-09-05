package org.laser.cobalt.screens;

import org.laser.cobalt.gameworld.GameWorld;
import org.laser.cobalt.helpers.inputhandlers.WorldInputHandler;
import org.laser.cobalt.helpers.renderers.GameWorldRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class IndoorScreen implements Screen {

	private GameWorld world;
	private GameWorldRenderer renderer;

	public IndoorScreen(GameWorld gameWorld) {
		this.world = gameWorld;
		this.renderer = new GameWorldRenderer(gameWorld);

		Gdx.input.setInputProcessor(new WorldInputHandler(world));
	}

	@Override
	public void render(float delta) {
		world.update(delta);
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
