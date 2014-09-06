package org.laser.cobalt.gameobjects.levels;

import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.Exit;
import org.laser.cobalt.gameobjects.GameLevel;
import org.laser.cobalt.gameobjects.enemies.Imp;
import org.laser.cobalt.gameworld.OutdoorGameWorld;

public class SecondLevel extends GameLevel {

	public SecondLevel(OutdoorGameWorld GameWorld) {
		super(1500.0f, false, GameWorld, TextureIndex.ICE);
		levelIndex = LevelIndex.IMP_PATH;
		AddMob(new Imp(100));
		AddMob(new Imp(355));
		AddMob(new Imp(700));
		AddMob(new Imp(1050));
		AddMob(new Imp(1300));

		AddExit(new Exit(10, TextureIndex.HOUSE, LevelIndex.STARTING_PATH));
		AddExit(new Exit(1450, TextureIndex.SIGN, LevelIndex.CREEPER_PATH));
	}
}
