package com.leomenbel.offthewall;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

//GameScreen Class where the game is played
public class GameScreen implements Screen {

	// Local Variables
	MyGdxGame game;
	OrthographicCamera camera;
	SpriteBatch batch;
	Vector3 touch;
	String strCount;
	Wall wall;
	Ball eBall;
	Ball nBall;
	Ball hBall;
	Sound easyHit = Assets.easyHit;
	Sound hit = Assets.hit;
	Sound hardHit = Assets.hardHit;
	boolean gameOver;
	static int counter = 0;
	final int ballX = 900;
	final int ballY = 480;
	final int eBallW = 150;
	final Vector2 eBallA = new Vector2(0,-1);
	final Sprite eBallI = Assets.sprite_ballEasy;
	final int nBallW = 120;
	final Vector2 nBallA = new Vector2(0,-1);
	final Sprite nBallI = Assets.sprite_ball;
	final int hBallW = 120;
	final Vector2 hBallA = new Vector2(0,-2);
	final Sprite hBallI = Assets.sprite_ballHard;

	public GameScreen(MyGdxGame game) {
		// Initialize all the variables used in this screen

		this.game = game;

		// Resizing and scaling to screen
		camera = new OrthographicCamera();

		camera.setToOrtho(true, 1920, 1080);

		batch = new SpriteBatch();

		touch = new Vector3();

		nBall = new Ball(ballX, ballY, nBallW, nBallA, nBallI);

		eBall = new Ball(ballX, ballY, eBallW, eBallA, eBallI);

		hBall = new Ball(ballX, ballY, hBallW, hBallA, hBallI);

		wall = new Wall();

	}

	public void render(float delta) {

		camera.update();

		strCount = intToStr(counter);

		batch.setProjectionMatrix(camera.combined);

		batch.begin();

		// Convert highScore variables into strings to write them on the screen

		batch.draw(Assets.sprite_back, 0, 0);

		switch (game.difficulty) {
		case 1:
			/*batch.draw(eBall.image, eBall.bounds.x, eBall.bounds.y);*/
			eBall.draw(batch);
			break;
		case 2:
			nBall.draw(batch);
			break;
		case 3:
			hBall.draw(batch);
			break;
		}

		wall.draw(batch);

		Assets.font.draw(batch, strCount, wall.bounds.width/2, wall.bounds.height/3); // draw counter

		// set vector3 touch to the current click/touch location
		touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);

		if (gameOver == true) {
			gameIsOver();

		} else {
			generalUpdate(touch, camera);
		}

		batch.end();

	}

	public void generalUpdate(Vector3 touch, OrthographicCamera camera) {

		
		switch (game.difficulty) {
		case 1:
			runDif(eBall, easyHit);
			break;
		case 2:
			runDif(nBall, hit);
			break;
		case 3:
			runDif(hBall, hardHit);
			break;
		}


	}

	private void runDif(Ball ball, Sound hit) {
		
		ball.move();
		ball.checkWall(wall, game);
		if (ball.checkGameOver()) {
			gameOver = true;
		}
		if (Gdx.input.justTouched()) {
			camera.unproject(touch);
			if (ball.checkNoTouchZone(touch)) {
				gameOver = true;
			}
			if (ball.isTouched(touch)) {
				if (game.audioOn == true) {
					hit.play();
				}
				ball.accelerate();

			}

		}
		
	}
	
	void gameScore(String strCount, int highScore, String strHS, String placeStr){
		
		Assets.font.draw(batch, "Your Score: " + strCount + "    High Score: " + strHS, 600, 500);
		if (counter >= highScore) {

			highScore = counter;
			Assets.settings.putInteger(placeStr, highScore);
			Assets.settings.flush(); // Saves file
		}
		
		
	}
	
	String intToStr(int num){
		
		String str;
		StringBuilder sb = new StringBuilder();
		sb.append("");
		sb.append(num);
		str = sb.toString();
		return str;
		
	}

	void gameIsOver() {

		batch.draw(Assets.sprite_gameOver, 0, 0); // Draw game over screen
		Button menuBtn, againBtn;

		againBtn = new Button(1000, 635, 500, 150);
		menuBtn = new Button(425, 635, 500, 150);

		
		String strHighScoreEasy = intToStr(game.highScoreEasy);
		String strHighScoreNormal = intToStr(game.highScoreNormal);
		String strHighScoreHard = intToStr(game.highScoreHard);

		switch (game.difficulty) {
		case 1:	
			gameScore(strCount, game.highScoreEasy, strHighScoreEasy, "High Score Easy");
			break;
		case 2:
			gameScore(strCount, game.highScoreNormal, strHighScoreNormal,"High Score Normal");
			break;
		case 3:
			gameScore(strCount, game.highScoreHard, strHighScoreHard,"High Score Hard");
			break;
		}

		if (Gdx.input.justTouched()) {
			camera.unproject(touch);
			if (againBtn.isTouched(touch)) {

				if (game.audioOn == true) {
					Assets.hit.play();
				}

				gameOver = false;
				nBall.reset();
				eBall.reset();
				hBall.reset();
				counter = 0;
			}
			if (menuBtn.isTouched(touch)) {

				game.setScreen(new MenuScreen(game));
				if (game.audioOn == true) {
					Assets.hit.play();
				}
				counter = 0;
				dispose();

			}

		}

	}

	@Override
	public void show() {

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {

	}

}
