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
		HOSPITAL // Hospital
	};

	public static enum Damage {
		PHYSICAL, FIRE, WATER, EARTH, LIGHTNING
	}

	public static enum ItemIndex {
		NO_CHEST_PLATE, LIGHT_CHEST_PLATE, // chest pieces
		BARE_HANDS, SWORD // weapons
	}

	// height and width of the desktop client window
	public static final int DESKTOP_VIEWPORT_WIDTH = 480;
	public static final int DESKTOP_VIEWPORT_HEIGHT = 320;

	// title of the window for the desktop client
	public static final String WINDOW_TITLE = "Cobalt - Lil RPG";

	// controlled resolution of the game in any client
	public static final int GAME_SCREEN_WIDTH = 480;
	public static final int GAME_SCREEN_HEIGHT = 320;

	// how far left and right the hero can walk before scrolling the terrain
	public static final int LEFT_WALK_LIMIT = 200;
	public static final int RIGHT_WALK_LIMIT = GAME_SCREEN_WIDTH - LEFT_WALK_LIMIT;

	// x,y of the starting of the types of textures in our texture map
	public static final int TERRAIN_TEXTURE_START_X = 0;
	public static final int TERRAIN_TEXTURE_START_Y = 0;
	public static final int MOB_TEXTURE_START_X = 0;
	public static final int MOB_TEXTURE_START_Y = 16;
	public static final int STOREFRONT_TEXTURE_START_X = 0;
	public static final int STOREFRONT_TEXTURE_START_Y = 48;

	// height and width of terrains
	public static final int TERRAIN_WIDTH = 256;
	public static final int TERRAIN_HEIGHT = 16;

	// height and width of storefronts
	public static final int STOREFRONT_WIDTH = 480;
	public static final int STOREFRONT_HEIGHT = 128;

	// height and width of equipables
	public static final int WEAPON_WIDTH = 8;
	public static final int WEAPON_HEIGHT = 8;
	public static final int ARMOR_WIDTH = 8;
	public static final int ARMOR_HEIGHT = 8;

	// height from bottom of viewport to start drawing the terrain
	public static final int TERRAIN_BASE_Y = 0;

	// square size of mob sprites
	public static final int MOB_SQUARE_SIZE = 32;

	// y coordinate for the bottom of the view port
	public static final int VIEWPORT_LOWER_BOUNDS = GAME_SCREEN_HEIGHT - TERRAIN_HEIGHT * 3;

	// storefront metrics
	public static final int STOREFRONT_GREETING_WINDOW_BOTTOM = GAME_SCREEN_HEIGHT - 75;
	public static final int STOREFRONT_OPTION_HEIGHT = 40;
	public static final int STOREFRONT_OPTION_WIDTH = 180;
	public static final int STOREFRONT_OPTION_GAP = 10;
	public static final int FONT_HEIGHT_OFFSET = 25;
}
