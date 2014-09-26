package org.laser.cobalt.helpers.inputhandlers;

import org.laser.cobalt.CobaltBasics;
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
		IndoorGameLevel level = (IndoorGameLevel) game.getLevel();
		if (optionOneClicked(screenX, CobaltBasics.GAME_SCREEN_HEIGHT - screenY)) {
			level.clickOption(0);
		} else if (optionTwoClicked(screenX, CobaltBasics.GAME_SCREEN_HEIGHT - screenY)) {
			level.clickOption(1);
		} else if (optionThreeClicked(screenX, CobaltBasics.GAME_SCREEN_HEIGHT - screenY)) {
			level.clickOption(2);
		} else if (optionExitClicked(screenX, CobaltBasics.GAME_SCREEN_HEIGHT - screenY)) {
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
		return (x > 5 && x < CobaltBasics.STOREFRONT_OPTION_WIDTH + 5
				&& y > CobaltBasics.STOREFRONT_HEIGHT + CobaltBasics.STOREFRONT_OPTION_GAP * 2 + CobaltBasics.STOREFRONT_OPTION_HEIGHT && y < CobaltBasics.STOREFRONT_HEIGHT
				+ CobaltBasics.STOREFRONT_OPTION_HEIGHT * 2 + CobaltBasics.STOREFRONT_OPTION_GAP * 2);
	}

	public boolean optionTwoClicked(int x, int y) {
		return (x > 5 + CobaltBasics.STOREFRONT_OPTION_WIDTH + CobaltBasics.STOREFRONT_OPTION_GAP
				&& x < 5 + CobaltBasics.STOREFRONT_OPTION_WIDTH * 2 + CobaltBasics.STOREFRONT_OPTION_GAP
				&& y > CobaltBasics.STOREFRONT_HEIGHT + CobaltBasics.STOREFRONT_OPTION_GAP * 2 + CobaltBasics.STOREFRONT_OPTION_HEIGHT && y < CobaltBasics.STOREFRONT_HEIGHT
				+ CobaltBasics.STOREFRONT_OPTION_HEIGHT * 2 + CobaltBasics.STOREFRONT_OPTION_GAP * 2);
	}

	public boolean optionThreeClicked(int x, int y) {
		return (x > 5 && x < CobaltBasics.STOREFRONT_OPTION_WIDTH + 5 && y > CobaltBasics.STOREFRONT_HEIGHT + CobaltBasics.STOREFRONT_OPTION_GAP && y < CobaltBasics.STOREFRONT_HEIGHT
				+ CobaltBasics.STOREFRONT_OPTION_GAP + CobaltBasics.STOREFRONT_OPTION_HEIGHT);
	}

	public boolean optionExitClicked(int x, int y) {
		return (x > 5 + CobaltBasics.STOREFRONT_OPTION_WIDTH + CobaltBasics.STOREFRONT_OPTION_GAP
				&& x < 5 + CobaltBasics.STOREFRONT_OPTION_WIDTH * 2 + CobaltBasics.STOREFRONT_OPTION_GAP
				&& y > CobaltBasics.STOREFRONT_HEIGHT + CobaltBasics.STOREFRONT_OPTION_GAP && y < CobaltBasics.STOREFRONT_HEIGHT
				+ CobaltBasics.STOREFRONT_OPTION_GAP + CobaltBasics.STOREFRONT_OPTION_HEIGHT);
	}
}
