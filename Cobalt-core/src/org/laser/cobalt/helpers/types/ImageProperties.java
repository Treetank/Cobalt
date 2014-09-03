package org.laser.cobalt.helpers.types;

public final class ImageProperties {

	private final float x, y, height, width;

	public ImageProperties(float x, float y, float height, float width) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}

	public float X() {
		return x;
	}

	public float Y() {
		return y;
	}

	public float Height() {
		return height;
	}

	public float Width() {
		return width;
	}
}
