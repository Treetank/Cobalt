package org.laser.cobalt;

public final class CobaltBasics {

	public static enum TextureIndex {
		GRASS, ICE, // Terrains
		HERO, HERO_ATTACKING, // Hero images
		SLIME, IMP, CREEPER, // monster images
		EXPLOSION, SCRATCH, // damage overlays
		SIGN, HOUSE, // path markings
		IN_HOSPITAL, // indoor screens
		SWORD, // weapon images
		LIGHT_CHEST_PLATE // armor images
	};

	public static enum LevelIndex {
		STARTING_PATH, // FirstLevel
		IMP_PATH, // SecondLevel
		CREEPER_PATH, // ThirdLevel
		HOSPITAL, // Hospital
		BLACKSMITH // Blacksmith
	};

	public static enum Damage {
		PHYSICAL, FIRE, WATER, EARTH, LIGHTNING
	}

	public static enum ItemIndex {
		NO_CHEST_PLATE, LIGHT_CHEST_PLATE, // chest pieces
		BARE_HANDS, SWORD // weapons
	}

	public static enum EnemyIndex {
		SLIME, IMP, CREEPER
	}

	public static enum GameStateIndex {
		SAVE_SELECT, // choosing new or continue
		GAME_RUNNING, // alive in outdoor world
		INDOORS, // inside a building
		HERO_DEAD // hero has died
	}

	public static final class DesktopWindowMetrics {
		// height and width of the desktop client window
		public static final int VIEWPORT_WIDTH = 480;
		public static final int VIEWPORT_HEIGHT = 320;

		// title of the window for the desktop client
		public static final String WINDOW_TITLE = "Cobalt - Lil RPG";
	}

	public static final class GameWindowMetrics {
		// controlled resolution of the game in any client
		public static final int SCREEN_WIDTH = 480;
		public static final int SCREEN_HEIGHT = 320;

		// how far left and right the hero can walk before scrolling the terrain
		public static final int LEFT_WALK_LIMIT = 200;
		public static final int RIGHT_WALK_LIMIT = SCREEN_WIDTH - LEFT_WALK_LIMIT;

		// height from bottom of view port to start drawing the terrain
		public static final int TERRAIN_BASE_Y = 0;

		// y coordinate for the bottom of the view port
		public static final int VIEWPORT_LOWER_BOUNDS = SCREEN_HEIGHT - ImageMetrics.TERRAIN_HEIGHT * 5;

		// bottom button metrics
		public static final int BOTTOM_BUTTON_PADDING = 28;
		public static final int BOTTOM_BUTTON_SQUARE_SIZE = 64;
	}

	public static final class TextureMapMetrics {
		// x,y of the starting of the types of textures in our texture map
		public static final int TERRAIN_START_X = 0;
		public static final int TERRAIN_START_Y = 0;
		public static final int MOB_START_X = 0;
		public static final int MOB_START_Y = 16;
		public static final int STOREFRONT_START_X = 0;
		public static final int STOREFRONT_START_Y = 48;
		public static final int SPLASH_START_X = 0;
		public static final int SPLASH_START_Y = 176;
	}

	public static final class ImageMetrics {
		// height and width of terrains
		public static final int TERRAIN_WIDTH = 256;
		public static final int TERRAIN_HEIGHT = 16;

		// height and width of store fronts
		public static final int STOREFRONT_WIDTH = 480;
		public static final int STOREFRONT_HEIGHT = 128;

		// height and width of equipables
		public static final int WEAPON_WIDTH = 8;
		public static final int WEAPON_HEIGHT = 8;
		public static final int ARMOR_WIDTH = 8;
		public static final int ARMOR_HEIGHT = 8;

		// square size of mob sprites
		public static final int MOB_SQUARE_SIZE = 32;

		public static final int SPLASH_WIDTH = 128;
		public static final int SPLASH_HEIGHT = 64;
	}

	public static final class StoreMetrics {
		public static final int GREETING_WINDOW_BOTTOM = GameWindowMetrics.SCREEN_HEIGHT - 75;
		public static final int OPTION_HEIGHT = 40;
		public static final int OPTION_WIDTH = 180;
		public static final int OPTION_GAP = 10;
		public static final int FONT_HEIGHT_OFFSET = 25;
	}

	public static final class GameSelectMetrics {
		public static final int NEW_X1 = 100;
		public static final int NEW_Y1 = 50;
		public static final int NEW_X2 = 300;
		public static final int NEW_Y2 = 90;
		public static final int LOAD_X1 = 100;
		public static final int LOAD_Y1 = 150;
		public static final int LOAD_X2 = 300;
		public static final int LOAD_Y2 = 190;
		public static final int SUPER_X1 = 100;
		public static final int SUPER_Y1 = 250;
		public static final int SUPER_X2 = 300;
		public static final int SUPER_Y2 = 290;
		public static final int FONT_HEIGHT_OFFSET = 25;
		public static final boolean SUPER_GAME_AVAILABLE = true;
	}

	public static final class CombatMetrics {
		public static final int AGILITY_SWING_MODIFIER = 1000;
		public static final float TAKE_DAMAGE_TIMER = 0.5f;
		public static final float AGILITY_MOVESPEED_MODIFIER = 100;
	}

	public static final class StatMetrics {
		public static final class GearStats {
			public static final class WeaponStats {
				public static final class BareHandStats {
					public static final int SWING_SPEED = 1;
					public static final float RANGE = 0.5f;
					public static final int LEVEL_1_STRENGTH = 0;
					public static final int LEVEL_1_AGILITY = 0;
					public static final int LEVEL_1_INTELLECT = 0;
					public static final int LEVEL_1_STAMINA = 0;
					public static final int LEVEL_1_VITALITY = 0;
					public static final int LEVEL_1_DAMAGE = 3;
				}

