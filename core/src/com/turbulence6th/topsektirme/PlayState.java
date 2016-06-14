package com.turbulence6th.topsektirme;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class PlayState extends State {

	Ball ball;
	Bar bar;
	BitmapFont scoreText;

	protected PlayState(GameStateManager gsm) {
		super(gsm);

		ball = new Ball();
		bar = new Bar();
		scoreText = new BitmapFont(Gdx.files.internal("font.fnt"));
		scoreText.setColor(Color.BLACK);
	}

	@Override
	protected void handleInput() {
		if (Gdx.input.isTouched()) {
			Vector3 touchPosition = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPosition);
			bar.update((int) touchPosition.x);
		}
	}

	@Override
	public void update(float dt) {
		handleInput();
		ball.update(dt, bar, gsm);
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		sb.draw(background, 0, 0, TopSektirme.WIDTH, TopSektirme.HEIGHT);
		sb.draw(ball.getImage(), ball.getPosition().x, ball.getPosition().y);
		sb.draw(bar.getImage(), bar.getPosition().x, bar.getPosition().y);
		scoreText.draw(sb, Integer.toString(ball.getScore()), TopSektirme.WIDTH * 3 / 4, TopSektirme.HEIGHT * 9 / 10);
		sb.end();
	}

	@Override
	public void dispose() {
		ball.dispose();
		bar.dispose();
	}

}
