package org.laser.cobalt;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;

public class CobaltClient extends Client {

	private String username;
	private int id;
	private Connection con;

	public CobaltClient(String user, Connection connection) {
		this.username = user;
		this.con = connection;
		this.id = connection.getID();
		System.out.println("[INFO] Created client.");
	}

	public String getUsername() {
		return this.username;
	}

	public int getId() {
		return this.id;
	}

	public Connection getConnection() {
		return this.con;
	}
}
