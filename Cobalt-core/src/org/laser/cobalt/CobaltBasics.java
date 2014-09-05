package org.laser.cobalt;

public final class CobaltBasics {

	public static enum TextureIndex {
		GRASS, ICE, HERO, SLIME, IMP, CREEPER, HERO_ATTACKING, EXPLOSION, SCRATCH, SIGN
	};

	public static enum LevelIndex {
		STARTING_PATH, IMP_PATH, CREEPER_PATH
	};

	// height and width of the desktop client window
	public static final int DESKTOP_VIEWPORT_WIDTH = 480;
	public static final int DESKTOP_VIEWPORT_HEIGHT = 320;

	// title of the window for the desktop client
	public static final String WINDOW_TITLE = "Cobalt - Lil RPG";

	// controlled resolution of the game in any client
	public static final int GAME_SCREEN_WIDTH = 480;
	public static final int GAME_SCREEN_HEIGHT = 320;

	// how far left and right the hero can walk before scrolling the terrain
	public static final int LEFT_WALK_LIMIT = 55;
	public static final int RIGHT_WALK_LIMIT = GAME_SCREEN_WIDTH - LEFT_WALK_LIMIT;

	// x,y of the starting of the types of textures in our texture map
	public static final int TERRAIN_TEXTURE_START_X = 0;
	public static final int TERRAIN_TEXTURE_START_Y = 0;
	public static final int MOB_TEXTURE_START_X = 0;
	public static final int MOB_TEXTURE_START_Y = 32;

	// height and width of terrains
	public static final int TERRAIN_WIDTH = 256;
	public static final int TERRAIN_HEIGHT = 16;

	// height from bottom of viewport to start drawing the terrain
	public static final int TERRAIN_BASE_Y = 0;

	// square size of mob sprites
	public static final int MOB_SQUARE_SIZE = 32;

	// y coordinate for the bottom of the view port
	public static final int VIEWPORT_LOWER_BOUNDS = GAME_SCREEN_HEIGHT - TERRAIN_HEIGHT * 3;
}
