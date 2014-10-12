package org.laser.cobalt;

import static org.laser.cobalt.CobaltBasics.GameWindowMetrics.SCREEN_HEIGHT;
import static org.laser.cobalt.CobaltBasics.GameWindowMetrics.SCREEN_WIDTH;

import org.laser.cobalt.CobaltBasics.GameStateIndex;
import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.gameobjects.Hero;
import org.laser.cobalt.gameobjects.gear.armor.LightPlate;
import org.laser.cobalt.gameobjects.gear.weapons.Sword;
import org.laser.cobalt.gameobjects.levels.GameLevel;
import org.laser.cobalt.gameworld.GameWorld;
import org.laser.cobalt.gameworld.OutdoorGameWorld;
import org.laser.cobalt.helpers.AssetLoader;
import org.laser.cobalt.helpers.GameSaver;
import org.laser.cobalt.helpers.inputhandlers.GameSelectInputHandler;
import org.laser.cobalt.helpers.renderers.GameSelectRenderer;
import org.laser.cobalt.helpers.renderers.GameWorldRenderer;
import org.laser.cobalt.helpers.renderers.IndoorWorldRenderer;
import org.laser.cobalt.helpers.types.MobStats;
import org.laser.cobalt.helpers.types.PrimaryStats;
import org.laser.cobalt.helpers.types.StaticMobStats;
import org.laser.cobalt.helpers.types.World;
import org.laser.cobalt.interfaces.IRenderer;
import org.laser.cobalt.screens.GameScreen;
import org.laser.cobalt.screens.GameSelectScreen;
import org.laser.cobalt.screens.IndoorScreen;
import org.laser.cobalt.screens.WorldScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class CobaltGame extends Game {

	private GameWorld gameWorld;
	private World world;
	private IRenderer renderer;
	private GameLevel gameLevel, lastOutdoorLevel;
	private float saveOutdoorPosition, saveOutdoorX;
	private GameStateIndex gameState;

	@Override
	public void create() {
		initGame();

		// load all assets
		AssetLoader.load();

		bootGame();
		// TODO beginGame();
	}

	private void initGame() {
		// setup hardware screen metrics
		DeviceInfo.screenWidth = Gdx.graphics.getWidth();
		DeviceInfo.screenHeight = Gdx.graphics.getHeight();
		DeviceInfo.screenMidX = DeviceInfo.screenWidth / 2;
		DeviceInfo.screenMidY = DeviceInfo.screenHeight / 2;

		// setup game resolution metrics
		DeviceInfo.gameWidth = SCREEN_WIDTH;
		DeviceInfo.gameHeight = SCREEN_HEIGHT;
		DeviceInfo.gameMidY = DeviceInfo.gameHeight / 2;
		DeviceInfo.gameMidX = DeviceInfo.gameWidth / 2;
	}

	@Deprecated
	private void bootGame() {
		renderer = new GameSelectRenderer(this);
		setScreen(new GameSelectScreen(this));
	}

	private void beginGame() {
		gameState = GameStateIndex.SAVE_SELECT;
		renderer = new GameSelectRenderer(this);
		gameWorld = new GameWorld(this);
		Gdx.input.setInputProcessor(new GameSelectInputHandler(this));
		setScreen(new GameScreen(this));
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

	public void loadSuperGame() {
		oldLoadSuperGame();
	}

	public void loadGame() {
		oldLoadGame();
	}

	public void newGame() {
		oldNewGame();
	}

	public void startGame() {
	}

	@Deprecated
	public void oldLoadSuperGame() {
		world = new World();
		world.loadHero(new Hero(world.getHero().getX(), new MobStats(new StaticMobStats(50000, 100, 1, 10, 5), 50000, 10000, 0, new PrimaryStats(1000, 1000,
				1000, 1000, 1000))));
		world.getHero().equip(new Sword(1));
		world.getHero().equip(new LightPlate(1));
		oldStartGame();
	}

	@Deprecated
	public void oldLoadGame() {
		world = GameSaver.loadWorld();
		oldStartGame();
	}

	@Deprecated
	public void oldNewGame() {
		world = new World();
		oldStartGame();
	}

	@Deprecated
	public void oldStartGame() {
		gameWorld = new OutdoorGameWorld(this);
		renderer = new GameWorldRenderer(this);
		setScreen(new WorldScreen(this));
	}

	public void setLevel(LevelIndex levelIndex) {
		GameLevel tempLevel = GameLevel.LevelCreator(this, levelIndex);
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
		oldUpdate(delta);
		// TODO newUpdate(delta);
	}

	@Deprecated
	public void oldUpdate(float delta) {
		gameLevel.update(delta);
		gameWorld.update(delta);
	}

	public void newUpdate(float delta) {
		switch (gameState) {
		case SAVE_SELECT:
			updateLoading();
			break;
		case GAME_RUNNING:
			updateRunning();
			break;
		case INDOORS:
			updateIndoors();
			break;
		case HERO_DEAD:
			updateDead();
			break;
		default:
			break;
		}
		renderer.render(delta);
	}

	private void updateLoading() {

	}

	private void updateRunning() {

	}

	private void updateIndoors() {

	}

	private void updateDead() {

	}

	private void goIndoors() {
		lastOutdoorLevel = gameLevel;
		saveOutdoorPosition = world.getLevelPosition();
		saveOutdoorX = world.getHero().getX();
		renderer = new IndoorWorldRenderer(this);
		setScreen(new IndoorScreen(this));
	}

	public void goOutdoors() {
		gameLevel = lastOutdoorLevel;
		world.setLevelPosition(saveOutdoorPosition);
		world.getHero().move(saveOutdoorPosition + saveOutdoorX);
		world.setLevel(gameLevel.getLevelIndex());
		renderer = new GameWorldRenderer(this);
		setScreen(new WorldScreen(this));
	}

	public void pushBottomButton(int button) {
		switch (button) {
		case 0:
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		default:
			break;
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		if (gameLevel != null) {
			if (gameLevel.isIndoor()) {
				goOutdoors();
			}
			GameSaver.saveWorld(world);
		}
		AssetLoader.dispose();
	}
}
