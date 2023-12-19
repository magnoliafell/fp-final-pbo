package id.its.pbo.main.util;

import java.awt.image.BufferedImage;

import id.its.pbo.graphic.BufferImageLoader;
import id.its.pbo.gameObject.Coin;
import id.its.pbo.gameObject.Ground;
import id.its.pbo.gameObject.GuraGurita;
import id.its.pbo.gameObject.Hiasan;
import id.its.pbo.gameObject.util.handler;

public class LevelHandler {
	private final String root_folder = "/media";
	private BufferImageLoader load;
	private BufferedImage levelTiles;
	private handler handler;
	private Coin coinImr;
	public LevelHandler(handler handler){
		this.handler = handler;
		load = new BufferImageLoader();
		
	}
	
	public void start() {
		setLevel(root_folder + "/nyoba.png");
		setCoin(root_folder + "/nyoba.png");
		setEnemy(root_folder + "/gura_position.png");
//		loadChar();
	}
	
	private void setCoin(String path) {
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
				
				if(red == 250 && green == 188 && blue == 28) {
					handler.addObject(new Coin(i*32-96, j*32-15, 1, 48, 48, 0, handler));
				}else if(red == 252 && green == 188 && blue == 28) {
					handler.addObject(new Coin(i*32-96, j*32-15, 1, 48, 48, 1, handler));
				}else if(red == 255 && green == 188 && blue == 28) {
					handler.addObject(new Coin(i*32-96, j*32-15, 1, 48, 48, 2, handler));
				}else if(red == 200 && green == 188 && blue == 28) {
					handler.addObject(new Coin(i*32-96, j*32-15, 1, 48, 48, 3, handler));
				}else if(red == 205 && green == 188 && blue == 28) {
					handler.addObject(new Coin(i*32-96, j*32-15, 1, 48, 48, 4, handler));
				}else if(red == 215 && green == 188 && blue == 28) {
					handler.addObject(new Coin(i*32-96, j*32-15, 1, 48, 48, 5, handler));
				}else if(red == 220 && green == 188 && blue == 28) {
					handler.addObject(new Coin(i*32-96, j*32-15, 1, 48, 48, 6, handler));
				}else if(red == 225 && green == 188 && blue == 28) {
					handler.addObject(new Coin(i*32-96, j*32-15, 1, 48, 48, 7, handler));
				}else if(red == 228 && green == 188 && blue == 28) {
					handler.addObject(new Coin(i*32-96, j*32-15, 1, 48, 48, 8, handler));
				}else if(red == 232 && green == 188 && blue == 28) {
					handler.addObject(new Coin(i*32-96, j*32-15, 1, 48, 48, 9, handler));
				}else if(red == 100 && green == 27 && blue == 74) {
					handler.addObject(new Coin(i*32-96, j*32-15, 1, 48, 48, 10, handler));
				}else if(red == 97 && green == 27 && blue == 74) {
					handler.addObject(new Coin(i*32-96, j*32-15, 1, 48, 48, 11, handler));
				}else if(red == 90 && green == 27 && blue == 74) {
					handler.addObject(new Coin(i*32-96, j*32-15, 1, 48, 48, 12, handler));
				}else if(red == 200 && green == 27 && blue == 74) {
					handler.addObject(new Coin(i*32-96, j*32-15, 1, 48, 48, 13, handler));
				}
				
				
				
			}
		}
	}
	public int getTotalPoints() {
	    return coinImr.getPoint();
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
					handler.addObject(new GuraGurita(i*32-128, j*32-15, 1, handler));
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
			for(int j = 0; j<19; j++) {
				int pixel = levelTiles.getRGB(i, j);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if(red == 212 && green == 46 && blue == 206) {
					handler.addObject(new Ground(i*32-128, j*32-15, 1, 32, 32, 1));
				} else if (red == 52 && green == 27 && blue ==74) {
					handler.addObject(new Ground(i*32-128, j*32-15, 1, 32, 32, 2));
				} else if (red == 34 && green == 158 && blue == 14) {
					handler.addObject(new Ground(i*32-128, j*32-15, 1, 32, 32, 3));
				} else if (red == 124 && green == 242 && blue == 105) {
					handler.addObject(new Ground(i*32-128, j*32-15, 1, 32, 32, 4));
				} else if (red == 237 && green == 229 && blue == 30) {
					handler.addObject(new Ground(i*32-128, j*32-15, 1, 32, 32, 5));
				}  else if (red == 95 && green == 91 && blue == 7) {
					handler.addObject(new Ground(i*32-128, j*32-15, 1, 32, 32, 6));
				} else if (red == 244 && green == 240 && blue == 136) {
					handler.addObject(new Ground(i*32-128, j*32-15, 1, 32, 32, 7));
				} else if (red == 100 && green == 61 && blue == 83) {
					handler.addObject(new Hiasan(i*32-128, j*32-15, 1, 32, 32, 0));
				} else if (red == 110 && green == 61 && blue == 83) {
					handler.addObject(new Hiasan(i*32-128, j*32-15, 1, 32, 32, 1));
				} 
				else if (red == 100 && green == 244 && blue == 205) {
					handler.addObject(new Hiasan(i*32-128, j*32-15, 1, 32, 32, 2));
				} else if (red == 120 && green == 244 && blue == 205) {
					handler.addObject(new Hiasan(i*32-128, j*32-15, 1, 32, 32, 3));
				}
			}
		}
	}

}
