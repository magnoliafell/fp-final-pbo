package id.its.pbo.graphic;

import java.awt.image.BufferedImage;

public class Texture {
	private static final String rootFolder = "/media";
	private final int imroatus_count=8;
	private final int tile_1_count =7;
	private final int tile_2_count =4;
	private final int gura_count=3;
	private final int coin_count=14;
	private final int hiasan_count=4;
			
	private BufferImageLoader load;
	private BufferedImage imroatus, gura, brick, stone, game_over, intro, coin, hiasan;
	
	public BufferedImage[] imroatus_1, tile_1, tile_2, stone_1, gura_1, coin_1, hiasan_1;
	
	public BufferedImage getCoin() {
		return coin;
	}

	public void setCoin(BufferedImage coin) {
		this.coin = coin;
	}

	public BufferedImage[] getCoin_1() {
		return coin_1;
	}

	public void setCoin_1(BufferedImage[] coin_1) {
		this.coin_1 = coin_1;
	}

	public BufferedImage[] getGura_1() {
		return gura_1;
	}

	public void setGura_1(BufferedImage[] gura_1) {
		this.gura_1 = gura_1;
	}

	public Texture() {
		imroatus_1 = new BufferedImage[imroatus_count];
		gura_1 = new BufferedImage[gura_count];
		tile_1 = new BufferedImage[tile_1_count];
//		tile_2 = new BufferedImage[tile_1_count+tile_2_count];
		stone_1 = new BufferedImage [1];
		coin_1 = new BufferedImage[coin_count];
		hiasan_1 = new BufferedImage[hiasan_count];
		
		load = new BufferImageLoader();
		
		try {
			imroatus=load.loadImage(rootFolder+"/"+"imr.png");
//			imroatus=load.loadImage(rootFolder+"/"+"dokja.png");
			brick=load.loadImage(rootFolder+"/"+"ground.png");
			gura=load.loadImage(rootFolder+"/"+"gura2.png");
			coin=load.loadImage(rootFolder+"/"+"koin.png");
			hiasan=load.loadImage(rootFolder+"/"+"hiasan2.png");
		}catch(Exception e){
			e.printStackTrace();
		}
		getImroatusTexture();
		getBrickTexture();
		getGuraTexture();
		getStoneTexture();
		getCoinTexture();
		getHiasanTexture();
	}
	
	private void getHiasanTexture() {
		int x_off= 0;
		int y_off=0;
		int width=96;
		int height=96;
		
		for ( int i=0; i<tile_2_count; i++) {
			hiasan_1[i]= hiasan.getSubimage(x_off+i*(width), y_off, width, height);
			
		}
		
	}

	public BufferedImage[] getHiasan_1() {
		return hiasan_1;
	}

	public void setHiasan_1(BufferedImage[] hiasan_1) {
		this.hiasan_1 = hiasan_1;
	}

