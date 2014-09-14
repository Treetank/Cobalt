package org.laser.cobalt.gameobjects.enemies;

import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.Npc;
import org.laser.cobalt.helpers.types.MobStats;
import org.laser.cobalt.helpers.types.StaticMobStats;
import org.laser.cobalt.helpers.types.TextureCollection;

public class Imp extends Npc {

	public Imp(float x) {
		super(x, new TextureCollection(TextureIndex.IMP, TextureIndex.IMP, TextureIndex.SCRATCH), new MobStats(new StaticMobStats(200, 1, 2, 0, 2), 200, 50, 8,
				2, 1, 1, 3, 1));
	}

}
