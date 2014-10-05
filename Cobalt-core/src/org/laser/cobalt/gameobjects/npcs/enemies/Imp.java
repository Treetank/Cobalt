package org.laser.cobalt.gameobjects.npcs.enemies;

import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.npcs.Npc;
import org.laser.cobalt.helpers.types.PrimaryStats;
import org.laser.cobalt.helpers.types.MobStats;
import org.laser.cobalt.helpers.types.Reward;
import org.laser.cobalt.helpers.types.StaticMobStats;
import org.laser.cobalt.helpers.types.TextureCollection;

public class Imp extends Npc {

	public Imp(float x) {
		super(x, new TextureCollection(TextureIndex.IMP, TextureIndex.IMP, TextureIndex.SCRATCH), new MobStats(new StaticMobStats(20, 1, 2, 0, 2), 20, 50, 8,
				new PrimaryStats(2, 1, 1, 3, 1)));
	}

	@Override
	protected Reward generateReward() {
		Reward retVal = new Reward();
		retVal.setGold(25);
		retVal.setRedGems(1);
		retVal.setBlueGems(1);
		retVal.setDiamonds(1);
		retVal.setExperience(10);
		return retVal;
	}

}
