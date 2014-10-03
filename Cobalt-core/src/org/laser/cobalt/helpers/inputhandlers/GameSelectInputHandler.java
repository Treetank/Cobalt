package org.laser.cobalt.helpers.inputhandlers;

import static org.laser.cobalt.CobaltBasics.GameSelectMetrics.LOAD_Y1;
import static org.laser.cobalt.CobaltBasics.GameSelectMetrics.LOAD_Y2;
import static org.laser.cobalt.CobaltBasics.GameSelectMetrics.NEW_X1;
import static org.laser.cobalt.CobaltBasics.GameSelectMetrics.NEW_X2;
import static org.laser.cobalt.CobaltBasics.GameSelectMetrics.NEW_Y1;
import static org.laser.cobalt.CobaltBasics.GameSelectMetrics.NEW_Y2;
import static org.laser.cobalt.CobaltBasics.GameSelectMetrics.SUPER_Y1;
import static org.laser.cobalt.CobaltBasics.GameSelectMetrics.SUPER_Y2;
import static org.laser.cobalt.CobaltBasics.GameWindowMetrics.SCREEN_HEIGHT;

import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.CobaltMain;

import com.badlogic.gdx.InputProcessor;

public class GameSelectInputHandler implements InputProcessor {

	private CobaltGame game;
	private CobaltMain mainGame;

	public GameSelectInputHandler(CobaltGame game) {
		this.game = game;
	}

	public GameSelectInputHandler(CobaltMain cobaltMain) {
		mainGame = cobaltMain;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		int flippedY = SCREEN_HEIGHT - screenY;
		if (screenX > NEW_X1 && screenX < NEW_X2) {
			if (flippedY > NEW_Y1 && flippedY < NEW_Y2) {
				game.newGame();
				return true;
			} else if (flippedY > LOAD_Y1 && flippedY < LOAD_Y2) {
				game.loadGame();
				return true;
			} else if (flippedY > SUPER_Y1 && flippedY < SUPER_Y2) {
				game.loadSuperGame();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
