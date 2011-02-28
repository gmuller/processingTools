package com.grantmuller.shapes.moving;

import com.grantmuller.physics.Motion;

import processing.core.PApplet;
import processing.core.PGraphics;

public abstract class MovingObject extends Motion{

    PApplet parent;
	PGraphics buffer;
	int fillColor;
	int strokeColor;

	protected MovingObject(Object p, float tempX, float tempY, float tempLife) {
		super(tempX, tempY, tempLife);
		int height = 0;
		int width = 0;
		if (p instanceof PGraphics){
			  buffer = (PGraphics) p;
		  		height = buffer.height;
		  		width = buffer.width;
		  }

		  if (p instanceof PApplet){
			  parent = (PApplet) p;
		  		height = parent.height;
		  		width = parent.width;
		  }
		  
		  super.setHeight(height);
		  super.setWidth(width);
	}

	public int getFillColor() {
		return fillColor;
	}

	public void setFillColor(int color) {
		this.fillColor = color;
	}
	
	public int getStrokeColor() {
		return strokeColor;
	}

	public void setStrokeColor(int strokeColor) {
		this.strokeColor = strokeColor;
	}
}
