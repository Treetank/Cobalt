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
		case 0:
			game.getWorld().getHero().getStats().heal(-1);
			break;
		case 1:
			game.getWorld().getHero().getStats().heal(5);
			break;
		case 2:
			game.getWorld().getHero().getStats().heal(1);
			break;
		default:
			break;
		}
	}

	@Override
	public void setupText() {
		optionText = new String[3];
		greeting = "WELCOME TO HOSPITAL";
		optionText[0] = "HEAL";
		optionText[1] = "DIE";
		optionText[2] = "GO HOME AND DIE";
	}
}
