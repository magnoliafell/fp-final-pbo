//package id.its.pbo.graphic;
//
//import java.awt.Graphics;
//import java.awt.Image;
//import java.util.Timer;
//
//import javax.swing.ImageIcon;
//
//public class Scrolling {
//	Image img;
//	Timer time = new Timer();
//	
//	int imgWidth = 12799;
//	int imgHeight = 1024;
//	int x = 0;
//	int move;
//	
//	public Scrolling() {
//		ImageIcon obj = new ImageIcon("/media/b.png");
//		img = obj.getImage();
//		move = 1;
//	}
//	
//	public void tick() {
//		// Update the x position for scrolling effect
//        x += move;
//        
//        // Reset the background to the beginning once it scrolls off the screen
//        if (x >= imgWidth) {
//            x = 0;
//        }
//    }
//
//    public void render(Graphics g) {
//        // Draw the background at current and next positions for seamless scrolling
//        g.drawImage(img, -x, 0, null);
//        g.drawImage(img, imgWidth - x, 0, null);
//    }
//	
//}
