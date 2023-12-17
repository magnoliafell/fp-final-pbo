package id.its.pbo.graphic;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferImageLoader {
	private BufferedImage img;
	
	public BufferedImage loadImage(String path) {
		try {
			img = ImageIO.read(getClass().getResource(path));
		} catch(IOException e) {
			e.printStackTrace();
		}
		return img;
	}
}
