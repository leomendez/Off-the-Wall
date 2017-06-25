package com.leomenbel.offthewall;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class BallHard extends Ball{

	final static int ballX = 900;
	final static int ballY = 480;
	final static int ballW = 120;
	final static Vector2 ballA = new Vector2(0,-2);
	final static Sprite ballI = Assets.sprite_ballHard;
	
	public BallHard(){
		super(ballX,ballY,ballW,ballA,ballI);
	}
	
}
