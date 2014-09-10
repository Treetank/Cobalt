package org.laser.cobalt.gameobjects.levels;

import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.gameworld.GameWorld;
import org.laser.cobalt.helpers.types.World;

public abstract class GameLevel {

	protected CobaltGame game;
	protected GameWorld gameWorld;
	protected TextureIndex terrainTexture;
	protected LevelIndex levelIndex;

	protected World world;

	public GameLevel(CobaltGame game, TextureIndex texture) {
		this.game = game;
		this.world = game.getWorld();
		this.gameWorld = game.getGameWorld();
		this.terrainTexture = texture;

	}

	public abstract void update(float delta);

	public TextureIndex getTerrainTexture() {
		return terrainTexture;
	}

	public LevelIndex getLevelIndex() {
		return levelIndex;
	}

	public abstract boolean isIndoor();
}
