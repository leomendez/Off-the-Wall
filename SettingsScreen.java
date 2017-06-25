package com.leomenbel.offthewall;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class SettingsScreen implements Screen {

	MyGdxGame game;
	OrthographicCamera camera;
	SpriteBatch batch;
	Vector3 touch;
	Button backBtn, audioOnBtn, audioOffBtn, easyBtn, normalBtn, hardBtn;

	public SettingsScreen(MyGdxGame game) {
		this.game = game;

		backBtn = new Button(55, 55, 180, 180);
		audioOnBtn = new Button(980, 660, 130, 90);
		audioOffBtn = new Button(1280, 660, 160, 90);
		easyBtn = new Button(680, 850, 190, 90);
		normalBtn = new Button(1040, 850, 310, 90);
		hardBtn = new Button(1500, 850, 215, 90);

		// Resizing and scaling to screen
		camera = new OrthographicCamera();

		camera.setToOrtho(true, 1920, 1080);

		batch = new SpriteBatch();

		touch = new Vector3();

	}

	@Override
	public void render(float delta) {

		camera.update();
		batch.setProjectionMatrix(camera.combined);

		generalUpdate(touch, camera);

		batch.begin();

		batch.draw(Assets.sprite_settings, 0, 0);

		if (game.audioOn == true) {
			batch.draw(Assets.sprite_audioOn, 0, 0);
		} else {
			batch.draw(Assets.sprite_audioOff, 0, 0);
		}

		switch (game.difficulty) {
		case 1:
			batch.draw(Assets.sprite_easyOn, 0, 0);
			break;
		case 2:
			batch.draw(Assets.sprite_normalOn, 0, 0);
			break;
		case 3:
			batch.draw(Assets.sprite_hardOn, 0, 0);
			break;
		}

		batch.end();

	}

	public void generalUpdate(Vector3 touch, OrthographicCamera camera) {

		if (Gdx.input.justTouched()) {
			touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch);

			if (backBtn.isTouched(touch)) {

				dispose();
				game.setScreen(new MenuScreen(game));

				if (game.audioOn == true) {
					Assets.hit.play();
				}

			}
			if (audioOnBtn.isTouched(touch)) {
				game.audioOn = true;

				if (game.audioOn == true) {
					Assets.hit.play();
				}

				Assets.settings.putBoolean("Audio", true);
				Assets.settings.flush();
			}
			if (audioOffBtn.isTouched(touch)) {
				game.audioOn = false;
				Assets.settings.putBoolean("Audio", false);
				Assets.settings.flush();
			}
			if (easyBtn.isTouched(touch)) {

				if (game.audioOn == true) {
					Assets.hit.play();

				}

				game.difficulty = 1;
				Assets.settings.putInteger("Difficulty", game.difficulty);
				Assets.settings.flush();
			}

			if (normalBtn.isTouched(touch)) {

				if (game.audioOn == true) {
					Assets.hit.play();
				}

				game.difficulty = 2;
				Assets.settings.putInteger("Difficulty", game.difficulty);
				Assets.settings.flush();
			}

			if (hardBtn.isTouched(touch)) {

				if (game.audioOn == true) {
					Assets.hit.play();
				}

				game.difficulty = 3;
				Assets.settings.putInteger("Difficulty", game.difficulty);
				Assets.settings.flush();
			}

		}

	}

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
