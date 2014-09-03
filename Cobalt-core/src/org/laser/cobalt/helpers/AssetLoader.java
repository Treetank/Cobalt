package org.laser.cobalt.helpers;

import org.laser.cobalt.CobaltBasics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

	public static Texture texture, fontTexture;

	public static TextureRegion grass, ice, hero, slime, imp, heroAttack, explosion, scratch, sign;

	public static BitmapFont font;

	public static void load() {
		texture = new Texture(Gdx.files.internal("textures/texture.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		fontTexture = new Texture(Gdx.files.internal("fonts/Aharoni2.png"), true); // true
		// enables
		// mipmaps
		fontTexture.setFilter(TextureFilter.MipMapLinearLinear, TextureFilter.Linear); // linear
																						// filtering
																						// in
																						// nearest
																						// mipmap
																						// image

		grass = loadTerrain(0, 0);
		ice = loadTerrain(0, 1);

		hero = loadTexture(0, 2, 1);
		slime = loadTexture(0, 3, 1);
		explosion = loadTexture(1, 2, 1);
		sign = loadTexture(1, 3, 1);
		scratch = loadTexture(2, 2, 1);
		imp = loadTexture(2, 3, 1);
		heroAttack = loadTexture(3, 2, 1);

		font = new BitmapFont(Gdx.files.internal("fonts/Aharoni2.fnt"), new TextureRegion(fontTexture), false);
	}

	private static TextureRegion loadTexture(int xPos, int yPos, int size) {
		return new TextureRegion(texture, xPos * CobaltBasics.MOB_SQUARE_SIZE, yPos * CobaltBasics.MOB_SQUARE_SIZE, size * CobaltBasics.MOB_SQUARE_SIZE, size
				* CobaltBasics.MOB_SQUARE_SIZE);
	}

	private static TextureRegion loadTerrain(int xPos, int yPos) {
		return new TextureRegion(texture, xPos * CobaltBasics.TERRAIN_WIDTH, yPos * CobaltBasics.TERRAIN_HEIGHT, CobaltBasics.TERRAIN_WIDTH,
				CobaltBasics.TERRAIN_HEIGHT);
	}

	public static void dispose() {
		texture.dispose();
		fontTexture.dispose();
	}
}
