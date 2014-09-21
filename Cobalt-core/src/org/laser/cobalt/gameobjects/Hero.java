package org.laser.cobalt.gameobjects;

import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.helpers.types.MobStats;
import org.laser.cobalt.helpers.types.Reward;
import org.laser.cobalt.helpers.types.SerializingData.HeroData;
import org.laser.cobalt.helpers.types.TextureCollection;

import com.badlogic.gdx.utils.Json;

public class Hero extends Mob {

	private float velocity;
	private Inventory inventory;

	public Hero(float x, MobStats ms) {
		super(x, new TextureCollection(TextureIndex.HERO, TextureIndex.HERO_ATTACKING, TextureIndex.EXPLOSION), ms);
		inventory = new Inventory();
	}

	public String save(float levelPosition) {
		HeroData data = new HeroData();
		data.x = getX() + levelPosition;
		data.statsJson = stats.save();
		data.inventoryJson = inventory.save();
		data.weaponJson = weapon.save();
		data.chestArmorJson = chestArmor.save();
		Json json = new Json();
		return json.toJson(data);
	}

	public void load(String loadString) {
		Json json = new Json();
		HeroData data = json.fromJson(HeroData.class, loadString);
		move(data.x);
		stats.load(data.statsJson);
		inventory.load(data.inventoryJson);
		equip(Equipable.load(data.weaponJson));
		equip(Equipable.load(data.chestArmorJson));
	}

	public float getVelocity() {
		return velocity;
	}

	public void moveRight() {
		velocity = stats.getStatics().MoveSpeed();
	}

	public void moveLeft() {
		velocity = -stats.getStatics().MoveSpeed();
	}

	public void stop() {
		velocity = 0;
	}

	public boolean isDead() {
		return stats.Hp() == 0;
	}

	@Override
	protected Reward generateReward() {
		return null;
	}

	@Override
	public void receiveReward(Reward reward) {
		if (reward != null) {
			stats.addExp(reward.getExperience());
			inventory.addCurrency(reward.getGold(), reward.getRedGems(), reward.getBlueGems(), reward.getDiamonds());
		}

	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
}
