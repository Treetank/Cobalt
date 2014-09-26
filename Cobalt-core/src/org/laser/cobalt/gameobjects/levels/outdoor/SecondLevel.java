package org.laser.cobalt.gameobjects.levels.outdoor;

import org.laser.cobalt.CobaltBasics.EnemyIndex;
import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.gameobjects.Exit;
import org.laser.cobalt.gameobjects.levels.OutdoorGameLevel;
import org.laser.cobalt.gameobjects.npcs.Npc;

public class SecondLevel extends OutdoorGameLevel {

	public SecondLevel(CobaltGame game) {
		super(1500.0f, false, game, TextureIndex.ICE);
		levelIndex = LevelIndex.IMP_PATH;
		AddMob(Npc.EnemyCreator(EnemyIndex.IMP, 100));
		AddMob(Npc.EnemyCreator(EnemyIndex.IMP, 225));
		AddMob(Npc.EnemyCreator(EnemyIndex.IMP, 350));
		AddMob(Npc.EnemyCreator(EnemyIndex.IMP, 475));
		AddMob(Npc.EnemyCreator(EnemyIndex.IMP, 600));
		AddMob(Npc.EnemyCreator(EnemyIndex.IMP, 725));
		AddMob(Npc.EnemyCreator(EnemyIndex.IMP, 900));
		AddMob(Npc.EnemyCreator(EnemyIndex.IMP, 1025));
		AddMob(Npc.EnemyCreator(EnemyIndex.IMP, 1150));
		AddMob(Npc.EnemyCreator(EnemyIndex.IMP, 1275));
		AddMob(Npc.EnemyCreator(EnemyIndex.IMP, 1400));

		AddExit(new Exit(10, TextureIndex.HOUSE, LevelIndex.STARTING_PATH));
		AddExit(new Exit(1450, TextureIndex.SIGN, LevelIndex.CREEPER_PATH));
		AddExit(new Exit(825, TextureIndex.HOUSE, LevelIndex.BLACKSMITH));
	}
}
