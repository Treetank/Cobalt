package org.laser.cobalt.networking;

import org.laser.cobalt.networking.packets.Packet;
import org.laser.cobalt.networking.packets.Packet1Connect;

import com.esotericsoftware.kryo.Kryo;

public class KryoConfig {

	public static void RegisterClasses(Kryo kryo) {
		kryo.register(Packet.class);
		kryo.register(Packet1Connect.class);
	}
}
