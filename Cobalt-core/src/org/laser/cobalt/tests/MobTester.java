package org.laser.cobalt.tests;

import org.laser.cobalt.CobaltBasics.EnemyIndex;
import org.laser.cobalt.gameobjects.Mob;
import org.laser.cobalt.gameobjects.npcs.Npc;

public class MobTester extends BaseTest {

	@Override
	public void runTests() {
		System.out.println("\nMob Tester");
		System.out.print("initial value test: ");
		if (testInitialValues())
			System.out.println("Passed");
		else
			System.out.println("Failed");
	}

	public boolean testInitialValues() {
		Mob mob = Npc.EnemyCreator(EnemyIndex.SLIME, 0);
		boolean retVal = true;
		retVal &= printResult("assert Slime initial hp", mob.getHp().getCurrent() == 10);
		return retVal;
	}

}
