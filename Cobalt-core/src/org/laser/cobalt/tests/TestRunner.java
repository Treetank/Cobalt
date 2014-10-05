package org.laser.cobalt.tests;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {

	public static void main(String[] args) {
		List<BaseTest> testList = new ArrayList<BaseTest>();
		testList.add(new InventoryTester());
		testList.add(new FactoryTester());
		testList.add(new MobTester());
		testList.add(new CombatTester());

		for (BaseTest b : testList) {
			b.runTests();
		}
	}

}
