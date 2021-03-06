package org.laser.cobalt.helpers.types;

import static org.laser.cobalt.CobaltBasics.InitialValues.LEVEL_POSITION;

import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.gameobjects.Hero;
import org.laser.cobalt.gameobjects.Inventory;
import org.laser.cobalt.helpers.types.SerializingData.WorldData;

import com.badlogic.gdx.utils.Json;

public class World {

	private Hero hero;
	private float levelPosition, timePlayed;
	private LevelIndex level;
	private Inventory inventory;

	public World() {
		hero = new Hero();
		inventory = new Inventory();
	}

	public String save() {
		WorldData data = new WorldData();
		data.setLevelPosition(levelPosition);
		data.setLevel(level);
		data.setHeroJson(getHero().save());
		data.setInventoryJson(inventory.save());
		data.setTimePlayed(timePlayed);
		Json json = new Json();
		return json.toJson(data);
	}

	public void load(String loadString) {
		if (loadString != null) {
			Json json = new Json();
			WorldData data = json.fromJson(WorldData.class, loadString);
			levelPosition = data.getLevelPosition();
			level = data.getLevel();
			hero.load(data.getHeroJson());
			inventory.load(data.getInventoryJson());
			timePlayed = data.getTimePlayed();
		} else
			loadNew();
	}

	public void loadNew() {
		hero.load("");
		inventory.load("");
		levelPosition = LEVEL_POSITION;
		setLevel(LevelIndex.STARTING_PATH);
		timePlayed = 0;
	}

	public void loadSuperHero() {
		hero.loadSuper();
		levelPosition = LEVEL_POSITION;
		level = LevelIndex.STARTING_PATH;
	}

	public void update(float delta) {
		Reward tempReward = hero.collectReward();
		if (tempReward != null) {
			hero.addExperience(tempReward.getExperience());
			inventory.addCurrency(tempReward.getGold(), tempReward.getRedGems(), tempReward.getBlueGems(), tempReward.getDiamonds());
		}
	}

	public void addTime(float delta) {
		timePlayed += delta;
	}
	
	public Hero getHero() {
		return hero;
	}

	public float getLevelPosition() {
		return levelPosition;
	}

	public float getTimePlayed() {
		return timePlayed;
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
		return inventory;
	}
}
