package org.laser.cobalt.tests;

public abstract class BaseTest {

	public abstract void runTests();

	public void printResult(String testText, boolean result) {
		System.out.print(testText + " : ");
		if (result) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
	}
}
