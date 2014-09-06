package org.laser.cobalt.gameobjects.levels;

import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.Exit;
import org.laser.cobalt.gameobjects.GameLevel;
import org.laser.cobalt.gameobjects.enemies.Slime;
import org.laser.cobalt.gameworld.OutdoorGameWorld;

public class FirstLevel extends GameLevel {

	public FirstLevel(OutdoorGameWorld gameWorld) {
		super(1500.0f, false, gameWorld, TextureIndex.GRASS);
		levelIndex = LevelIndex.STARTING_PATH;
		AddMob(new Slime(100));
		AddMob(new Slime(255));
		AddMob(new Slime(400));
		AddMob(new Slime(650));
		AddMob(new Slime(850));
		AddMob(new Slime(1050));
		AddMob(new Slime(1350));

		AddExit(new Exit(10, TextureIndex.HOUSE, LevelIndex.CREEPER_PATH));
		AddExit(new Exit(1450, TextureIndex.SIGN, LevelIndex.IMP_PATH));
	}
}
