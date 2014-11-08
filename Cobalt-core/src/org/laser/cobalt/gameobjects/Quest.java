package org.laser.cobalt.gameobjects;

import org.laser.cobalt.helpers.types.Reward;

public class Quest {

	private int questId;

	public Quest(int id) {
		this.questId = id;
	}

	public Reward generateReward() {
		Reward retVal = new Reward();
		return retVal;
	}

	public int getQuestId() {
		return questId;
	}
}
