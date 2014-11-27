package org.laser.cobalt.database;

public class DBTester {
	public static void main(String[] args) {
		CobaltDBManager dbm = new CobaltDBManager();

		// dbm.createUserlist();
		// dbm.addNewUser("six one");
		// dbm.addNewUser("six two");
		// dbm.addNewUser("six three");

		System.out.println(dbm.findUser("six two").getId());
	}
}
