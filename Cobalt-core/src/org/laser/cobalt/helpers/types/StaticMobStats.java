package org.laser.cobalt.helpers.types;

import org.laser.cobalt.helpers.types.SerializingData.StaticMobStatsData;

import com.badlogic.gdx.utils.Json;

public final class StaticMobStats {

	private final int maxHp, level, range;
	private final float swingSpeed, moveSpeed;

	public StaticMobStats(int maxHp, int level, float swingSpeed, float moveSpeed, int range) {
		this.maxHp = maxHp;
		this.level = level;
		this.swingSpeed = swingSpeed;
		this.moveSpeed = moveSpeed;
		this.range = range;
	}

	public String save() {
		StaticMobStatsData data = new StaticMobStatsData();
		data.maxHp = MaxHp();
		data.level = Level();
		data.range = SwingRange();
		data.swingSpeed = SwingSpeed();
		data.moveSpeed = MoveSpeed();
		Json json = new Json();
		return json.toJson(data);
	}

	public static StaticMobStats load(String loadString) {
		Json json = new Json();
		StaticMobStatsData data = json.fromJson(StaticMobStatsData.class, loadString);
		StaticMobStats retVal = new StaticMobStats(data.maxHp, data.level, data.swingSpeed, data.moveSpeed, data.range);
		return retVal;
	}

	public int MaxHp() {
		return maxHp;
	};

	public int Level() {
		return level;
	};

	public float SwingSpeed() {
		return swingSpeed;
	};

	public float MoveSpeed() {
		return moveSpeed;
	};

	public int SwingRange() {
		return range;
	}
}
