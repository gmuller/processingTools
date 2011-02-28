package com.grantmuller.shapes.moving;


public class MovingBall extends MovingObject {

	float radius;

	public MovingBall(Object p, float tempX, float tempY, float tempRadius, float l, int color) {
		super(p, tempX, tempY, l);	
		radius = tempRadius;
		setFillColor(color);
	}

	public void display() {

		if (buffer != null){
			// Display the circle
			buffer.beginDraw();
			buffer.fill(getFillColor(),getLife());
			buffer.stroke(getFillColor(),getLife());
			buffer.ellipse(getXPosition(),getYPosition(),radius,radius);
			buffer.endDraw();
		}

		if (parent != null){
			// Display the circle
			parent.fill(getFillColor(),getLife());
			parent.stroke(getFillColor(),getLife());
			parent.ellipse(getXPosition(),getYPosition(),radius,radius);
		}
	}
}  

