package org.laser.cobalt.gameobjects.levels;

import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.GameLevel;
import org.laser.cobalt.gameworld.GameWorld;

public class Hospital extends GameLevel {

	public Hospital(GameWorld gameWorld) {
		super(1500.0f, false, gameWorld, TextureIndex.IN_HOSPITAL);
		levelIndex = LevelIndex.HOSPITAL;
	}
}
