package org.laser.cobalt.gameobjects.enemies;

import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.Npc;
import org.laser.cobalt.helpers.types.MobStats;
import org.laser.cobalt.helpers.types.StaticMobStats;
import org.laser.cobalt.helpers.types.TextureCollection;

public class Slime extends Npc {

	public Slime(float x) {
		super(x, new TextureCollection(TextureIndex.SLIME, TextureIndex.SLIME, TextureIndex.EXPLOSION), new MobStats(new StaticMobStats(100, 1, 2, 0, 2), 100,
				10, 5, 1, 1, 1, 1, 1));
	}

}
