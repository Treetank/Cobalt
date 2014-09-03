package org.laser.cobalt.gameobjects;

import java.util.ArrayList;
import java.util.List;

import org.laser.cobalt.CobaltBasics;
import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.DeviceInfo;
import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.gameworld.GameWorld;
import org.laser.cobalt.helpers.types.World;

public class GameLevel {

	protected float length;
	protected boolean loopable;
	protected Terrain terrain1, terrain2, terrain3;
	protected List<Mob> enemies;
	protected List<Exit> exits;
	protected GameWorld gameWorld;
	protected TextureIndex terrainTexture;
	protected LevelIndex levelIndex;

	protected Hero hero;
	protected World world;

	public GameLevel(float length, boolean loopable, GameWorld world, TextureIndex texture) {
		this.length = length;
		this.loopable = loopable;
		this.gameWorld = world;
		this.hero = world.getWorld().getHero();
		this.world = world.getWorld();
		this.terrainTexture = texture;

		terrain1 = new Terrain(0, texture);
		terrain2 = new Terrain(256, texture);
		terrain3 = new Terrain(-256, texture);

		enemies = new ArrayList<Mob>();
		exits = new ArrayList<Exit>();
	}

	public void update(float delta) {
		hero.move(hero.getLocation() + hero.getVelocity());

		if ((hero.getCenterX() < CobaltBasics.LEFT_WALK_LIMIT && hero.getVelocity() < 0)
				|| (hero.getCenterX() > CobaltBasics.RIGHT_WALK_LIMIT && hero.getVelocity() > 0)) {
			world.setLevelPosition(world.getLevelPosition() + hero.getVelocity());
		}

		if (!loopable) {
			if (world.getLevelPosition() < 0) {
				hero.move(hero.getX() + world.getLevelPosition());
				world.setLevelPosition(0);
				if (hero.getX() < 0) {
					hero.move(0);
				}
			}
			if (world.getLevelPosition() > length - DeviceInfo.gameWidth) {
				hero.move(hero.getX() + world.getLevelPosition());
				world.setLevelPosition(length - DeviceInfo.gameWidth);
				if (hero.getX() > DeviceInfo.gameWidth - hero.getWidth()) {
					hero.move(length - hero.getWidth());
				}
			}
		}

		checkCollisions();
		rotateTerrain();

		terrain1.update(world.getLevelPosition());
		terrain2.update(world.getLevelPosition());
		terrain3.update(world.getLevelPosition());

		for (Exit x : exits) {
			x.update(world.getLevelPosition());
		}

		for (Mob m : enemies) {
			m.update(world.getLevelPosition(), delta);
		}

		hero.update(world.getLevelPosition(), delta);

	}

	public void moveLeft() {
		hero.moveLeft();
	}

	public void moveRight() {
		hero.moveRight();
	}

	public void stopMoving() {
		hero.stop();
	}

	public void rotateTerrain() {
		if (terrain1.getX() < -300)
			terrain1.move(terrain3.getLocation() + terrain3.getWidth() - 1);
		if (terrain1.getX() > 300)
			terrain1.move(terrain2.getLocation() - terrain1.getWidth() + 1);
		if (terrain2.getX() < -300)
			terrain2.move(terrain1.getLocation() + terrain1.getWidth() - 1);
		if (terrain2.getX() > 300)
			terrain2.move(terrain3.getLocation() - terrain2.getWidth() + 1);
		if (terrain3.getX() < -300)
			terrain3.move(terrain2.getLocation() + terrain2.getWidth() - 1);
		if (terrain3.getX() > 300)
			terrain3.move(terrain1.getLocation() - terrain3.getWidth() + 1);
	}

	public void checkCollisions() {
		for (Mob m : enemies) {
			if (hero.getLocation() > m.getLocation() - hero.getWidth() && hero.getLocation() <= m.getLocation()) {
				hero.move(m.getLocation() - hero.getWidth());
			} else if (hero.getLocation() > m.getLocation() && hero.getLocation() < m.getLocation() + m.getWidth()) {
				hero.move(m.getLocation() + m.getWidth());
			}
			if (hero.getLocation() > m.getLocation() - hero.getWidth() - hero.getStats().getStatics().SwingRange()
					&& hero.getLocation() < m.getLocation() + m.getWidth() + hero.getStats().getStatics().SwingRange()) {
				hero.swing(m);
			}
			if (hero.getLocation() > m.getLocation() - hero.getWidth() - m.getStats().getStatics().SwingRange()
					&& hero.getLocation() < m.getLocation() + m.getWidth() + m.getStats().getStatics().SwingRange()) {
				m.swing(hero);
			}
		}

		for (Exit x : exits) {
			if (hero.getLocation() > x.getLocation() - hero.getWidth() && hero.getLocation() < x.getLocation() + x.getWidth()) {
				gameWorld.changeLevel(x.GetDestination());
			}
		}
	}

	public Hero getHero() {
		return hero;
	}

	public Drawable getTerrain1() {
		return terrain1;
	}

	public Drawable getTerrain2() {
		return terrain2;
	}

	public Drawable getTerrain3() {
		return terrain3;
	}

	public List<Exit> getExit() {
		return exits;
	}

	public List<Mob> getEnemies() {
		return enemies;
	}

	public void AddMob(Mob mob) {
		enemies.add(mob);
	}

	public void AddExit(Exit exit) {
		exits.add(exit);
	}

	public TextureIndex getTerrainTexture() {
		return terrainTexture;
	}
	
	public LevelIndex getLevelIndex() {
		return levelIndex;
	}
}
