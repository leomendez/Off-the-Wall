package com.leomenbel.offthewall;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Assets {
	
	public static Texture texture_back;
	public static Sprite sprite_back;
	
	public static Texture texture_wall;
	public static Sprite sprite_wall;
	
	public static Texture texture_ball;
	public static Sprite sprite_ball;
	
	public static Texture texture_ballEasy;
	public static Sprite sprite_ballEasy;
	
	public static Texture texture_ballHard;
	public static Sprite sprite_ballHard;
	
	public static Texture texture_gameOver;
	public static Sprite sprite_gameOver;
	
	public static Texture texture_mainMenu;
	public static Sprite sprite_mainMenu;
	
	public static Texture texture_settings;
	public static Sprite sprite_settings;
	
	public static Texture texture_about;
	public static Sprite sprite_about;
	
	public static Texture texture_score;
	public static Sprite sprite_score;
	
	public static Texture texture_audioOn;
	public static Sprite sprite_audioOn;
	
	public static Texture texture_audioOff;
	public static Sprite sprite_audioOff;
	
	public static Texture texture_easyOn;
	public static Sprite sprite_easyOn;
	
	public static Texture texture_normalOn;
	public static Sprite sprite_normalOn;

	public static Texture texture_hardOn;
	public static Sprite sprite_hardOn;
	
	public static BitmapFont font;

	public static Preferences settings;
	
	public static Sound hit;
	
	public static Sound bounce;
	
	public static Sound easyHit;
	
	public static Sound hardHit;
	
	public static void load()
	{
		texture_back = new Texture("Game/Background.jpg");
		texture_back.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite_back = new Sprite(texture_back);
		sprite_back.flip(false, true);
		
		texture_wall = new Texture(Gdx.files.internal("Game/Wall.png"));
		texture_wall.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite_wall = new Sprite(texture_wall);
		sprite_wall.flip(false, true);
		
		texture_ballEasy = new Texture(Gdx.files.internal("Game/BallEasy.png"));
		texture_ballEasy.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite_ballEasy = new Sprite(texture_ballEasy);
		sprite_ballEasy.flip(false, true);
		
		texture_ballHard = new Texture(Gdx.files.internal("Game/BallHard.png"));
		texture_ballHard.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite_ballHard = new Sprite(texture_ballHard);
		sprite_ballHard.flip(false, true);
		
		texture_ball = new Texture(Gdx.files.internal("Game/ball.png"));
		texture_ball.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite_ball = new Sprite(texture_ball);
		sprite_ball.flip(false, true);
		
		texture_gameOver = new Texture(Gdx.files.internal("Game/Game Over.png"));
		texture_gameOver.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite_gameOver = new Sprite(texture_gameOver);
		sprite_gameOver.flip(false, true);
		
		texture_mainMenu = new Texture(Gdx.files.internal("Game/Menu.png"));
		texture_mainMenu.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite_mainMenu = new Sprite(texture_mainMenu);
		sprite_mainMenu.flip(false, true);
		
		texture_settings = new Texture(Gdx.files.internal("Game/Settings.png"));
		texture_settings.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite_settings = new Sprite(texture_settings);
		sprite_settings.flip(false, true);
		
		texture_about = new Texture(Gdx.files.internal("Game/About.png"));
		texture_about.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite_about = new Sprite(texture_about);
		sprite_about.flip(false, true);
		
		texture_score = new Texture(Gdx.files.internal("Game/Scoreboard.png"));
		texture_score.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite_score = new Sprite(texture_score);
		sprite_score.flip(false, true);
		
		texture_audioOn = new Texture(Gdx.files.internal("Game/AudioOn.png"));
		texture_audioOn.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite_audioOn = new Sprite(texture_audioOn);
		sprite_audioOn.flip(false, true);
		
		texture_audioOff = new Texture(Gdx.files.internal("Game/AudioOff.png"));
		texture_audioOff.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite_audioOff = new Sprite(texture_audioOff);
		sprite_audioOff.flip(false, true);
		
		texture_easyOn = new Texture(Gdx.files.internal("Game/EasyOn.png"));
		texture_easyOn.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite_easyOn = new Sprite(texture_easyOn);
		sprite_easyOn.flip(false, true);
		
		texture_normalOn = new Texture(Gdx.files.internal("Game/NormalOn.png"));
		texture_normalOn.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite_normalOn = new Sprite(texture_normalOn);
		sprite_normalOn.flip(false, true);
		
		texture_hardOn = new Texture(Gdx.files.internal("Game/HardOn.png"));
		texture_hardOn.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite_hardOn = new Sprite(texture_hardOn);
		sprite_hardOn.flip(false, true);
		
		
		font = new BitmapFont(Gdx.files.internal("Game/font.fnt"),true);
		
		settings = Gdx.app.getPreferences("settings");
		
		hit = Gdx.audio.newSound(Gdx.files.internal("Game/hit.mp3"));
		bounce = Gdx.audio.newSound(Gdx.files.internal("Game/bounce.mp3"));
		easyHit = Gdx.audio.newSound(Gdx.files.internal("Game/EasyHit.mp3"));
		hardHit = Gdx.audio.newSound(Gdx.files.internal("Game/HardHit.mp3"));
	}
	
}
