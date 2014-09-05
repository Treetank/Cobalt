package org.laser.cobalt;

import org.laser.cobalt.gameobjects.Hero;
import org.laser.cobalt.gameworld.GameRenderer;
import org.laser.cobalt.gameworld.GameWorld;
import org.laser.cobalt.helpers.AssetLoader;
import org.laser.cobalt.helpers.GameSaver;
import org.laser.cobalt.helpers.types.MobStats;
import org.laser.cobalt.helpers.types.StaticMobStats;
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
		// setup hardware screen metrics
		DeviceInfo.screenWidth = Gdx.graphics.getWidth();
		DeviceInfo.screenHeight = Gdx.graphics.getHeight();
		DeviceInfo.screenMidX = DeviceInfo.screenWidth / 2;
		DeviceInfo.screenMidY = DeviceInfo.screenHeight / 2;

		// setup game resolution metrics
		DeviceInfo.gameWidth = CobaltBasics.GAME_SCREEN_WIDTH;
		DeviceInfo.gameHeight = CobaltBasics.GAME_SCREEN_HEIGHT;
		DeviceInfo.gameMidY = DeviceInfo.gameHeight / 2;
		DeviceInfo.gameMidX = DeviceInfo.gameWidth / 2;

		// load all assets
		AssetLoader.load();

		// restore persistent game data
		world = GameSaver.loadWorld();

		// load super hero for testing
		world.loadHero(new Hero(world.getHero().getX(), new MobStats(new StaticMobStats(50000, 100, 1, 10, 5), 50000, 10000, 0)));

		// create a new world with restored data
		gameWorld = new GameWorld(world);

		// attatch a new renderer to our game world
		renderer = new GameRenderer(gameWorld);

		// start the game screen engine
		setScreen(new WorldScreen(gameWorld, renderer));
	}

	@Override
	public void dispose() {
		super.dispose();
		GameSaver.saveWorld(world);
		AssetLoader.dispose();
	}
}