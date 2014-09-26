package org.laser.cobalt.helpers.inputhandlers;

import org.laser.cobalt.CobaltBasics;
import org.laser.cobalt.CobaltGame;

import com.badlogic.gdx.InputProcessor;

public class GameSelectInputHandler implements InputProcessor {

	private CobaltGame game;

	public GameSelectInputHandler(CobaltGame game) {
		this.game = game;
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
		int flippedY = CobaltBasics.GAME_SCREEN_HEIGHT - screenY;
		if (screenX > CobaltBasics.GAME_SELECT_NEW_X1 && screenX < CobaltBasics.GAME_SELECT_NEW_X2) {
			if (flippedY > CobaltBasics.GAME_SELECT_NEW_Y1 && flippedY < CobaltBasics.GAME_SELECT_NEW_Y2) {
				game.newGame();
				return true;
			} else if (flippedY > CobaltBasics.GAME_SELECT_LOAD_Y1 && flippedY < CobaltBasics.GAME_SELECT_LOAD_Y2) {
				game.loadGame();
				return true;
			} else if (flippedY > CobaltBasics.GAME_SELECT_SUPER_Y1 && flippedY < CobaltBasics.GAME_SELECT_SUPER_Y2) {
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
