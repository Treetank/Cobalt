package org.laser.cobalt.gameobjects;

import org.laser.cobalt.CobaltBasics;
import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.helpers.types.ImageProperties;

public class Exit extends Drawable {
	
	protected LevelIndex gotoLevel;

	public Exit(float x, TextureIndex texture, LevelIndex level) {
		super(new ImageProperties(x, CobaltBasics.TERRAIN_HEIGHT, CobaltBasics.MOB_SQUARE_SIZE, CobaltBasics.MOB_SQUARE_SIZE), texture);
		
		gotoLevel = level;
	}
	
	public LevelIndex GetDestination () {
		return gotoLevel;
	}
}
