package org.laser.cobalt.helpers;

import org.laser.cobalt.DeviceInfo;
import org.laser.cobalt.gameobjects.GameLevel;
import com.badlogic.gdx.InputProcessor;

public class InputHandler implements InputProcessor{
	
	private GameLevel level;
	
	public InputHandler(GameLevel level) {
		this.level = level;
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
		if (screenX > DeviceInfo.screenMidX)
			level.moveRight();
		else
			level.moveLeft();
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
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
