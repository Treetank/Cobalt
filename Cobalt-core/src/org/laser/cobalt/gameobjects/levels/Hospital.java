package org.laser.cobalt.gameobjects.levels;

import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.CobaltGame;

public class Hospital extends IndoorGameLevel {

	public Hospital(CobaltGame game) {
		super(game, TextureIndex.IN_HOSPITAL);
		levelIndex = LevelIndex.HOSPITAL;
	}
	
	@Override
	public void doOption(int option) {
		switch (option) {
			case 1: 
				// game.getworld().gethero().heal()
				break;
			default: break;
		}
	}
	
	@Override
	public void setupText() {
		greeting = "Welcome to hospital";
	}
}
