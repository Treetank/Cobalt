package org.laser.cobalt.gameobjects.factories;

import org.laser.cobalt.CobaltBasics.ItemIndex;
import org.laser.cobalt.gameobjects.Equipable;
import org.laser.cobalt.gameobjects.gear.armor.LightPlate;
import org.laser.cobalt.gameobjects.gear.armor.NoChestArmor;
import org.laser.cobalt.gameobjects.gear.weapons.BareHands;
import org.laser.cobalt.gameobjects.gear.weapons.Sword;

public class EquipableFactory {

	public static Equipable ItemCreator(ItemIndex item, int level) {
		Equipable retVal;
		switch (item) {
		case BARE_HANDS:
			retVal = new BareHands(level);
			break;
		case LIGHT_CHEST_PLATE:
			retVal = new LightPlate(level);
			break;
		case NO_CHEST_PLATE:
			retVal = new NoChestArmor(level);
			break;
		case SWORD:
			retVal = new Sword(level);
			break;
		default:
			retVal = null;
			break;
		}
		return retVal;
	}
}
