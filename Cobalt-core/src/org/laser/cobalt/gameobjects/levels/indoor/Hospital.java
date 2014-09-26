package org.laser.cobalt.gameobjects.levels.indoor;

import org.laser.cobalt.CobaltBasics;
import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.gameobjects.levels.IndoorGameLevel;

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
			game.getWorld().getHero().getInventory().addCurrency(-10, 0, 0, 0);
			greeting = CobaltBasics.HOSPITAL_HEALED_GREETING;
			break;
		default:
			break;
		}
	}

	@Override
	public void setupText() {
		optionText = new String[1];
		greeting = CobaltBasics.HOSPITAL_BASE_GREETING;
		optionText[0] = "HEAL";
	}

	@Override
	public boolean optionIsAvailable(int option) {
		switch (option) {
		case 0:
			return ((game.getWorld().getHero().getStats().Hp() < game.getWorld().getHero().getStats().getStatics().MaxHp()) && (game.getWorld().getHero()
					.getInventory().getGold() > 10));
		default:
			return false;
		}
	}
}
