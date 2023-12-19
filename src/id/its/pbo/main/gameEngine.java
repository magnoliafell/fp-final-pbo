package id.its.pbo.main;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

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

public class gameEngine extends Canvas implements Runnable{
	
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
	private JFrame frame;
	private JFrame frame2;
	
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
	private static int resetCount = 0;
	private static int a = 0;
	
	public gameEngine () {
		frame = new JFrame("Imroatus");
		showStartScreen();
//		initialize();
		resetPosition = false;
	}
	
	
	private void showStartScreen() {
		frame.getContentPane().removeAll();
	    frame.repaint();
	    JPanel startPanel = new JPanel();
	    startPanel.setLayout(null); 
	    startPanel.setPreferredSize(new Dimension(1440, 1024));
	    startPanel.setBackground(Color.BLACK);
	    
	    JButton startButton = new JButton();
	    JButton level2 = new JButton();
	    JButton reviewButton = new JButton();
	  //  startButton.setPreferredSize(new Dimension(600, 65));
	    startButton.setBounds(315, 253, 600, 65);
	    level2.setBounds(315, 339, 600, 65);
	    reviewButton.setBounds(315, 425, 600, 65);
	    startButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if (a == 0) {
		        	initialize();
		        	frame.dispose();
	        	} else {
//	        		frame2.setVisible(true);
	        		resetGame();
	        	//	frame.dispose();
	        	}
	        	
	            
	        }
	    });
	    level2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	showGameOverPanel(2);           
	        }
	    });
	    reviewButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	showGameOverPanel(2);
	        	
	            
	        }
	    });
	   // try {
//		    // Load the image using a relative path
//		    background = ImageIO.read(getClass().getResource("/media/bg.png"));
//		} catch (IOException e) {
//		    e.printStackTrace();
//		}
	    
	    try {
	    	BufferedImage img = ImageIO.read(getClass().getResource("/media/startbg.png"));
	        JLabel backgroundLabel = new JLabel(new ImageIcon(img));
	        backgroundLabel.setBounds(0, 0, img.getWidth(), img.getHeight());
	        startPanel.add(backgroundLabel);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    startButton.setOpaque(false);
	    startButton.setContentAreaFilled(false);
	    startButton.setBorderPainted(true);
	    level2.setOpaque(false);
	    reviewButton.setOpaque(false);
	   // startButton.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
	    

	   // startButton.setBorder((Border) Color.blue);
	    startPanel.add(startButton);
	    startPanel.add(level2);
	    startPanel.add(reviewButton);
	    
	    frame.getContentPane().add(startPanel);
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
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
	        frame2 = new JFrame("Imroatus");
	        frame2.setSize(1440, 1024);
	        frame2.setPreferredSize(new Dimension(1440, 1024));
	        frame2.add(this);
	        frame2.pack();
	        frame2.setLocationRelativeTo(null);
	        this.createBufferStrategy(3);
	        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame2.setVisible(true);
	        setTex(new Texture());
	        imroatus = new Imroatus(80, 80, 1, handler);
	        handler.setImroatus(imroatus);
	        handler.addObject(imroatus);
	        level = new LevelHandler(handler);
	        level.start();
	        
	      //  coinImr = new Coin(boundsOp, boundsOp, boundsOp, boundsOp, boundsOp, boundsOp, handler);
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
//	public int getTotalPoints() {
//	    return coinImr.getPoint();
//	}

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
		if (imroatus.getX() > 10500) {
			showGameOverPanel(1);
			stop();
		}
		if (resetCount > 1) {
			showGameOverPanel(3);
			stop();
		}
		if (imroatus.getY() > 1250) {
			resetGame();
			resetCount++;
	    }
//		camera.tick(imroatus, screen_width, screen_height);
	}
	
	private void showGameOverPanel(int n) {
		frame.getContentPane().removeAll();
	    frame.repaint();
	    String path = null;

	    JButton endButton = new JButton();
	  //  endButton.setPreferredSize(new Dimension(600, 65));
	    endButton.setBounds(0, 0, 1440, 1024);
	    endButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	       
	        	if (n==2) {
	        		frame.setVisible(false);
		            frame2.dispose();
		            showStartScreen();
		            a = 1;
		            resetCount = 0;
	        	} else {
	        		frame.setVisible(false);
		            showStartScreen();
//		            a = 1;
//		        	frame.dispose();
//		            resetGame();
	        	}
	            
	        }
	    });
	   // try {
//		    background = ImageIO.read(getClass().getResource("/media/bg.png"));
//		} catch (IOException e) {
//		    e.printStackTrace();
//		}
	    endButton.setOpaque(true);
	    endButton.setContentAreaFilled(false);
	    endButton.setBorderPainted(true);
	   // endButton.setBorder(BorderFactory.createLineBorder(Color.YELLOW));

	    JPanel gameOverPanel = new JPanel();
	    gameOverPanel.setLayout(null);
	    gameOverPanel.setBackground(Color.BLACK);
	    gameOverPanel.setPreferredSize(new Dimension(1440, 1024));
	    try {
	    	if (n == 1) {
	    		path = "/media/youwin.png";
	    	} else if(n==3){
	    		path = "/media/gameover.png";
	    	}else if(n==2){
	    		path = "/media/comingsoon.png";
	    	}
	        BufferedImage gameOverImage = ImageIO.read(getClass().getResource(path));
	        JLabel backgroundLabel = new JLabel(new ImageIcon(gameOverImage));
	        backgroundLabel.setBounds(0, 0, gameOverImage.getWidth(), gameOverImage.getHeight());
	        gameOverPanel.add(backgroundLabel);
	    } catch (IOException e1) {
	        e1.printStackTrace();
	    }
	    gameOverPanel.add(endButton);
	    frame.getContentPane().add(gameOverPanel);
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    
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
//	String jumlah = level.getTotalPoints()+"";
	private void render() {
		BufferStrategy buff = this.getBufferStrategy();
		if (buff == null) {
			this.createBufferStrategy(4);
			return;
		}
		Graphics g = buff.getDrawGraphics();
		//System.out.println("Total Points: " + getTotalPoints());
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
		g.setColor(new Color(0x130D25));
        g.fillRect(0, 0, 1440, 1024);
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(camera.getX(), camera.getY());
		
		
//		gameGround.render(getGraphics());
//		handler.render(getGraphics());
		handler.render(g);
		g2d.translate(-camera.getX(), -camera.getY());
		g.dispose();
		buff.show();
//		g2d.setColor(Color.WHITE);
//	    g2d.setFont(new Font("Arial", Font.BOLD, 20)); // Set font for points display
//	    g2d.drawString("Points: " + String.valueOf(level.getTotalPoints()), 20, 40); // Modify the position as needed

//		g.drawString(jumlah, 720, 50);
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
