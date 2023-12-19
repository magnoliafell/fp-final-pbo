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

public class Imroatus extends gameObject {
	public static final double  WIDTH = 32, HEIGHT=64;
//	public static final double  WIDTH = 96, HEIGHT=96;
	
	private  handler handler;
	private Texture text;
	private BufferedImage[] sprite;
	private BufferedImage[] currSprite;
	private Animation currAnimation;
	private Animation imr_walk;
	private boolean forward=false;
	private gameEngine game;
	private Coin coin;
	private int points;
	public int jumpCount = 0;
	public boolean jumping = false;
	public boolean canJump = true;
	public boolean hasJumped() {
		return jumping;
	}
	
	public void resetPosition() {
		setX(80);
		setY(80);
	}
	
	public void setJump(boolean hasJumped){
		jumping = hasJumped();
	}
	public Imroatus(int x, int y, int scale, handler handler) {
		super(x, y, objectId.imroatus, scale, WIDTH, HEIGHT);
		this.handler= handler;
		text= gameEngine.getTex();
		sprite= text.getImroatus_1();
		points = 0;
		imr_walk = new Animation(9, sprite[1], sprite[2], sprite[3], sprite[4]);
		currSprite = sprite;
		currAnimation = imr_walk;
		
	}

	@Override
	public void tick() {
		if (!jumping) {
            jumpCount = 0; 
            canJump = true; 
		}
		if (getX() <= 0) {
	        setX(0);
	    }
	    setX((float) (getVelX() + getX()));
	    setY((float) (getVelY() + getY()));
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
		if(jumping) {
			if(forward) {
				g.drawImage(currSprite[4], (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);
			}else {
				g.drawImage(currSprite[4], (int) getX()+ (int) getWidth(), (int) getY(), (int) -getWidth(), (int) getHeight(), null);
			}
		}else if (getVelX()>0) {
			currAnimation.drawAnimation(g,(int) getX(), (int) getY(), (int) getWidth(), (int) getHeight());
			forward=true;
		}else if(getVelX()<0) {
			currAnimation.drawAnimation(g,(int) getX()+ (int) getWidth(), (int) getY(), (int) -getWidth(), (int) getHeight());
			forward=false;
		}else {
			g.drawImage(currSprite[0], (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);
		}
//		
//		showBounds(g);
	}
	
	public void acquirePoints(int point){
        points = points + point;
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
	        if (temp.getId() == objectId.bricks) {
	            if (getBounds().intersects(temp.getBounds())) {
	                setY((float) (temp.getY() - getHeight()));
	                setVelY(0);
	                jumping = false;
	                canJump = true;
	            }
	            if (getBoundsTop().intersects(temp.getBounds())) {
	                setY((float) (temp.getY() + temp.getHeight()));
	                setVelY(0);
	            }
				if(getBoundsRight().intersects(temp.getBounds())) {
					setX((float) (temp.getX()- getWidth()));
					
				}
				if(getBoundsLeft().intersects(temp.getBounds())) {
					setX((float) (temp.getX()+getWidth()));
				}
			}
	        
//	        if (temp.getId() == objectId.coin) {
//	            if (getBounds().intersects(temp.getBounds())) {
//	                setY((float) (temp.getY() - getHeight()));
//	                setVelY(0);
//	                coin.setY(-6000);
//	                jumping = false;
//	                canJump = true;
//	            }
//	            if (getBoundsTop().intersects(temp.getBounds())) {
//	                setY((float) (temp.getY() + temp.getHeight()));
//	                setVelY(0);
//	                
//	            }
//				if(getBoundsRight().intersects(temp.getBounds())) {
//					setX((float) (temp.getX()- getWidth()));
//					
//				}
//				if(getBoundsLeft().intersects(temp.getBounds())) {
//					setX((float) (temp.getX()+getWidth()));
//				}
//			}
//	        
	        if (temp.getId() == objectId.guraGurita) {
	            if (getBounds().intersects(temp.getBounds())) {
	                setY((float) (temp.getY() - getHeight()));
	                setVelY(0);
	            }
				if(getBoundsRight().intersects(temp.getBounds())) {
					 setX(-6000);
				}
				if(getBoundsLeft().intersects(temp.getBounds())) {
					 setX(-6000);
				}
			}
	        
//	        if (temp.getId() == objectId.coin) {
//				if(getBoundsRight().intersects(temp.getBounds())) {
//					setX((float) (temp.getX()- getWidth()));
//				}
//				if(getBoundsLeft().intersects(temp.getBounds())) {
//					setX((float) (temp.getX()- getWidth()));
//				}
//			}
	       
		}
	}
	
	public void jump() {
        if (!jumping && canJump) { 
            setVelY(-10); 
            jumping = true;
            canJump = false; 
        }
    }

}

