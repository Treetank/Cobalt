package org.laser.cobalt;

import java.util.ArrayList;

import com.esotericsoftware.kryonet.Connection;

public class ClientHandler {

	public ArrayList<CobaltClient> clients;

	public ClientHandler() {
		clients = new ArrayList<CobaltClient>();
	}

	public void addClient(CobaltClient client) {
		if (client.getConnection().isConnected()) {
			clients.add(client);
			System.out.println("[CONFIRM] Client " + client.getUsername() + " added to clients list.");
		} else {
			System.out.println("[INFO] Client " + client.getUsername() + " is disconnected.");
		}
	}

	public void removeClient(Connection con) {

	}

	public CobaltClient getClient(Connection con) {
		for (CobaltClient cc : clients) {
			if (cc.getId() == con.getID()) {
				return cc;
			}
		}
		return null;
	}

	public void showConnected() {
		for (CobaltClient cc : clients) {
			System.out.println(cc.getUsername());
		}
	}
}
