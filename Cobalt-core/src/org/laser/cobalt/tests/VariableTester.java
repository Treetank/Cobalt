package org.laser.cobalt.tests;

public class VariableTester extends BaseTest {
	@Override
	public void runTests() {
		System.out.println("\nVariable Tester");
		System.out.print("variable changing test: ");
		if (testVariablesChange())
			System.out.println("Passed");
		else
			System.out.println("Failed");
	}

	public boolean testVariablesChange() {
		TestingBaseVariable base = new TestingBaseVariable(1);
		TestingReferencedVariable ref = new TestingReferencedVariable(base);
		boolean retVal = true;
		retVal &= printResult("assert inital values", ref.getBase().getId() == base.getId());

		base = new TestingBaseVariable(2); // setting new base breaks the ref
		retVal &= printResult("assert with new base", ref.getBase().getId() != base.getId());

		ref.setBase(base); // setting base in ref fixes connection
		retVal &= printResult("assert base set by ref", ref.getBase().getId() == base.getId());

		ref.getBase().setId(3); // setting base variable through ref works
		retVal &= printResult("assert changed id through ref", ref.getBase().getId() == base.getId());

		ref.setBase(new TestingBaseVariable(4)); // setting new base through ref
													// does not change base
		retVal &= printResult("assert base not changed by new through ref", ref.getBase().getId() != base.getId());

		ref = new TestingReferencedVariable(base); // creating a new ref fixes
													// link
		retVal &= printResult("assert new ref fixed", ref.getBase().getId() == base.getId());

		base.setId(5); // changes in base extend to ref
		retVal &= printResult("assert ref id changed by base", ref.getBase().getId() == base.getId());
		return retVal;
	}
}
