package org.laser.cobalt.helpers;

import org.laser.cobalt.CobaltBasics;

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

		font = new BitmapFont(Gdx.files.internal("textures/aharoni2.fnt"), new TextureRegion(fontTexture), false);
	}

	private static TextureRegion loadTexture(int xPos, int yPos, int size) {
		return new TextureRegion(texture, CobaltBasics.MOB_TEXTURE_START_X + xPos * CobaltBasics.MOB_SQUARE_SIZE, CobaltBasics.MOB_TEXTURE_START_Y + yPos
				* CobaltBasics.MOB_SQUARE_SIZE, size * CobaltBasics.MOB_SQUARE_SIZE, size * CobaltBasics.MOB_SQUARE_SIZE);
	}

	private static TextureRegion loadTerrain(int xPos, int yPos) {
		return new TextureRegion(texture, CobaltBasics.TERRAIN_TEXTURE_START_X + xPos * CobaltBasics.TERRAIN_WIDTH, CobaltBasics.TERRAIN_TEXTURE_START_Y + yPos
				* CobaltBasics.TERRAIN_HEIGHT, CobaltBasics.TERRAIN_WIDTH, CobaltBasics.TERRAIN_HEIGHT);
	}

	private static TextureRegion loadStorefront(int xPos, int yPos) {
		return new TextureRegion(texture, CobaltBasics.STOREFRONT_TEXTURE_START_X + xPos * CobaltBasics.STOREFRONT_WIDTH,
				CobaltBasics.STOREFRONT_TEXTURE_START_Y + yPos * CobaltBasics.STOREFRONT_HEIGHT, CobaltBasics.STOREFRONT_WIDTH, CobaltBasics.STOREFRONT_HEIGHT);
	}

	public static void dispose() {
		texture.dispose();
		fontTexture.dispose();
	}
}
