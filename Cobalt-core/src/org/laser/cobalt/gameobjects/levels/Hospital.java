package org.laser.cobalt.gameobjects.levels;

import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameworld.OutdoorGameWorld;

public class Hospital extends IndoorGameLevel {

	public Hospital(OutdoorGameWorld gameWorld) {
		super(1500.0f, false, gameWorld, TextureIndex.IN_HOSPITAL);
		levelIndex = LevelIndex.HOSPITAL;
	}
}