				public static final class SwordStats {
					public static final int SWING_SPEED = 2;
					public static final float RANGE = 1.5f;
					public static final int LEVEL_1_STRENGTH = 5;
					public static final int LEVEL_1_AGILITY = 2;
					public static final int LEVEL_1_INTELLECT = 0;
					public static final int LEVEL_1_STAMINA = 5;
					public static final int LEVEL_1_VITALITY = 0;
					public static final int LEVEL_1_DAMAGE = 5;
				}
			}

			public static final class ChestArmorStats {
				public static final class NoChestStats {
					public static final int LEVEL_1_STRENGTH = 0;
					public static final int LEVEL_1_AGILITY = 0;
					public static final int LEVEL_1_INTELLECT = 0;
					public static final int LEVEL_1_STAMINA = 0;
					public static final int LEVEL_1_VITALITY = 0;
					public static final int LEVEL_1_DEFENSE = 0;
				}

				public static final class LightPlateChestStats {
					public static final int LEVEL_1_STRENGTH = 5;
					public static final int LEVEL_1_AGILITY = 0;
					public static final int LEVEL_1_INTELLECT = 0;
					public static final int LEVEL_1_STAMINA = 10;
					public static final int LEVEL_1_VITALITY = 0;
					public static final int LEVEL_1_DEFENSE = 5;
				}
			}
		}

		public static final class MobStats {
			public static final class HeroStats {
				public static final int NORMAL_INITIAL_STRENGTH = 1;
				public static final int NORMAL_INITIAL_AGILITY = 1;
				public static final int NORMAL_INITIAL_INTELLECT = 1;
				public static final int NORMAL_INITIAL_STAMINA = 1;
				public static final int NORMAL_INITIAL_VITALITY = 1;
				public static final int NORMAL_INITIAL_HP = 50;
				public static final int NORMAL_INITIAL_MP = 100;
				public static final int SUPER_INITIAL_STRENGTH = 1000;
				public static final int SUPER_INITIAL_AGILITY = 1000;
				public static final int SUPER_INITIAL_INTELLECT = 1000;
				public static final int SUPER_INITIAL_STAMINA = 1000;
				public static final int SUPER_INITIAL_VITALITY = 1000;
				public static final int SUPER_INITIAL_HP = 50000;
				public static final int SUPER_INITIAL_MP = 10000;
				public static final int INITIAL_POSITION = 50;
			}

			public static final class SlimeStats {
				public static final int LEVEL_1_STRENGTH = 2;
				public static final int LEVEL_1_AGILITY = 3;
				public static final int LEVEL_1_INTELLECT = 1;
				public static final int LEVEL_1_STAMINA = 2;
				public static final int LEVEL_1_VITALITY = 1;
				public static final int LEVEL_1_HP = 15;
				public static final int LEVEL_1_MP = 5;
				public static final int RESPAWN_SPEED = 5;
				public static final int LEVEL_1_GOLD = 5;
				public static final int LEVEL_1_RED = 1;
				public static final int LEVEL_1_BLUE = 1;
				public static final int LEVEL_1_DIAMONDS = 1;
				public static final int LEVEL_1_EXPERIENCE = 5;
			}

			public static final class ImpStats {
				public static final int LEVEL_1_STRENGTH = 2;
				public static final int LEVEL_1_AGILITY = 3;
				public static final int LEVEL_1_INTELLECT = 1;
				public static final int LEVEL_1_STAMINA = 2;
				public static final int LEVEL_1_VITALITY = 1;
				public static final int LEVEL_1_HP = 15;
				public static final int LEVEL_1_MP = 5;
				public static final int RESPAWN_SPEED = 5;
				public static final int LEVEL_1_GOLD = 25;
				public static final int LEVEL_1_RED = 1;
				public static final int LEVEL_1_BLUE = 1;
				public static final int LEVEL_1_DIAMONDS = 1;
				public static final int LEVEL_1_EXPERIENCE = 10;
			}

			public static final class CreeperStats {
				public static final int LEVEL_1_STRENGTH = 2;
				public static final int LEVEL_1_AGILITY = 3;
				public static final int LEVEL_1_INTELLECT = 1;
				public static final int LEVEL_1_STAMINA = 2;
				public static final int LEVEL_1_VITALITY = 1;
				public static final int LEVEL_1_HP = 15;
				public static final int LEVEL_1_MP = 5;
				public static final int RESPAWN_SPEED = 5;
				public static final int LEVEL_1_GOLD = 15;
				public static final int LEVEL_1_RED = 5;
				public static final int LEVEL_1_BLUE = 3;
				public static final int LEVEL_1_DIAMONDS = 1;
				public static final int LEVEL_1_EXPERIENCE = 25;
			}
		}
	}

	public static final class InitialValues {
		public static final int LEVEL_POSITION = 0;
	}

	public static final class DeathSplashValues {
		public static final int SPLASH_X = (GameWindowMetrics.SCREEN_WIDTH - ImageMetrics.SPLASH_WIDTH) / 2;
		public static final int SPLASH_Y = (GameWindowMetrics.SCREEN_HEIGHT - ImageMetrics.SPLASH_HEIGHT) / 2;
	}

	public static final class CobaltStrings {
		// STRINGS
		public static final String HOSPITAL_BASE_GREETING = "WELCOME TO HOSPITAL. HEALING COST 10 GOLD.";
		public static final String HOSPITAL_HEALED_GREETING = "THANK YOU. PLEASE COME AGAIN.";
		public static final String SMITHY_BASE_GREETING = "WELCOME TO THE SMITHERY. SELL YOU THIS NICE SWORD 100 GOLD.";
		public static final String SMITHY_NO_WORK_GREETING = "I CANNOT HELP YOU AT THIS TIME";
	}
}
