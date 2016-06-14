package com.turbulence6th.topsektirme;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EndState extends State {

	Texture gameover;
	Texture retry;

	public EndState(GameStateManager gsm) {
		super(gsm);

		gameover = new Texture("gameover.png");
		retry = new Texture("retry.png");
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
		sb.draw(gameover, TopSektirme.WIDTH / 2 - gameover.getWidth() / 2,
				TopSektirme.HEIGHT / 2 - gameover.getHeight() / 2);
		sb.draw(retry, TopSektirme.WIDTH / 2 - retry.getWidth() / 2, TopSektirme.HEIGHT / 2 - gameover.getHeight() / 2 - retry.getHeight());
		sb.end();
	}

	@Override
	public void dispose() {
		gameover.dispose();
		retry.dispose();
	}

}
