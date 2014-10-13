package org.laser.cobalt.gameobjects.npcs.enemies;

import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.ImpStats.LEVEL_1_AGILITY;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.ImpStats.LEVEL_1_BLUE;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.ImpStats.LEVEL_1_DIAMONDS;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.ImpStats.LEVEL_1_EXPERIENCE;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.ImpStats.LEVEL_1_GOLD;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.ImpStats.LEVEL_1_HP;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.ImpStats.LEVEL_1_INTELLECT;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.ImpStats.LEVEL_1_MP;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.ImpStats.LEVEL_1_RED;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.ImpStats.LEVEL_1_STAMINA;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.ImpStats.LEVEL_1_STRENGTH;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.ImpStats.LEVEL_1_VITALITY;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.ImpStats.RESPAWN_SPEED;

import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.npcs.Npc;
import org.laser.cobalt.helpers.types.ConsumableResource;
import org.laser.cobalt.helpers.types.PrimaryStats;
import org.laser.cobalt.helpers.types.Reward;
import org.laser.cobalt.helpers.types.TextureCollection;

public class Imp extends Npc {

	public Imp(float x) {
		super(x);
		setTextureCollection(new TextureCollection(TextureIndex.IMP, TextureIndex.IMP, TextureIndex.SCRATCH));
		setPrimaryStats(new PrimaryStats(LEVEL_1_STRENGTH, LEVEL_1_AGILITY, LEVEL_1_INTELLECT, LEVEL_1_STAMINA, LEVEL_1_VITALITY));
		setResources(new ConsumableResource(LEVEL_1_HP), new ConsumableResource(LEVEL_1_MP));
		setRespawnSpeed(RESPAWN_SPEED);
	}

	@Override
	protected Reward generateReward() {
		Reward retVal = new Reward();
		retVal.setGold(LEVEL_1_GOLD);
		retVal.setRedGems(LEVEL_1_RED);
		retVal.setBlueGems(LEVEL_1_BLUE);
		retVal.setDiamonds(LEVEL_1_DIAMONDS);
		retVal.setExperience(LEVEL_1_EXPERIENCE);
		return retVal;
	}

}
