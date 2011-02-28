package com.grantmuller.physics;

import java.util.ArrayList;

public abstract class Motion {

	private int height;
	private int width;
	private float fallSpeed;
	private float gravity = 0.1f;
	private float dampening = -0.8f;
	private float xPosition;
	private float yPosition;
	private float life;
	private boolean isFinished;
	private ArrayList<MotionType> motionList;

	protected Motion(float tempX, float tempY, float tempLife){
		this (tempX, tempY, tempLife, new ArrayList<MotionType>());
	}

	protected Motion(float tempX, float tempY, float tempLife, ArrayList<MotionType> motions){
		xPosition = tempX;
		yPosition = tempY;
		fallSpeed = 0;
		life = tempLife;
		motionList = motions;
	}

	public void move() {
		if (motionList.contains(MotionType.FALL))
			fall();

		if (motionList.contains(MotionType.FADE))
			isFinished = fade();

		if (motionList.contains(MotionType.VERTICAL_BOUNCE))
			verticalBounce();

		if (motionList.contains(MotionType.HORIZONATAL_BOUNCE))
			horizontalBounce();
	}

	public boolean fade() {
		life--;
		if (life < 0) {
			return true;
		} else {
			return false;
		}
	}

	public void fall(){
		// Add gravity to speed
		fallSpeed = fallSpeed + gravity;
		// Add speed to y location
		yPosition = yPosition + fallSpeed;
	}

	public void verticalBounce(){
		if (yPosition > height) {
			// Dampening
			fallSpeed = fallSpeed * dampening;
			yPosition = height;
		}

		if (yPosition < 0) {
			// Dampening
			fallSpeed = 0;
			yPosition = 0;
		}
	}

	public void horizontalBounce(){
		if (xPosition > width) {
			// Dampening
			fallSpeed = fallSpeed * dampening;
			xPosition = width;
		}

		if (xPosition < 0) {
			// Dampening
			fallSpeed = 0;
			xPosition = 0;
		}
	}

	public boolean isFinished() {
		return isFinished;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public float getLife() {
		return life;
	}

	public void setLife(float life) {
		this.life = life;
	}

	public float getXPosition() {
		return xPosition;
	}

	public float getYPosition() {
		return yPosition;
	}
	
	public float getGravity() {
		return gravity;
	}

	public void setGravity(float gravity) {
		this.gravity = gravity;
	}

	public float getDampening() {
		return dampening;
	}

	public void setDampening(float dampening) {
		this.dampening = dampening;
	}

	public void addMotion(MotionType motion){
		if (!motionList.contains(motion))
			motionList.add(motion);
	}

	public void removeMotion(MotionType motion){
		motionList.remove(motion);
	}
}
