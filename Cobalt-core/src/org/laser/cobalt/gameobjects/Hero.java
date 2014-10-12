package org.laser.cobalt.gameobjects;

import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.HeroStats.INITIAL_POSITION;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.HeroStats.NORMAL_INITIAL_AGILITY;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.HeroStats.NORMAL_INITIAL_HP;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.HeroStats.NORMAL_INITIAL_INTELLECT;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.HeroStats.NORMAL_INITIAL_MP;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.HeroStats.NORMAL_INITIAL_STAMINA;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.HeroStats.NORMAL_INITIAL_STRENGTH;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.HeroStats.NORMAL_INITIAL_VITALITY;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.HeroStats.SUPER_INITIAL_AGILITY;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.HeroStats.SUPER_INITIAL_HP;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.HeroStats.SUPER_INITIAL_INTELLECT;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.HeroStats.SUPER_INITIAL_MP;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.HeroStats.SUPER_INITIAL_STAMINA;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.HeroStats.SUPER_INITIAL_STRENGTH;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.HeroStats.SUPER_INITIAL_VITALITY;

import org.laser.cobalt.CobaltBasics.ItemIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.gear.Equipable;
import org.laser.cobalt.helpers.types.ConsumableResource;
import org.laser.cobalt.helpers.types.MobStats;
import org.laser.cobalt.helpers.types.PrimaryStats;
import org.laser.cobalt.helpers.types.Reward;
import org.laser.cobalt.helpers.types.SerializingData.HeroData;
import org.laser.cobalt.helpers.types.TextureCollection;

import com.badlogic.gdx.utils.Json;

public class Hero extends Mob {

	private float velocity;
	private Inventory inventory;

	@Deprecated
	public Hero(float x, MobStats ms) {
		super(x, new TextureCollection(TextureIndex.HERO, TextureIndex.HERO_ATTACKING, TextureIndex.EXPLOSION), ms);
		inventory = new Inventory();
	}

	public Hero() {
		super();
		setTextureCollection(new TextureCollection(TextureIndex.HERO, TextureIndex.HERO_ATTACKING, TextureIndex.EXPLOSION));
	}

	protected void init() {
		super.init();
		velocity = 0;
	}

	public String save() {
		HeroData data = new HeroData();
		data.setX(getX());
		data.setPrimaryStatsJson(baseStats.save());
		data.setHpJson(hp.save());
		data.setMpJson(mp.save());
		data.setStatsJson(stats.save());
		data.setInventoryJson(inventory.save());
		data.setWeaponJson(weapon.save());
		data.setChestArmorJson(chestArmor.save());
		data.setExperience(getExperience());
		Json json = new Json();
		return json.toJson(data);
	}

	public void load(String loadString) {
		if (loadString != null & loadString != "") {
			Json json = new Json();
			HeroData data = json.fromJson(HeroData.class, loadString);
			move(data.getX());
			baseStats.load(data.getPrimaryStatsJson());
			hp.load(data.getHpJson());
			mp.load(data.getMpJson());
			stats.load(data.getStatsJson());
			inventory.load(data.getInventoryJson());
			equip(Equipable.load(data.getWeaponJson()));
			equip(Equipable.load(data.getChestArmorJson()));
			setExperience(data.getExperience());
		} else
			loadNew();
	}

	public void loadNew() {
		move(INITIAL_POSITION);
		setPrimaryStats(new PrimaryStats(NORMAL_INITIAL_STRENGTH, NORMAL_INITIAL_AGILITY, NORMAL_INITIAL_INTELLECT, NORMAL_INITIAL_STAMINA,
				NORMAL_INITIAL_VITALITY));
		setResources(new ConsumableResource(NORMAL_INITIAL_HP), new ConsumableResource(NORMAL_INITIAL_MP));
		setExperience(0);
		equip(Equipable.ItemCreator(ItemIndex.BARE_HANDS, 1));
		equip(Equipable.ItemCreator(ItemIndex.NO_CHEST_PLATE, 1));
	}

	public void loadSuper() {
		move(INITIAL_POSITION);
		setPrimaryStats(new PrimaryStats(SUPER_INITIAL_STRENGTH, SUPER_INITIAL_AGILITY, SUPER_INITIAL_INTELLECT, SUPER_INITIAL_STAMINA, SUPER_INITIAL_VITALITY));
		setResources(new ConsumableResource(SUPER_INITIAL_HP), new ConsumableResource(SUPER_INITIAL_MP));
		setExperience(0);
		equip(Equipable.ItemCreator(ItemIndex.SWORD, 1));
		equip(Equipable.ItemCreator(ItemIndex.LIGHT_CHEST_PLATE, 1));
	}

	public float getVelocity() {
		return velocity;
	}

	public void moveRight() {
		// TODO velocity = 1 + (baseStats.getAgility() +
		// bonusStats.getAgility()) / AGILITY_MOVESPEED_MODIFIER;
		velocity = stats.getStatics().MoveSpeed();
	}

	public void moveLeft() {
		// TODO velocity = -(1 + (baseStats.getAgility() +
		// bonusStats.getAgility()) / AGILITY_MOVESPEED_MODIFIER);
		velocity = -stats.getStatics().MoveSpeed();
	}

	public void stop() {
		velocity = 0;
	}

	public boolean isDead() {
		// TODO return hp.getCurrent() == 0;
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
