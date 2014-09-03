package org.laser.cobalt.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import org.laser.cobalt.CobaltBasics;
import org.laser.cobalt.CobaltGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = CobaltBasics.WINDOW_TITLE;
		config.width = CobaltBasics.DESKTOP_VIEWPORT_WIDTH;
		config.height= CobaltBasics.DESKTOP_VIEWPORT_HEIGHT;
		new LwjglApplication(new CobaltGame(), config);
	}
}
