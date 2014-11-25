package org.laser.cobalt.database.helpers;

public class DBColumn {
	private final String columnName;
	private final String columnType;

	public DBColumn(String name, String type) {
		this.columnName = name;
		this.columnType = type;
	}

	public String getName() {
		return this.columnName;
	}

	public String getType() {
		return this.columnType;
	}
}
