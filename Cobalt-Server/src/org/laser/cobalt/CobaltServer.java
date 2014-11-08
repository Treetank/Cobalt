package org.laser.cobalt;

import static org.laser.cobalt.networking.KryoBasics.ServerConnectionInformation.TCP_PORT;
import static org.laser.cobalt.networking.KryoBasics.ServerConnectionInformation.UDP_PORT;

import java.io.IOException;

import org.laser.cobalt.networking.KryoConfig;
import org.laser.cobalt.networking.packets.Packet;
import org.laser.cobalt.networking.packets.Packet1Connect;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

public class CobaltServer {

	public static void main(String[] args) {
		System.out.println("Cobalt Server");
		Server server = new Server();
		KryoConfig.RegisterClasses(server.getKryo());
		server.start();
		try {
			server.bind(TCP_PORT, UDP_PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		server.addListener(new Listener() {
			public void received(Connection connection, Object object) {
				if (object instanceof Packet) {
					if (object instanceof Packet1Connect) {
						Packet1Connect con = (Packet1Connect) object;
						System.out.println("new connection " + con.name);
					}
				}
			}
		});
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		server.stop();
		System.out.println("Stopped");
	}

}
