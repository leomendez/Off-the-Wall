package com.leomenbel.offthewall;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

//GameScreen Class where the game is played
public class GameScreen implements Screen {

	// Local Variables
	MyGdxGame game;
	OrthographicCamera camera;
	SpriteBatch batch;
	Vector3 touch;
	// Ball nBall, eBall, hBall;
	Wall wall;
	boolean gameOver;
	public static int counter = 0;
	String strCount;
	BallEasy eBall;
	BallNormal nBall;
	BallHard hBall;
	Sound easyHit = Assets.easyHit;
	Sound hit = Assets.hit;
	Sound hardHit = Assets.hardHit;

	public GameScreen(MyGdxGame game) {
		// Initialize all the variables used in this screen

		this.game = game;

		// Resizing and scaling to screen
		camera = new OrthographicCamera();

		camera.setToOrtho(true, 1920, 1080);

		batch = new SpriteBatch();

		touch = new Vector3();

		game.highScoreNormal = Assets.settings.getInteger("High Score Normal");

		nBall = new BallNormal();

		eBall = new BallEasy();

		hBall = new BallHard();

		wall = new Wall();

	}

	public void render(float delta) {

		camera.update();

		// Convert the counter variable into a string to write it on the screen
		StringBuilder sb = new StringBuilder();
		sb.append("");
		sb.append(counter);
		strCount = sb.toString();

		batch.setProjectionMatrix(camera.combined);

		batch.begin();

		// Convert highScore variables into strings to write them on the screen

		batch.draw(Assets.sprite_back, 0, 0);

		switch (game.difficulty) {
		case 1:
			batch.draw(eBall.image, eBall.bounds.x, eBall.bounds.y);
			break;
		case 2:
			batch.draw(nBall.image, nBall.bounds.x, nBall.bounds.y);
			break;
		case 3:
			batch.draw(hBall.image, hBall.bounds.x, hBall.bounds.y);
			break;
		}

		batch.draw(wall.image, wall.bounds.x, wall.bounds.y); // draw wall

		Assets.font.draw(batch, strCount, 960, 30); // draw counter

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

	void gameIsOver() {

		batch.draw(Assets.sprite_gameOver, 0, 0); // Draw game over screen
		Button menuBtn, againBtn;

		againBtn = new Button(1000, 635, 500, 150);
		menuBtn = new Button(425, 635, 500, 150);

		StringBuilder sb2 = new StringBuilder();
		sb2.append("");
		sb2.append(game.highScoreEasy);
		String strHighScoreEasy = sb2.toString();

		StringBuilder sb3 = new StringBuilder();
		sb3.append("");
		sb3.append(game.highScoreNormal);
		String strHighScoreNormal = sb3.toString();

		StringBuilder sb4 = new StringBuilder();
		sb4.append("");
		sb4.append(game.highScoreHard);
		String strHighScoreHard = sb4.toString();

		switch (game.difficulty) {
		case 1:
			Assets.font.draw(batch, "Your Score: " + strCount + "    High Score: " + strHighScoreEasy, 600, 500);
			if (counter >= game.highScoreEasy) {

				game.highScoreEasy = counter;
				Assets.settings.putInteger("High Score Easy", game.highScoreEasy);
				Assets.settings.flush(); // Saves file
			}
			break;
		case 2:
			Assets.font.draw(batch, "Your Score: " + strCount + "    High Score: " + strHighScoreNormal, 600, 500);

			if (counter >= game.highScoreNormal) {
				game.highScoreNormal = counter;
				Assets.settings.putInteger("High Score Normal", game.highScoreNormal);
				Assets.settings.flush();
			}
			break;
		case 3:
			Assets.font.draw(batch, "Your Score: " + strCount + "    High Score: " + strHighScoreHard, 600, 500);
			if (counter >= game.highScoreHard) {
				game.highScoreHard = counter;
				Assets.settings.putInteger("High Score Hard", game.highScoreHard);
				Assets.settings.flush();
			}
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
