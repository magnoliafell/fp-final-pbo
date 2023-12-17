package id.its.pbo.gameObject;

import java.awt.Graphics;
import java.awt.Rectangle;

import id.its.pbo.gameObject.util.objectId;

public abstract class gameObject {
	private float x;
	private float y;
	private objectId id;
	private double velX;
	private double velY;
	private double width;
	private double height;
	private int scale;
	
	public gameObject(float x, float y, objectId id, int scale, double width, double height) {
		this.x = x * scale;
		this.y = y * scale;
		this.id = id;
		this.scale = scale;
		this.width = width * scale;
		this.height = height * scale;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	
	public void applyGravity() {
		velY += 0.5f;
	}
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public objectId getId() {
		return id;
	}

	public void setId(objectId id) {
		this.id = id;
	}

	public double getVelX() {
		return velX;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height*scale;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}
}
