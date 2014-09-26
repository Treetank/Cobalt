package org.laser.cobalt.gameobjects.levels.indoor;

import org.laser.cobalt.CobaltBasics.ItemIndex;
import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.gameobjects.gear.Equipable;
import org.laser.cobalt.gameobjects.levels.IndoorGameLevel;

public class Smith extends IndoorGameLevel {

	public Smith(CobaltGame game) {
		super(game, TextureIndex.IN_HOSPITAL);
		levelIndex = LevelIndex.BLACKSMITH;
	}

	@Override
	public void doOption(int option) {
		switch (option) {
		case 0:
			game.getWorld().getHero().getInventory().addItem(Equipable.ItemCreator(ItemIndex.SWORD, 1));
			game.getWorld().getHero().getInventory().addCurrency(-100, 0, 0, 0);
			game.getWorld().getHero().equip(game.getWorld().getHero().getInventory().getSword());
			break;
		default:
			break;
		}
	}

	@Override
	public void setupText() {
		optionText = new String[1];
		greeting = "WELCOME TO THE SMITHERY. SELL YOU THIS NICE SWORD 100G.";
		optionText[0] = "BUY SWORD";
	}

	@Override
	public boolean optionIsAvailable(int option) {
		switch (option) {
		case 0:
			return ((game.getWorld().getHero().getInventory().getSword().getLevel() == 0) && (game.getWorld().getHero().getInventory().getGold() > 100));
		default:
			return false;
		}
	}

}
