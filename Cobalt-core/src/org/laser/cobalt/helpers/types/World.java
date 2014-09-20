package org.laser.cobalt.helpers.types;

import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.gameobjects.Hero;
import org.laser.cobalt.gameobjects.Inventory;

public class World {

	private Hero hero;
	private float levelPosition;
	private LevelIndex level;

	private class WorldData {
		private final float levelPosition;
		private final LevelIndex level;
		private final String heroJson;
		
		public WorldData(float levelPosition, LevelIndex level, String heroJson) {
			this.levelPosition = levelPosition;
			this.level = level;
			this.heroJson = heroJson;
		}
		
		public float getLevelPosition() {return levelPosition;}
		
		public LevelIndex getLevel() {return level;}
		
		public String getHeroJson() {return heroJson;}
	}
	
	public World() {
		hero = new Hero(50, new MobStats(new StaticMobStats(500, 1, 1, 2, 2), 500, 100, 0, new CombatStats(1, 1, 1, 1, 1)));
		levelPosition = 0;
		hero.setInventory(new Inventory());
		setLevel(LevelIndex.STARTING_PATH);
	}
	
	public String save(){
		WorldData data = new WorldData(getLevelPosition(),getLevel(),getHero().save);
		Json json = new Json;
		return json.toJson(data);
	}

	public void load(String loadString) {
		Json json = new Json();
		WorldData data = json.fromJson(WorldData.class,loadString);
		setLevelPosition(data.getLevelPosition());
		setLevel(data.getLevel());
		getHero().load(data.getHeroJson());
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

	public Inventory getInventory() {
		return hero.getInventory();
	}
}
