package org.laser.cobalt.gameobjects;

import static org.laser.cobalt.CobaltBasics.ImageMetrics.MOB_SQUARE_SIZE;
import static org.laser.cobalt.CobaltBasics.ImageMetrics.TERRAIN_HEIGHT;

import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.helpers.types.ImageProperties;

public class Exit extends Drawable {

	protected LevelIndex gotoLevel;

	public Exit(float x, TextureIndex texture, LevelIndex level) {
		super(new ImageProperties(x, TERRAIN_HEIGHT, MOB_SQUARE_SIZE, MOB_SQUARE_SIZE), texture);

		gotoLevel = level;
	}

	public LevelIndex GetDestination() {
		return gotoLevel;
	}
}
