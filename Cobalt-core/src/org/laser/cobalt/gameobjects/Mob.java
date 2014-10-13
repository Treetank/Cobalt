package org.laser.cobalt.gameobjects;

import static org.laser.cobalt.CobaltBasics.CombatMetrics.AGILITY_SWING_MODIFIER;
import static org.laser.cobalt.CobaltBasics.CombatMetrics.TAKE_DAMAGE_TIMER;
import static org.laser.cobalt.CobaltBasics.ImageMetrics.MOB_SQUARE_SIZE;
import static org.laser.cobalt.CobaltBasics.ImageMetrics.TERRAIN_HEIGHT;

import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameobjects.gear.ChestArmor;
import org.laser.cobalt.gameobjects.gear.Equipable;
import org.laser.cobalt.gameobjects.gear.Weapon;
import org.laser.cobalt.gameobjects.gear.armor.NoChestArmor;
import org.laser.cobalt.gameobjects.gear.weapons.BareHands;
import org.laser.cobalt.helpers.DamageCalculator;
import org.laser.cobalt.helpers.types.ConsumableResource;
import org.laser.cobalt.helpers.types.ImageProperties;
import org.laser.cobalt.helpers.types.MobStats;
import org.laser.cobalt.helpers.types.PrimaryStats;
import org.laser.cobalt.helpers.types.Reward;
import org.laser.cobalt.helpers.types.StaticMobStats;
import org.laser.cobalt.helpers.types.TextureCollection;

public abstract class Mob extends Drawable {

	protected ConsumableResource hp, mp;
	protected PrimaryStats baseStats, bonusStats;
	private int experience;

	protected float swingTimer, beingHitTimer;
	protected TextureIndex beingHitImage;
	protected TextureCollection textureCollection;
	protected MobStats stats;
	protected ChestArmor chestArmor;
	protected Weapon weapon;

	@Deprecated
	public Mob(float x, TextureCollection tc, MobStats ms) {
		super();
		setImageProperties(new ImageProperties(x, TERRAIN_HEIGHT, MOB_SQUARE_SIZE, MOB_SQUARE_SIZE));
		setTextureCollection(tc);
		stats = ms;
	}

	protected Mob(float x) {
		super();
		setImageProperties(new ImageProperties(x, TERRAIN_HEIGHT, MOB_SQUARE_SIZE, MOB_SQUARE_SIZE));
	}

	protected Mob() {
		this(0);
	}

	protected void setTextureCollection(TextureCollection tc) {
		setTexture(tc.Base());
		textureCollection = tc;
	}

	protected void setPrimaryStats(PrimaryStats base) {
		setPrimaryStats(base, new PrimaryStats());
	}

	protected void setPrimaryStats(PrimaryStats base, PrimaryStats bonus) {
		this.baseStats = base;
		this.bonusStats = bonus;
	}

	protected void setResources(ConsumableResource hp, ConsumableResource mp) {
		this.hp = hp;
		this.mp = mp;
	}

	@Override
	protected void init() {
		experience = 0;
		swingTimer = 0;
		beingHitTimer = 0;
		hp = new ConsumableResource();
		mp = new ConsumableResource();
		baseStats = new PrimaryStats();
		bonusStats = new PrimaryStats();
		stats = new MobStats(new StaticMobStats(0, 0, 0, 0, 0), 0, 0, 0, baseStats);
		equip(new NoChestArmor(1));
		equip(new BareHands(1));
	}

	public void update(float position, float delta) {
		super.update(position);
		if (swingTimer > 0) {
			swingTimer -= delta;
			if (swingTimer <= 0) {
				texture = textureCollection.Base();
			}
		}
		if (beingHitTimer > 0) {
			beingHitTimer -= delta;
			// TODO if (hp.getCurrent() == 0) {
			if (stats.Hp() <= 0) {
				die();
			}
		}
	}

	public void swing(Mob mob) {
		if (!(swingTimer > 0)) {
			// TODO swingTimer = (1 / (weapon.getAttackSpeed() +
			// ((baseStats.getAgility() + bonusStats.getAgility()) /
			// AGILITY_SWING_MODIFIER)));
			swingTimer = (1 / (weapon.getAttackSpeed() + (stats.getAgility() / AGILITY_SWING_MODIFIER)));
			if (swingHit(mob)) {
				receiveReward(mob.takeHit(DamageCalculator.CalculateDamage(this, mob), textureCollection.Damage()));
			}
			texture = textureCollection.Swinging();
		}
	}

	public Reward takeHit(int damage, TextureIndex hitImage) {
		beingHitImage = hitImage;
		beingHitTimer = TAKE_DAMAGE_TIMER;
		// TODO hp.useResource(damage);
		// TODO if (hp.getCurrent() == 0) {
		if (stats.takeDamage(damage)) {
			return generateReward();
		} else {
			return null;
		}
	}

	public void die() {
	}

	public void respawn() {
		// TODO hp.fill();
		stats.heal(stats.getStatics().MaxHp());
		returnToBase();
	}

	public boolean takingDamage() {
		return beingHitTimer > 0;
	}

	public TextureIndex takingDamageImage() {
		return beingHitImage;
	}

	public void equip(Equipable item) {
		if (item instanceof Weapon) {
			unEquip(weapon);
			weapon = (Weapon) item;
		} else if (item instanceof ChestArmor) {
			unEquip(chestArmor);
			chestArmor = (ChestArmor) item;
		}
		// TODO bonusStats.addStats(item.getStats());
		stats.addToBonusStats(item.getStats());
	}

	public void unEquip(Equipable item) {
		if (item != null) {
			// TODO bonusStats.removeStats(item.getStats());
			stats.removeBonusStats(item.getStats());
		}
	}

	@Deprecated
	public MobStats getStats() {
		return stats;
	}

	public PrimaryStats getPrimaryStats() {
		PrimaryStats retVal = new PrimaryStats();
		retVal.addStats(baseStats);
		retVal.addStats(bonusStats);
		return retVal;
	}

	protected boolean swingHit(Mob mob) {
		return true;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public ChestArmor getChestArmor() {
		return chestArmor;
	}

	public abstract void receiveReward(Reward reward);

	protected abstract Reward generateReward();

	public int getExperience() {
		return experience;
	}

	protected void setExperience(int experience) {
		this.experience = experience;
	}

	public void addExperience(int experience) {
		this.experience += experience;
	}

	public ConsumableResource getHp() {
		return hp;
	}

	public ConsumableResource getMp() {
		return mp;
	}

	public PrimaryStats getBaseStats() {
		return baseStats;
	}

	public PrimaryStats getBonusStats() {
		return bonusStats;
	}
}
