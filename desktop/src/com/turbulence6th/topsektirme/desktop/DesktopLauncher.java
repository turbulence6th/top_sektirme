package com.turbulence6th.topsektirme.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.turbulence6th.topsektirme.TopSektirme;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = TopSektirme.WIDTH;
		config.height = TopSektirme.HEIGHT;
		config.title = TopSektirme.TITLE;
		
		new LwjglApplication(new TopSektirme(), config);
	}
}
