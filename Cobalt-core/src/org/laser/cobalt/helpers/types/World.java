package org.laser.cobalt.helpers.types;

import static org.laser.cobalt.CobaltBasics.InitialValues.LEVEL_POSITION;

import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.gameobjects.Hero;
import org.laser.cobalt.gameobjects.Inventory;
import org.laser.cobalt.helpers.types.SerializingData.WorldData;

import com.badlogic.gdx.utils.Json;

public class World {

	private Hero hero;
	private float levelPosition;
	private LevelIndex level;

	public World() {
		hero = new Hero(50, new MobStats(new StaticMobStats(500, 1, 1, 2, 2), 500, 100, 0, new PrimaryStats(1, 1, 1, 1, 1)));
		hero.loadNew();
		levelPosition = LEVEL_POSITION;
		setLevel(LevelIndex.STARTING_PATH);
	}

	public String save() {
		WorldData data = new WorldData();
		data.setLevelPosition(getLevelPosition());
		data.setLevel(getLevel());
		data.setHeroJson(getHero().save());
		Json json = new Json();
		return json.toJson(data);
	}

	public void load(String loadString) {
		if (loadString != null) {
			Json json = new Json();
			WorldData data = json.fromJson(WorldData.class, loadString);
			setLevelPosition(data.getLevelPosition());
			setLevel(data.getLevel());
			getHero().load(data.getHeroJson());
		} else
			loadNew();
	}

	public void loadNew() {
		getHero().load("");
		levelPosition = LEVEL_POSITION;
		setLevel(LevelIndex.STARTING_PATH);
	}

	public void loadSuperHero() {
		hero.loadSuper();
	}

	public void update(float delta) {

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
