package org.laser.cobalt;

import static org.laser.cobalt.networking.KryoBasics.ServerConnectionInformation.SERVER_IP;
import static org.laser.cobalt.networking.KryoBasics.ServerConnectionInformation.TCP_PORT;
import static org.laser.cobalt.networking.KryoBasics.ServerConnectionInformation.UDP_PORT;

import java.io.IOException;
import java.util.Scanner;

import org.laser.cobalt.networking.KryoConfig;
import org.laser.cobalt.networking.packets.Packet1Connect;
import org.laser.cobalt.networking.packets.Packet2Message;

import com.esotericsoftware.kryonet.Client;

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
		con.name = "TestClient";
		client = new Client();
		KryoConfig.RegisterClasses(client.getKryo());
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
}
