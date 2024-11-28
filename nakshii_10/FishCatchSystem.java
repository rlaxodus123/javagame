package nakshii_10;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FishCatchSystem extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent e) {
			if(Nakshicommon.game == null) {
				return;
			}
			if(e.getKeyCode() == KeyEvent.VK_W){
				
			}
			else if(e.getKeyCode() == KeyEvent.VK_A){
				
			}
			else if(e.getKeyCode() == KeyEvent.VK_S){
	
			}
			else if(e.getKeyCode() == KeyEvent.VK_D){
	
			}
				
		}
		@Override
		public void keyReleased(KeyEvent e) {
			if(Nakshicommon.game == null) {
				return;
			}
			
			if(e.getKeyCode() == KeyEvent.VK_W){
				
			}
			else if(e.getKeyCode() == KeyEvent.VK_A){
				
			}
			else if(e.getKeyCode() == KeyEvent.VK_S){
	
			}
			else if(e.getKeyCode() == KeyEvent.VK_D){
	
			}
		}
					
}
