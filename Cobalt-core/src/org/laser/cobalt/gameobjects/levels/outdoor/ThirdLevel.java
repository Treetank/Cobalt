package org.laser.cobalt.gameobjects.levels.outdoor;

import org.laser.cobalt.CobaltBasics.EnemyIndex;
import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.gameobjects.Exit;
import org.laser.cobalt.gameobjects.levels.OutdoorGameLevel;
import org.laser.cobalt.gameobjects.npcs.Npc;

public class ThirdLevel extends OutdoorGameLevel {

	public ThirdLevel(CobaltGame game) {
		super(1500.0f, false, game, TextureIndex.GRASS);
		levelIndex = LevelIndex.CREEPER_PATH;
		AddMob(Npc.EnemyCreator(EnemyIndex.CREEPER, 100));
		AddMob(Npc.EnemyCreator(EnemyIndex.CREEPER, 225));
		AddMob(Npc.EnemyCreator(EnemyIndex.CREEPER, 350));
		AddMob(Npc.EnemyCreator(EnemyIndex.CREEPER, 475));
		AddMob(Npc.EnemyCreator(EnemyIndex.CREEPER, 600));
		AddMob(Npc.EnemyCreator(EnemyIndex.CREEPER, 725));
		AddMob(Npc.EnemyCreator(EnemyIndex.CREEPER, 900));
		AddMob(Npc.EnemyCreator(EnemyIndex.CREEPER, 1025));
		AddMob(Npc.EnemyCreator(EnemyIndex.CREEPER, 1150));
		AddMob(Npc.EnemyCreator(EnemyIndex.CREEPER, 1275));
		AddMob(Npc.EnemyCreator(EnemyIndex.CREEPER, 1400));

		AddExit(new Exit(10, TextureIndex.HOUSE, LevelIndex.IMP_PATH));
		AddExit(new Exit(1450, TextureIndex.SIGN, LevelIndex.STARTING_PATH));
	}
}
