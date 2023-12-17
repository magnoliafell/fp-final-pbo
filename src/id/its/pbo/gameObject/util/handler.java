package id.its.pbo.gameObject.util;
import id.its.pbo.gameObject.*;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

public class handler {
	private List <gameObject> gameObject;
	private Imroatus imroatus;
	public handler() {
		gameObject = new LinkedList<gameObject>();
	}
	
	public void tick() {
		for(gameObject obj : gameObject) {
			obj.tick();
		}
	}
	
	public void render(Graphics g) {
		for(gameObject obj : gameObject) {
			obj.render(g);
		}
	}
	
	public void addObject (gameObject obj) {
		gameObject.add(obj);
	}
	
	public void removeObject (gameObject obj) {
		gameObject.removeAll(getGameObject());
	}
	public int setImroatus(Imroatus imroatus) {
		if (imroatus!=null) {
			return -1;
		}
		addObject(imroatus);
		this.imroatus=imroatus;
		return 0;
		
	}
	public int removeImroatus(Imroatus imroatus) {
		if (imroatus==null) {
			return -1;
		}
		removeObject(imroatus);
		this.imroatus=null;
		return 0;
	}
	public Imroatus getImroatus() {
		return imroatus;
	}
	
	public List<gameObject> getGameObject(){
		return gameObject;
	}
	
}
