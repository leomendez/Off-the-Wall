package com.leomenbel.offthewall;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class MenuScreen implements Screen {

	MyGdxGame game;
	OrthographicCamera camera;
	SpriteBatch batch;
	Vector3 touch;
	Button playBtn, settingsBtn, aboutBtn, scoreBtn;
	int btnX = 455, btnY = 355, btnW = 1000, btnH = 195, btnGap = 40;
	int scoreBtnX = 1685, scoreBtnY = 55, scoreBtnW = 180;

	public MenuScreen(MyGdxGame game) {
		this.game = game;

		playBtn = new Button(btnX, btnY, btnW, btnH);
		settingsBtn = new Button(btnX, btnY + btnH + btnGap, btnW, btnH);
		aboutBtn = new Button(btnX, btnY + ((btnH + btnGap) * 2), btnW, btnH);
		scoreBtn = new Button(scoreBtnX, scoreBtnY, scoreBtnW, scoreBtnW);

		// Resizing and scaling to screen
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 1920, 1080);

		batch = new SpriteBatch();

		touch = new Vector3();

		game.highScoreEasy = Assets.settings.getInteger("High Score Easy");
		game.highScoreNormal = Assets.settings.getInteger("High Score Normal");
		game.highScoreHard = Assets.settings.getInteger("High Score Hard");

		// Identifies it is the first time the game is run in this device
		if (game.highScoreEasy == 0 && game.highScoreNormal == 0 && game.highScoreHard == 0) {
			game.difficulty = 2;
			game.audioOn = true;
			Assets.settings.putInteger("Difficulty", game.difficulty);
			Assets.settings.putBoolean("Audio", true);
			Assets.settings.flush();

		} else {
			game.difficulty = Assets.settings.getInteger("Difficulty");
			game.audioOn = Assets.settings.getBoolean("Audio");
		}

	}

	@Override
	public void render(float delta) {

		camera.update();

		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();

		batch.draw(Assets.sprite_mainMenu, 0, 0);

		generalUpdate(touch, camera);

		batch.end();

	}

	public void generalUpdate(Vector3 touch, OrthographicCamera camera) {

		if (Gdx.input.justTouched()) {

			touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);

			camera.unproject(touch);

			if (playBtn.isTouched(touch)) {

				dispose();
				game.setScreen(new GameScreen(game));

				if (game.audioOn == true) {
					Assets.hit.play();
				}

			}
			if (settingsBtn.isTouched(touch)) {

				dispose();
				game.setScreen(new SettingsScreen(game));

				if (game.audioOn == true) {
					Assets.hit.play();
				}

			}

			if (aboutBtn.isTouched(touch)) {

				dispose();
				game.setScreen(new AboutScreen(game));

				if (game.audioOn == true) {
					Assets.hit.play();
				}

			}

			if (scoreBtn.isTouched(touch)) {

				dispose();
				game.setScreen(new ScoreboardScreen(game));

				if (game.audioOn == true) {
					Assets.hit.play();
				}

			}

		}

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
