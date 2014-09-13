package org.laser.cobalt;

import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.gameobjects.Hero;
import org.laser.cobalt.gameobjects.LevelFactory;
import org.laser.cobalt.gameobjects.levels.GameLevel;
import org.laser.cobalt.gameworld.GameWorld;
import org.laser.cobalt.gameworld.OutdoorGameWorld;
import org.laser.cobalt.helpers.AssetLoader;
import org.laser.cobalt.helpers.GameSaver;
import org.laser.cobalt.helpers.renderers.GameWorldRenderer;
import org.laser.cobalt.helpers.types.MobStats;
import org.laser.cobalt.helpers.types.StaticMobStats;
import org.laser.cobalt.helpers.types.World;
import org.laser.cobalt.interfaces.IRenderer;
import org.laser.cobalt.screens.WorldScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class CobaltGame extends Game {

	private GameWorld gameWorld;
	private World world;
	private IRenderer renderer;
	private GameLevel gameLevel, lastOutdoorLevel;

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
		gameWorld = new OutdoorGameWorld(this);

		// create a renderer for the outdoors
		renderer = new GameWorldRenderer(this);

		// start the game screen engine
		setScreen(new WorldScreen(this));
	}

	public GameWorld getGameWorld() {
		return gameWorld;
	}

	public World getWorld() {
		return world;
	}

	public IRenderer getRenderer() {
		return renderer;
	}

	public void setLevel(LevelIndex levelIndex) {
		GameLevel tempLevel = LevelFactory.LevelCreator(this, levelIndex);
		if (tempLevel.isIndoor()) {
			goIndoors();
		}
		gameLevel = tempLevel;
	}

	public void ChangeLevel(LevelIndex levelIndex) {
		if (levelIndex == null) {
			levelIndex = gameLevel.getLevelIndex();
		}
		setLevel(levelIndex);
		world.setLevel(levelIndex);
		world.setLevelPosition(0);
		world.getHero().move(50);
	}

	public GameLevel getLevel() {
		return gameLevel;
	}

	public void update(float delta) {
		gameLevel.update(delta);
		gameWorld.update(delta);
	}

	private void goIndoors() {
		lastOutdoorLevel = gameLevel;
		// save level position
		// save hero x
		// set renderer= new indoorrenderer(this);
		// setscreen(new indoorscreen);
	}

	public void goOutdoors() {
		gameLevel = lastOutdoorLevel;
		// restore level position
		// restore hero x
		// set renderer = new outdoorrenderer(this);
		// setscreen(new worldscreen);
	}

	@Override
	public void dispose() {
		super.dispose();
		GameSaver.saveWorld(world);
		AssetLoader.dispose();
	}
}
