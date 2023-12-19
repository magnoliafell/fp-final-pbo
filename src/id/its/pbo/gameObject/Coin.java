package id.its.pbo.gameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import id.its.pbo.gameObject.util.handler;
import id.its.pbo.gameObject.util.objectId;
import id.its.pbo.graphic.Texture;
import id.its.pbo.main.gameEngine;

public class Coin extends gameObject {
	
	private  handler handler;
	private Texture text;
	private long tileNum;
	private String jumlah =  getPoint()	+ "";
//	private int[] sequence;
//	private int sequenceIndex;
	private static int point = 0;
	private BufferedImage[] sprite;
	public Coin(int x, int y, int scale, int width, int height, int coinNum, handler handler) {
		super(x, y, objectId.coin, scale, width, height);
		this.handler= handler;
		text= gameEngine.getTex();
		this.tileNum = coinNum;
		sprite= text.getCoin_1();
//		this.sequence = sequence;
//        sequenceIndex = 0;
//		point += tileNum;
	}

	@Override
	public void tick() {
		
		Collision();

//		point += tileNum;
	}
	
	public int getPoint() {
	    return point;
	}
	
	public int point() {
//		if (tileNum == 11) {
//			point += tileNum;
//		} else if (tileNum == 12) {
//			point *= tileNum;
//		} else if (tileNum == 13) {
//			point -= tileNum;
//		}
		if (tileNum >= 0 && tileNum <=9 ) {
			point += tileNum;
		} else if (tileNum == 10) {
			point --;
		} else if (tileNum == 11) {
			point -= 2;
		} else if (tileNum == 12) {
			point *= 1;
		} else if (tileNum == 13) {
			point *= 2;
		}
		System.out.print(point);
		return point;
	}
	@Override
	public void render(Graphics g) {
//		g.setColor(Color.GREEN);
//		g.drawRect((int) getX(), (int)getY(), (int)getWidth(), (int)getHeight());
		if(tileNum == 1) {
			g.drawImage(sprite[1], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		} else if (tileNum ==0) {
			g.drawImage(sprite[0], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		} else if (tileNum == 2) {
			g.drawImage(sprite[2], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		} else if (tileNum == 6) {
			g.drawImage(sprite[6], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		} else if (tileNum == 3) {
			g.drawImage(sprite[3], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		} else if (tileNum == 4) {
			g.drawImage(sprite[4], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		} else if (tileNum == 5) {
			g.drawImage(sprite[5], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		}else if (tileNum == 7) {
			g.drawImage(sprite[7], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		}else if (tileNum == 8) {
			g.drawImage(sprite[8], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		}else if (tileNum == 9) {
			g.drawImage(sprite[9], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		}else if (tileNum == 10) {
			g.drawImage(sprite[10], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		}else if (tileNum == 11) {
			g.drawImage(sprite[11], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		}else if (tileNum == 12) {
			g.drawImage(sprite[12], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		}else if (tileNum == 13) {
			g.drawImage(sprite[13], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
		}
//		
	//	showBounds(g);
		
	}
	@Override
	public Rectangle getBounds() {
	return new Rectangle((int) (getX()+getWidth()/2-getWidth()/4), 
			(int) (getY()+getHeight()/2), 
			(int) (getWidth()),
			(int) (getHeight()));
	}
//	public Rectangle getBoundsTop() {
//		return new Rectangle((int) (getX()+getWidth()/2-getWidth()/4), 
//				(int) (getY()), 
//				(int) (getWidth()),
//				(int) (getHeight()));
//	}
//	public Rectangle getBoundsRight() {
//	    return new Rectangle((int) (getX() + getWidth() - 8), 
//	                         (int) (getY() + 6), 
//	                         (int) 8,
//	                         (int) (getHeight() - 10));
//	}
//
//	public Rectangle getBoundsLeft() {
//	    return new Rectangle((int) getX(), 
//	                         (int) (getY() + 6), 
//	                         (int) 8,
//	                         (int) (getHeight() - 10));
//	}

	private void showBounds(Graphics g) {
//		Graphics2D g2d = (Graphics2D) g;
//		
//		g.setColor(Color.RED);
//		g2d.draw(getBounds());
		//g.drawString(jumlah, 720, 50);
//		g2d.draw(getBoundsTop());
//		g2d.draw(getBoundsLeft());
//		g2d.draw(getBoundsRight());
	}
	
	public void Collision() {
		for(int i =0; i<200; i++) {
			gameObject temp = handler.getGameObject().get(i);
	        if (temp.getId() == objectId.imroatus) {
	            if (getBounds().intersects(temp.getBounds())) {
	            	System.out.println("bawah");
	            	point();
	            	setX(-6000);
	            }
//	            if (getBoundsTop().intersects(temp.getBounds())) {
//	            	System.out.println("atas");
//	                setX(-6000);
//	            }
//	            if (getBoundsLeft().intersects(temp.getBounds())) {
//	            	System.out.println("kiri");
//	                setX(-6000);
//	            }
//	            if (getBoundsRight().intersects(temp.getBounds())) {
//	            	System.out.println("kanan");
//	                setX(-6000);
//	            }
			}
		}
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

