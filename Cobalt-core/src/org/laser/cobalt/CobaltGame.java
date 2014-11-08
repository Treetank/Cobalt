package org.laser.cobalt;

import static org.laser.cobalt.CobaltBasics.GameWindowMetrics.SCREEN_HEIGHT;
import static org.laser.cobalt.CobaltBasics.GameWindowMetrics.SCREEN_WIDTH;

import org.laser.cobalt.CobaltBasics.GameStateIndex;
import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.gameworld.GameWorld;
import org.laser.cobalt.helpers.AssetLoader;
import org.laser.cobalt.helpers.GameSaver;
import org.laser.cobalt.helpers.inputhandlers.GameOverInputHandler;
import org.laser.cobalt.helpers.inputhandlers.GameSelectInputHandler;
import org.laser.cobalt.helpers.inputhandlers.IndoorInputHandler;
import org.laser.cobalt.helpers.inputhandlers.WorldInputHandler;
import org.laser.cobalt.helpers.renderers.GameOverRenderer;
import org.laser.cobalt.helpers.renderers.GameSelectRenderer;
import org.laser.cobalt.helpers.renderers.GameWorldRenderer;
import org.laser.cobalt.helpers.renderers.IndoorWorldRenderer;
import org.laser.cobalt.interfaces.IRenderer;
import org.laser.cobalt.screens.GameScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.esotericsoftware.kryo.Kryo;

public class CobaltGame extends Game {

	private GameWorld gameWorld;
	private IRenderer renderer;
	private GameStateIndex gameState;
	private Kryo kryo;

	@Override
	public void create() {
		prepScreen();

		// load all assets
		AssetLoader.load();

		initGame();

		beginGame();
	}

	private void prepScreen() {
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

	private void initGame() {
		renderer = new GameSelectRenderer(this);
		gameWorld = new GameWorld(this);
	}

	private void beginGame() {
		gameState = GameStateIndex.SAVE_SELECT;
		Gdx.input.setInputProcessor(new GameSelectInputHandler(this));
		setScreen(new GameScreen(this));
	}

	public GameWorld getGameWorld() {
		return gameWorld;
	}

	public IRenderer getRenderer() {
		return renderer;
	}

	public void loadSuperGame() {
		gameWorld.loadSuper();
		startGame();
	}

	public void loadGame() {
		gameWorld.loadLast();
		startGame();
	}

	public void newGame() {
		gameWorld.loadNew();
		startGame();
	}

	public void startGame() {
		gameState = GameStateIndex.GAME_RUNNING;
		gameWorld.loadLevel();
		renderer = new GameWorldRenderer(this);
		Gdx.input.setInputProcessor(new WorldInputHandler(this));
	}

	public void ChangeLevel(LevelIndex levelIndex) {
		gameWorld.ChangeLevel(levelIndex);
		if (gameWorld.isInside()) {
			renderer = new IndoorWorldRenderer(this);
			Gdx.input.setInputProcessor(new IndoorInputHandler(this));
		}
	}

	public void HeroHasDied() {
		gameState = GameStateIndex.HERO_DEAD;
		Gdx.input.setInputProcessor(new GameOverInputHandler(this));
		renderer = new GameOverRenderer(this);
	}

	public void Respawn() {
		gameState = GameStateIndex.GAME_RUNNING;
		gameWorld.respawnHero();
		gameWorld.loadLevel();
		renderer = new GameWorldRenderer(this);
		Gdx.input.setInputProcessor(new WorldInputHandler(this));
	}

	public void update(float delta) {
		switch (gameState) {
		case SAVE_SELECT:
			updateLoading();
			break;
		case GAME_RUNNING:
			updateRunning(delta);
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
		gameWorld.addTime(delta);
		renderer.render(delta);
	}

	private void updateLoading() {

	}

	private void updateRunning(float delta) {
		gameWorld.update(delta);
	}

	private void updateIndoors() {

	}

	private void updateDead() {

	}

	public void goOutdoors() {
		gameWorld.goOutside();
		renderer = new GameWorldRenderer(this);
		Gdx.input.setInputProcessor(new WorldInputHandler(this));
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
		GameSaver.saveWorld(gameWorld.getWorldData().save(), 0);
		AssetLoader.dispose();
	}
}
