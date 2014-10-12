package org.laser.cobalt.helpers.types;

import org.laser.cobalt.CobaltBasics.ItemIndex;
import org.laser.cobalt.CobaltBasics.LevelIndex;

public class SerializingData {

	public static class WorldData {

		public float getLevelPosition() {
			return levelPosition;
		}

		public void setLevelPosition(float levelPosition) {
			this.levelPosition = levelPosition;
		}

		public LevelIndex getLevel() {
			return level;
		}

		public void setLevel(LevelIndex level) {
			this.level = level;
		}

		public String getHeroJson() {
			if (heroJson != null)
				return heroJson;
			else
				return "";
		}

		public void setHeroJson(String heroJson) {
			this.heroJson = heroJson;
		}

		private float levelPosition;
		private LevelIndex level;
		private String heroJson;
	}

	public static class HeroData {

		private float x;
		private int experience;
		private String statsJson, inventoryJson, weaponJson, chestArmorJson, primaryStatsJson, hpJson, mpJson;

		public float getX() {
			return x;
		}

		public void setX(float x) {
			this.x = x;
		}

		public String getStatsJson() {
			if (statsJson != null)
				return statsJson;
			else
				return "";
		}

		public void setStatsJson(String statsJson) {
			this.statsJson = statsJson;
		}

		public String getInventoryJson() {
			if (inventoryJson != null)
				return inventoryJson;
			else
				return "";
		}

		public void setInventoryJson(String inventoryJson) {
			this.inventoryJson = inventoryJson;
		}

		public String getWeaponJson() {
			if (weaponJson != null)
				return weaponJson;
			else
				return "";
		}

		public void setWeaponJson(String weaponJson) {
			this.weaponJson = weaponJson;
		}

		public String getChestArmorJson() {
			if (chestArmorJson != null)
				return chestArmorJson;
			else
				return "";
		}

		public void setChestArmorJson(String chestArmorJson) {
			this.chestArmorJson = chestArmorJson;
		}

		public int getExperience() {
			return experience;
		}

		public void setExperience(int experience) {
			this.experience = experience;
		}

		public String getPrimaryStatsJson() {
			return primaryStatsJson;
		}

		public void setPrimaryStatsJson(String primaryStatsJson) {
			this.primaryStatsJson = primaryStatsJson;
		}

		public String getHpJson() {
			return hpJson;
		}

		public void setHpJson(String hpJson) {
			this.hpJson = hpJson;
		}

		public String getMpJson() {
			return mpJson;
		}

		public void setMpJson(String mpJson) {
			this.mpJson = mpJson;
		}

	}

	public static class MobStatsData {

		private int hp, damage, exp;
		private String staticsJson, combatJson;

		public int getHp() {
			return hp;
		}

		public void setHp(int hp) {
			this.hp = hp;
		}

		public int getDamage() {
			return damage;
		}

		public void setDamage(int damage) {
			this.damage = damage;
		}

		public int getExp() {
			return exp;
		}

		public void setExp(int exp) {
			this.exp = exp;
		}

		public String getStaticsJson() {
			if (staticsJson != null)
				return staticsJson;
			else
				return "";
		}

		public void setStaticsJson(String staticsJson) {
			this.staticsJson = staticsJson;
		}

		public String getCombatJson() {
			if (combatJson != null)
				return combatJson;
			else
				return "";
		}

		public void setCombatJson(String combatJson) {
			this.combatJson = combatJson;
		}

	}

	public static class StaticMobStatsData {

		public int getMaxHp() {
			return maxHp;
		}

		public void setMaxHp(int maxHp) {
			this.maxHp = maxHp;
		}

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

		public int getRange() {
			return range;
		}

		public void setRange(int range) {
			this.range = range;
		}

		public float getSwingSpeed() {
			return swingSpeed;
		}

		public void setSwingSpeed(float swingSpeed) {
			this.swingSpeed = swingSpeed;
		}

		public float getMoveSpeed() {
			return moveSpeed;
		}

		public void setMoveSpeed(float moveSpeed) {
			this.moveSpeed = moveSpeed;
		}

		private int maxHp, level, range;
		private float swingSpeed, moveSpeed;
	}

	public static class PrimaryStatsData {
		private int strength, agility, intellect, stamina, vitality;

		public int getStrength() {
			return strength;
		}

		public void setStrength(int strength) {
			this.strength = strength;
		}

		public int getAgility() {
			return agility;
		}

		public void setAgility(int agility) {
			this.agility = agility;
		}

		public int getIntellect() {
			return intellect;
		}

		public void setIntellect(int intellect) {
			this.intellect = intellect;
		}

		public int getStamina() {
			return stamina;
		}

		public void setStamina(int stamina) {
			this.stamina = stamina;
		}

		public int getVitality() {
			return vitality;
		}

		public void setVitality(int vitality) {
			this.vitality = vitality;
		}
	}

	public static class InventoryData {
		private int gold, red, blue, diamond;

		public int getGold() {
			return gold;
		}

		public void setGold(int gold) {
			this.gold = gold;
		}

		public int getRed() {
			return red;
		}

		public void setRed(int red) {
			this.red = red;
		}

		public int getBlue() {
			return blue;
		}

		public void setBlue(int blue) {
			this.blue = blue;
		}

		public int getDiamond() {
			return diamond;
		}

		public void setDiamond(int diamond) {
			this.diamond = diamond;
		}

		public String getLightPlateJson() {
			if (lightPlateJson != null)
				return lightPlateJson;
			else
				return "";
		}

		public void setLightPlateJson(String lightPlateJson) {
			this.lightPlateJson = lightPlateJson;
		}

		public String getSwordJson() {
			if (swordJson != null)
				return swordJson;
			else
				return "";
		}

		public void setSwordJson(String swordJson) {
			this.swordJson = swordJson;
		}

		public String getNoChestJson() {
			if (noChestJson != null)
				return noChestJson;
			else
				return "";
		}

		public void setNoChestJson(String noChestJson) {
			this.noChestJson = noChestJson;
		}

		public String getBareHandsJson() {
			if (bareHandsJson != null)
				return bareHandsJson;
			else
				return "";
		}

		public void setBareHandsJson(String bareHandsJson) {
			this.bareHandsJson = bareHandsJson;
		}

		private String lightPlateJson, swordJson, noChestJson, bareHandsJson;
	}

	public static class EquipableData {
		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

		public ItemIndex getItem() {
			return item;
		}

		public void setItem(ItemIndex item) {
			this.item = item;
		}

		private int level;
		private ItemIndex item;
	}

	public static class PrimaryStatData {
		private int base, bonus;

		public int getBase() {
			return base;
		}

		public void setBase(int base) {
			this.base = base;
		}

		public int getBonus() {
			return bonus;
		}

		public void setBonus(int bonus) {
			this.bonus = bonus;
		}
	}

	public static class ConsumableResourceData {
		private int current, max;

		public int getCurrent() {
			return current;
		}

		public void setCurrent(int current) {
			this.current = current;
		}

		public int getMax() {
			return max;
		}

		public void setMax(int max) {
			this.max = max;
		}
	}
}
