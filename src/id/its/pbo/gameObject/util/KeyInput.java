//package id.its.pbo.gameObject.util;
//
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//
//public class KeyInput extends KeyAdapter {
//	private boolean[] keyDown = new boolean[4];
//	private handler handler;
//	
//	public KeyInput(handler handler) {
//		this.handler = handler;
//	}
//	
//	@Override
//	public void keyPressed (KeyEvent e) {
//		int key = e.getKeyCode();
//		
//		if (key == KeyEvent.VK_ESCAPE) {
//			System.exit(0);
//		}
//		
//		if (key == KeyEvent.VK_UP) {
//			if (!handler.getImroatus().hasJumped()) {
//				handler.getImroatus().setVelY(-15);
//				keyDown[0] = true;
//				handler.getImroatus().setJump(true);
//			}
//		}
//		
//		if (key == KeyEvent.VK_LEFT) {
//			handler.getImroatus().setVelX(-5);
//			keyDown[1] = true;
//		}
//		
//		if (key == KeyEvent.VK_D) {
//			handler.getImroatus().setVelX(5);
//			keyDown[2] = true;
//		}
//		
//		if (key == KeyEvent.VK_DOWN) {
//			handler.getImroatus().setVelX(5);
//			keyDown[3] = true;
//		}
//	}
//	
//	@Override
//	public void keyReleased (KeyEvent e) {
//		int key = e.getKeyCode();
//		
//		if (key == KeyEvent.VK_UP) {
//			keyDown[0] = false;
//		}
//		
//		if (key == KeyEvent.VK_LEFT) {
//			keyDown[1] = false;
//		}
//		
//		if (key == KeyEvent.VK_D) {
//			keyDown[2] = false;
//		}
//		if (!keyDown[1] && !keyDown[2]) {
//			handler.getImroatus().setVelX(0);
//		}
//	}
//	
//	@Override
//	public void keyPressed(KeyEvent e) {
//	    int key = e.getKeyCode();
//
//	    if (key == KeyEvent.VK_ESCAPE) {
//	        System.exit(0);
//	    }
//
//	    if (key == KeyEvent.VK_UP) {
//	        if (!handler.getImroatus().hasJumped()) {
//	            handler.getImroatus().setVelY(-15);
//	            handler.getImroatus().setJump(true);
//	        }
//	    }
//
//	    if (key == KeyEvent.VK_LEFT) {
//	        handler.getImroatus().setVelX(-10);
//	    }
//
//	    if (key == KeyEvent.VK_RIGHT) {
//	        handler.getImroatus().setVelX(10);
//	    }
//	}
//
//	@Override
//	public void keyReleased(KeyEvent e) {
//	    int key = e.getKeyCode();
//
//	    if (key == KeyEvent.VK_UP) {
//	    	keyDown[0] = false;
//	    }
//
//	    if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
//	        handler.getImroatus().setVelX(0);
////	    }
////	}
//}

//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//
//import id.its.pbo.gameObject.Imroatus;
//
//public class KeyInput extends KeyAdapter {
//    private handler handler;
//
//    public KeyInput(handler handler) {
//        this.handler = handler;
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        int key = e.getKeyCode();
//
//        if (key == KeyEvent.VK_ESCAPE) {
//            System.exit(0);
//        }
//
//        Imroatus imroatus = handler.getImroatus(); // Retrieve Imroatus object once
//
//        if (imroatus != null) {
//            if (key == KeyEvent.VK_UP) {
//                if (!imroatus.hasJumped()) {
//                    imroatus.setVelY(-15);
//                    imroatus.setJump(true);
//                }
//                if (key == KeyEvent.VK_LEFT) {
//                    imroatus.setVelX(-5);
//                }
//
//                if (key == KeyEvent.VK_RIGHT) {
//                    imroatus.setVelX(5);
//                }
//
//                if (key == KeyEvent.VK_DOWN) {
//                    imroatus.setVelX(5);
//                }
//                
//
//                
//            }
//        }
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//        int key = e.getKeyCode();
//
//        Imroatus imroatus = handler.getImroatus(); // Retrieve Imroatus object once
//
//        if (imroatus != null) { // Check if Imroatus is not null
//            if (key == KeyEvent.VK_UP) {
//
//}
//
//            if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_D) {
//                imroatus.setVelX(0);
//            }
//        }
//    }
//}
//

package id.its.pbo.gameObject.util;

import id.its.pbo.gameObject.Imroatus;
import id.its.pbo.gameObject.gameObject;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private handler handler;
    
    public KeyInput(handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (gameObject obj : handler.getGameObject()) {
            if (obj.getId() == objectId.imroatus) {
                Imroatus imroatus = (Imroatus) obj;
                if (key == KeyEvent.VK_LEFT) {
                    imroatus.setVelX(-5);
//                    if(handler.getImroatus()==null){
//                    	
//                    }
                }
                if (key == KeyEvent.VK_RIGHT) {
                    imroatus.setVelX(5); 
                }
                if (key == KeyEvent.VK_UP) {
                	if (!imroatus.jumping && imroatus.jumpCount < 2 && imroatus.canJump) {
                        imroatus.setVelY(-10);
                        imroatus.jumping = true;
                        imroatus.canJump = false;
                        imroatus.jumpCount++;
                    }
                    
                }
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (gameObject obj : handler.getGameObject()) {
            if (obj.getId() == objectId.imroatus) {
                Imroatus imroatus = (Imroatus) obj;
                if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
                    imroatus.setVelX(0);
                }
            }
        }
    }
}

