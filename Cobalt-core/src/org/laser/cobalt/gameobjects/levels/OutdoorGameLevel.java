package org.laser.cobalt.gameobjects.levels;

import static org.laser.cobalt.CobaltBasics.GameWindowMetrics.LEFT_WALK_LIMIT;
import static org.laser.cobalt.CobaltBasics.GameWindowMetrics.RIGHT_WALK_LIMIT;
import static org.laser.cobalt.CobaltBasics.ImageMetrics.TERRAIN_WIDTH;

import java.util.ArrayList;
import java.util.List;

import org.laser.cobalt.CobaltBasics.TextureIndex;
import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.DeviceInfo;
import org.laser.cobalt.gameobjects.Drawable;
import org.laser.cobalt.gameobjects.Exit;
import org.laser.cobalt.gameobjects.Hero;
import org.laser.cobalt.gameobjects.Mob;
import org.laser.cobalt.gameobjects.Terrain;
import org.laser.cobalt.helpers.types.World;

public class OutdoorGameLevel extends GameLevel {

	protected float length;
	protected boolean loopable;
	protected Terrain terrain1, terrain2, terrain3;
	protected List<Mob> enemies;
	protected List<Exit> exits;

	public OutdoorGameLevel(float length, boolean loopable, CobaltGame game, TextureIndex texture) {
		super(game, texture);
		this.length = length;
		this.loopable = loopable;
		terrain1 = new Terrain(0, texture);
		terrain2 = new Terrain(256, texture);
		terrain3 = new Terrain(-256, texture);

		enemies = new ArrayList<Mob>();
		exits = new ArrayList<Exit>();
	}

	@Override
	public void update(float delta) {
		World world = game.getGameWorld().getWorldData();
		Hero hero = world.getHero();
		hero.move(hero.getLocation() + hero.getVelocity());

		if ((hero.getCenterX() < LEFT_WALK_LIMIT && hero.getVelocity() < 0) || (hero.getCenterX() > RIGHT_WALK_LIMIT && hero.getVelocity() > 0)) {
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
		game.getGameWorld().getWorldData().getHero().moveLeft();
	}

	public void moveRight() {
		game.getGameWorld().getWorldData().getHero().moveRight();
	}

	public void clickEnter() {
		Hero hero = game.getGameWorld().getWorldData().getHero();
		Exit exitToFollow = null;
		for (Exit x : exits) {
			if (hero.getLocation() > x.getLocation() - hero.getWidth() && hero.getLocation() < x.getLocation() + x.getWidth()) {
				exitToFollow = x;
			}
		}
		if (exitToFollow != null) {
			game.ChangeLevel(exitToFollow.GetDestination());
		}
	}

	public void stopMoving() {
		game.getGameWorld().getWorldData().getHero().stop();
	}

	public void rotateTerrain() {
		if (terrain1.getX() < -TERRAIN_WIDTH - 5)
			terrain1.move(terrain3.getLocation() + terrain3.getWidth() - 1);
		if (terrain1.getX() > TERRAIN_WIDTH * 2 + 5)
			terrain1.move(terrain2.getLocation() - terrain1.getWidth() + 1);
		if (terrain2.getX() < -TERRAIN_WIDTH - 5)
			terrain2.move(terrain1.getLocation() + terrain1.getWidth() - 1);
		if (terrain2.getX() > TERRAIN_WIDTH * 2 + 5)
			terrain2.move(terrain3.getLocation() - terrain2.getWidth() + 1);
		if (terrain3.getX() < -TERRAIN_WIDTH - 5)
			terrain3.move(terrain2.getLocation() + terrain2.getWidth() - 1);
		if (terrain3.getX() > TERRAIN_WIDTH * 2 + 5)
			terrain3.move(terrain1.getLocation() - terrain3.getWidth() + 1);
	}

	public void checkCollisions() {
		Hero hero = game.getGameWorld().getWorldData().getHero();
		for (Mob m : enemies) {
			if (hero.getLocation() > m.getLocation() - hero.getWidth() && hero.getLocation() <= m.getLocation()) {
				hero.move(m.getLocation() - hero.getWidth());
			} else if (hero.getLocation() > m.getLocation() && hero.getLocation() < m.getLocation() + m.getWidth()) {
				hero.move(m.getLocation() + m.getWidth());
			}
			if (hero.getLocation() > m.getLocation() - hero.getWidth() - hero.getWeapon().getRange()
					&& hero.getLocation() < m.getLocation() + m.getWidth() + hero.getWeapon().getRange()) {
				hero.swing(m);
			}
			if (hero.getLocation() > m.getLocation() - hero.getWidth() - m.getWeapon().getRange()
					&& hero.getLocation() < m.getLocation() + m.getWidth() + m.getWeapon().getRange()) {
				m.swing(hero);
			}
		}
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

	@Override
	public boolean isIndoor() {
		return false;
	}

}
