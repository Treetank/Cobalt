package org.laser.cobalt;

import org.laser.cobalt.gameworld.GameRenderer;
import org.laser.cobalt.gameworld.GameWorld;
import org.laser.cobalt.helpers.AssetLoader;
import org.laser.cobalt.helpers.GameSaver;
import org.laser.cobalt.helpers.types.World;
import org.laser.cobalt.screens.WorldScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class CobaltGame extends Game {

	private GameWorld gameWorld;
	private GameRenderer renderer;
	private World world;

	@Override
	public void create() {
		DeviceInfo.screenWidth = Gdx.graphics.getWidth();
		DeviceInfo.screenHeight = Gdx.graphics.getHeight();
		DeviceInfo.screenMidX = DeviceInfo.screenWidth / 2;
		DeviceInfo.screenMidY = DeviceInfo.screenHeight / 2;
		DeviceInfo.gameWidth = CobaltBasics.GAME_SCREEN_WIDTH;
//		DeviceInfo.gameHeight = DeviceInfo.screenHeight / (DeviceInfo.screenWidth / DeviceInfo.gameWidth);
		DeviceInfo.gameHeight = CobaltBasics.GAME_SCREEN_HEIGHT;
		DeviceInfo.gameMidY = DeviceInfo.gameHeight / 2;
		DeviceInfo.gameMidX = DeviceInfo.gameWidth / 2;

		AssetLoader.load();

		world = GameSaver.loadWorld();

		gameWorld = new GameWorld(world);

		renderer = new GameRenderer(gameWorld);

		setScreen(new WorldScreen(gameWorld, renderer));
	}

	@Override
	public void dispose() {
		super.dispose();
		GameSaver.saveWorld(world);
		AssetLoader.dispose();
	}
}