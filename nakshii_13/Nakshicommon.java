package nakshii_13;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Nakshicommon extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image Bg = new ImageIcon(Main.class.getResource("../images/tempbg.jpg")).getImage();
	private JLabel menubar =  new JLabel(new ImageIcon(Main.class.getResource("../images/uppermenu.jpg")));

	private Image stageui = new ImageIcon(Main.class.getResource("../images/stageui.jpg")).getImage();
	
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exit.jpg"));
	private ImageIcon exitButtonpressedImage = new ImageIcon(Main.class.getResource("../images/exitpressed.jpg"));
	private JButton exitButton = new JButton(exitButtonEnteredImage);  
	
	private int mouseX,mouseY;
	
	private boolean Stages = false;
	private boolean onStage = false;
	private boolean finalScore = false;
	
	private ImageIcon StartButtonEnterImage = new ImageIcon(Main.class.getResource("../images/start.jpg"));
	private ImageIcon StartButtonPressedImage = new ImageIcon(Main.class.getResource("../images/startpressed.jpg"));
	private ImageIcon endButtonEnterImage = new ImageIcon(Main.class.getResource("../images/end.jpg"));
	private ImageIcon endButtonPressedImage = new ImageIcon(Main.class.getResource("../images/endpressed.jpg"));		
	private JButton startButton = new JButton(StartButtonEnterImage);
	private JButton endButton = new JButton(endButtonEnterImage);

	private ImageIcon replayButtonEnterImage = new ImageIcon(Main.class.getResource("../images/start.jpg"));
	private ImageIcon replayButtonPressedImage = new ImageIcon(Main.class.getResource("../images/startpressed.jpg"));
	private JButton replayButton = new JButton(StartButtonEnterImage);
	
	
	private ImageIcon LstagetButtonEnterImage = new ImageIcon(Main.class.getResource("../images/Lstage.jpg"));
	private ImageIcon LstageButtonPressedImage = new ImageIcon(Main.class.getResource("../images/Lstagepressed.jpg"));
	private ImageIcon RstageButtonEnterImage = new ImageIcon(Main.class.getResource("../images/Rstage.jpg"));
	private ImageIcon RstageButtonPressedImage = new ImageIcon(Main.class.getResource("../images/Rstagepressed.jpg"));		
	private JButton LstageButton = new JButton(LstagetButtonEnterImage);
	private JButton RstageButton = new JButton(RstageButtonEnterImage);

	private ImageIcon stagestartButtonEnterImage = new ImageIcon(Main.class.getResource("../images/stagestart.jpg"));
	private ImageIcon stagestartButtonPressedImage = new ImageIcon(Main.class.getResource("../images/stagestartpressed.jpg"));		
	private JButton stagestartButton = new JButton(stagestartButtonEnterImage);
	
	
	
	private ImageIcon backButtonEnterImage = new ImageIcon(Main.class.getResource("../images/back.jpg"));
	private ImageIcon backButtonPressedImage = new ImageIcon(Main.class.getResource("../images/backpressed.jpg"));		
	private JButton backButton = new JButton(backButtonEnterImage);

	
	
	private ImageIcon fishimage;
	private ImageIcon fishimagepressed;
	private JButton FishButton = new JButton(fishimage);
	
	private ImageIcon fishimage1;
	private ImageIcon fishimagepressed1;
	private JButton FishButton1 = new JButton(fishimage1);
	
	private ImageIcon fishimage2;
	private ImageIcon fishimagepressed2;
	private JButton FishButton2 = new JButton(fishimage2);
	
	private ImageIcon fishhide = new ImageIcon(Main.class.getResource("../images/fishhide.png"));
	
	private Image stagename;
	private Image stageselect;
	private int nowSelected = 0;
	
	//ui관련
	private int location = 0;
	private int score = 0;
	private int fishno = 0;
	private String abcdf = "F";
	
	//타이머 관련
	private String Stringsec ;
	int sec = 50; //타이머 시간 50초로 지정

	
	private String screenscore= "000";
	ArrayList<FishingSpot> spotList = new ArrayList<FishingSpot>();
	ArrayList<Fish> fishList = new ArrayList<Fish>();
	ArrayList<Fish> fishList1 = new ArrayList<Fish>();
	ArrayList<Fish> fishList2 = new ArrayList<Fish>();


	public Nakshicommon() {
		setUndecorated(true);
		setTitle("Nakshii");
		setSize(Main.SCREEN_WIDTH , Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0,0,0,0));
		setLayout(null);
		RstageButton.setVisible(false);
		LstageButton.setVisible(false);
		stagestartButton.setVisible(false);
		backButton.setVisible(false);
		FishButton.setVisible(false);
		FishButton1.setVisible(false);
		FishButton2.setVisible(false);
		replayButton.setVisible(false);
		myTimer.interrupt();
		location = 0;
	
		
		spotList.add(new FishingSpot("oceanstage.jpg","stagenameocean.jpg","oceanstageBg.jpg"));
		spotList.add(new FishingSpot("riverstage.jpg","stagenameriver.jpg","riverstageBg.jpg"));
		spotList.add(new FishingSpot("oiknawa.png","stagenameokinawa.jpg","oiknawaBg.png"));
		
		
		
		fishList.add(new Fish("fish1.png","fish1pressed.png"));
		fishList.add(new Fish("fish2.png","fish2pressed.png"));
		fishList.add(new Fish("fish3.png","fish3pressed.png"));
		fishList.add(new Fish("fish4.png","fish4pressed.png"));
		fishList.add(new Fish("fish5.png","fish5pressed.png"));

		fishList1.add(new Fish("fish6.png","fish6pressed.png"));
		fishList1.add(new Fish("fish7.png","fish7pressed.png"));
		fishList1.add(new Fish("fish8.png","fish8pressed.png"));
		fishList1.add(new Fish("fish9.png","fish9pressed.png"));
		fishList1.add(new Fish("fish10.png","fish10pressed.png"));

		fishList2.add(new Fish("fish11.png","fish11pressed.png"));
		fishList2.add(new Fish("fish12.png","fish12pressed.png"));
		fishList2.add(new Fish("fish13.png","fish13pressed.png"));
		fishList2.add(new Fish("fish14.png","fish14pressed.png"));
		fishList2.add(new Fish("fish15.png","fish15pressed.png"));
		
		
		
		exitButton.setBounds(1170, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonpressedImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});

		add(exitButton);
		
		
		startButton.setBounds(800, 400, 185,59);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(StartButtonPressedImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(StartButtonEnterImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				//게임 진행
				selectstage(0);
				finalScore = false;
				startButton.setVisible(false);
				endButton.setVisible(false);
				RstageButton.setVisible(true);
				LstageButton.setVisible(true);
				stagestartButton.setVisible(true);
				backButton.setVisible(true);
				Bg = new ImageIcon(Main.class.getResource("../images/menuimage.png")).getImage();
				Stages = true;
				location = 1;
			}
		});

		add(startButton);
		
		replayButton.setBounds(500, 500, 185,59);
		replayButton.setBorderPainted(false);
		replayButton.setContentAreaFilled(false);
		replayButton.setFocusPainted(false);
		replayButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				replayButton.setIcon(StartButtonPressedImage);
				replayButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				replayButton.setIcon(StartButtonEnterImage);
				replayButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				//게임 진행
				selectstage(0);
				finalScore = false;
				startButton.setVisible(false);
				replayButton.setVisible(false);
				endButton.setVisible(false);
				RstageButton.setVisible(true);
				LstageButton.setVisible(true);
				stagestartButton.setVisible(true);
				backButton.setVisible(true);
				Bg = new ImageIcon(Main.class.getResource("../images/menuimage.png")).getImage();
				Stages = true;
				sec = 50;
				score =0;
				abcdf = "F";
				screenscore= Integer.toString(score);
				location = 1;
			}
		});

		add(replayButton);
		
		
		endButton.setBounds(800, 530, 185 , 59);
		endButton.setBorderPainted(false);
		endButton.setContentAreaFilled(false);
		endButton.setFocusPainted(false);
		endButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				endButton.setIcon(endButtonPressedImage);
				endButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				endButton.setIcon(endButtonEnterImage);
				endButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});

		add(endButton);
		
		LstageButton.setBounds(140, 310, 60 , 60);
		LstageButton.setBorderPainted(false);
		LstageButton.setContentAreaFilled(false);
		LstageButton.setFocusPainted(false);
		LstageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LstageButton.setIcon(LstageButtonPressedImage);
				LstageButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LstageButton.setIcon(LstagetButtonEnterImage);
				LstageButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				selectedR();
			}
		});

		add(LstageButton);
		
		
		
		RstageButton.setBounds(1030, 310, 60 , 60);
		RstageButton.setBorderPainted(false);
		RstageButton.setContentAreaFilled(false);
		RstageButton.setFocusPainted(false);
		RstageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				RstageButton.setIcon(RstageButtonPressedImage);
				RstageButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				RstageButton.setIcon(RstageButtonEnterImage);
				RstageButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				selectedL();
			}
		});
		add(RstageButton);
		
		stagestartButton.setBounds(300, 580, 600 , 100);
		stagestartButton.setBorderPainted(false);
		stagestartButton.setContentAreaFilled(false);
		stagestartButton.setFocusPainted(false);
		stagestartButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				stagestartButton.setIcon(stagestartButtonPressedImage);
				stagestartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				stagestartButton.setIcon(stagestartButtonEnterImage);
				stagestartButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				//스테이지로 이동
				gameStart(nowSelected);
				sec= 50;
				score = 0;
				screenscore = "000";
			}
		});
		add(stagestartButton);
		
		
		backButton.setBounds(20, 50, 80 ,80);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonPressedImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonEnterImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				//뒤로가기
				backtrack();
				
			}
		});
		add(backButton);
		
		
		
		Random rand = new Random();
		int maxX = 1000;
		int maxY = 400;
		int minX = 200;
		int minY = 200;
		        
		        
		int randomX = rand.nextInt(maxX); // x 좌표 랜덤 (버튼 크기 고려)
		int randomY = rand.nextInt(maxY); // y 좌표 랜덤 (버튼 크기 고려)
		 
		

		        // 버튼의 위치 설정
		FishButton.setBounds(randomX, randomY, 300, 150);  
		FishButton.setBorderPainted(false);
		FishButton.setContentAreaFilled(false);
		FishButton.setFocusPainted(false);
		FishButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						fishimage = new ImageIcon(Main.class.getResource("../images/" + fishList.get(fishno).getFishimage()));	
						FishButton.setIcon(fishimage);
						FishButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						FishButton.setIcon(fishhide);
						FishButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
					@Override
					public void mousePressed(MouseEvent e) {
						//게임 진행
						System.out.println("game class working");
						System.out.println(fishno);
					    fishchange();
			
					    Random rand = new Random();

					        int randomX = rand.nextInt(maxX - minX) + minX; // minX ~ maxX 사이 값
					        int randomY = rand.nextInt(maxY - minY) + minY; // minY ~ maxY 사이 값
				        
					        // 새로운 위치로 버튼 이동
					        FishButton.setBounds(randomX, randomY, 300, 150);
					        score += 100;
					        FinalScore();
					        System.out.println(score);
					        screenscore= Integer.toString(score);
					        
					}
			});
		add(FishButton);
		
		FishButton1.setBounds(randomX, randomY, 400, 200);  
		FishButton1.setBorderPainted(false);
		FishButton1.setContentAreaFilled(false);
		FishButton1.setFocusPainted(false);
		FishButton1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						fishimage1 = new ImageIcon(Main.class.getResource("../images/" + fishList1.get(fishno).getFishimage()));	
						FishButton1.setIcon(fishimage1);
						FishButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						FishButton1.setIcon(fishhide);
						FishButton1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
					@Override
					public void mousePressed(MouseEvent e) {
						//게임 진행

						System.out.println("game class working");
						System.out.println(fishno);
					    fishchange();
					    repaint();
					    Random rand = new Random();

				        int randomX = rand.nextInt(maxX - minX) + minX; // minX ~ maxX 사이 값
				        int randomY = rand.nextInt(maxY - minY) + minY; // minY ~ maxY 사이 값

					    	FishButton1.setBounds(randomX, randomY, 400, 200);
					        score += 100;
					        FinalScore();
					        System.out.println(score);
					        screenscore= Integer.toString(score);
					        
					}
			});
		add(FishButton1);
		
		FishButton2.setBounds(randomX, randomY, 500, 250);  
		FishButton2.setBorderPainted(false);
		FishButton2.setContentAreaFilled(false);
		FishButton2.setFocusPainted(false);
		FishButton2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						fishimage2 = new ImageIcon(Main.class.getResource("../images/" + fishList2.get(fishno).getFishimage()));	
						FishButton2.setIcon(fishimage2);
						FishButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						FishButton2.setIcon(fishhide);
						FishButton2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
					@Override
					public void mousePressed(MouseEvent e) {
						//게임 진행
						fishchange();
						repaint();
						System.out.println("game class working");
						System.out.println(fishno);
						Random rand = new Random();

				        int randomX = rand.nextInt(maxX - minX) + minX; // minX ~ maxX 사이 값
				        int randomY = rand.nextInt(maxY - minY) + minY; // minY ~ maxY 사이 값
							FishButton2.setBounds(randomX, randomY, 500, 250);
					        score += 100;
					        FinalScore();
					        System.out.println(score);
					        screenscore= Integer.toString(score);
					        
					}
			});
		add(FishButton2);
		
		menubar.setBounds(0, 0, 1200, 30);
		menubar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
			
		});
		menubar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int Y = e.getYOnScreen();
				setLocation(x - mouseX, Y - mouseY);
			}
		});
		add(menubar);
		
		
		
		}
	
	public void fishchange() {
		
		fishno = (int)(Math.random()*5);
		if(nowSelected ==0) {
			FishButton.setIcon(fishhide);
		}
		else if(nowSelected ==1) {
			FishButton1.setIcon(fishhide);
		}
		else {
			FishButton2.setIcon(fishhide);
		}
		System.out.println("Updated fishno: " + fishno);

		repaint();
	}
	
	

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D)screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics2D g)
	{
		g.drawImage(Bg, 0, 0, null); // 변화하는거
		if(Stages) {
			g.drawImage(stageselect,300,200,null);
			g.drawImage(stagename,300,70,null);
		}
		if(onStage) {
			g.drawImage(stageui,0,667,null);
			g.setColor(Color.black);
			g.setFont(new Font("Arial",Font.BOLD, 30));
			g.drawString("Score:", 900, 702);
			g.drawString("Rate:", 700, 702);
			g.drawString(screenscore, 1050, 702);
			g.drawString(abcdf, 850, 702);
			g.setColor(Color.white);
			g.drawString("Move your mouse to find fishes!!", 120, 100);
			g.drawString("Remaining Time :", 700, 100);
			/*
			g.setFont(new Font("Arial",Font.BOLD, 50));
			g.setColor(Color.red);
			*/
			g.drawString(Stringsec, 1000, 100);
			
		}
		if(finalScore) {
			
			g.setColor(Color.black);
			g.setFont(new Font("Arial",Font.BOLD, 50));
			g.drawString("Score:", 200, 200);
			g.drawString("Rate:", 200, 400);
			g.drawString(screenscore, 400, 200);
			g.drawString(abcdf, 400, 400);

			
		}
		paintComponents(g); // 고정된거
		this.repaint();
		
	}

	public void selectstage(int nowSelected) {
		stageselect = new ImageIcon(Main.class.getResource("../images/" + spotList.get(nowSelected).getStageimage())).getImage();
		stagename = new ImageIcon(Main.class.getResource("../images/" + spotList.get(nowSelected).getStagename())).getImage();

	}
	
	public void fishimage(int fishno) {
		fishimage = new ImageIcon(Main.class.getResource("../images/" + fishList.get(fishno).getFishimage()));
		fishimagepressed = new ImageIcon(Main.class.getResource("../images/" + fishList.get(fishno).getFishpressedImage()));

	}
	
	public void FinalScore() {
		if(score <= 500)
			abcdf ="F";
		else if(score <= 1000)		 
			abcdf ="D";
		else if(score <= 1500)		 
			abcdf ="C";
		else if(score <= 2000)		 
			abcdf ="B";
		else if(score <= 2500)		 
			abcdf ="A";
		else
			abcdf="S";
		}
		
	
	public void selectedL() {
		if(nowSelected == 0)
			nowSelected = spotList.size()-1;
		else 
			nowSelected --;
		selectstage(nowSelected);
		
	}
	public void selectedR() {
		if(nowSelected == spotList.size()-1)
			nowSelected = 0;
		else 
			nowSelected ++;
		selectstage(nowSelected);
		
	}
	public void gameStart(int nowSelected) {
		Thread myTimerThread = new Thread(new myTimer());
		Stages = false;
		onStage = true;
		RstageButton.setVisible(false);
		LstageButton.setVisible(false);
		stagestartButton.setVisible(false);
		Bg = new ImageIcon(Main.class.getResource("../images/" + spotList.get(nowSelected).getGameImage())).getImage();
		location = 2;
		System.out.println(fishno);
		if(nowSelected ==0) {
			FishButton.setVisible(true);
		}
		else if(nowSelected ==1) {
			FishButton1.setVisible(true);
		}
		else {
			FishButton2.setVisible(true);
		}
		

		sec = 50;
		myTimerThread.start();

	}
	
	


	
    class myTimer extends Thread {
        final long timeInterval = 1000;
        
        public void run(){
                 try{ 
                	 
                	 while(sec>=0){
                    
                    Stringsec= Integer.toString(sec);
                    --sec;
                    System.out.println(sec);
                  
                        Thread.sleep(timeInterval);
                          
                    if(sec == 0){
                        System.out.println("Time Out!");
                        Stages = false;
            			onStage = false;
            			finalScore = true;
            			FishButton.setVisible(false);
            			FishButton1.setVisible(false);
            			FishButton2.setVisible(false);
            			backButton.setVisible(false);
            			Bg = new ImageIcon(Main.class.getResource("../images/menuimage.png")).getImage();
            			replayButton.setVisible(true);
                        location = 3;
                        sec =50;
                           
                    }
                    
                    
                }
                 	}catch(InterruptedException e){
                        e.printStackTrace();
                 }	
        	}
    }
    
   myTimer  myTimer = new  myTimer();
	
	public void backtrack() {
		if(location == 2 ) {
			Stages = true;
			onStage = false;
			FishButton.setVisible(false);
			FishButton1.setVisible(false);
			FishButton2.setVisible(false);
			RstageButton.setVisible(true);
			LstageButton.setVisible(true);
			stagestartButton.setVisible(true);
			replayButton.setVisible(false);
			Bg = new ImageIcon(Main.class.getResource("../images/menuimage.png")).getImage();
			location = 1;
			myTimer.interrupt();
			sec = 50;
			score =0;
			abcdf = "F";
			screenscore= Integer.toString(score);

	        
			
			
		}
		else if(location == 1) {
			Stages = false;
			startButton.setVisible(true);
			endButton.setVisible(true);
			RstageButton.setVisible(false);
			LstageButton.setVisible(false);
			stagestartButton.setVisible(false);
			backButton.setVisible(false);
			replayButton.setVisible(false);
			Bg = new ImageIcon(Main.class.getResource("../images/tempbg.jpg")).getImage();
			location = 0;
			myTimer.interrupt();
		}
		
		else
			location = 0;
				
				
	}
		
}

	
	