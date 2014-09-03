package org.laser.cobalt.helpers.types;

public final class StaticMobStats {

	private final float maxHp, swingSpeed, moveSpeed, level, range;

	public StaticMobStats(float maxHp, float level, float swingSpeed, float moveSpeed, float range) {
		this.maxHp = maxHp;
		this.level = level;
		this.swingSpeed = swingSpeed;
		this.moveSpeed = moveSpeed;
		this.range = range;
	}

	public float MaxHp() {
		return maxHp;
	};

	public float Level() {
		return level;
	};

	public float SwingSpeed() {
		return swingSpeed;
	};

	public float MoveSpeed() {
		return moveSpeed;
	};
	
	public float SwingRange() {
		return range;
	}
}
