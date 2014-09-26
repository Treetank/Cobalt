package org.laser.cobalt.gameobjects.levels.outdoor;

import org.laser.cobalt.CobaltBasics.EnemyIndex;
import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.gameobjects.Exit;
import org.laser.cobalt.gameobjects.enemies.Mob;
import org.laser.cobalt.gameobjects.levels.OutdoorGameLevel;

public class FirstLevel extends OutdoorGameLevel {

	public FirstLevel(CobaltGame game) {
		super(1500.0f, false, game, TextureIndex.GRASS);
		levelIndex = LevelIndex.STARTING_PATH;
		AddMob(Mob.MobCreator(EnemyIndex.SLIME, 100));
		AddMob(Mob.MobCreator(EnemyIndex.SLIME, 225));
		AddMob(Mob.MobCreator(EnemyIndex.SLIME, 350));
		AddMob(Mob.MobCreator(EnemyIndex.SLIME, 475));
		AddMob(Mob.MobCreator(EnemyIndex.SLIME, 600));
		AddMob(Mob.MobCreator(EnemyIndex.SLIME, 725));
		AddMob(Mob.MobCreator(EnemyIndex.SLIME, 900));
		AddMob(Mob.MobCreator(EnemyIndex.SLIME, 1025));
		AddMob(Mob.MobCreator(EnemyIndex.SLIME, 1150));
		AddMob(Mob.MobCreator(EnemyIndex.SLIME, 1275));
		AddMob(Mob.MobCreator(EnemyIndex.SLIME, 1400));

		AddExit(new Exit(10, TextureIndex.HOUSE, LevelIndex.CREEPER_PATH));
		AddExit(new Exit(1450, TextureIndex.SIGN, LevelIndex.IMP_PATH));
		AddExit(new Exit(825, TextureIndex.HOUSE, LevelIndex.HOSPITAL));
	}
}
