package org.laser.cobalt.gameobjects;

import static org.laser.cobalt.CobaltBasics.GameWindowMetrics.VIEWPORT_LOWER_BOUNDS;

import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.helpers.types.ImageProperties;

import com.badlogic.gdx.math.Vector2;

public abstract class Drawable {

	protected Vector2 coords;
	protected float width, height, location, baseLocation;
	protected TextureIndex texture;

	@Deprecated
	public Drawable(ImageProperties ip, TextureIndex texture) {
		init();
		setImageProperties(ip);
		setTexture(texture);
	}

	protected Drawable() {
		init();
	}

	public void setImageProperties(ImageProperties ip) {
		coords = new Vector2(ip.X(), ip.Y() + VIEWPORT_LOWER_BOUNDS);
		this.width = ip.Width();
		this.height = ip.Height();
		this.location = ip.X();
	}

	public void setTexture(TextureIndex texture) {
		baseLocation = this.location;
		this.texture = texture;
	}

	public void update(float position) {
		coords.x = location - position;
	}

	public float getX() {
		return coords.x;
	}

	public float getY() {
		return coords.y;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public void move(float location) {
		this.location = location;
	}

	public float getLocation() {
		return location;
	}

	public float getCenterX() {
		return coords.x + (width / 2);
	}

	public float getCenterY() {
		return coords.y + (height / 2);
	}

	public TextureIndex getTexture() {
		return texture;
	}

	public void returnToBase() {
		location = baseLocation;
	}

	protected abstract void init();
}
