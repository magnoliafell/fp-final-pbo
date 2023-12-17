package id.its.pbo.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import id.its.pbo.gameObject.Coin;
import id.its.pbo.gameObject.Ground;
import id.its.pbo.gameObject.Imroatus;
import id.its.pbo.gameObject.util.KeyInput;
import id.its.pbo.gameObject.util.handler;
import id.its.pbo.graphic.Camera;
import id.its.pbo.graphic.Frame;
import id.its.pbo.graphic.Texture;
import id.its.pbo.main.util.LevelHandler;
//import id.its.pbo.graphic.Texture;

public class gameEngine extends Canvas implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int mili_per_second = 1000;
	private static final int nano_per_second = 1000000000;
	private static final double tick_per_update = 80.0;
	private static final int screen_width = 1440 - 67;
	private static final int screen_height = 1024;
	private static final int screen_offset = 16*3;
	Imroatus imroatus;
	//Image img = Toolkit.getDefaultToolkit().createImage("background.png");

	private boolean running;
	private handler handler;
	private Thread thread;
	private Camera camera;
	private static Texture tex;
	private Ground gameGround;
	private Coin coinImr;
	private LevelHandler level;
	boolean resetPosition;
	public gameEngine () {
		initialize();
		resetPosition = false;
	}
	
	public void initialize() {
//		handler = new handler();
//		new Frame(300, 600, "Imroatus", this);
////		handler.setImroatus(new Imroatus(32,32,1,handler));
//		Imroatus imroatus = new Imroatus(32, 32, 1, handler);
//	    handler.addObject(imroatus);
//	    KeyInput k = new KeyInput(handler);
//		this.addKeyListener(k);
//		start();
//		handler = new handler();
//        new Frame(300, 600, "Imroatus", this);
//        Imroatus imroatus = new Imroatus(32, 32, 1, handler);
//        handler.addObject(imroatus);
//        handler.setImroatus(imroatus);
//        this.addKeyListener(new KeyInput(handler));
//        setFocusable(true);
//		requestFocus();
//        start();
			
	        handler = new handler();
	        new Frame(1440, 1024, "Imroatus", this);
	        setTex(new Texture());
	        imroatus = new Imroatus(80, 80, 1, handler);
	        
	        handler.setImroatus(imroatus);
	        handler.addObject(imroatus);
	        level = new LevelHandler(handler);
	        level.start();
//	        for(int i=0; i<20; i++) {
//	        	handler.addObject(new Ground(i*32, 32*10, 1, 32, 32));
//	        }
//	        for(int i=0; i<20; i++) {
//	        	handler.addObject(new Ground(i*(32) + 700, 32*10, 1, 32, 32));
//	        }
//	        for(int i=0; i<1000; i++) {
//	        	handler.addObject(new Ground(i*32, 32*15, 1, 32, 32));
//	        }
//	        for(int i=0; i<1000; i++) {
//	        	handler.addObject(new Ground(i*32, 32*15, 1, 32, 32));
//	        }
	        camera = new Camera(0, screen_offset);
//	        gameGround = new Ground(96, 96, 1, 96, 96);
	        this.addKeyListener(new KeyInput(handler));
	        start();
			setFocusable(true);
			requestFocus();

	}
	
	public static void main(String args[]) {
		new gameEngine();
	}
	
	public synchronized void start() {
		thread = new Thread (this);
		thread.start();
		running = true;

	}
	
	public synchronized void stop() {
		try{
			running = false;
			thread.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = tick_per_update;
		double nanoSecond = nano_per_second/amountOfTicks;
		long timer = System.currentTimeMillis();
		double delta = 0;
		int frame = 0;
		int update = 0;
		
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime)/nanoSecond;
			lastTime = now;
			while (delta >=1) {
				tick();
				update++;
				delta--;
			}
			
			if (running) {
				render();
				frame++;
			}
			
			if (System.currentTimeMillis() - timer > mili_per_second) {
				timer += mili_per_second;
				System.out.println("FPS: " + frame + " TPS: " + update);
				frame = 0;
				update = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		handler.tick();
		camera.tick(imroatus);
		if (imroatus.getY() > 1250) {
//			stop();
//			running = false;
//			handler.removeObject(gameGround);
//	        initialize();
			resetGame();
	    }
//		camera.tick(imroatus, screen_width, screen_height);
	}
	
	
	public void resetGame() {
		handler.removeObject(imroatus);
		handler.removeObject(gameGround);
		imroatus.resetPosition();
		handler.addObject(imroatus);
        level = new LevelHandler(handler);
        level.start();
//		initialize();
//		imroatus.resetPosition();
//		handler.addObject(imroatus);
	}

	private void render() {
		BufferStrategy buff = this.getBufferStrategy();
		if (buff == null) {
			this.createBufferStrategy(4);
			return;
		}
		Graphics g = buff.getDrawGraphics();
//		g.setColor(Color.WHITE);
//		g.drawImage(img, 0, 0, null);
//		BufferedImage background = null;
//		try {
//		    // Load the image using a relative path
//		    background = ImageIO.read(getClass().getResource("/media/bg.png"));
//		} catch (IOException e) {
//		    e.printStackTrace();
//		}
//	    if (background != null) {
//	        // Draw the background image
//	        g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
//	    } else {
//	        // If the image loading fails, fill the background with a solid color
//	        g.setColor(Color.WHITE);
//	        g.fillRect(0, 0, 1440, 1024);
//	    }
        g.setColor(Color.black);
        g.fillRect(0, 0, 1440, 1024);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(camera.getX(), camera.getY());
		
		
//		gameGround.render(getGraphics());
//		handler.render(getGraphics());
		handler.render(g);
		g2d.translate(-camera.getX(), -camera.getY());
		g.dispose();
		buff.show();
	}

	public static void setTex(Texture tex) {
		gameEngine.tex = tex;
	}

	public static Texture getTex() {
		// TODO Auto-generated method stub
		return tex;
	}

	public Coin getCoinImr() {
		return coinImr;
	}

	public void setCoinImr(Coin coinImr) {
		this.coinImr = coinImr;
	}

	
}
