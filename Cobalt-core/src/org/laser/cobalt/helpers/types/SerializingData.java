package org.laser.cobalt.helpers.types;

import org.laser.cobalt.CobaltBasics.ItemIndex;
import org.laser.cobalt.CobaltBasics.LevelIndex;

public class SerializingData {

	public static class WorldData {

		public float levelPosition;
		public LevelIndex level;
		public String heroJson;
	}

	public static class HeroData {

		public float x;
		public String statsJson, inventoryJson, weaponJson, chestArmorJson;

	}

	public static class MobStatsData {

		public int hp, damage, exp;
		public String staticsJson, combatJson;

	}

	public static class StaticMobStatsData {

		public int maxHp, level, range;
		public float swingSpeed, moveSpeed;
	}

	public static class CombatStatsData {
		public int strength, agility, intellect, stamina, vitality;
	}

	public static class InventoryData {
		public int gold, red, blue, diamond;
		public String lightPlateJson, swordJson, noChestJson, bareHandsJson;
	}

	public static class EquipableData {
		public int level;
		public ItemIndex item;
	}
}
