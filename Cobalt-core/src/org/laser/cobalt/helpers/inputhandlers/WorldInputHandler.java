package org.laser.cobalt.helpers.inputhandlers;

import org.laser.cobalt.CobaltBasics;
import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.DeviceInfo;

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
		if (screenY <= CobaltBasics.GAME_SCREEN_HEIGHT - CobaltBasics.VIEWPORT_LOWER_BOUNDS) {
			game.getLevel().clickEnter();
		} else if (screenX > DeviceInfo.screenMidX)
			game.getLevel().moveRight();
		else
			game.getLevel().moveLeft();
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		game.getLevel().stopMoving();
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
