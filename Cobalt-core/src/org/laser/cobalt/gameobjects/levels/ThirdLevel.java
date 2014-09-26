package org.laser.cobalt.gameobjects.levels;

import org.laser.cobalt.CobaltBasics.EnemyIndex;
import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.gameobjects.Exit;
import org.laser.cobalt.gameobjects.enemies.Mob;

public class ThirdLevel extends OutdoorGameLevel {

	public ThirdLevel(CobaltGame game) {
		super(1500.0f, false, game, TextureIndex.GRASS);
		levelIndex = LevelIndex.CREEPER_PATH;
		AddMob(Mob.MobCreator(EnemyIndex.CREEPER, 100));
		AddMob(Mob.MobCreator(EnemyIndex.CREEPER, 225));
		AddMob(Mob.MobCreator(EnemyIndex.CREEPER, 350));
		AddMob(Mob.MobCreator(EnemyIndex.CREEPER, 475));
		AddMob(Mob.MobCreator(EnemyIndex.CREEPER, 600));
		AddMob(Mob.MobCreator(EnemyIndex.CREEPER, 725));
		AddMob(Mob.MobCreator(EnemyIndex.CREEPER, 900));
		AddMob(Mob.MobCreator(EnemyIndex.CREEPER, 1025));
		AddMob(Mob.MobCreator(EnemyIndex.CREEPER, 1150));
		AddMob(Mob.MobCreator(EnemyIndex.CREEPER, 1275));
		AddMob(Mob.MobCreator(EnemyIndex.CREEPER, 1400));

		AddExit(new Exit(10, TextureIndex.HOUSE, LevelIndex.IMP_PATH));
		AddExit(new Exit(1450, TextureIndex.SIGN, LevelIndex.STARTING_PATH));
	}
}
