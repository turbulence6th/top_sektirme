package com.turbulence6th.topsektirme;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Bar {

	private Texture image;
	private Vector3 position;

	public Bar() {
		image = new Texture("bar.png");
		position = new Vector3(TopSektirme.WIDTH / 2 - image.getWidth() / 2, 0, 0);
	}

	public void update(int x) {
		position.x = x - image.getWidth() / 2;
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

}
