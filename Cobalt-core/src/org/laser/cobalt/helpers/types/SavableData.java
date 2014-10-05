package org.laser.cobalt.helpers.types;

public abstract class SavableData {

	public void load(String loadString) {
		if (loadString != null && loadString != "")
			loadData(loadString);
		else
			loadNew();
	}

	public abstract String save();

	public abstract void loadNew();

	public abstract void loadData(String loadString);
}
