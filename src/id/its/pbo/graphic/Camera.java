package id.its.pbo.graphic;

import id.its.pbo.gameObject.gameObject;

public class Camera {
	private int x, y;
	
	public Camera (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void tick(gameObject imroatus) {
		x = (int) (-imroatus.getX()+200);
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
