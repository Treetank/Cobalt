package org.laser.cobalt;

import java.util.ArrayList;

import org.laser.cobalt.networking.packets.Packet2Message;

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
		int index = 0;
		for (CobaltClient c : clients) {
			if (c.getId() == con.getID()) {
				break;
			} else {
				index++;
			}
		}
		System.out.println("[INFO] Client removed with connection ID " + con.getID() + ", " + getUsername(con) + ".");
		clients.remove(index);
	}

	public CobaltClient getClient(Connection con) {
		for (CobaltClient c : clients) {
			if (c.getId() == con.getID()) {
				return c;
			}
		}
		return null;
	}

	public String getUsername(Connection con) {
		for (CobaltClient c : clients) {
			if (c.getId() == con.getID()) {
				return c.getUsername();
			}
		}
		return "unfound";
	}

	public void circulateMessage(Connection con, Packet2Message mes) {
		for (CobaltClient c : clients) {
			if (c.getId() != con.getID()) {
				c.getConnection().sendTCP(mes);
			}
		}
	}

	public void showConnected() {
		for (CobaltClient c : clients) {
			System.out.println(c.getUsername());
		}
	}
}
