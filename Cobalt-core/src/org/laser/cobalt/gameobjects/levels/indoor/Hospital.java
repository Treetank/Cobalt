package org.laser.cobalt.gameobjects.levels.indoor;

import static org.laser.cobalt.CobaltBasics.CobaltStrings.HOSPITAL_BASE_GREETING;
import static org.laser.cobalt.CobaltBasics.CobaltStrings.HOSPITAL_HEALED_GREETING;

import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.gameobjects.Hero;
import org.laser.cobalt.gameobjects.levels.IndoorGameLevel;
import org.laser.cobalt.helpers.types.World;

public class Hospital extends IndoorGameLevel {

	public Hospital(CobaltGame game) {
		super(game, TextureIndex.IN_HOSPITAL);
		levelIndex = LevelIndex.HOSPITAL;
	}

	@Override
	public void doOption(int option) {
		Hero hero = game.getGameWorld().getWorldData().getHero();
		World data = game.getGameWorld().getWorldData();
		switch (option) {
		case 0:
			hero.getHp().fill();
			data.getInventory().addCurrency(-10, 0, 0, 0);
			greeting = HOSPITAL_HEALED_GREETING;
			break;
		default:
			break;
		}
	}

	@Override
	public void setupText() {
		optionText = new String[1];
		if (optionIsAvailable(0)) {
			greeting = HOSPITAL_BASE_GREETING;
		} else {
			greeting = HOSPITAL_HEALED_GREETING;
		}
		optionText[0] = "HEAL";
	}

	@Override
	public boolean optionIsAvailable(int option) {
		Hero hero = game.getGameWorld().getWorldData().getHero();
		World data = game.getGameWorld().getWorldData();
		switch (option) {
		case 0:
			return ((hero.getHp().getCurrent() < hero.getHp().getMax()) && (data.getInventory().getGold() > 10));
		default:
			return false;
		}
	}
}
