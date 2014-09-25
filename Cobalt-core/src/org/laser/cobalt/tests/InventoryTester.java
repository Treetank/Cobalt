package org.laser.cobalt.tests;

import org.laser.cobalt.CobaltBasics.ItemIndex;
import org.laser.cobalt.gameobjects.Equipable;
import org.laser.cobalt.gameobjects.Inventory;

public class InventoryTester extends BaseTest {
	private Inventory inv;

	public InventoryTester() {
		inv = new Inventory();
	}

	@Override
	public void runTests() {
		System.out.println("\nInventory Tester");
		System.out.print("assert initial values: ");
		if (assertInitialValues())
			System.out.println("Passed");
		else
			System.out.println("Failed");
		System.out.print("add new items: ");
		if (addNewItemTest())
			System.out.println("Passed");
		else
			System.out.println("Failed");
	}

	public boolean assertInitialValues() {
		boolean retVal = true;
		retVal &= printResult("assert initial values sword level", inv.getSword().getLevel() == 0);
		retVal &= printResult("assert initial values lightPlate level", inv.getLightPlate().getLevel() == 0);
		retVal &= printResult("assert initial values bare hands level", inv.getBareHands().getLevel() == 0);
		retVal &= printResult("assert initial values no chest plate level", inv.getNoChestArmor().getLevel() == 0);
		retVal &= printResult("assert initial values gold level", inv.getGold() == 0);
		retVal &= printResult("assert initial values red gems level", inv.getRedGems() == 0);
		retVal &= printResult("assert initial values blue gems level", inv.getBlueGems() == 0);
		retVal &= printResult("assert initial values diamonds level", inv.getDiamonds() == 0);
		return retVal;
	}

	public boolean addNewItemTest() {
		boolean retVal = true;
		inv.addItem(Equipable.ItemCreator(ItemIndex.SWORD, 1));
		retVal &= printResult("add sword assert new level", inv.getSword().getLevel() == 1);
		inv.addItem(Equipable.ItemCreator(ItemIndex.LIGHT_CHEST_PLATE, 1));
		retVal &= printResult("add light plate assert new level", inv.getLightPlate().getLevel() == 1);
		inv.addItem(Equipable.ItemCreator(ItemIndex.BARE_HANDS, 1));
		retVal &= printResult("add bare hands assert new level", inv.getSword().getLevel() == 1);
		inv.addItem(Equipable.ItemCreator(ItemIndex.NO_CHEST_PLATE, 1));
		retVal &= printResult("add no chest plate assert new level", inv.getLightPlate().getLevel() == 1);
		inv.addCurrency(10, 50, 90, 223);
		retVal &= printResult("add gold assert new value", inv.getGold() == 10);
		retVal &= printResult("add red gems assert new value", inv.getRedGems() == 50);
		retVal &= printResult("add blue gems assert new value", inv.getBlueGems() == 90);
		retVal &= printResult("add diamonds assert new value", inv.getDiamonds() == 223);
		return retVal;
	}
}
