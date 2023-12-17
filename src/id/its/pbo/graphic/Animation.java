package id.its.pbo.graphic;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation {
	private int speed;
	private int frames;
	private int index = 0;
	private int count = 0;
	private BufferedImage[] img;
	private BufferedImage currImg;
	
	
	public Animation(int speed, BufferedImage... args) {
		this.speed = speed;
		int n = args.length;
		img = new BufferedImage[n];
		for(int i = 0; i<n; i++) {
			img[i] = args[i];
		}
		
		frames = n;
	}
	
	public void runAnimation() {
		index++;
		if(index>speed) {
			index = 0;
			nextFrame();
		}
	}
	
	public void nextFrame() {
		currImg = img[count];
		count++;
		if(count>=frames) {
			count = 0;
		}
	}
	
	public void drawAnimation(Graphics g, int x, int y, int scaleX, int scaleY) {
		g.drawImage(currImg, x, y, scaleX, scaleY, null);
	}
	
}
