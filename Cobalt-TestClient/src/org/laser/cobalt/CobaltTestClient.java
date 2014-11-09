package org.laser.cobalt;

import static org.laser.cobalt.networking.KryoBasics.ServerConnectionInformation.SERVER_IP;
import static org.laser.cobalt.networking.KryoBasics.ServerConnectionInformation.TCP_PORT;
import static org.laser.cobalt.networking.KryoBasics.ServerConnectionInformation.UDP_PORT;

import java.io.IOException;
import java.util.Scanner;

import org.laser.cobalt.networking.KryoConfig;
import org.laser.cobalt.networking.packets.Packet;
import org.laser.cobalt.networking.packets.Packet1Connect;
import org.laser.cobalt.networking.packets.Packet2Message;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class CobaltTestClient {

	private String message;
	Client client;
	Packet1Connect con;
	Packet2Message messagePacket;
	Scanner scanner;

	public static void main(String args[]) {

		new CobaltTestClient();
	}

	public CobaltTestClient() {
		System.out.println("Cobalt Client");
		message = "";
		scanner = new Scanner(System.in);
		con = new Packet1Connect();
		con.id = "TestClient 2";
		client = new Client();
		KryoConfig.RegisterClasses(client.getKryo());
		client.addListener(clientListener);
		client.start();
		try {
			client.connect(5000, SERVER_IP, TCP_PORT, UDP_PORT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		client.sendTCP(con);
		while (!message.equals("quit")) {
			System.out.println("message? :");
			message = scanner.nextLine();
			messagePacket = new Packet2Message();
			messagePacket.message = message;
			client.sendTCP(messagePacket);
		}
		client.stop();
		System.out.println("Client stopped");
	}

	private static Listener clientListener = new Listener() {
		public void received(Connection connection, Object object) {
			if (object instanceof Packet) {
				if (object instanceof Packet2Message) {
					Packet2Message mes = (Packet2Message) object;
					System.out.println("[RECEVIED] " + mes.message);
				}
			}
		}
	};
}
