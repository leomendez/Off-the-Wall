package com.leomenbel.offthewall;

import com.badlogic.gdx.Game;
//Main Class
//Author: Leonardo Mendez


public class MyGdxGame extends Game{
	
	// Global variables
	public boolean audioOn;
	public int difficulty, highScoreEasy, highScoreNormal, highScoreHard; 
	
	@Override
	public void create() 
	{
		
		Assets.load();
		this.setScreen(new MenuScreen(this));
		
	}
	
	
	
}
