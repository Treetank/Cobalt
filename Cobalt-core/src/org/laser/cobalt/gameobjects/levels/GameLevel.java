package org.laser.cobalt.gameobjects.levels;

import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.gameobjects.levels.indoor.Hospital;
import org.laser.cobalt.gameobjects.levels.indoor.Smith;
import org.laser.cobalt.gameobjects.levels.outdoor.FirstLevel;
import org.laser.cobalt.gameobjects.levels.outdoor.SecondLevel;
import org.laser.cobalt.gameobjects.levels.outdoor.ThirdLevel;
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

	public static GameLevel LevelCreator(CobaltGame game, LevelIndex li) {
		GameLevel retVal;
		switch (li) {
		case CREEPER_PATH:
			retVal = new ThirdLevel(game);
			break;
		case IMP_PATH:
			retVal = new SecondLevel(game);
			break;
		case STARTING_PATH:
			retVal = new FirstLevel(game);
			break;
		case HOSPITAL:
			retVal = new Hospital(game);
			break;
		case BLACKSMITH:
			retVal = new Smith(game);
			break;
		default:
			retVal = new FirstLevel(game);
			break;
		}
		return retVal;
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
