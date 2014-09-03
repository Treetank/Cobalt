package org.laser.cobalt.gameobjects.levels;

import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.Exit;
import org.laser.cobalt.gameobjects.GameLevel;
import org.laser.cobalt.gameobjects.enemies.Imp;
import org.laser.cobalt.gameobjects.enemies.Slime;
import org.laser.cobalt.gameworld.GameWorld;

public class FirstLevel extends GameLevel {

	public FirstLevel(GameWorld gameWorld) {
		super(500.0f, false, gameWorld, TextureIndex.GRASS);
		levelIndex = LevelIndex.STARTING_PATH;
		AddMob(new Slime(100));
		AddMob(new Imp(155));
		AddMob(new Slime(200));
		AddMob(new Slime(250));
		AddMob(new Imp(300));
		AddMob(new Slime(350));
		AddMob(new Slime(450));

		AddExit(new Exit(475, TextureIndex.SIGN, LevelIndex.IMP_PATH));
	}
}
