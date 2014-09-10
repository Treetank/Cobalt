package org.laser.cobalt.helpers.renderers;

import org.laser.cobalt.CobaltBasics;
import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.DeviceInfo;
import org.laser.cobalt.gameobjects.Exit;
import org.laser.cobalt.gameobjects.Hero;
import org.laser.cobalt.gameobjects.Mob;
import org.laser.cobalt.gameworld.GameWorld;
import org.laser.cobalt.helpers.AssetLoader;
import org.laser.cobalt.helpers.types.MobStats;
import org.laser.cobalt.interfaces.IRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameWorldRenderer implements IRenderer {

	private CobaltGame game;

	private GameWorld gameWorld;

	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;
	private SpriteBatch batcher;
	private BitmapFont font;

	public GameWorldRenderer(CobaltGame game) {
		this.game = game;

		this.gameWorld = game.getGameWorld();

		cam = new OrthographicCamera();
		shapeRenderer = new ShapeRenderer();
		batcher = new SpriteBatch();
		font = AssetLoader.font;

		cam.setToOrtho(false, DeviceInfo.gameWidth, DeviceInfo.gameHeight);
		shapeRenderer.setProjectionMatrix(cam.combined);
		batcher.setProjectionMatrix(cam.combined);
		font.setColor(Color.WHITE);
		font.setScale(0.4f, 0.4f);

	}

	public void render(float delta) {
		Hero hero = game.getWorld().getHero();

		TextureRegion tempRegion = null;
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		drawTerrain();

		batcher.begin();
		batcher.enableBlending();

		for (Exit x : game.getLevel().getExit()) {
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
		for (Mob m : game.getLevel().getEnemies()) {
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
		Hero hero = game.getWorld().getHero();

		MobStats stats = gameWorld.getWorld().getHero().getStats();
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(200, 200, 200, 1);
		RoundRectangle(3, 3, DeviceInfo.gameWidth - 3, CobaltBasics.VIEWPORT_LOWER_BOUNDS - 3, 2);
		for (Exit x : game.getLevel().getExit()) {
			if (isNear(x.getX(), x.getWidth(), hero.getX(), hero.getWidth())) {
				DrawEnterButton();
			}
		}
		shapeRenderer.end();
		batcher.begin();
		batcher.enableBlending();
		font.draw(batcher, stats.Hp() + "/" + stats.getStatics().MaxHp(), 10, CobaltBasics.VIEWPORT_LOWER_BOUNDS - 15);
		font.draw(batcher, stats.Exp() + "", 10, CobaltBasics.VIEWPORT_LOWER_BOUNDS - 25);
		for (Exit x : game.getLevel().getExit()) {
			if (isNear(x.getX(), x.getWidth(), hero.getX(), hero.getWidth())) {
				font.draw(batcher, "ENTER", CobaltBasics.GAME_SCREEN_WIDTH - 50, CobaltBasics.GAME_SCREEN_HEIGHT - 10);
			}
		}
		batcher.end();
	}

	public void drawTerrain() {
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
		batcher.draw(tempRegion, game.getLevel().getTerrain1().getX(), game.getLevel().getTerrain1().getY());
		batcher.draw(tempRegion, game.getLevel().getTerrain2().getX(), game.getLevel().getTerrain2().getY());
		batcher.draw(tempRegion, game.getLevel().getTerrain3().getX(), game.getLevel().getTerrain3().getY());

		batcher.end();
	}

	public void RoundRectangle(float x1, float y1, float x2, float y2, float w) {
		shapeRenderer.circle(x1 + w, y1 + w, w);
		shapeRenderer.circle(x1 + w, y2 - w, w);
		shapeRenderer.circle(x2 - w, y1 + w, w);
		shapeRenderer.circle(x2 - w, y2 - w, w);
		shapeRenderer.rect(x1 + w, y1, x2 - x1 - 2 * w, w);
		shapeRenderer.rect(x1, y1 + w, w, y2 - y1 - 2 * w);
		shapeRenderer.rect(x1 + w, y2 - w, x2 - x1 - 2 * w, w);
		shapeRenderer.rect(x2 - w, y1 + w, w, y2 - y1 - 2 * w);
		shapeRenderer.setColor(0, 0, 0, 1);
		shapeRenderer.circle(x1 + 2 * w, y1 + 2 * w, w);
		shapeRenderer.circle(x1 + 2 * w, y2 - 2 * w, w);
		shapeRenderer.circle(x2 - 2 * w, y1 + 2 * w, w);
		shapeRenderer.circle(x2 - 2 * w, y2 - 2 * w, w);
	}

	public void DrawEnterButton() {
		shapeRenderer.setColor(200, 200, 200, 1);
		RoundRectangle(CobaltBasics.GAME_SCREEN_WIDTH - 64, CobaltBasics.GAME_SCREEN_HEIGHT - 32, CobaltBasics.GAME_SCREEN_WIDTH,
				CobaltBasics.GAME_SCREEN_HEIGHT, 2);
		shapeRenderer.rect(CobaltBasics.GAME_SCREEN_WIDTH - 62, CobaltBasics.GAME_SCREEN_HEIGHT - 30, 60, 28);
	}

	public boolean isNear(float x1, float width1, float x2, float width2) {
		if (x1 > x2 - width1 && x1 < x2 + width2) {
			return true;
		}
		return false;
	}
}
