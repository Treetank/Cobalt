package org.laser.cobalt.helpers;

import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.gameobjects.Hero;
import org.laser.cobalt.helpers.types.CombatStats;
import org.laser.cobalt.helpers.types.MobStats;
import org.laser.cobalt.helpers.types.StaticMobStats;
import org.laser.cobalt.helpers.types.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

public class GameSaver {

	public static class JsonWorld {
		public float heroSwingSpeed, heroMoveSpeed;
		public int heroHp, heroDamage, heroExp, heroMaxHp, heroLevel, heroSwingRange;
		public int heroStr, heroAgi, heroInt, heroSta, heroVit;
		public int gold, redGems, blueGems, diamonds;
		public float heroX, levelPosition;
		public LevelIndex levelIndex;
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
		jWorld.heroStr = world.getHero().getStats().getBaseStrength();
		jWorld.heroAgi = world.getHero().getStats().getBaseAgility();
		jWorld.heroInt = world.getHero().getStats().getBaseIntellect();
		jWorld.heroSta = world.getHero().getStats().getBaseStamina();
		jWorld.heroVit = world.getHero().getStats().getBaseVitality();

		jWorld.heroX = world.getHero().getX() + world.getLevelPosition();

		jWorld.levelPosition = world.getLevelPosition();

		jWorld.levelIndex = world.getLevel();

		jWorld.gold = world.getHero().getInventory().getGold();
		jWorld.redGems = world.getHero().getInventory().getRedGems();
		jWorld.blueGems = world.getHero().getInventory().getBlueGems();
		jWorld.diamonds = world.getHero().getInventory().getDiamonds();

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
					jWorld.heroMoveSpeed, jWorld.heroSwingRange), jWorld.heroHp, jWorld.heroDamage, jWorld.heroExp, new CombatStats(jWorld.heroStr,
					jWorld.heroAgi, jWorld.heroInt, jWorld.heroSta, jWorld.heroVit))));

			world.setLevelPosition(jWorld.levelPosition);

			world.setLevel(jWorld.levelIndex);

			world.getHero().getInventory().addCurrency(jWorld.gold, jWorld.redGems, jWorld.blueGems, jWorld.diamonds);
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
