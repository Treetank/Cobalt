package org.laser.cobalt.gameworld;

import static org.laser.cobalt.CobaltBasics.InitialValues.LEVEL_POSITION;
import static org.laser.cobalt.CobaltBasics.StatMetrics.MobStats.HeroStats.INITIAL_POSITION;

import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.gameobjects.levels.GameLevel;
import org.laser.cobalt.helpers.GameSaver;
import org.laser.cobalt.helpers.types.World;

public class GameWorld {

	private CobaltGame game;
	private World data;
	private boolean inside;
	private GameLevel outdoors, indoors;

	public GameWorld(CobaltGame game) {
		this.game = game;
		data = new World();
		inside = false;
	}

	public void respawnHero() {
		data.getHero().getHp().fill();
		data.getHero().stop();
		data.getHero().move(INITIAL_POSITION);
		data.setLevelPosition(LEVEL_POSITION);
	}

	public void update(float delta) {
		data.update(delta);
		getLevel().update(delta);
		if (data.getHero().isDead()) {
			game.HeroHasDied();
		}
	}

	public World getWorldData() {
		return data;
	}

	public void loadNew() {
		data.loadNew();
	}

	public void loadLast() {
		data.load(GameSaver.loadWorld(0));
	}

	public void loadSuper() {
		data.loadSuperHero();
	}

	public void loadLevel() {
		outdoors = GameLevel.LevelCreator(game, data.getLevel());
	}

	public GameLevel getLevel() {
		if (inside)
			return indoors;
		else
			return outdoors;
	}

	public void ChangeLevel(LevelIndex levelIndex) {
		GameLevel tempLevel = GameLevel.LevelCreator(game, levelIndex);
		if (tempLevel.isIndoor()) {
			inside = true;
			indoors = tempLevel;
		} else {
			outdoors = tempLevel;
			data.setLevel(levelIndex);
			data.setLevelPosition(LEVEL_POSITION);
			data.getHero().move(INITIAL_POSITION);
		}
	}

	public void goOutside() {
		inside = false;
	}

	public boolean isInside() {
		return inside;
	}
}
