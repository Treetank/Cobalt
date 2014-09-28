package org.laser.cobalt.gameobjects;

import static org.laser.cobalt.CobaltBasics.GameWindowMetrics.TERRAIN_BASE_Y;
import static org.laser.cobalt.CobaltBasics.ImageMetrics.TERRAIN_HEIGHT;
import static org.laser.cobalt.CobaltBasics.ImageMetrics.TERRAIN_WIDTH;

import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.helpers.types.ImageProperties;

public class Terrain extends Drawable {

	public Terrain(float x, TextureIndex texture) {
		super(new ImageProperties(x, TERRAIN_BASE_Y, TERRAIN_HEIGHT, TERRAIN_WIDTH), texture);
	}

}
