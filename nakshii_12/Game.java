package nakshii_12;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;





public class Game extends JFrame {
	
    private Random random;
	private Image screenImage;
	private Graphics screenGraphic;

	/*
	private ImageIcon FishButtonEnterImage = new ImageIcon(Main.class.getResource("../images/fish.jpg"));
	private ImageIcon FishButtonPressedImage = new ImageIcon(Main.class.getResource("../images/fishpressed.jpg"));
	private JButton FishButton = new JButton(FishButtonEnterImage);

    	public ImageIcon getFishButtonEnterImage() {
    		return FishButtonEnterImage;
    	}

    	public ImageIcon getFishButtonPressedImage() {
    		return FishButtonPressedImage;
    	}

    	public JButton getFishButton() {
    		return FishButton;
    	}
    	
    	
    public void fishapear() { 
        Random rand = new Random();
        int maxX = 1000;
        int maxY = 600;
        int minX = 200;
        int minY = 200;
        
        
        int randomX = rand.nextInt(maxX); // x 좌표 랜덤 (버튼 크기 고려)
        int randomY = rand.nextInt(maxY); // y 좌표 랜덤 (버튼 크기 고려)
        
        // 버튼의 위치 설정
        FishButton.setBounds(randomX, randomY, 185, 59);   
    	getFishButtonEnterImage();
    	getFishButtonPressedImage();
    	getFishButton();
    	FishButton.setBounds(800, 400, 185,59);
        FishButton.setBorderPainted(true);
        FishButton.setContentAreaFilled(true);
        FishButton.setFocusPainted(true);
        FishButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				FishButton.setIcon(FishButtonPressedImage);
				FishButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				FishButton.setIcon(FishButtonEnterImage);
				FishButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				//게임 진행
				
			}
		});
		add(FishButton);
		System.out.print("game class working");
		FishButton.setVisible(true);
		
		
		System.out.print("game class working");
		
		revalidate();
		repaint();
		
 
    }
    */
}