	private void getStoneTexture() {
		// TODO Auto-generated method stub
		
	}
	private void getBrickTexture() {
		int x_off= 0;
		int y_off=0;
		int width=96;
		int height=96;
		
		for ( int i=0; i<tile_1_count; i++) {
			tile_1[i]= brick.getSubimage(x_off+i*(width), y_off, width, height);
			
		}
		
//		for ( int i=0; i<2; i++) {
//			for(int j=0; j<tile_1_count; j++) {
//				if(i==0) {
//					tile_1[j]= brick.getSubimage(x_off+j*(width), y_off, width, height);
//				}else if(i==1) {
//					tile_1[j]= brick.getSubimage(x_off+j*(width), y_off, width, height);
//				}
//			}
//			
//			y_off+=height;
//			
////			for(int j=0; j<tile_2_count; j++) {
////				if(i==0) {
////					tile_2[j]= brick.getSubimage(x_off+j*(width+1), y_off+i*height*2, width, height);
////				}else if(i==1) {
////					tile_2[j]= brick.getSubimage(x_off+j*(width+1), y_off+i*height*2, width, height);
////				}
////			}
//		
//		}
		
		
		
	}
	private void getImroatusTexture(){
		int x_off=0;
		int y_off=0;
		int width=32;
		int height=64;
//		int width=64;
//		int height=64;
		
		for ( int i=0; i<imroatus_count; i++) {
			imroatus_1[i]= imroatus.getSubimage(x_off+i*(width), y_off, width, height);
			
		}
//		imroatus_1[0]= imroatus.getSubimage(x_off, y_off, width, height);
		
//		y_off+=height+1;
//		
//		for ( int i=0; i<imroatus_count; i++) {
//			imroatus_1[i]= imroatus.getSubimage(x_off+i*(width+1), y_off, width, height);
//			
//		}
	}
	private void getGuraTexture(){
		int x_off=0;
		int y_off=0;
		int width=32;
		int height=32;
//		int width=64;
//		int height=64;
		
		for ( int i=0; i<gura_count; i++) {
			gura_1[i]= gura.getSubimage(x_off+i*(width), y_off, width, height);
		}
//		imroatus_1[0]= imroatus.getSubimage(x_off, y_off, width, height);
		
//		y_off+=height+1;
//		
//		for ( int i=0; i<imroatus_count; i++) {
//			imroatus_1[i]= imroatus.getSubimage(x_off+i*(width+1), y_off, width, height);
//			
//		}
	}
	
	private void getCoinTexture(){
		int x_off=0;
		int y_off=0;
		int width=48;
		int height=48;
		
		for ( int i=0; i<coin_count; i++) {
			coin_1[i]= coin.getSubimage(x_off+i*(width), y_off, width, height);
			
		}
	}
	
	
	public BufferImageLoader getLoad() {
		return load;
	}

	public void setLoad(BufferImageLoader load) {
		this.load = load;
	}

	public BufferedImage getImroatus() {
		return imroatus;
	}

	public void setImroatus(BufferedImage imroatus) {
		this.imroatus = imroatus;
	}

	public BufferedImage getBrick() {
		return brick;
	}

	public void setBrick(BufferedImage brick) {
		this.brick = brick;
	}

	public BufferedImage getStone() {
		return stone;
	}

	public void setStone(BufferedImage stone) {
		this.stone = stone;
	}

	public BufferedImage getGame_over() {
		return game_over;
	}

	public void setGame_over(BufferedImage game_over) {
		this.game_over = game_over;
	}

	public BufferedImage getIntro() {
		return intro;
	}

	public void setIntro(BufferedImage intro) {
		this.intro = intro;
	}

	public BufferedImage[] getImroatus_1() {
		return imroatus_1;
	}

	public void setImroatus_1(BufferedImage[] imroatus_1) {
		this.imroatus_1 = imroatus_1;
	}

	public BufferedImage[] getTile_1() {
		return tile_1;
	}

	public void setTile_1(BufferedImage[] tile_1) {
		this.tile_1 = tile_1;
	}

	public BufferedImage[] getTile_2() {
		return tile_2;
	}

	public void setTile_2(BufferedImage[] tile_2) {
		this.tile_2 = tile_2;
	}

	public BufferedImage[] getStone_1() {
		return stone_1;
	}

	public void setStone_1(BufferedImage[] stone_1) {
		this.stone_1 = stone_1;
	}

	public static String getRootfolder() {
		return rootFolder;
	}

	public int getImroatus_count() {
		return imroatus_count;
	}

	public int getTile_1_count() {
		return tile_1_count;
	}

	public int getTile_2_count() {
		return tile_2_count;
	}

	public BufferedImage getGura() {
		return gura;
	}

	public BufferedImage getHiasan() {
		return hiasan;
	}

	public void setHiasan(BufferedImage hiasan) {
		this.hiasan = hiasan;
	}

	public int getHiasan_count() {
		return hiasan_count;
	}

	
	
	
			
	

	
}
