package org.laser.cobalt.helpers.inputhandlers;

import static org.laser.cobalt.CobaltBasics.GameWindowMetrics.BOTTOM_BUTTON_SQUARE_SIZE;
import static org.laser.cobalt.CobaltBasics.GameWindowMetrics.SCREEN_HEIGHT;
import static org.laser.cobalt.CobaltBasics.GameWindowMetrics.VIEWPORT_LOWER_BOUNDS;

import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.DeviceInfo;
import org.laser.cobalt.gameobjects.levels.OutdoorGameLevel;

import com.badlogic.gdx.InputProcessor;

public class WorldInputHandler implements InputProcessor {

	private CobaltGame game;

	public WorldInputHandler(CobaltGame game) {
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
		OutdoorGameLevel level = (OutdoorGameLevel) game.getGameWorld().getLevel();
		if (screenY <= SCREEN_HEIGHT - VIEWPORT_LOWER_BOUNDS) {
			level.clickEnter();
		} else if (screenY >= SCREEN_HEIGHT - BOTTOM_BUTTON_SQUARE_SIZE - 3) {
			game.pushBottomButton(screenX / 120);
		} else if (screenX > DeviceInfo.screenMidX)
			level.moveRight();
		else
			level.moveLeft();
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		OutdoorGameLevel level = (OutdoorGameLevel) game.getGameWorld().getLevel();
		level.stopMoving();
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

}
