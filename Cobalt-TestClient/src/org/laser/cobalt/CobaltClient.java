package org.laser.cobalt;

import static org.laser.cobalt.networking.KryoBasics.ServerConnectionInformation.SERVER_IP;
import static org.laser.cobalt.networking.KryoBasics.ServerConnectionInformation.TCP_PORT;
import static org.laser.cobalt.networking.KryoBasics.ServerConnectionInformation.UDP_PORT;

import java.io.IOException;

import org.laser.cobalt.networking.KryoConfig;
import org.laser.cobalt.networking.packets.Packet1Connect;

import com.esotericsoftware.kryonet.Client;

public class CobaltClient {

	public static void main(String args[]) {

		new CobaltClient();
	}

	public CobaltClient() {
		Packet1Connect con = new Packet1Connect();
		con.name = "TestClient";
		System.out.println("Cobalt Client");
		Client client = new Client();
		KryoConfig.RegisterClasses(client.getKryo());
		client.start();
		try {
			client.connect(5000, SERVER_IP, TCP_PORT, UDP_PORT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		client.sendTCP(con);
		client.stop();
		System.out.println("Client stopped");
	}
}
