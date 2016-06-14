package com.turbulence6th.topsektirme;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuState extends State {

	Texture playButton;

	public MenuState(GameStateManager gsm) {
		super(gsm);
		playButton = new Texture("play.png");
	}

	@Override
	protected void handleInput() {
		if(Gdx.input.justTouched()){
			gsm.set(new PlayState(gsm));
		}
	}

	@Override
	public void update(float dt) {
		handleInput();
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		sb.draw(background, 0, 0, TopSektirme.WIDTH, TopSektirme.HEIGHT);
		sb.draw(playButton, TopSektirme.WIDTH / 2 - playButton.getWidth() / 2,
				TopSektirme.HEIGHT / 2 - playButton.getHeight() / 2);
		sb.end();
	}

	@Override
	public void dispose() {
		background.dispose();
		playButton.dispose();
	}

}
