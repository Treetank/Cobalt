package org.laser.cobalt.tests;

import org.laser.cobalt.CobaltBasics.ItemIndex;
import org.laser.cobalt.gameobjects.Inventory;
import org.laser.cobalt.gameobjects.factories.EquipableFactory;

public class InventoryTester extends BaseTest {
	private Inventory inv;

	public InventoryTester() {
		inv = new Inventory();
	}

	@Override
	public void runTests() {
		System.out.println("assert initial values:");
		assertInitialValues();
		System.out.println("add new items:");
		addNewItemTest();
	}

	public void assertInitialValues() {
		printResult("assert initial values sword level", inv.getSword().getLevel() == 0);
		printResult("assert initial values lightPlate level", inv.getLightPlate().getLevel() == 0);
		printResult("assert initial values gold level", inv.getGold() == 0);
		printResult("assert initial values red gems level", inv.getRedGems() == 0);
		printResult("assert initial values blue gems level", inv.getBlueGems() == 0);
		printResult("assert initial values diamonds level", inv.getDiamonds() == 0);
	}

	public void addNewItemTest() {
		inv.addItem(EquipableFactory.ItemCreator(ItemIndex.SWORD, 1));
		printResult("add sword assert new level", inv.getSword().getLevel() == 1);
		inv.addItem(EquipableFactory.ItemCreator(ItemIndex.LIGHT_CHEST_PLATE, 1));
		printResult("add light plate assert new level", inv.getLightPlate().getLevel() == 1);
		inv.addCurrency(10, 50, 90, 223);
		printResult("add gold assert new value", inv.getGold() == 10);
		printResult("add red gems assert new value", inv.getRedGems() == 50);
		printResult("add blue gems assert new value", inv.getBlueGems() == 90);
		printResult("add diamonds assert new value", inv.getDiamonds() == 223);
	}
}
