package org.laser.cobalt.gameobjects.levels;

import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.Exit;
import org.laser.cobalt.gameobjects.GameLevel;
import org.laser.cobalt.gameobjects.enemies.Imp;
import org.laser.cobalt.gameworld.GameWorld;

public class SecondLevel extends GameLevel {

	public SecondLevel(GameWorld GameWorld) {
		super(500.0f, false, GameWorld, TextureIndex.ICE);
		levelIndex = LevelIndex.IMP_PATH;
		AddMob(new Imp(100));
		AddMob(new Imp(155));
		AddMob(new Imp(200));
		AddMob(new Imp(250));
		AddMob(new Imp(300));
		AddMob(new Imp(350));
		AddMob(new Imp(450));

		AddExit(new Exit(475, TextureIndex.SIGN, LevelIndex.STARTING_PATH));
	}
}
