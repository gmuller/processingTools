package com.grantmuller.effects;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.video.Movie;

public class VideoEffect {

	PApplet parent;
	PGraphics buffer;
	
	public VideoEffect(Object p){
		if (p instanceof PApplet)
			parent = (PApplet) p;
	
		if (p instanceof PGraphics)
			buffer = (PGraphics) p;
	}
	
	public void alphaReveal(Movie movie, PGraphics buffer){
		movie.mask(buffer.pixels);
	}
	
	public void stutter(Movie movie, Float amt){
		//TODO : Make this compatible with buffer so off screen stutters can be performed.
		movie.play();
		parent.delay(30);
		movie.jump(movie.time()+amt);
		movie.pause();
	}

}
