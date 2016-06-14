package com.turbulence6th.topsektirme;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {

	protected OrthographicCamera camera;
	protected Vector3 mouse;
	protected GameStateManager gsm;
	protected Texture background;
	
	protected State(GameStateManager gsm){
		this.gsm = gsm;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, TopSektirme.WIDTH, TopSektirme.HEIGHT);
		mouse = new Vector3();
		
		background = new Texture("background.jpg");
	}
	
	protected abstract void handleInput();
	public abstract void update(float dt);
	public abstract void render(SpriteBatch sb);
	public abstract void dispose();

}
