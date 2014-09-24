package org.laser.cobalt.gameobjects.levels;

import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.CobaltGame;

public abstract class IndoorGameLevel extends GameLevel {
	
	protected String greeting;
	protected String[] optionText;

	public IndoorGameLevel(CobaltGame game, TextureIndex texture) {
		super(game, texture);
		setupText();
	}

	@Override
	public boolean isIndoor() {
		return true;
	}

	@Override
	public void update(float delta) {
	}

	public void clickExit() {
		game.goOutdoors();
	}
	
	public String getGreeting() {
		return greeting;
	}
	
	public String[] getOptions() {
		return optionText;
	}

	public abstract void doOption(int option);
	
	public abstract void setupText();
	
	public abstract boolean optionIsAvailable(int option);
}
