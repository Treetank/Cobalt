package org.laser.cobalt.gameobjects.factories;

import org.laser.cobalt.CobaltBasics.LevelIndex;
import org.laser.cobalt.CobaltGame;
import org.laser.cobalt.gameobjects.levels.FirstLevel;
import org.laser.cobalt.gameobjects.levels.GameLevel;
import org.laser.cobalt.gameobjects.levels.Hospital;
import org.laser.cobalt.gameobjects.levels.SecondLevel;
import org.laser.cobalt.gameobjects.levels.ThirdLevel;

public class LevelFactory {

	public static GameLevel LevelCreator(CobaltGame game, LevelIndex li) {
		GameLevel retVal;
		switch (li) {
		case CREEPER_PATH:
			retVal = new ThirdLevel(game);
			break;
		case HOSPITAL:
			retVal = new Hospital(game);
			break;
		case IMP_PATH:
			retVal = new SecondLevel(game);
			break;
		case STARTING_PATH:
			retVal = new FirstLevel(game);
			break;
		default:
			retVal = new FirstLevel(game);
			break;
		}
		return retVal;
	}
}
