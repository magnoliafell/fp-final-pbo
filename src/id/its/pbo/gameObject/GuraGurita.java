package id.its.pbo.gameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import id.its.pbo.gameObject.util.handler;
import id.its.pbo.gameObject.util.objectId;
import id.its.pbo.graphic.Animation;
import id.its.pbo.graphic.Texture;
import id.its.pbo.main.gameEngine;


public class GuraGurita extends gameObject {
	public static final double  WIDTH = 32, HEIGHT=32;
//	public static final double  WIDTH = 96, HEIGHT=96;

	private  handler handler;
	private Texture text;
	private BufferedImage[] sprite;
	private BufferedImage[] currSprite;
	private Animation currAnimation;
	private Animation gura_walk;

    private float speed = 1.0f;
    private int n = 1;
	
	public GuraGurita(int x, int y, int scale, handler handler) {
		super(x, y, objectId.guraGurita, scale, WIDTH, HEIGHT);
		this.handler= handler;
		text= gameEngine.getTex();
		sprite= text.getGura_1();
		
		gura_walk = new Animation(1, sprite[0]);
		currSprite = sprite;
		currAnimation = gura_walk;
		
	}

	@Override
	public void tick() {
		 	if(n==1) {
		 	setVelX(speed); 
		 	
		 	}
			setX((float) (getX() + getVelX())); 

	       setY((float) (getY() + getVelY())); 
	        applyGravity(); 

	        Collision();
	        currAnimation.runAnimation();
	}

	@Override
	public void render(Graphics g) {
////		g.setColor(Color.BLUE);
////		g.fillRect((int)getX(),(int) getY(),(int) WIDTH, (int)HEIGHT);
//		for(int i = 0; i < 8; i++) {
//			g.drawImage(sprite[0], (int) getX(), (int) getY(), (int) getWidth(),(int) getHeight(), null);
//		}
		g.drawImage(currSprite[0], (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);
//			if(movingRight) {
//				g.drawImage(currSprite[0], (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);
//			}else {
//				g.drawImage(currSprite[0], (int) getX()+ (int) getWidth(), (int) getY(), (int) -getWidth(), (int) getHeight(), null);
//			}
//	
//		showBounds(g);
	}

	@Override
	public Rectangle getBounds() {
	return new Rectangle((int) (getX()+getWidth()/2-getWidth()/4), 
			(int) (getY()+getHeight()/2), 
			(int) (getWidth()/2),
			(int) (getHeight()/2));
	}
	public Rectangle getBoundsTop() {
		return new Rectangle((int) (getX()+getWidth()/2-getWidth()/4), 
				(int) (getY()), 
				(int) (getWidth()/2),
				(int) (getHeight()/2));
	}
	public Rectangle getBoundsRight() {
		return new Rectangle((int) (getX()+getWidth()-8), 
				(int) (getY()+5), 
				(int) 8,
				(int) (getHeight()-10));
	}
	public Rectangle getBoundsLeft() {
		return new Rectangle((int) getX(), 
				(int) (getY()+5), 
				(int) 8,
				(int) (getHeight()-10));
	}
private void showBounds(Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
	
	g.setColor(Color.RED);
	g2d.draw(getBounds());
	g2d.draw(getBoundsTop());
	g2d.draw(getBoundsLeft());
	g2d.draw(getBoundsRight());
}
	
	public void Collision() {
		for(int i =0; i<handler.getGameObject().size(); i++) {
			gameObject temp = handler.getGameObject().get(i);
	        if (temp.getId() == objectId.bricks || temp.getId() == objectId.stone) {
	            if (getBounds().intersects(temp.getBounds())) {
	                setY((float) (temp.getY() - getHeight()));
	                setVelY(0);
	            }
	            if (getBoundsTop().intersects(temp.getBounds())) {
	                setY((float) (temp.getY() + temp.getHeight()));
	                setVelY(0);
	            }
				if(getBoundsRight().intersects(temp.getBounds())) {
					setVelX(-1);
					n=2;
			        setX((float) (getX() +getVelX()));
					
				}
				if(getBoundsLeft().intersects(temp.getBounds())) {
					setVelX(speed);
					n=2;
			        setX((float) (getX() + getVelX()));
				}
			}
	        
	        
	        if (temp.getId() == objectId.imroatus) {
	            if (getBounds().intersects(temp.getBounds())) {
	                setY((float) (temp.getY() - getHeight()));
	                setVelY(0);
	            }
	            if (getBoundsTop().intersects(temp.getBounds())) {
	                setX(-6000);
	            }
			}
		}
	}

	public Animation getGura_walk() {
		return gura_walk;
	}

	public void setGura_walk(Animation gura_walk) {
		this.gura_walk = gura_walk;
	}
}
