package org.laser.cobalt.helpers.types;

import org.laser.cobalt.CobaltBasics.TextureIndex;

public final class TextureCollection {

	private final TextureIndex base, swinging, damage;

	public TextureCollection(TextureIndex base, TextureIndex swinging, TextureIndex damage) {
		this.base = base;
		this.swinging = swinging;
		this.damage = damage;
	}

	public TextureIndex Base() {
		return base;
	}

	public TextureIndex Swinging() {
		return swinging;
	}
	
	public TextureIndex Damage() {
		return damage;
	}
}
