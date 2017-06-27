package com.leomenbel.offthewall;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Wall {

	public Sprite image;
	public Rectangle bounds;
	
	public Wall(){
		image = Assets.sprite_wall;
		bounds = new Rectangle(0, 0, 1920, 80);
	}
	
	void draw(SpriteBatch batch){
		batch.draw(image, bounds.x, bounds.y);
	}
}
