package id.its.pbo.gameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import id.its.pbo.gameObject.util.handler;
import id.its.pbo.gameObject.util.objectId;
import id.its.pbo.graphic.Texture;
import id.its.pbo.main.gameEngine;

public class Hiasan extends gameObject {
	
	private  handler handler;
	private Texture text;
	private int tileNum;
	private BufferedImage[] sprite;
	public Hiasan(int x, int y, int scale, int width, int height, int hiasanNum) {
		super(x, y, objectId.hiasan, scale, width, height);
		text= gameEngine.getTex();
		this.tileNum = hiasanNum;
		sprite= text.getHiasan_1();
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
//		g.setColor(Color.GREEN);
//		g.drawRect((int) getX(), (int)getY(), (int)getWidth(), (int)getHeight());
		if(tileNum == 1) {
			g.drawImage(sprite[1], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		} else if (tileNum ==0) {
			g.drawImage(sprite[0], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		} else if (tileNum ==2) {
			g.drawImage(sprite[2], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		} else if (tileNum ==3) {
			g.drawImage(sprite[3], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		} 
		
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)getX(), (int)getY(), (int) getWidth(), (int)getHeight());
	}

}


