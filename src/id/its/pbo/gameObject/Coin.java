package id.its.pbo.gameObject;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import id.its.pbo.gameObject.util.handler;
import id.its.pbo.gameObject.util.objectId;
import id.its.pbo.graphic.Texture;
import id.its.pbo.main.gameEngine;

public class Coin extends gameObject{

	private  handler handler;
	private Texture text;
	private int coinNum;
	private BufferedImage[] sprite;
	public Coin(int x, int y, int scale, int width, int height, int coinNum) {
		super(x, y, objectId.coin, scale, width, height);
		text= gameEngine.getTex();
		this.coinNum = coinNum;
		sprite= text.getCoin_1();
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
//		g.setColor(Color.GREEN);
//		g.drawRect((int) getX(), (int)getY(), (int)getWidth(), (int)getHeight());
		if(coinNum == 0) {
			g.drawImage(sprite[10], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		} else if (coinNum ==1) {
			g.drawImage(sprite[1], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		} else if (coinNum == 2) {
			g.drawImage(sprite[2], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		} else if (coinNum == 3) {
			g.drawImage(sprite[3], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		} else if (coinNum == 4) {
			g.drawImage(sprite[4], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		} else if (coinNum == 5) {
			g.drawImage(sprite[5], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		} else if (coinNum == 6) {
			g.drawImage(sprite[6], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		} else if (coinNum == 7) {
			g.drawImage(sprite[7], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		} else if (coinNum == 8) {
			g.drawImage(sprite[8], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		} else if (coinNum == 9) {
			g.drawImage(sprite[9], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		}
		
		
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)getX(), (int)getY(), (int) getWidth(), (int)getHeight());
	}
}
