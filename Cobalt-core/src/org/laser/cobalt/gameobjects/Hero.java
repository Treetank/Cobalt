package org.laser.cobalt.gameobjects;

import static org.laser.cobalt.CobaltBasics.CombatMetrics.AGILITY_MOVESPEED_MODIFIER;
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

import java.util.ArrayList;
import java.util.List;

import org.laser.cobalt.CobaltBasics.ItemIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.gear.Equipable;
import org.laser.cobalt.helpers.types.ConsumableResource;
import org.laser.cobalt.helpers.types.PrimaryStats;
import org.laser.cobalt.helpers.types.Reward;
import org.laser.cobalt.helpers.types.SerializingData.HeroData;
import org.laser.cobalt.helpers.types.TextureCollection;

import com.badlogic.gdx.utils.Json;

public class Hero extends Mob {

	private float velocity;
	private List<Reward> rewards;

	public Hero() {
		super();
		setTextureCollection(new TextureCollection(TextureIndex.HERO, TextureIndex.HERO_ATTACKING, TextureIndex.EXPLOSION));
	}

	protected void init() {
		super.init();
		rewards = new ArrayList<Reward>();
		velocity = 0;
	}

	public String save() {
		HeroData data = new HeroData();
		data.setX(getLocation());
		data.setPrimaryStatsJson(baseStats.save());
		data.setHpJson(hp.save());
		data.setMpJson(mp.save());
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
		velocity = 1 + (baseStats.getAgility() + bonusStats.getAgility()) / AGILITY_MOVESPEED_MODIFIER;
	}

	public void moveLeft() {
		velocity = -(1 + (baseStats.getAgility() + bonusStats.getAgility()) / AGILITY_MOVESPEED_MODIFIER);
	}

	public void stop() {
		velocity = 0;
	}

	public boolean isDead() {
		return hp.getCurrent() == 0;
	}

	public Reward collectReward() {
		Reward retVal = null;
		if (rewards.size() > 0) {
			retVal = rewards.get(0);
			rewards.remove(0);
		}
		return retVal;
	}

	@Override
	protected Reward generateReward() {
		return null;
	}

	@Override
	public void receiveReward(Reward reward) {
		if (reward != null) {
			rewards.add(reward);
		}

	}
}
