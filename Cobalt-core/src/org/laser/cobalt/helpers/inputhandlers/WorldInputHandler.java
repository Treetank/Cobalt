package org.laser.cobalt.helpers.inputhandlers;

import org.laser.cobalt.CobaltBasics;
import org.laser.cobalt.DeviceInfo;
import org.laser.cobalt.gameworld.GameWorld;

import com.badlogic.gdx.InputProcessor;

public class WorldInputHandler implements InputProcessor {

	private GameWorld gameWorld;

	public WorldInputHandler(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
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
			gameWorld.getLevel().clickEnter();
		} else if (screenX > DeviceInfo.screenMidX)
			gameWorld.getLevel().moveRight();
		else
			gameWorld.getLevel().moveLeft();
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		gameWorld.getLevel().stopMoving();
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
