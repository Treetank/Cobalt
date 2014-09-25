package org.laser.cobalt.tests;

public abstract class BaseTest {

	public abstract void runTests();

	public boolean printResult(String testText, boolean result) {
		if (!result) {
			System.out.print(testText + " : Failed");
		}
		return result;
	}
}
