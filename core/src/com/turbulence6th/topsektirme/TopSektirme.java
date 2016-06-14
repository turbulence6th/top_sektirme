package com.turbulence6th.topsektirme;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TopSektirme extends ApplicationAdapter {
	public static final int WIDTH = 400;
	public static final int HEIGHT = 600;
	public static final String TITLE = "Top Sektirme";
	
	GameStateManager gsm;
	SpriteBatch sb;
	
	@Override
	public void create () {
		gsm = new GameStateManager();
		gsm.push(new MenuState(gsm));
		sb = new SpriteBatch();
		
		Gdx.gl.glClearColor(1, 0, 1, 1);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(sb);
	}
}
