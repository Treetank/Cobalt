package org.laser.cobalt.helpers;

import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.gameobjects.Hero;
import org.laser.cobalt.helpers.types.MobStats;
import org.laser.cobalt.helpers.types.StaticMobStats;
import org.laser.cobalt.helpers.types.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

public class GameSaver {

	public static class JsonWorld {
		public float heroHp, heroDamage, heroExp, heroMaxHp, heroLevel, heroSwingSpeed, heroMoveSpeed, heroSwingRange;
		public float heroX, levelIndex, levelPosition;
	}

	public static void saveWorld(World world) {
		JsonWorld jWorld = new JsonWorld();

		jWorld.heroHp = world.getHero().getStats().Hp();
		jWorld.heroDamage = world.getHero().getStats().Damage();
		jWorld.heroExp = world.getHero().getStats().Exp();
		jWorld.heroMaxHp = world.getHero().getStats().getStatics().MaxHp();
		jWorld.heroLevel = world.getHero().getStats().getStatics().Level();
		jWorld.heroSwingSpeed = world.getHero().getStats().getStatics().SwingSpeed();
		jWorld.heroMoveSpeed = world.getHero().getStats().getStatics().MoveSpeed();
		jWorld.heroSwingRange = world.getHero().getStats().getStatics().SwingRange();

		jWorld.heroX = world.getHero().getX() + world.getLevelPosition();

		jWorld.levelPosition = world.getLevelPosition();

		switch (world.getLevel()) {
		case STARTING_PATH:
			jWorld.levelIndex = 1;
			break;
		case IMP_PATH:
			jWorld.levelIndex = 2;
			break;
		default:
			jWorld.levelIndex = 1;
			break;
		}

		Json json = new Json();
		writeFile("game.sav", json.toJson(jWorld));
	}

	public static World loadWorld() {
		String save = readFile("game.sav");
		World world = new World();
		if (!save.isEmpty()) {
			Json json = new Json();
			JsonWorld jWorld = json.fromJson(JsonWorld.class, save);

			world.loadHero(new Hero(jWorld.heroX, new MobStats(new StaticMobStats(jWorld.heroMaxHp, jWorld.heroLevel, jWorld.heroSwingSpeed,
					jWorld.heroMoveSpeed, jWorld.heroSwingRange), jWorld.heroHp, jWorld.heroDamage, jWorld.heroExp)));

			world.setLevelPosition(jWorld.levelPosition);

			switch ((int) jWorld.levelIndex) {
			case 1:
				world.setLevel(LevelIndex.STARTING_PATH);
				break;
			case 2:
				world.setLevel(LevelIndex.IMP_PATH);
				break;
			default:
				world.setLevel(LevelIndex.STARTING_PATH);
				break;
			}
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
