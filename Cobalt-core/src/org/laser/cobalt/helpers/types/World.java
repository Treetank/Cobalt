package org.laser.cobalt.helpers.types;

import static org.laser.cobalt.CobaltBasics.InitialValues.LEVEL_POSITION;

import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.gameobjects.Hero;
import org.laser.cobalt.gameobjects.Inventory;
import org.laser.cobalt.helpers.types.SerializingData.WorldData;
import org.laser.cobalt.interfaces.ISavable;

import com.badlogic.gdx.utils.Json;

public class World implements ISavable {

	private Hero hero;
	private float levelPosition;
	private LevelIndex level;

	public World() {
		hero = new Hero(50, new MobStats(new StaticMobStats(500, 1, 1, 2, 2), 500, 100, 0, new PrimaryStats(1, 1, 1, 1, 1)));
		levelPosition = LEVEL_POSITION;
		setLevel(LevelIndex.STARTING_PATH);
	}

	@Override
	public String save() {
		WorldData data = new WorldData();
		data.setLevelPosition(getLevelPosition());
		data.setLevel(getLevel());
		data.setHeroJson(getHero().save());
		Json json = new Json();
		return json.toJson(data);
	}

	@Override
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

	@Override
	public void loadNew() {
		getHero().load("");
		levelPosition = LEVEL_POSITION;
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

	public Inventory getInventory() {
		return hero.getInventory();
	}
}
