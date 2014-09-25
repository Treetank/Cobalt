package org.laser.cobalt.tests;

import org.laser.cobalt.CobaltBasics.ItemIndex;
import org.laser.cobalt.gameobjects.factories.EquipableFactory;

public class FactoryTester extends BaseTest {

	@Override
	public void runTests() {
		System.out.println("\nFactory Tester");
		System.out.print("equipable factory test: ");
		if (testEquipableFactoryOutput())
			System.out.println("Passed");
		else
			System.out.println("Failed");
	}

	public boolean testEquipableFactoryOutput() {
		boolean retVal = true;
		retVal &= printResult("assert sword level", EquipableFactory.ItemCreator(ItemIndex.SWORD, 1).getLevel() == 1);
		retVal &= printResult("assert light plate level", EquipableFactory.ItemCreator(ItemIndex.LIGHT_CHEST_PLATE, 1).getLevel() == 1);
		retVal &= printResult("assert bare hands level", EquipableFactory.ItemCreator(ItemIndex.BARE_HANDS, 1).getLevel() == 1);
		retVal &= printResult("assert no chest plate level", EquipableFactory.ItemCreator(ItemIndex.NO_CHEST_PLATE, 1).getLevel() == 1);
		return retVal;
	}

}
