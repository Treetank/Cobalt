package org.laser.cobalt;

import static org.laser.cobalt.CobaltBasics.GameWindowMetrics.SCREEN_HEIGHT;
import static org.laser.cobalt.CobaltBasics.GameWindowMetrics.SCREEN_WIDTH;

import org.laser.cobalt.CobaltBasics.GameState;
import org.laser.cobalt.gameworld.GameWorld;
import org.laser.cobalt.helpers.AssetLoader;
import org.laser.cobalt.helpers.inputhandlers.GameSelectInputHandler;
import org.laser.cobalt.helpers.renderers.CobaltRenderer;
import org.laser.cobalt.helpers.renderers.GameSelectRenderer;
import org.laser.cobalt.helpers.renderers.GameWorldRenderer;
import org.laser.cobalt.screens.GameScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class CobaltMain extends Game {

	private GameState gameState;
	private CobaltRenderer renderer;
	private GameWorld gameWorld;

	@Override
	public void create() {
		setupScreenMetrics();

		// load all assets
		AssetLoader.load();

		initGame();

		launchGame();
	}

	public void setupScreenMetrics() {
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

	public void initGame() {
		gameWorld = new GameWorld(this);
		gameState = GameState.GAME_SELECT;
	}

	public void launchGame() {
		renderer = new GameSelectRenderer(this);
		Gdx.input.setInputProcessor(new GameSelectInputHandler(this));
		setScreen(new GameScreen(this));
	}

	public void loadSuperGame() {
		gameWorld.loadSuperHero();
		startGame();
	}

	public void loadGame() {
		gameWorld.loadHero();
		startGame();
	}

	public void newGame() {
		gameWorld.loadNewHero();
		startGame();
	}

	public void startGame() {
		gameState = GameState.ACTIVE_WORLD;
		renderer = new GameWorldRenderer(this);
	}

	public void update(float delta) {
		switch (gameState) {
		case ACTIVE_WORLD:
			gameWorld.update(delta);
			break;
		case GAME_SELECT:
			break;
		case HERO_DIED:
			break;
		case INDOORS:
			break;
		default:
			break;
		}
	}

	public GameWorld getGameWorld() {
		return gameWorld;
	}

	public CobaltRenderer getRenderer() {
		return renderer;
	}

	@Override
	public void dispose() {
		super.dispose();
		gameWorld.save();
		AssetLoader.dispose();
	}
}
