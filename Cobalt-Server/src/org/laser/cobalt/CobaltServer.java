package org.laser.cobalt;

import static org.laser.cobalt.networking.KryoBasics.ServerConnectionInformation.TCP_PORT;
import static org.laser.cobalt.networking.KryoBasics.ServerConnectionInformation.UDP_PORT;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

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
	private static Timer clientListTimer;

	public static void main(String[] args) {
		initServer();
		createDBConnection();
		// addNewUser();
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

	private static void createDBConnection() {
	}

	private static void addNewUser() {
	}

	private static void startServer() {
		server.start();
		clientListTimer = new Timer();
		clientListTimer.scheduleAtFixedRate(clientListTimerTask, 5 * 60 * 1000, 5 * 60 * 1000);
		System.out.println("Cobalt Server Started");
	}

	private static void stopServer() {
		server.stop();
		clientListTimer.cancel();
		System.out.println("Cobalt Server Stopped");
	}

	private static void printClientList() {
		System.out.println("===BEGIN CLIENT LIST===");
		clientHandler.showConnected();
		System.out.println("=== END CLIENT LIST ===");
	}

	private static Listener serverListener = new Listener() {
		public void disconnected(Connection connection) {
			clientHandler.removeClient(connection);
		}

		public void received(Connection connection, Object object) {
			if (object instanceof Packet) {
				if (object instanceof Packet1Connect) {
					Packet1Connect con = (Packet1Connect) object;
					System.out.println("[CONNECTED] " + con.id);
					clientHandler.addClient(new CobaltClient(con.id, connection));
				} else if (object instanceof Packet2Message) {
					Packet2Message mes = (Packet2Message) object;
					System.out.println("[RECEVIED] [" + clientHandler.getClient(connection).getUsername() + "] " + mes.message);
					clientHandler.circulateMessage(connection, mes);
				}
			}
		}
	};

	private static TimerTask clientListTimerTask = new TimerTask() {

		@Override
		public void run() {
			printClientList();
		}

	};
}
