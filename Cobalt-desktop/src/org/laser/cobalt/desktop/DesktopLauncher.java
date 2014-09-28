package org.laser.cobalt.desktop;

import static org.laser.cobalt.CobaltBasics.DesktopWindowMetrics.VIEWPORT_HEIGHT;
import static org.laser.cobalt.CobaltBasics.DesktopWindowMetrics.VIEWPORT_WIDTH;
import static org.laser.cobalt.CobaltBasics.DesktopWindowMetrics.WINDOW_TITLE;

import org.laser.cobalt.CobaltGame;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = WINDOW_TITLE;
		config.width = VIEWPORT_WIDTH;
		config.height = VIEWPORT_HEIGHT;
		new LwjglApplication(new CobaltGame(), config);
	}
}
