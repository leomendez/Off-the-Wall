package com.leomenbel.offthewall;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Button extends Rectangle{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4750383653099594947L;

	public Button(int x,int y,int w,int h){
		
		super(x,y,w,h);
		
	}
	
	boolean isTouched(Vector3 touch){
		
		if(touch.x >= this.x && touch.x <= x+this.width && touch.y >= this.y && touch.y <= y+this.height){
			return true;
		}else{
			return false;
		}
	
		
	}

}
