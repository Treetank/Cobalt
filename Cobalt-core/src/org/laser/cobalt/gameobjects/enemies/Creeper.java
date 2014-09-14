package org.laser.cobalt.gameobjects.enemies;

import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.Npc;
import org.laser.cobalt.helpers.types.CombatStats;
import org.laser.cobalt.helpers.types.MobStats;
import org.laser.cobalt.helpers.types.StaticMobStats;
import org.laser.cobalt.helpers.types.TextureCollection;

public class Creeper extends Npc {

	public Creeper(float x) {
		super(x, new TextureCollection(TextureIndex.CREEPER, TextureIndex.CREEPER, TextureIndex.SCRATCH), new MobStats(new StaticMobStats(150, 2, 1, 0, 2),
				150, 75, 10, new CombatStats(2, 3, 1, 2, 1)));
	}

}
