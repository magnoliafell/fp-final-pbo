package id.its.pbo.gameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import id.its.pbo.gameObject.util.handler;
import id.its.pbo.gameObject.util.objectId;
import id.its.pbo.graphic.Texture;
import id.its.pbo.main.gameEngine;

public class Ground extends gameObject {
	
	private  handler handler;
	private Texture text;
	private int tileNum;
	private BufferedImage[] sprite;
	public Ground(int x, int y, int scale, int width, int height, int tileNum) {
		super(x, y, objectId.bricks, scale, width, height);
		text= gameEngine.getTex();
		this.tileNum = tileNum;
		sprite= text.getTile_1();
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
		} else if (tileNum ==2) {
			g.drawImage(sprite[0], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		} else if (tileNum == 3) {
			g.drawImage(sprite[2], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		} else if (tileNum == 4) {
			g.drawImage(sprite[6], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		} else if (tileNum == 5) {
			g.drawImage(sprite[3], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		} else if (tileNum == 6) {
			g.drawImage(sprite[4], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		} else if (tileNum == 7) {
			g.drawImage(sprite[5], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		}
		
		
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)getX(), (int)getY(), (int) getWidth(), (int)getHeight());
	}

}

//public class Ground {
//    private ArrayList<Rectangle> groundLayers;
//
//    public Ground() {
//        groundLayers = new ArrayList<>();
//
//        // Define multiple layers of ground using rectangles
//        groundLayers.add(new Rectangle(0, 200, 100, 50)); // Bottom layer
//        groundLayers.add(new Rectangle(100, 100, 100, 50)); // Second layer
//        // Add more layers as needed
//    }
//
//    public void render(Graphics g) {
//        for (Rectangle layer : groundLayers) {
//            g.setColor(Color.GREEN); // Set the color for each layer
//            g.fillRect(layer.x, layer.y, layer.width, layer.height);
//        }
//    }
//
//    public ArrayList<Rectangle> getGroundLayers() {
//        return groundLayers;
//    }
//}

