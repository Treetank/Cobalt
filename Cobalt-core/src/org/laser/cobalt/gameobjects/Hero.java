package org.laser.cobalt.gameobjects;

import static org.laser.cobalt.CobaltBasics.InitialValues.LEVEL_POSITION;

import org.laser.cobalt.CobaltBasics.ItemIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.gear.Equipable;
import org.laser.cobalt.helpers.types.MobStats;
import org.laser.cobalt.helpers.types.Reward;
import org.laser.cobalt.helpers.types.SerializingData.HeroData;
import org.laser.cobalt.helpers.types.TextureCollection;
import org.laser.cobalt.interfaces.ISavable;

import com.badlogic.gdx.utils.Json;

public class Hero extends Mob implements ISavable {

	private float velocity;
	private Inventory inventory;
	private MobStats offhand;

	public Hero(float x, MobStats ms) {
		super(x, new TextureCollection(TextureIndex.HERO, TextureIndex.HERO_ATTACKING, TextureIndex.EXPLOSION), ms);
		inventory = new Inventory();
		offhand = ms;
	}

	@Override
	public String save() {
		HeroData data = new HeroData();
		data.setX(getX());
		data.setStatsJson(stats.save());
		data.setInventoryJson(inventory.save());
		data.setWeaponJson(weapon.save());
		data.setChestArmorJson(chestArmor.save());
		Json json = new Json();
		return json.toJson(data);
	}

	@Override
	public void load(String loadString) {
		if (loadString != null & loadString != "") {
			Json json = new Json();
			HeroData data = json.fromJson(HeroData.class, loadString);
			move(data.getX());
			stats.load(data.getStatsJson());
			inventory.load(data.getInventoryJson());
			equip(Equipable.load(data.getWeaponJson()));
			equip(Equipable.load(data.getChestArmorJson()));
			offhand.load(data.getNullproblem());
		} else
			loadNew();
	}

	@Override
	public void loadNew() {
		stats.loadNew();
		move(LEVEL_POSITION);
		equip(Equipable.ItemCreator(ItemIndex.BARE_HANDS, 1));
		equip(Equipable.ItemCreator(ItemIndex.NO_CHEST_PLATE, 1));
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
