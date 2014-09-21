package org.laser.cobalt.helpers;

import org.laser.cobalt.helpers.types.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

public class GameSaver {

	public static class JsonWorld {
		public String worldJson;
	}

	public static void saveWorld(World world) {
		JsonWorld jWorld = new JsonWorld();

		jWorld.worldJson = world.save();

		Json json = new Json();
		writeFile("game.sav", json.toJson(jWorld));
	}

	public static World loadWorld() {
		String save = readFile("game.sav");
		World world = new World();
		if (!save.isEmpty()) {
			Json json = new Json();
			JsonWorld jWorld = json.fromJson(JsonWorld.class, save);

			world.load(jWorld.worldJson);
		}
		return world;
	}

	public static void writeFile(String fileName, String s) {
		FileHandle file = Gdx.files.local(fileName);
		file.writeString(com.badlogic.gdx.utils.Base64Coder.encodeString(s), false);
	}

	public static String readFile(String fileName) {
		FileHandle file = Gdx.files.local(fileName);
		if (file != null && file.exists()) {
			String s = file.readString();
			if (!s.isEmpty()) {
				return com.badlogic.gdx.utils.Base64Coder.decodeString(s);
			}
		}
		return "";
	}
}
