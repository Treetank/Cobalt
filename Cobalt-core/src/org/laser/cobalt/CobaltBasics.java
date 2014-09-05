package org.laser.cobalt;

public final class CobaltBasics {

	public static enum TextureIndex {
		GRASS, ICE, HERO, SLIME, IMP, HERO_ATTACKING, EXPLOSION, SCRATCH, SIGN
	};

	public static enum LevelIndex {
		STARTING_PATH, IMP_PATH
	};

	public static final int DESKTOP_VIEWPORT_WIDTH = 480;
	public static final int DESKTOP_VIEWPORT_HEIGHT = 320;

	public static final int GAME_SCREEN_WIDTH = 480;
	public static final int GAME_SCREEN_HEIGHT = 320;
	public static final int LEFT_WALK_LIMIT = 55;
	public static final int RIGHT_WALK_LIMIT = GAME_SCREEN_WIDTH - LEFT_WALK_LIMIT;

	public static final String WINDOW_TITLE = "Cobalt - Lil RPG";

	public static final int TERRAIN_TEXTURE_START_X = 0;
	public static final int TERRAIN_TEXTURE_START_Y = 0;
	public static final int TERRAIN_WIDTH = 256;
	public static final int TERRAIN_HEIGHT = 16;
	public static final int TERRAIN_BASE_Y = 0;

	public static final int MOB_TEXTURE_START_X = 0;
	public static final int MOB_TEXTURE_START_Y = 32;
	public static final int MOB_SQUARE_SIZE = 32;

	public static final int VIEWPORT_LOWER_BOUNDS = GAME_SCREEN_HEIGHT - TERRAIN_HEIGHT * 3;
}
