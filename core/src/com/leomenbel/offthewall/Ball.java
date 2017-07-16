package com.leomenbel.offthewall;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Ball {

	Sprite image;
	Rectangle bounds;
	Vector2 velocity, acceleration, position;
	int ballX, ballY, ballW;

	public Ball(int x, int y, int w, Vector2 a, Sprite i) {

		ballX = x;
		ballY = y;
		ballW = w;
		image = i;
		acceleration = a;

		bounds = new Rectangle(ballX, ballY, w, w);
		position = new Vector2(bounds.x, bounds.y);
		velocity = new Vector2(0, 0);

	}

	boolean isTouched(Vector3 touch) {

		if (touch.x >= bounds.x && touch.x <= bounds.x + ballW && touch.y >= bounds.y && touch.y <= bounds.y + ballW) {
			
			return true;
		} else {
			return false;
		}

	}
	boolean checkGameOver(){
		if(position.y > 1080){
			return true;
		}else{
			return false;
		}
	}
	
	boolean checkNoTouchZone(Vector3 touch){
		if(touch.y < 355){
			return true;
		}else{
			return false;
		}
	}

	void reset() {

		position.set(ballX, ballY);
		velocity.set(0, 0);

	}
	
	void draw(SpriteBatch batch){
		batch.draw(image, bounds.x, bounds.y);
	}
	
	

	void move() {
		
		position.add(velocity);
		/*bounds.x = position.x;
		bounds.y = position.y;*/
		bounds.setPosition(position.x,position.y);

	}
	
	void accelerate(){
		
		
		if(velocity.y > 0){
			velocity.y*=-1;
		}
		if(velocity.y == 0){
			velocity.y-= 5;
		}
		Random r = new Random();
		int x = 0;

		x = r.nextInt(40) - 20;

		velocity.x = x;
		velocity.add(acceleration);
		
	}
	

	void checkWall(Wall wall, MyGdxGame game) {

		
		if(bounds.y < wall.bounds.y + wall.bounds.height){
			if(game.audioOn){
				Assets.bounce.play();
			}
			velocity.y*=-1;
			GameScreen.counter ++;
		}
		if(bounds.x < 0 || bounds.x > 1920 - bounds.width){
			if(game.audioOn){
				Assets.bounce.play();
			}
			velocity.x *= -1;
		}
		
		
	}

}
