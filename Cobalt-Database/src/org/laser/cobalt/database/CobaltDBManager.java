package org.laser.cobalt.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.laser.cobalt.database.tables.Userlist;

public class CobaltDBManager {

	private static final String USERLIST = "USERS";

	private static String dbURL = "jdbc:derby:C:\\Users\\Wayne\\MyDB;create=true";
	private static Connection dbCon = null;
	private static Statement stmt = null;

	public static Userlist userlist;

	private static Map<String, Table> tables;

	public CobaltDBManager() {
		userlist = new Userlist();
		tables = new HashMap<>();
		tables.put(USERLIST, userlist);

		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			dbCon = DriverManager.getConnection(dbURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean addNewUser(String deviceId) {
		return executeStatement(userlist.addUser(deviceId));
	}

	public boolean createUserlist() {
		if (!executeStatement(userlist.makeTable())) {
			if (dropUserlist()) {
				return createUserlist();
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	public boolean dropUserlist() {
		return executeStatement(userlist.dropTable());
	}

	private boolean executeStatement(String statement) {
		try {
			stmt = dbCon.createStatement();
			stmt.execute(statement);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}