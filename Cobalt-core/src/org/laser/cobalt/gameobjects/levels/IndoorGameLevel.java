package org.laser.cobalt.gameobjects.levels;

import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.CobaltGame;

public class IndoorGameLevel extends GameLevel {

	public IndoorGameLevel(CobaltGame game, TextureIndex texture) {
		super(game, texture);
	}

	@Override
	public boolean isIndoor() {
		return true;
	}

	@Override
	public void update(float delta) {
	}

}
