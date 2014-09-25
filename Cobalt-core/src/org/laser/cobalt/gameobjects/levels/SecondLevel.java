package org.laser.cobalt.gameobjects.levels;

import org.laser.cobalt.CobaltBasics.EnemyIndex;
import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.gameobjects.Exit;
import org.laser.cobalt.gameobjects.factories.MobFactory;

public class SecondLevel extends OutdoorGameLevel {

	public SecondLevel(CobaltGame game) {
		super(1500.0f, false, game, TextureIndex.ICE);
		levelIndex = LevelIndex.IMP_PATH;
		AddMob(MobFactory.MobCreator(EnemyIndex.IMP, 100));
		AddMob(MobFactory.MobCreator(EnemyIndex.IMP, 225));
		AddMob(MobFactory.MobCreator(EnemyIndex.IMP, 350));
		AddMob(MobFactory.MobCreator(EnemyIndex.IMP, 475));
		AddMob(MobFactory.MobCreator(EnemyIndex.IMP, 600));
		AddMob(MobFactory.MobCreator(EnemyIndex.IMP, 725));
		AddMob(MobFactory.MobCreator(EnemyIndex.IMP, 900));
		AddMob(MobFactory.MobCreator(EnemyIndex.IMP, 1025));
		AddMob(MobFactory.MobCreator(EnemyIndex.IMP, 1150));
		AddMob(MobFactory.MobCreator(EnemyIndex.IMP, 1275));
		AddMob(MobFactory.MobCreator(EnemyIndex.IMP, 1400));

		AddExit(new Exit(10, TextureIndex.HOUSE, LevelIndex.STARTING_PATH));
		AddExit(new Exit(1450, TextureIndex.SIGN, LevelIndex.CREEPER_PATH));
		AddExit(new Exit(825, TextureIndex.HOUSE, LevelIndex.BLACKSMITH));
	}
}
