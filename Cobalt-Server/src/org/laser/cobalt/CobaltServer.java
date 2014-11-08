package org.laser.cobalt;

import static org.laser.cobalt.networking.KryoBasics.ServerConnectionInformation.TCP_PORT;
import static org.laser.cobalt.networking.KryoBasics.ServerConnectionInformation.UDP_PORT;

import java.io.IOException;

import org.laser.cobalt.networking.KryoConfig;
import org.laser.cobalt.networking.packets.Packet;
import org.laser.cobalt.networking.packets.Packet1Connect;
import org.laser.cobalt.networking.packets.Packet2Message;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

public class CobaltServer {

	private static ClientHandler clientHandler;
	private static Server server;

	public static void main(String[] args) {
		initServer();
		startServer();
		try {
			server.bind(TCP_PORT, UDP_PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		server.addListener(serverListener);
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stopServer();
	}

	private static void initServer() {
		server = new Server();
		clientHandler = new ClientHandler();
		KryoConfig.RegisterClasses(server.getKryo());
		System.out.println("Cobalt Server Initialized");
	}

	private static void startServer() {
		server.start();
		System.out.println("Cobalt Server Started");
	}

	private static void stopServer() {
		server.stop();
		System.out.println("Cobalt Server Stopped");
	}

	private static Listener serverListener = new Listener() {
		public void disconnected(Connection connection) {
			clientHandler.removeClient(connection);
		}

		public void received(Connection connection, Object object) {
			if (object instanceof Packet) {
				if (object instanceof Packet1Connect) {
					Packet1Connect con = (Packet1Connect) object;
					System.out.println("[CONNECTED] " + con.name);
					clientHandler.addClient(new CobaltClient(con.name, connection));
				} else if (object instanceof Packet2Message) {
					Packet2Message mes = (Packet2Message) object;
					System.out.println("[RECEVIED] [" + clientHandler.getClient(connection).getUsername() + "] " + mes.message);
				}
			}
		}
	};
}
