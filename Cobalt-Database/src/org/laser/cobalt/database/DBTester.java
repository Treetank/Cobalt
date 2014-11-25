package org.laser.cobalt.database;

public class DBTester {
	public static void main(String[] args) {
		CobaltDBManager dbm = new CobaltDBManager();

		// dbm.createUserlist();
		dbm.addNewUser("two one");
		dbm.addNewUser("two two");
		dbm.addNewUser("two three");
	}
}
