package id.its.pbo.main.util;

import java.awt.image.BufferedImage;

import id.its.pbo.graphic.BufferImageLoader;
import id.its.pbo.gameObject.Coin;
import id.its.pbo.gameObject.Ground;
import id.its.pbo.gameObject.GuraGurita;
import id.its.pbo.gameObject.util.handler;

public class LevelHandler {
	private final String root_folder = "/media";
	private BufferImageLoader load;
	private BufferedImage levelTiles;
	private handler handler;
	
	public LevelHandler(handler handler){
		this.handler = handler;
		load = new BufferImageLoader();
		
	}
	
	public void start() {
		setLevel(root_folder + "/levelLengkap.png");
		setCoin(root_folder + "/coin.png");
		setEnemy(root_folder + "/gura_position.png");
//		loadChar();
	}
	
	private void setCoin(String path) {
		// TODO Auto-generated method stub
		this.levelTiles = load.loadImage(path);
		int width = levelTiles.getWidth();
		int height = levelTiles.getHeight();
		for(int i = 0; i<342; i++) {
			for(int j = 0; j<17; j++) {
				int pixel = levelTiles.getRGB(i, j);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if(red == 250 && green == 288 && blue == 28) {
					handler.addObject(new Coin(i*32-128, j*32+96, 1, 32, 32, 1));
				}
				
			}
		}
	}

	public void setEnemy(String path) {
		this.levelTiles = load.loadImage(path);
		int width = levelTiles.getWidth();
		int height = levelTiles.getHeight();
		for(int i = 0; i<342; i++) {
			for(int j = 0; j<17; j++) {
				int pixel = levelTiles.getRGB(i, j);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if(red == 232 && green == 25 && blue == 25) {
					handler.addObject(new GuraGurita(i*32-128, j*32+96, 1, handler));
				}
				
			}
		}
	}

	private void setLevel(String path) {
		// TODO Auto-generated method stub
		this.levelTiles = load.loadImage(path);
		int width = levelTiles.getWidth();
		int height = levelTiles.getHeight();
		for(int i = 0; i<341; i++) {
			for(int j = 0; j<17; j++) {
				int pixel = levelTiles.getRGB(i, j);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if(red == 212 && green == 46 && blue == 206) {
					handler.addObject(new Ground(i*32-128, j*32+96, 1, 32, 32, 1));
				} else if (red == 52 && green == 27 && blue ==74) {
					handler.addObject(new Ground(i*32-128, j*32+96, 1, 32, 32, 2));
				} else if (red == 34 && green == 158 && blue == 14) {
					handler.addObject(new Ground(i*32-128, j*32+96, 1, 32, 32, 3));
				} else if (red == 124 && green == 242 && blue == 105) {
					handler.addObject(new Ground(i*32-128, j*32+96, 1, 32, 32, 4));
				} else if (red == 237 && green == 229 && blue == 30) {
					handler.addObject(new Ground(i*32-128, j*32+96, 1, 32, 32, 5));
				}  else if (red == 95 && green == 91 && blue == 7) {
					handler.addObject(new Ground(i*32-128, j*32+96, 1, 32, 32, 6));
				} else if (red == 244 && green == 240 && blue == 136) {
					handler.addObject(new Ground(i*32-128, j*32+96, 1, 32, 32, 7));
				}
			}
		}
	}

}
