package org.laser.cobalt.gameobjects.factories;

import org.laser.cobalt.CobaltBasics.EnemyIndex;
import org.laser.cobalt.gameobjects.Mob;
import org.laser.cobalt.gameobjects.enemies.Creeper;
import org.laser.cobalt.gameobjects.enemies.Imp;
import org.laser.cobalt.gameobjects.enemies.Slime;

public class MobFactory {

	public static Mob MobCreator(EnemyIndex enemy, float position) {
		Mob retVal = null;
		switch (enemy) {
		case SLIME:
			retVal = new Slime(position);
			break;
		case IMP:
			retVal = new Imp(position);
			break;
		case CREEPER:
			retVal = new Creeper(position);
			break;
		default:
			break;
		}
		return retVal;
	}
}
