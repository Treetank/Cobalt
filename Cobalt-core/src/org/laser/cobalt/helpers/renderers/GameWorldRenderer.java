package org.laser.cobalt.helpers.renderers;

import static org.laser.cobalt.CobaltBasics.GameWindowMetrics.BOTTOM_BUTTON_PADDING;
import static org.laser.cobalt.CobaltBasics.GameWindowMetrics.BOTTOM_BUTTON_SQUARE_SIZE;
import static org.laser.cobalt.CobaltBasics.GameWindowMetrics.SCREEN_HEIGHT;
import static org.laser.cobalt.CobaltBasics.GameWindowMetrics.SCREEN_WIDTH;
import static org.laser.cobalt.CobaltBasics.GameWindowMetrics.VIEWPORT_LOWER_BOUNDS;
import static org.laser.cobalt.CobaltBasics.ImageMetrics.TERRAIN_HEIGHT;

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

	TextureRegion tempRegion = null;

	public GameWorldRenderer(CobaltGame game) {
		super(game);
	}

	public void render(float delta) {
		OutdoorGameLevel level = (OutdoorGameLevel) game.getLevel();
		Hero hero = game.getWorld().getHero();

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		drawTerrain();

		drawLandmarks(level);

		drawMobs(level);

		drawHero(hero);

		drawUI();
	}

	public void drawHero(Hero hero) {
		batcher.begin();
		batcher.enableBlending();
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
		drawDamageEffect(hero);
		batcher.end();
	}

	public void drawMobs(OutdoorGameLevel level) {
		batcher.begin();
		batcher.enableBlending();
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
			drawDamageEffect(m);
		}
		batcher.end();
	}

	public void drawDamageEffect(Mob m) {
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

	public void drawLandmarks(OutdoorGameLevel level) {
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
		batcher.end();
	}

	public void drawUI() {
		OutdoorGameLevel level = (OutdoorGameLevel) game.getLevel();

		Hero hero = game.getWorld().getHero();

		MobStats stats = gameWorld.getWorld().getHero().getStats();
		shapeRenderer.begin(ShapeType.Filled);
		RoundRectangle(3, BOTTOM_BUTTON_SQUARE_SIZE + 6, DeviceInfo.gameWidth - 3, VIEWPORT_LOWER_BOUNDS - 3, 2);
		for (Exit x : level.getExit()) {
			if (isNear(x.getX(), x.getWidth(), hero.getX(), hero.getWidth())) {
				DrawEnterButton();
			}
		}
		shapeRenderer.end();
		batcher.begin();
		batcher.enableBlending();
		font.draw(batcher, stats.Hp() + "/" + stats.getStatics().MaxHp(), 10, VIEWPORT_LOWER_BOUNDS - 15);
		font.draw(batcher, stats.Exp() + "", 10, VIEWPORT_LOWER_BOUNDS - 25);
		font.draw(batcher, "STRENGTH  " + stats.getStrength() + "  " + stats.getBaseStrength() + "/" + stats.getBonusStrength(), 10, VIEWPORT_LOWER_BOUNDS - 35);
		font.draw(batcher, "AGILITY   " + stats.getAgility() + "  " + stats.getBaseAgility() + "/" + stats.getBonusAgility(), 10, VIEWPORT_LOWER_BOUNDS - 45);
		font.draw(batcher, "INTELLECT " + stats.getIntellect() + "  " + stats.getBaseIntellect() + "/" + stats.getBonusIntellect(), 10,
				VIEWPORT_LOWER_BOUNDS - 55);
		font.draw(batcher, "STAMINA   " + stats.getStamina() + "  " + stats.getBaseStamina() + "/" + stats.getBonusStamina(), 10, VIEWPORT_LOWER_BOUNDS - 65);
		font.draw(batcher, "VITALITY  " + stats.getVitality() + "  " + stats.getBaseVitality() + "/" + stats.getBonusVitality(), 10, VIEWPORT_LOWER_BOUNDS - 75);
		font.draw(batcher, "GOLD " + hero.getInventory().getGold(), 10, VIEWPORT_LOWER_BOUNDS - 85);
		font.draw(batcher, "RED GEMS " + hero.getInventory().getRedGems(), 10, VIEWPORT_LOWER_BOUNDS - 95);
		font.draw(batcher, "BLUE GEMS " + hero.getInventory().getBlueGems(), 10, VIEWPORT_LOWER_BOUNDS - 105);
		font.draw(batcher, "DIAMONDS " + hero.getInventory().getDiamonds(), 10, VIEWPORT_LOWER_BOUNDS - 115);
		for (Exit x : level.getExit()) {
			if (isNear(x.getX(), x.getWidth(), hero.getX(), hero.getWidth())) {
				font.draw(batcher, "ENTER", SCREEN_WIDTH - 50, SCREEN_HEIGHT - 10);
			}
		}
		batcher.end();
		drawBottomButtons();
	}

	public void drawBottomButtons() {
		shapeRenderer.begin(ShapeType.Filled);
		RoundRectangle(BOTTOM_BUTTON_PADDING, 3, BOTTOM_BUTTON_PADDING + BOTTOM_BUTTON_SQUARE_SIZE, BOTTOM_BUTTON_SQUARE_SIZE + 3, 2);
		RoundRectangle(BOTTOM_BUTTON_PADDING * 3 + BOTTOM_BUTTON_SQUARE_SIZE, 3, BOTTOM_BUTTON_PADDING * 3 + BOTTOM_BUTTON_SQUARE_SIZE * 2,
				BOTTOM_BUTTON_SQUARE_SIZE + 3, 2);
		RoundRectangle(BOTTOM_BUTTON_PADDING * 5 + BOTTOM_BUTTON_SQUARE_SIZE * 2, 3, BOTTOM_BUTTON_PADDING * 5 + BOTTOM_BUTTON_SQUARE_SIZE * 3,
				BOTTOM_BUTTON_SQUARE_SIZE + 3, 2);
		RoundRectangle(BOTTOM_BUTTON_PADDING * 7 + BOTTOM_BUTTON_SQUARE_SIZE * 3, 3, BOTTOM_BUTTON_PADDING * 7 + BOTTOM_BUTTON_SQUARE_SIZE * 4,
				BOTTOM_BUTTON_SQUARE_SIZE + 3, 2);
		shapeRenderer.end();
	}

	public void drawTerrain() {
		OutdoorGameLevel level = (OutdoorGameLevel) game.getLevel();
		TextureRegion tempRegion = null;

		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(Color.BLUE);
		shapeRenderer.rect(0, VIEWPORT_LOWER_BOUNDS + TERRAIN_HEIGHT, DeviceInfo.gameWidth, DeviceInfo.gameHeight - TERRAIN_HEIGHT - VIEWPORT_LOWER_BOUNDS);
		shapeRenderer.setColor(34, 177, 76, 1);
		shapeRenderer.rect(0, VIEWPORT_LOWER_BOUNDS, DeviceInfo.gameWidth, TERRAIN_HEIGHT);
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
		RoundRectangle(SCREEN_WIDTH - 64, SCREEN_HEIGHT - 32, SCREEN_WIDTH, SCREEN_HEIGHT, 2);
		shapeRenderer.rect(SCREEN_WIDTH - 62, SCREEN_HEIGHT - 30, 60, 28);
	}
}
