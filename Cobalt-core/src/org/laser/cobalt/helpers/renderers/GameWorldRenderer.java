package org.laser.cobalt.helpers.renderers;

import org.laser.cobalt.CobaltBasics;
import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.DeviceInfo;
import org.laser.cobalt.gameobjects.Exit;
import org.laser.cobalt.gameobjects.Hero;
import org.laser.cobalt.gameobjects.Mob;
import org.laser.cobalt.gameobjects.levels.OutdoorGameLevel;
import org.laser.cobalt.helpers.AssetLoader;
import org.laser.cobalt.helpers.types.MobStats;
import org.laser.cobalt.interfaces.IRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameWorldRenderer extends CobaltRenderer implements IRenderer {

	public GameWorldRenderer(CobaltGame game) {
		super(game);
	}

	public void render(float delta) {
		OutdoorGameLevel level = (OutdoorGameLevel) game.getLevel();
		Hero hero = game.getWorld().getHero();

		TextureRegion tempRegion = null;
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		drawTerrain();

		batcher.begin();
		batcher.enableBlending();

		for (Exit x : level.getExit()) {
			switch (x.getTexture()) {
			case SIGN:
				tempRegion = AssetLoader.sign;
				break;
			case HOUSE:
				tempRegion = AssetLoader.house;
				break;
			default:
				tempRegion = AssetLoader.sign;
				break;
			}
			batcher.draw(tempRegion, x.getX(), x.getY());
		}
		switch (hero.getTexture()) {
		case HERO:
			tempRegion = AssetLoader.hero;
			break;
		case HERO_ATTACKING:
			tempRegion = AssetLoader.heroAttack;
			break;
		default:
			tempRegion = AssetLoader.hero;
			break;
		}
		batcher.draw(tempRegion, hero.getX(), hero.getY());
		if (hero.takingDamage()) {
			switch (hero.takingDamageImage()) {
			case EXPLOSION:
				tempRegion = AssetLoader.explosion;
				break;
			case SCRATCH:
				tempRegion = AssetLoader.scratch;
				break;
			default:
				tempRegion = AssetLoader.explosion;
				break;
			}
			batcher.draw(tempRegion, hero.getX(), hero.getY());
		}
		for (Mob m : level.getEnemies()) {
			switch (m.getTexture()) {
			case SLIME:
				tempRegion = AssetLoader.slime;
				break;
			case IMP:
				tempRegion = AssetLoader.imp;
				break;
			case CREEPER:
				tempRegion = AssetLoader.creeper;
				break;
			default:
				tempRegion = AssetLoader.slime;
				break;
			}
			batcher.draw(tempRegion, m.getX(), m.getY());
			if (m.takingDamage()) {
				switch (m.takingDamageImage()) {
				case EXPLOSION:
					tempRegion = AssetLoader.explosion;
					break;
				case SCRATCH:
					tempRegion = AssetLoader.scratch;
					break;
				default:
					tempRegion = AssetLoader.explosion;
					break;
				}
				batcher.draw(tempRegion, m.getX(), m.getY());
			}
		}
		batcher.end();
		drawUI();
	}

	public void drawUI() {
		OutdoorGameLevel level = (OutdoorGameLevel) game.getLevel();

		Hero hero = game.getWorld().getHero();

		MobStats stats = gameWorld.getWorld().getHero().getStats();
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(200, 200, 200, 1);
		RoundRectangle(3, 3, DeviceInfo.gameWidth - 3, CobaltBasics.VIEWPORT_LOWER_BOUNDS - 3, 2);
		for (Exit x : level.getExit()) {
			if (isNear(x.getX(), x.getWidth(), hero.getX(), hero.getWidth())) {
				DrawEnterButton();
			}
		}
		shapeRenderer.end();
		batcher.begin();
		batcher.enableBlending();
		font.draw(batcher, stats.Hp() + "/" + stats.getStatics().MaxHp(), 10, CobaltBasics.VIEWPORT_LOWER_BOUNDS - 15);
		font.draw(batcher, stats.Exp() + "", 10, CobaltBasics.VIEWPORT_LOWER_BOUNDS - 25);
		for (Exit x : level.getExit()) {
			if (isNear(x.getX(), x.getWidth(), hero.getX(), hero.getWidth())) {
				font.draw(batcher, "ENTER", CobaltBasics.GAME_SCREEN_WIDTH - 50, CobaltBasics.GAME_SCREEN_HEIGHT - 10);
			}
		}
		batcher.end();
	}

	public void drawTerrain() {
		OutdoorGameLevel level = (OutdoorGameLevel) game.getLevel();
		TextureRegion tempRegion = null;

		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(Color.BLUE);
		shapeRenderer.rect(0, CobaltBasics.VIEWPORT_LOWER_BOUNDS + CobaltBasics.TERRAIN_HEIGHT, DeviceInfo.gameWidth, DeviceInfo.gameHeight
				- CobaltBasics.TERRAIN_HEIGHT - CobaltBasics.VIEWPORT_LOWER_BOUNDS);
		shapeRenderer.setColor(34, 177, 76, 1);
		shapeRenderer.rect(0, CobaltBasics.VIEWPORT_LOWER_BOUNDS, DeviceInfo.gameWidth, CobaltBasics.TERRAIN_HEIGHT);
		shapeRenderer.end();

		batcher.begin();
		batcher.disableBlending();
		switch (game.getLevel().getTerrainTexture()) {
		case GRASS:
			tempRegion = AssetLoader.grass;
			break;
		case ICE:
			tempRegion = AssetLoader.ice;
			break;
		default:
			tempRegion = AssetLoader.grass;
			break;

		}
		batcher.draw(tempRegion, level.getTerrain1().getX(), level.getTerrain1().getY());
		batcher.draw(tempRegion, level.getTerrain2().getX(), level.getTerrain2().getY());
		batcher.draw(tempRegion, level.getTerrain3().getX(), level.getTerrain3().getY());

		batcher.end();
	}

	public void DrawEnterButton() {
		shapeRenderer.setColor(200, 200, 200, 1);
		RoundRectangle(CobaltBasics.GAME_SCREEN_WIDTH - 64, CobaltBasics.GAME_SCREEN_HEIGHT - 32, CobaltBasics.GAME_SCREEN_WIDTH,
				CobaltBasics.GAME_SCREEN_HEIGHT, 2);
		shapeRenderer.rect(CobaltBasics.GAME_SCREEN_WIDTH - 62, CobaltBasics.GAME_SCREEN_HEIGHT - 30, 60, 28);
	}
}
