package com.grantmuller.shapes.moving;

import com.grantmuller.shapes.Hexagon;

public class MovingHexagon extends MovingObject {

	Hexagon hexagon;
	float sideLength;

	public MovingHexagon(Object p, int tempX, int tempY, int length, float l, int color){
		super(p, tempX, tempY, l);
		setFillColor(color);
		sideLength = length;
		hexagon = new Hexagon(p, tempX, tempY, length);
	}

	public void display(){
		hexagon.setStartX(getXPosition());
		hexagon.setStartY(getYPosition());
		
		if (buffer != null){
			// Display the circle
			buffer.beginDraw();
			buffer.fill(getFillColor(),getLife());
			buffer.stroke(getFillColor(),getLife());
			hexagon.drawTranslatedHex();
			buffer.endDraw();
		}

		if (parent != null){
			// Display the circle
			parent.fill(getFillColor(),getLife());
			parent.stroke(getFillColor(),getLife());
			hexagon.drawTranslatedHex();
		}
	}
}
