package com.turbulence6th.topsektirme;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Ball {

	public static final int GRAVITY = -15;

	private Texture image;
	private Vector3 position;
	private Vector3 velocity;
	
	private int score;

	public Ball() {
		image = new Texture("ball.png");
		position = new Vector3(TopSektirme.WIDTH * 3 / 4 - image.getWidth() / 2,
				TopSektirme.HEIGHT * 3 / 4 - image.getWidth() / 2, 0);
		velocity = new Vector3(0, 0, 0);
		score = 0;
	}

	public void update(float dt, Bar bar, GameStateManager gsm) {
		velocity.add(0, GRAVITY, 0);
		velocity.scl(dt);
		position.add(velocity.x, velocity.y, 0);
		velocity.scl(1 / dt);

		if (position.x + image.getWidth() >= bar.getPosition().x
				&& position.x <= bar.getPosition().x + bar.getImage().getWidth()
				&& position.y <= bar.getPosition().y + bar.getImage().getHeight() / 2) {
			velocity.add(0, GRAVITY, 0);
			velocity.y *= -1;
			if (position.x + image.getWidth() / 2 > bar.getPosition().x + bar.getImage().getWidth() / 2)
				velocity.x = 25;
			else
				velocity.x = -25;
			score++;
		}

		if (position.x + image.getWidth() < 0 || position.x > TopSektirme.WIDTH)
			gsm.set(new EndState(gsm));
		else if(position.y <= 0)
			gsm.set(new EndState(gsm));
	}

	public void dispose() {
		image.dispose();
	}

	public Texture getImage() {
		return image;
	}

	public Vector3 getPosition() {
		return position;
	}
	
	public int getScore() {
		return score;
	}
}
