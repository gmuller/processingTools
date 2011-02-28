package com.grantmuller.shapes;

import processing.core.PApplet;
import processing.core.PGraphics;

public class CycleCircle {
	
	protected PApplet parent;
	protected PGraphics buffer;
	protected float xLocation;
	protected float yLocation;
	protected float size;
	protected boolean isIterated = false;

	public CycleCircle(Object p, float theX, float theY, float size){
		if (p instanceof PGraphics)
			buffer = (PGraphics) p;
		
		if (p instanceof PApplet)
			parent = (PApplet) p;
		
		this.yLocation = theY;
		this.xLocation = theX;
		this.size = size;
	}
	
	public void draw(){
		parent.ellipse(xLocation, yLocation, size, size);
	}
	
	public float getWidth() {
		return xLocation;
	}
	
	public float getHeight() {
		return yLocation;
	}

	public float getInitialSize() {
		return size;
	}
	
	public boolean isIterated() {
		return isIterated;
	}

	public void setIterated(boolean isIterated) {
		this.isIterated = isIterated;
	}
}
