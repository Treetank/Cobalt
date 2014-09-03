package org.laser.cobalt.gameobjects;

import org.laser.cobalt.CobaltBasics;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.helpers.types.ImageProperties;

public class Terrain extends Drawable{

	public Terrain(float x, TextureIndex texture) {
		super(new ImageProperties (x, CobaltBasics.TERRAIN_BASE_Y, CobaltBasics.TERRAIN_HEIGHT, CobaltBasics.TERRAIN_WIDTH), texture);
	}

}
