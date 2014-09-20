package org.laser.cobalt.gameobjects.enemies;

import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.Npc;
import org.laser.cobalt.helpers.types.CombatStats;
import org.laser.cobalt.helpers.types.MobStats;
import org.laser.cobalt.helpers.types.Reward;
import org.laser.cobalt.helpers.types.StaticMobStats;
import org.laser.cobalt.helpers.types.TextureCollection;

public class Imp extends Npc {

	public Imp(float x) {
		super(x, new TextureCollection(TextureIndex.IMP, TextureIndex.IMP, TextureIndex.SCRATCH), new MobStats(new StaticMobStats(200, 1, 2, 0, 2), 200, 50, 8,
				new CombatStats(2, 1, 1, 3, 1)));
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
