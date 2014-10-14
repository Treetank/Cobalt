package org.laser.cobalt.helpers;

import static org.laser.cobalt.CobaltBasics.ImageMetrics.MOB_SQUARE_SIZE;
import static org.laser.cobalt.CobaltBasics.ImageMetrics.SPLASH_HEIGHT;
import static org.laser.cobalt.CobaltBasics.ImageMetrics.SPLASH_WIDTH;
import static org.laser.cobalt.CobaltBasics.ImageMetrics.STOREFRONT_HEIGHT;
import static org.laser.cobalt.CobaltBasics.ImageMetrics.STOREFRONT_WIDTH;
import static org.laser.cobalt.CobaltBasics.ImageMetrics.TERRAIN_HEIGHT;
import static org.laser.cobalt.CobaltBasics.ImageMetrics.TERRAIN_WIDTH;
import static org.laser.cobalt.CobaltBasics.TextureMapMetrics.MOB_START_X;
import static org.laser.cobalt.CobaltBasics.TextureMapMetrics.MOB_START_Y;
import static org.laser.cobalt.CobaltBasics.TextureMapMetrics.SPLASH_START_X;
import static org.laser.cobalt.CobaltBasics.TextureMapMetrics.SPLASH_START_Y;
import static org.laser.cobalt.CobaltBasics.TextureMapMetrics.STOREFRONT_START_X;
import static org.laser.cobalt.CobaltBasics.TextureMapMetrics.STOREFRONT_START_Y;
import static org.laser.cobalt.CobaltBasics.TextureMapMetrics.TERRAIN_START_X;
import static org.laser.cobalt.CobaltBasics.TextureMapMetrics.TERRAIN_START_Y;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

	public static Texture texture, fontTexture;

	public static TextureRegion grass, ice;

	public static TextureRegion hero, heroAttack;

	public static TextureRegion slime, creeper, imp;

	public static TextureRegion explosion, scratch;

	public static TextureRegion sign, house;

	public static TextureRegion storefront;

	public static TextureRegion deathSplash;

	public static BitmapFont font;

	public static void load() {
		texture = new Texture(Gdx.files.internal("textures/texture.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		// true enables mipmaps
		fontTexture = new Texture(Gdx.files.internal("textures/aharoni2.png"), true);

		// linear filtering in nearest mipmap image
		fontTexture.setFilter(TextureFilter.MipMapLinearLinear, TextureFilter.Linear);

		grass = loadTerrain(0, 0);
		ice = loadTerrain(1, 0);

		hero = loadTexture(0, 0, 1);
		heroAttack = loadTexture(1, 0, 1);
		slime = loadTexture(2, 0, 1);
		creeper = loadTexture(3, 0, 1);
		imp = loadTexture(4, 0, 1);
		explosion = loadTexture(5, 0, 1);
		scratch = loadTexture(6, 0, 1);
		sign = loadTexture(7, 0, 1);
		house = loadTexture(8, 0, 1);

		storefront = loadStorefront(0, 0);

		deathSplash = loadSplash(0, 0);

		font = new BitmapFont(Gdx.files.internal("textures/aharoni2.fnt"), new TextureRegion(fontTexture), false);
	}

	private static TextureRegion loadTexture(int xPos, int yPos, int size) {
		return new TextureRegion(texture, MOB_START_X + xPos * MOB_SQUARE_SIZE, MOB_START_Y + yPos * MOB_SQUARE_SIZE, size * MOB_SQUARE_SIZE, size
				* MOB_SQUARE_SIZE);
	}

	private static TextureRegion loadTerrain(int xPos, int yPos) {
		return new TextureRegion(texture, TERRAIN_START_X + xPos * TERRAIN_WIDTH, TERRAIN_START_Y + yPos * TERRAIN_HEIGHT, TERRAIN_WIDTH, TERRAIN_HEIGHT);
	}

	private static TextureRegion loadStorefront(int xPos, int yPos) {
		return new TextureRegion(texture, STOREFRONT_START_X + xPos * STOREFRONT_WIDTH, STOREFRONT_START_Y + yPos * STOREFRONT_HEIGHT, STOREFRONT_WIDTH,
				STOREFRONT_HEIGHT);
	}

	private static TextureRegion loadSplash(int xPos, int yPos) {
		return new TextureRegion(texture, SPLASH_START_X + xPos * SPLASH_WIDTH, SPLASH_START_Y + yPos * SPLASH_HEIGHT, SPLASH_WIDTH, SPLASH_HEIGHT);
	}

	public static void dispose() {
		texture.dispose();
		fontTexture.dispose();
	}
}
