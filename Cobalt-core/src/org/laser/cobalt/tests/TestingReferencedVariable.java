package org.laser.cobalt.tests;

public class TestingReferencedVariable {
	private TestingBaseVariable base;

	public TestingReferencedVariable(TestingBaseVariable base) {
		this.setBase(base);
	}

	public TestingBaseVariable getBase() {
		return base;
	}

	public void setBase(TestingBaseVariable base) {
		this.base = base;
	}
}
