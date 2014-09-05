package org.laser.cobalt.screens;

import org.laser.cobalt.gameworld.GameWorldRenderer;
import org.laser.cobalt.gameworld.GameWorld;
import org.laser.cobalt.helpers.InputHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class WorldScreen implements Screen {

	private GameWorld world;
	private GameWorldRenderer renderer;

	public WorldScreen(GameWorld gameWorld) {
		this.world = gameWorld;
		this.renderer = new GameWorldRenderer(gameWorld);

		Gdx.input.setInputProcessor(new InputHandler(world));
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
