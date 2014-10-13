package org.laser.cobalt.helpers.inputhandlers;

import static org.laser.cobalt.CobaltBasics.GameWindowMetrics.SCREEN_HEIGHT;
import static org.laser.cobalt.CobaltBasics.ImageMetrics.STOREFRONT_HEIGHT;
import static org.laser.cobalt.CobaltBasics.StoreMetrics.OPTION_GAP;
import static org.laser.cobalt.CobaltBasics.StoreMetrics.OPTION_HEIGHT;
import static org.laser.cobalt.CobaltBasics.StoreMetrics.OPTION_WIDTH;

import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.gameobjects.levels.IndoorGameLevel;

import com.badlogic.gdx.InputProcessor;

public class IndoorInputHandler implements InputProcessor {

	private CobaltGame game;

	public IndoorInputHandler(CobaltGame game) {
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
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		IndoorGameLevel level = (IndoorGameLevel) game.getGameWorld().getLevel();
		if (optionOneClicked(screenX, SCREEN_HEIGHT - screenY)) {
			level.clickOption(0);
		} else if (optionTwoClicked(screenX, SCREEN_HEIGHT - screenY)) {
			level.clickOption(1);
		} else if (optionThreeClicked(screenX, SCREEN_HEIGHT - screenY)) {
			level.clickOption(2);
		} else if (optionExitClicked(screenX, SCREEN_HEIGHT - screenY)) {
			level.clickExit();
		}
		return true;
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

	public boolean optionOneClicked(int x, int y) {
		return (x > 5 && x < OPTION_WIDTH + 5 && y > OPTION_HEIGHT + OPTION_GAP * 2 + OPTION_HEIGHT && y < STOREFRONT_HEIGHT + OPTION_HEIGHT * 2 + OPTION_GAP
				* 2);
	}

	public boolean optionTwoClicked(int x, int y) {
		return (x > 5 + OPTION_WIDTH + OPTION_GAP && x < 5 + OPTION_WIDTH * 2 + OPTION_GAP && y > STOREFRONT_HEIGHT + OPTION_GAP * 2 + OPTION_HEIGHT && y < STOREFRONT_HEIGHT
				+ OPTION_HEIGHT * 2 + OPTION_GAP * 2);
	}

	public boolean optionThreeClicked(int x, int y) {
		return (x > 5 && x < OPTION_WIDTH + 5 && y > STOREFRONT_HEIGHT + OPTION_GAP && y < STOREFRONT_HEIGHT + OPTION_GAP + OPTION_HEIGHT);
	}

	public boolean optionExitClicked(int x, int y) {
		return (x > 5 + OPTION_WIDTH + OPTION_GAP && x < 5 + OPTION_WIDTH * 2 + OPTION_GAP && y > STOREFRONT_HEIGHT + OPTION_GAP && y < STOREFRONT_HEIGHT
				+ OPTION_GAP + OPTION_HEIGHT);
	}
}
