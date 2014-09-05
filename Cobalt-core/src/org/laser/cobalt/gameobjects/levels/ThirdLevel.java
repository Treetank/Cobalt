package org.laser.cobalt.gameobjects.levels;

import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.Exit;
import org.laser.cobalt.gameobjects.GameLevel;
import org.laser.cobalt.gameobjects.enemies.Creeper;
import org.laser.cobalt.gameworld.GameWorld;

public class ThirdLevel extends GameLevel {

	public ThirdLevel(GameWorld gameWorld) {
		super(1500.0f, false, gameWorld, TextureIndex.GRASS);
		levelIndex = LevelIndex.CREEPER_PATH;
		AddMob(new Creeper(100));
		AddMob(new Creeper(255));
		AddMob(new Creeper(400));
		AddMob(new Creeper(650));
		AddMob(new Creeper(850));
		AddMob(new Creeper(1050));
		AddMob(new Creeper(1350));

		AddExit(new Exit(1450, TextureIndex.SIGN, LevelIndex.STARTING_PATH));
	}
}