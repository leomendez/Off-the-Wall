package com.leomenbel.offthewall;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class BallEasy extends Ball{
	
	final static int ballX = 900;
	final static int ballY = 480;
	final static int ballW = 150;
	final static Vector2 ballA = new Vector2(0,-1);
	final static Sprite ballI = Assets.sprite_ballEasy;
	
	public BallEasy(){
		super(ballX,ballY,ballW,ballA,ballI);
	}
	
	

}
