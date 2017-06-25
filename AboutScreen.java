package com.leomenbel.offthewall;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class AboutScreen implements Screen {

	MyGdxGame game;
	OrthographicCamera camera;
	SpriteBatch batch;
	Vector3 touch;
	Button backBtn;
	int btnX = 55, btnY = 55, btnW = 180;

	public AboutScreen(MyGdxGame game) {
		
		this.game = game;

		backBtn = new Button(btnX, btnY, btnW, btnW);

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

		batch.draw(Assets.sprite_about, 0, 0);

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
