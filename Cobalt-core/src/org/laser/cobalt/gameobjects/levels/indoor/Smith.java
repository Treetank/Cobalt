package org.laser.cobalt.gameobjects.levels.indoor;

import static org.laser.cobalt.CobaltBasics.CobaltStrings.SMITHY_BASE_GREETING;
import static org.laser.cobalt.CobaltBasics.CobaltStrings.SMITHY_NO_WORK_GREETING;

import org.laser.cobalt.CobaltBasics.ItemIndex;
import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.gameobjects.Hero;
import org.laser.cobalt.gameobjects.gear.Equipable;
import org.laser.cobalt.gameobjects.levels.IndoorGameLevel;
import org.laser.cobalt.helpers.types.World;

public class Smith extends IndoorGameLevel {

	public Smith(CobaltGame game) {
		super(game, TextureIndex.IN_HOSPITAL);
		levelIndex = LevelIndex.BLACKSMITH;
	}

	@Override
	public void doOption(int option) {
		Hero hero = game.getGameWorld().getWorldData().getHero();
		World data = game.getGameWorld().getWorldData();
		switch (option) {
		case 0:
			data.getInventory().addItem(Equipable.ItemCreator(ItemIndex.SWORD, 1));
			data.getInventory().addCurrency(-100, 0, 0, 0);
			hero.equip(data.getInventory().getSword());
			greeting = SMITHY_NO_WORK_GREETING;
			break;
		default:
			break;
		}
	}

	@Override
	public void setupText() {
		optionText = new String[1];
		if (optionIsAvailable(0)) {
			greeting = SMITHY_BASE_GREETING;
		} else {
			greeting = SMITHY_NO_WORK_GREETING;
		}
		optionText[0] = "BUY SWORD";
	}

	@Override
	public boolean optionIsAvailable(int option) {
		World data = game.getGameWorld().getWorldData();
		switch (option) {
		case 0:
			return ((data.getInventory().getSword().getLevel() == 0) && (data.getInventory().getGold() > 100));
		default:
			return false;
		}
	}

}
