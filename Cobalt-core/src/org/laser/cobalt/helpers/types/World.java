package org.laser.cobalt.helpers.types;

import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.gameobjects.Hero;

public class World {

	private Hero hero;
	private float levelPosition;
	private LevelIndex level;
	private Inventory inventory;

	public World() {
		hero = new Hero(50, new MobStats(new StaticMobStats(500, 1, 1, 2, 2), 500, 100, 0, new CombatStats(1, 1, 1, 1, 1)));
		levelPosition = 0;
		inventory = new Inventory();
		setLevel(LevelIndex.STARTING_PATH);
	}

	public Hero getHero() {
		return hero;
	}

	public float getLevelPosition() {
		return levelPosition;
	}

	public void loadHero(Hero hero) {
		this.hero = hero;
	}

	public void setLevelPosition(float position) {
		levelPosition = position;
	}

	public LevelIndex getLevel() {
		return level;
	}

	public void setLevel(LevelIndex level) {
		this.level = level;
	}
	
	public Inventory getInventory() {return inventory;}
}
