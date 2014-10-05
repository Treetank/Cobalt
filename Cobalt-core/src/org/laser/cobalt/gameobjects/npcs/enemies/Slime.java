package org.laser.cobalt.gameobjects.npcs.enemies;

import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.npcs.Npc;
import org.laser.cobalt.helpers.types.PrimaryStats;
import org.laser.cobalt.helpers.types.MobStats;
import org.laser.cobalt.helpers.types.Reward;
import org.laser.cobalt.helpers.types.StaticMobStats;
import org.laser.cobalt.helpers.types.TextureCollection;

public class Slime extends Npc {

	public Slime(float x) {
		super(x, new TextureCollection(TextureIndex.SLIME, TextureIndex.SLIME, TextureIndex.EXPLOSION), new MobStats(new StaticMobStats(10, 1, 2, 0, 2), 10,
				10, 5, new PrimaryStats(1, 1, 1, 1, 1)));
	}

	@Override
	protected Reward generateReward() {
		Reward retVal = new Reward();
		retVal.setGold(5);
		retVal.setRedGems(1);
		retVal.setBlueGems(1);
		retVal.setDiamonds(1);
		retVal.setExperience(5);
		return retVal;
	}

}
