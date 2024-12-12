package nakshii_12;

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

    private Image screenImage;  // 전체 화면 이미지
    private Graphics screenGraphic;  // 그래픽 컨텍스트

    private Image Bg = new ImageIcon(Main.class.getResource("../images/tempbg.jpg")).getImage();  // 배경 이미지
    private JLabel menubar =  new JLabel(new ImageIcon(Main.class.getResource("../images/uppermenu.jpg")));  // 메뉴바 레이블

    private Image stageui = new ImageIcon(Main.class.getResource("../images/stageui.jpg")).getImage();  // 스테이지 UI 이미지

    private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exit.jpg"));  // 종료 버튼 이미지
    private ImageIcon exitButtonpressedImage = new ImageIcon(Main.class.getResource("../images/exitpressed.jpg"));  // 종료 버튼 클릭 이미지
    private JButton exitButton = new JButton(exitButtonEnteredImage);  // 종료 버튼

    private int mouseX, mouseY;  // 마우스 위치 변수

    private boolean Stages = false;  // 스테이지 선택 화면 여부
    private boolean onStage = false;  // 게임 진행 화면 여부
    private boolean finalScore = false;  // 최종 점수 화면 여부

    private ImageIcon StartButtonEnterImage = new ImageIcon(Main.class.getResource("../images/start.jpg"));  // 시작 버튼 이미지
    private ImageIcon StartButtonPressedImage = new ImageIcon(Main.class.getResource("../images/startpressed.jpg"));  // 시작 버튼 클릭 이미지
    private ImageIcon endButtonEnterImage = new ImageIcon(Main.class.getResource("../images/end.jpg"));  // 종료 버튼 이미지
    private ImageIcon endButtonPressedImage = new ImageIcon(Main.class.getResource("../images/endpressed.jpg"));  // 종료 버튼 클릭 이미지
    private JButton startButton = new JButton(StartButtonEnterImage);  // 시작 버튼
    private JButton endButton = new JButton(endButtonEnterImage);  // 종료 버튼

    private ImageIcon replayButtonEnterImage = new ImageIcon(Main.class.getResource("../images/start.jpg"));  // 재시작 버튼 이미지
    private ImageIcon replayButtonPressedImage = new ImageIcon(Main.class.getResource("../images/startpressed.jpg"));  // 재시작 버튼 클릭 이미지
    private JButton replayButton = new JButton(StartButtonEnterImage);  // 재시작 버튼

    private ImageIcon LstagetButtonEnterImage = new ImageIcon(Main.class.getResource("../images/Lstage.jpg"));  // 왼쪽 스테이지 버튼 이미지
    private ImageIcon LstageButtonPressedImage = new ImageIcon(Main.class.getResource("../images/Lstagepressed.jpg"));  // 왼쪽 스테이지 버튼 클릭 이미지
    private ImageIcon RstageButtonEnterImage = new ImageIcon(Main.class.getResource("../images/Rstage.jpg"));  // 오른쪽 스테이지 버튼 이미지
    private ImageIcon RstageButtonPressedImage = new ImageIcon(Main.class.getResource("../images/Rstagepressed.jpg"));  // 오른쪽 스테이지 버튼 클릭 이미지
    private JButton LstageButton = new JButton(LstagetButtonEnterImage);  // 왼쪽 스테이지 버튼
    private JButton RstageButton = new JButton(RstageButtonEnterImage);  // 오른쪽 스테이지 버튼

    private ImageIcon stagestartButtonEnterImage = new ImageIcon(Main.class.getResource("../images/stagestart.jpg"));  // 스테이지 시작 버튼 이미지
    private ImageIcon stagestartButtonPressedImage = new ImageIcon(Main.class.getResource("../images/stagestartpressed.jpg"));  // 스테이지 시작 버튼 클릭 이미지
    private JButton stagestartButton = new JButton(stagestartButtonEnterImage);  // 스테이지 시작 버튼

    private ImageIcon backButtonEnterImage = new ImageIcon(Main.class.getResource("../images/back.jpg"));  // 뒤로가기 버튼 이미지
    private ImageIcon backButtonPressedImage = new ImageIcon(Main.class.getResource("../images/backpressed.jpg"));  // 뒤로가기 버튼 클릭 이미지
    private JButton backButton = new JButton(backButtonEnterImage);  // 뒤로가기 버튼

    public static Game game = new Game();  // 게임 클래스 인스턴스

    private ImageIcon fishimage;  // 현재 물고기 이미지
    private ImageIcon fishimagepressed;  // 물고기 클릭 이미지
    private JButton FishButton = new JButton(fishimage);  // 물고기 버튼

    private ImageIcon fishimage1;  // 물고기1 이미지
    private ImageIcon fishimagepressed1;  // 물고기1 클릭 이미지
    private JButton FishButton1 = new JButton(fishimage1);  // 물고기1 버튼

    private ImageIcon fishimage2;  // 물고기2 이미지
    private ImageIcon fishimagepressed2;  // 물고기2 클릭 이미지
    private JButton FishButton2 = new JButton(fishimage2);  // 물고기2 버튼

    private ImageIcon fishhide = new ImageIcon(Main.class.getResource("../images/fishhide.png"));  // 물고기 숨김 이미지

    private Image stagename;  // 스테이지 이름 이미지
    private Image stageselect;  // 선택된 스테이지 이미지
    private int nowSelected = 0;  // 현재 선택된 스테이지 인덱스

    // UI 관련 변수 초기화
    private int location = 0;  // 현재 화면 위치 (0: 메인, 1: 스테이지 선택, 2: 게임 진행, 3: 게임 종료)
    private int score = 0;  // 현재 점수
    private int fishno = 0;  // 현재 물고기 번호 (랜덤 선택 예정)
	private String abcdf = "F";

    // 타이머 관련 변수
    private String Stringsec;  // 타이머 시간 문자열
    int sec = 50;  // 타이머 시간 초기값 (50초)

    private String screenscore = "000";  // 화면에 표시할 점수 문자열
    ArrayList<FishingSpot> spotList = new ArrayList<FishingSpot>();  // 스테이지 정보 리스트
    ArrayList<Fish> fishList = new ArrayList<Fish>();  // 물고기 정보 리스트 (기본)
    ArrayList<Fish> fishList1 = new ArrayList<Fish>();  // 물고기 정보 리스트 (타입1)
    ArrayList<Fish> fishList2 = new ArrayList<Fish>();  // 물고기 정보 리스트 (타입2)

    public Nakshicommon() {
        setUndecorated(true);  // 창 장식 제거
        setTitle("Nakshii");  // 창 제목 설정
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);  // 창 크기 설정
        setResizable(false);  // 창 크기 변경 불가
        setLocationRelativeTo(null);  // 창을 화면 중앙에 배치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 창 닫을 때 프로그램 종료
        setVisible(true);  // 창을 보이게 설정
        setBackground(new Color(0, 0, 0, 0));  // 창 배경색 설정 (투명)
        setLayout(null);  // 레이아웃 매니저 비활성화

        // 스테이지 버튼들 초기 상태 설정 (비활성화)
        RstageButton.setVisible(false);
        LstageButton.setVisible(false);
        stagestartButton.setVisible(false);
        backButton.setVisible(false);
        FishButton.setVisible(false);
        FishButton1.setVisible(false);
        FishButton2.setVisible(false);
        replayButton.setVisible(false);
        location = 0;  // 초기 위치 설정

        addKeyListener(new FishCatchSystem());  // 키 리스너 추가 (게임 컨트롤)

        // 물고기 장소 정보 리스트에 추가
        spotList.add(new FishingSpot("oceanstage.jpg", "stagenameocean.jpg", "oceanstageBg.jpg"));
        spotList.add(new FishingSpot("riverstage.jpg", "stagenameriver.jpg", "riverstageBg.jpg"));
        spotList.add(new FishingSpot("oiknawa.png", "stagenameokinawa.jpg", "oiknawaBg.png"));

        // 물고기 정보 리스트에 추가
        fishList.add(new Fish("fish1.jpg", "fish1pressed.jpg"));
        fishList1.add(new Fish("fish2.jpg", "fish2pressed.jpg"));
        fishList2.add(new Fish("fish3.jpg", "fish3pressed.jpg"));

        // 종료 버튼 설정
        exitButton.setBounds(1170, 0, 30, 30);  // 종료 버튼 위치 및 크기 설정
        exitButton.setBorderPainted(false);  // 테두리 없음
        exitButton.setContentAreaFilled(false);  // 내용 영역 채우기 없음
        exitButton.setFocusPainted(false);  // 포커스 표시 없음
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setIcon(exitButtonpressedImage);  // 마우스 오버 시 이미지 변경
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));  // 커서 모양 변경 (손가락 모양)
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setIcon(exitButtonEnteredImage);  // 마우스 나갈 때 원래 이미지로 복원
                exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));  // 커서 모양 원래대로 복원
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);  // 프로그램 종료
            }
        });

        add(exitButton);  // 종료 버튼을 프레임에 추가

        // 시작 버튼 설정
        startButton.setBounds(800, 400, 185, 59);  // 시작 버튼 위치 및 크기 설정
        startButton.setBorderPainted(false);  // 테두리 없음
        startButton.setContentAreaFilled(false);  // 내용 영역 채우기 없음
        startButton.setFocusPainted(false);  // 포커스 표시 없음
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setIcon(StartButtonPressedImage);  // 마우스 오버 시 이미지 변경
                startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));  // 커서 모양 변경 (손가락 모양)
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setIcon(StartButtonEnterImage);  // 마우스 나갈 때 원래 이미지로 복원
                startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));  // 커서 모양 원래대로 복원
            }

            @Override
            public void mousePressed(MouseEvent e) {
                selectstage(0);  // 첫 번째 스테이지 선택 함수 호출
                finalScore = false;  // 최종 점수 화면 플래그 비활성화
                startButton.setVisible(false);  // 시작 버튼 비활성화
                endButton.setVisible(false);  // 종료 버튼 비활성화
                RstageButton.setVisible(true);  // 오른쪽 스테이지 버튼 활성화
                LstageButton.setVisible(true);  // 왼쪽 스테이지 버튼 활성화
                stagestartButton.setVisible(true);  // 스테이지 시작 버튼 활성화
                backButton.setVisible(true);  // 뒤로가기 버튼 활성화
                Bg = new ImageIcon(Main.class.getResource("../images/menuimage.png")).getImage();  // 배경 이미지 변경
                Stages = true;  // 스테이지 선택 화면 플래그 활성화
                location = 1;  // 위치 플래그 업데이트 (스테이지 선택 화면)
            }
        });

        add(startButton);  // 시작 버튼을 프레임에 추가

        // 재시작 버튼 설정
        replayButton.setBounds(500, 500, 185, 59);  // 재시작 버튼 위치 및 크기 설정
        replayButton.setBorderPainted(false);  // 테두리 없음
        replayButton.setContentAreaFilled(false);  // 내용 영역 채우기 없음
        replayButton.setFocusPainted(false);  // 포커스 표시 없음
        replayButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                replayButton.setIcon(StartButtonPressedImage);  // 마우스 오버 시 이미지 변경
                replayButton.setCursor(new Cursor(Cursor.HAND_CURSOR));  // 커서 모양 변경 (손가락 모양)
            }

            @Override
            public void mouseExited(MouseEvent e) {
                replayButton.setIcon(StartButtonEnterImage);  // 마우스 나갈 때 원래 이미지로 복원
                replayButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));  // 커서 모양 원래대로 복원
            }

            @Override
            public void mousePressed(MouseEvent e) {
                selectstage(0);  // 첫 번째 스테이지 선택 함수 호출
                finalScore = false;  // 최종 점수 화면 플래그 비활성화
                startButton.setVisible(false);  // 시작 버튼 비활성화
                replayButton.setVisible(false);  // 재시작 버튼 비활성화
                endButton.setVisible(false);  // 종료 버튼 비활성화
                RstageButton.setVisible(true);  // 오른쪽 스테이지 버튼 활성화
                LstageButton.setVisible(true);  // 왼쪽 스테이지 버튼 활성화
                stagestartButton.setVisible(true);  // 스테이지 시작 버튼 활성화
                backButton.setVisible(true);  // 뒤로가기 버튼 활성화
                Bg = new ImageIcon(Main.class.getResource("../images/menuimage.png")).getImage();  // 배경 이미지 변경
                Stages = true;  // 스테이지 선택 화면 플래그 활성화
                sec = 50;  // 타이머 시간 초기화
                score = 0;  // 점수 초기화
                abcdf = "F";  // 점수 등급 초기화
                screenscore = Integer.toString(score);  // 화면에 표시될 점수 문자열 업데이트
                location = 1;  // 위치 플래그 업데이트 (스테이지 선택 화면)
            }
        });

        add(replayButton);  // 재시작 버튼을 프레임에 추가

        // 종료 버튼 설정
        endButton.setBounds(800, 530, 185, 59);  // 종료 버튼 위치 및 크기 설정
        endButton.setBorderPainted(false);  // 테두리 없음
        endButton.setContentAreaFilled(false);  // 내용 영역 채우기 없음
        endButton.setFocusPainted(false);  // 포커스 표시 없음
        endButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                endButton.setIcon(endButtonPressedImage);  // 마우스 오버 시 이미지 변경
                endButton.setCursor(new Cursor(Cursor.HAND_CURSOR));  // 커서 모양 변경 (손가락 모양)
            }

            @Override
            public void mouseExited(MouseEvent e) {
                endButton.setIcon(endButtonEnterImage);  // 마우스 나갈 때 원래 이미지로 복원
                endButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));  // 커서 모양 원래대로 복원
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);  // 프로그램 종료
            }
        });

        add(endButton);  // 종료 버튼을 프레임에 추가

        // 왼쪽 스테이지 버튼 설정
        LstageButton.setBounds(140, 310, 60, 60);  // 왼쪽 스테이지 버튼 위치 및 크기 설정
        LstageButton.setBorderPainted(false);  // 테두리 없음
        LstageButton.setContentAreaFilled(false);  // 내용 영역 채우기 없음
        LstageButton.setFocusPainted(false);  // 포커스 표시 없음
        LstageButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                LstageButton.setIcon(LstageButtonPressedImage);  // 마우스 오버 시 이미지 변경
                LstageButton.setCursor(new Cursor(Cursor.HAND_CURSOR));  // 커서 모양 변경 (손가락 모양)
            }

            @Override
            public void mouseExited(MouseEvent e) {
                LstageButton.setIcon(LstagetButtonEnterImage);  // 마우스 나갈 때 원래 이미지로 복원
                LstageButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));  // 커서 모양 원래대로 복원
            }

            @Override
            public void mousePressed(MouseEvent e) {
                selectedR();  // 오른쪽 스테이지 선택 함수 호출
            }
        });

        add(LstageButton);  // 왼쪽 스테이지 버튼을 프레임에 추가

        // 오른쪽 스테이지 버튼 설정
        RstageButton.setBounds(1030, 310, 60, 60);  // 오른쪽 스테이지 버튼 위치 및 크기 설정
        RstageButton.setBorderPainted(false);  // 테두리 없음
        RstageButton.setContentAreaFilled(false);  // 내용 영역 채우기 없음
        RstageButton.setFocusPainted(false);  // 포커스 표시 없음
        RstageButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                RstageButton.setIcon(RstageButtonPressedImage);  // 마우스 오버 시 이미지 변경
                RstageButton.setCursor(new Cursor(Cursor.HAND_CURSOR));  // 커서 모양 변경 (손가락 모양)
            }

            @Override
            public void mouseExited(MouseEvent e) {
                RstageButton.setIcon(RstageButtonEnterImage);  // 마우스 나갈 때 원래 이미지로 복원
                RstageButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));  // 커서 모양 원래대로 복원
            }

            @Override
            public void mousePressed(MouseEvent e) {
                selectedL();  // 왼쪽 스테이지 선택 함수 호출
            }
        });

        add(RstageButton);  // 오른쪽 스테이지 버튼을 프레임에 추가

        // 스테이지 시작 버튼 설정
        stagestartButton.setBounds(300, 580, 600, 100);  // 스테이지 시작 버튼 위치 및 크기 설정
        stagestartButton.setBorderPainted(false);  // 테두리 없음
        stagestartButton.setContentAreaFilled(false);  // 내용 영역 채우기 없음
        stagestartButton.setFocusPainted(false);  // 포커스 표시 없음
        stagestartButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                stagestartButton.setIcon(stagestartButtonPressedImage);  // 마우스 오버 시 이미지 변경
                stagestartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));  // 커서 모양 변경 (손가락 모양)
            }

            @Override
            public void mouseExited(MouseEvent e) {
                stagestartButton.setIcon(stagestartButtonEnterImage);  // 마우스 나갈 때 원래 이미지로 복원
                stagestartButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));  // 커서 모양 원래대로 복원
            }

            @Override
            public void mousePressed(MouseEvent e) {
                gameStart(nowSelected);  // 게임 시작 함수 호출
                sec = 50;  // 타이머 시간 초기화
                score = 0;  // 점수 초기화
                screenscore = "000";  // 화면에 표시될 점수 문자열 초기화
            }
        });

        add(stagestartButton);  // 스테이지 시작 버튼을 프레임에 추가

        // 뒤로가기 버튼 설정
        backButton.setBounds(20, 50, 80, 80);  // 뒤로가기 버튼 위치 및 크기 설정
        backButton.setBorderPainted(false);  // 테두리 없음
        backButton.setContentAreaFilled(false);  // 내용 영역 채우기 없음
        backButton.setFocusPainted(false);  // 포커스 표시 없음
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public  void mouseEntered(MouseEvent e) {
                backButton.setIcon(backButtonPressedImage);  // 마우스 오버 시 이미지 변경
                backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));  // 커서 모양 변경 (손가락 모양)
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backButton.setIcon(backButtonEnterImage);  // 마우스 나갈 때 원래 이미지로 복원
                backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));  // 커서 모양 원래대로 복원
            }

            @Override
            public void mousePressed(MouseEvent e) {
                backtrack();  // 뒤로가기 함수 호출
            }
        });

        add(backButton);  // 뒤로가기 버튼을 프레임에 추가

        Random rand = new Random();  // 랜덤 객체 생성
        int maxX = 1000;  // 최대 X 좌표값
        int maxY = 400;  // 최대 Y 좌표값
        int minX = 200;  // 최소 X 좌표값
        int minY = 200;  // 최소 Y 좌표값

        int randomX = rand.nextInt(maxX);  // X 좌표 랜덤 생성 (버튼 크기 고려)
        int randomY = rand.nextInt(maxY);  // Y 좌표 랜덤 생성 (버튼 크기 고려)

        // 물고기 버튼 위치 설정
        FishButton.setBounds(randomX, randomY, 185, 80);  // 물고기 버튼 위치 및 크기 설정
        FishButton.setBorderPainted(false);  // 테두리 없음
        FishButton.setContentAreaFilled(false);  // 내용 영역 채우기 없음
        FishButton.setFocusPainted(false);  // 포커스 표시 없음
        FishButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                fishimage = new ImageIcon(Main.class.getResource("../images/" + fishList.get(fishno).getFishimage()));  // 물고기 이미지 설정
                FishButton.setIcon(fishimage);  // 버튼에 물고기 이미지 설정
                FishButton.setCursor(new Cursor(Cursor.HAND_CURSOR));  // 커서 모양 변경 (손가락 모양)
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // fishimagepressed = new ImageIcon(Main.class.getResource("../images/" + fishList.get(fishno).getFishpressedImage()));  // 물고기 클릭 이미지 설정 (현재 사용 안 함)
                // FishButton.setIcon(fishimagepressed);  // 버튼에 물고기 클릭 이미지 설정 (현재 사용 안 함)
                FishButton.setIcon(fishhide);  // 버튼에 물고기 숨김 이미지 설정
                FishButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));  // 커서 모양 원래대로 복원
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("game class working");  // 게임 진행 상태 출력
                System.out.println(fishno);  // 현재 물고기 번호 출력
                fishchange();  // 물고기 변경 함수 호출

                Random rand = new Random();  // 랜덤 객체 재생성
                /*
                int randomX = rand.nextInt(maxX - minX) + minX;  // minX ~ maxX 사이 랜덤 X 좌표 생성
                int randomY = rand.nextInt(maxY - minY) + minY;  // minY ~ maxY 사이 랜덤 Y 좌표 생성
                */
                // 새로운 위치로 버튼 이동
                FishButton.setBounds(randomX, randomY, 185, 80);  // 물고기 버튼 새 위치 및 크기 설정
                score += 100;  // 점수 100점 증가
                FinalScore();  // 최종 점수 계산 함수 호출
                System.out.println(score);  // 현재 점수 출력
                screenscore = Integer.toString(score);  // 화면에 표시될 점수 문자열 업데이트
            }
        });

        add(FishButton);  // 물고기 버튼을 프레임에 추가

        // 물고기1 버튼 설정
        FishButton1.setBounds(randomX, randomY, 185, 80);  // 물고기1 버튼 위치 및 크기 설정
        FishButton1.setBorderPainted(false);  // 테두리 없음
        FishButton1.setContentAreaFilled(false);  // 내용 영역 채우기 없음
        FishButton1.setFocusPainted(false);  // 포커스 표시 없음
        FishButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                fishimage1 = new ImageIcon(Main.class.getResource("../images/" + fishList1.get(fishno).getFishimage()));  // 물고기1 이미지 설정
                FishButton1.setIcon(fishimage1);  // 버튼에 물고기1 이미지 설정
                FishButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));  // 커서 모양 변경 (손가락 모양)
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // fishimagepressed1 = new ImageIcon(Main.class.getResource("../images/" + fishList1.get(fishno).getFishpressedImage()));  // 물고기1 클릭 이미지 설정 (현재 사용 안 함)
                // FishButton1.setIcon(fishimagepressed1);  // 버튼에 물고기1 클릭 이미지 설정 (현재 사용 안 함)
                FishButton1.setIcon(fishhide);  // 버튼에 물고기1 숨김 이미지 설정
                FishButton1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));  // 커서 모양 원래대로 복원
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("game class working");  // 게임 진행 상태 출력
                System.out.println(fishno);  // 현재 물고기1 번호 출력
                fishchange();  // 물고기 변경 함수 호출
                repaint();  // 화면 갱신 요청

                score += 100;  // 점수 100점 증가
                FinalScore();  // 최종 점수 계산 함수 호출
                System.out.println(score);  // 현재 점수 출력
                screenscore = Integer.toString(score);  // 화면에 표시될 점수 문자열 업데이트
            }
        });

        add(FishButton1);  // 물고기1 버튼을 프레임에 추가

        // 물고기2 버튼 설정
        FishButton2.setBounds(randomX, randomY, 185, 80);  // 물고기2 버튼 위치 및 크기 설정
        FishButton2.setBorderPainted(false);  // 테두리 없음
        FishButton2.setContentAreaFilled(false);  // 내용 영역 채우기 없음
        FishButton2.setFocusPainted(false);  // 포커스 표시 없음
        FishButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                fishimage2 = new ImageIcon(Main.class.getResource("../images/" + fishList2.get(fishno).getFishimage()));  // 물고기2 이미지 설정
                FishButton2.setIcon(fishimage2);  // 버튼에 물고기2 이미지 설정
                FishButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));  // 커서 모양 변경 (손가락 모양)
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // fishimagepressed2 = new ImageIcon(Main.class.getResource("../images/" + fishList2.get(fishno).getFishpressedImage()));  // 물고기2 클릭 이미지 설정 (현재 사용 안 함)
                // FishButton2.setIcon(fishimagepressed2);  // 버튼에 물고기2 클릭 이미지 설정 (현재 사용 안 함)
                FishButton2.setIcon(fishhide);  // 버튼에 물고기2 숨김 이미지 설정
                FishButton2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));  // 커서 모양 원래대로 복원
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("game class working");  // 게임 진행 상태 출력
                System.out.println(fishno);  // 현재 물고기2 번호 출력
                fishchange();  // 물고기 변경 함수 호출
                repaint();  // 화면 갱신 요청

                score += 100;  // 점수 100점 증가
                FinalScore();  // 최종 점수 계산 함수 호출
                System.out.println(score);  // 현재 점수 출력
                screenscore = Integer.toString(score);  // 화면에 표시될 점수 문자열 업데이트
            }
        });

        add(FishButton2);  // 물고기2 버튼을 프레임에 추가

        // 메뉴바 설정
        menubar.setBounds(0, 0, 1200, 30);  // 메뉴바 위치 및 크기 설정
        menubar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();  // 마우스 X 좌표 저장
                mouseY = e.getY();  // 마우스 Y 좌표 저장
            }

        });
        menubar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();  // 화면 상의 X 좌표 얻기
                int Y = e.getYOnScreen();  // 화면 상의 Y 좌표 얻기
                setLocation(x - mouseX, Y - mouseY);  // 프레임 위치 이동
            }
        });

        add(menubar);  // 메뉴바를 프레임에 추가

        // 화면 갱신을 위한 그래픽 설정
        public void paint(Graphics g) {
            screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);  // 전체 화면 크기의 이미지 생성
            screenGraphic = screenImage.getGraphics();  // 이미지의 그래픽 컨텍스트 얻기
            screenDraw((Graphics2D) screenGraphic);  // 스크린 그리기 함수 호출
            g.drawImage(screenImage, 0, 0, null);  // 생성된 이미지를 화면에 그리기
        }

        // 화면 그리기 함수
        public void screenDraw(Graphics2D g) {
            g.drawImage(Bg, 0, 0, null);  // 배경 이미지 그리기
            if (Stages) {  // 스테이지 선택 화면일 때
                g.drawImage(stageselect, 300, 200, null);  // 선택된 스테이지 이미지 그리기
                g.drawImage(stagename, 300, 70, null);  // 선택된 스테이지 이름 이미지 그리기
            }
            if (onStage) {  // 게임 진행 화면일 때
                g.drawImage(stageui, 0, 667, null);  // 스테이지 UI 이미지 그리기
                // 최적화 코드 (렌더링 힌트 설정)
                // g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  // 안티앨리어싱 설정
                g.setColor(Color.black);  // 글씨 색상 설정 (검정)
                g.setFont(new Font("Arial", Font.BOLD, 30));  // 글씨 폰트 설정
                g.drawString("where", 20, 702);  // "where" 문자열 그리기
                g.drawString("Score:", 900, 702);  // "Score:" 문자열 그리기
                g.drawString("Rate:", 700, 702);  // "Rate:" 문자열 그리기
                g.drawString(screenscore, 1050, 702);  // 현재 점수 문자열 그리기
                g.drawString(abcdf, 850, 702);  // 현재 등급 문자열 그리기
                g.setColor(Color.white);  // 글씨 색상 설정 (흰색)
                g.drawString("Move your mouse to find fishes!!", 120, 100);  // "Move your mouse to find fishes!!" 문자열 그리기
                g.drawString("Remaining Time :", 700, 100);  // "Remaining Time :" 문자열 그리기
                // 추가 글씨 설정
                // g.setFont(new Font("Arial", Font.BOLD, 50));  // 글씨 폰트 크기 변경
                // g.setColor(Color.red);  // 글씨 색상 변경 (빨강)
                g.drawString(Stringsec, 1000, 100);  // 남은 시간 문자열 그리기
            }
            if (finalScore) {  // 최종 점수 화면일 때
                // 최적화 코드 (렌더링 힌트 설정)
                // g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  // 안티앨리어싱 설정
                g.setColor(Color.black);  // 글씨 색상 설정 (검정)
                g.setFont(new Font("Arial", Font.BOLD, 50));  // 글씨 폰트 설정
                g.drawString("where", 20, 702);  // "where" 문자열 그리기
                g.drawString("Score:", 200, 200);  // "Score:" 문자열 그리기
                g.drawString("Rate:", 200, 400);  // "Rate:" 문자열 그리기
                g.drawString(screenscore, 400, 200);  // 현재 점수 문자열 그리기
                g.drawString(abcdf, 400, 400);  // 현재 등급 문자열 그리기
            }
            paintComponents(g);  // 컴포넌트 그리기 요청
            this.repaint();  // 화면 갱신 요청
        }

        // 게임 오버 함수
        public void gameover() {

        }

   

        // 스테이지 선택 함수
        public void selectstage(int nowSelected) {
            stageselect = new ImageIcon(Main.class.getResource("../images/" + spotList.get(nowSelected).getStageimage())).getImage();  // 선택된 스테이지 이미지 설정
            stagename = new ImageIcon(Main.class.getResource("../images/" + spotList.get(nowSelected).getStagename())).getImage();  // 선택된 스테이지 이름 이미지 설정

        }

        // 물고기 이미지 설정 함수
        public void fishimage(int fishno) {
            fishimage = new ImageIcon(Main.class.getResource("../images/" + fishList.get(fishno).getFishimage()));  // 현재 물고기 이미지 설정
            fishimagepressed = new ImageIcon(Main.class.getResource("../images/" + fishList.get(fishno).getFishpressedImage()));  // 현재 물고기 클릭 이미지 설정

        }
        
    	public void fishchange() {
    		
    		fishno = (int)(Math.random()*0);
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
    	

        // 최종 점수 계산 함수
        public void FinalScore() {
            if (score <= 500)
                abcdf = "F";  // F 등급
            else if (score <= 1000)
                abcdf = "D";  // D 등급
            else if (score <= 1500)
                abcdf = "C";  // C 등급
            else if (score <= 2000)
                abcdf = "B";  // B 등급
            else if (score <= 2500)
                abcdf = "A";  // A 등급
            else
                abcdf = "S";  // S 등급
        }

        // 왼쪽 스테이지 선택 함수
        public void selectedL() {
            if (nowSelected == 0)
                nowSelected = spotList.size() - 1;  // 마지막 스테이지로 이동
            else
                nowSelected--;  // 이전 스테이지로 이동
            selectstage(nowSelected);  // 선택된 스테이지 설정
        }

        // 오른쪽 스테이지 선택 함수
        public void selectedR() {
            if (nowSelected == spotList.size() - 1)
                nowSelected = 0;  // 첫 번째 스테이지로 이동
            else
                nowSelected++;  // 다음 스테이지로 이동
            selectstage(nowSelected);  // 선택된 스테이지 설정
        }

        // 게임 시작 함수
        public void gameStart(int nowSelected) {
            Thread myTimerThread = new Thread(new myTimer());  // 타이머 스레드 생성
            Stages = false;  // 스테이지 선택 화면 비활성화
            onStage = true;  // 게임 진행 화면 활성화
            RstageButton.setVisible(false);  // 오른쪽 스테이지 버튼 비활성화
            LstageButton.setVisible(false);  // 왼쪽 스테이지 버튼 비활성화
            stagestartButton.setVisible(false);  // 스테이지 시작 버튼 비활성화
            Bg = new ImageIcon(Main.class.getResource("../images/" + spotList.get(nowSelected).getGameImage())).getImage();  // 게임 진행 배경 이미지 설정
            location = 2;  // 위치 플래그 업데이트 (게임 진행 화면)
            System.out.println(fishno);  // 현재 물고기 번호 출력
            if (nowSelected == 0) {
                FishButton.setVisible(true);  // 물고기 버튼 활성화 (기본 타입)
            } else if (nowSelected == 1) {
                FishButton1.setVisible(true);  // 물고기1 버튼 활성화 (타입1)
            } else {
                FishButton2.setVisible(true);  // 물고기2 버튼 활성화 (타입2)
            }

            // fishapear();  // 물고기 나타내기 함수 호출 (현재 사용 안 함)
            sec = 50;  // 타이머 시간 초기화
            myTimerThread.start();  // 타이머 스레드 시작

        }

        /*
        public void timer() {
            while (true) {
                if (timerx > 0) {
                    try {
                        this.sleep(1000);  // 1초 대기
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    timerx -= 1;  // 타이머 시간 감소
                    time = Integer.toString(score);  // 현재 점수 문자열 업데이트

                } else {
                    //System.out.println("종료");
                    break;  // 타이머 종료
                }
            }
        }
        */

        // 타이머 관련 클래스
        class myTimer extends Thread {
            final long timeInterval = 1000;  // 타이머 간격 (1초)

            public void run() {
                while (sec >= 0) {

                    Stringsec = Integer.toString(sec);  // 남은 시간 문자열 업데이트
                    --sec;  // 남은 시간 감소
                    System.out.println(sec);  // 현재 남은 시간 출력
                    try {
                        Thread.sleep(timeInterval);  // 1초 대기
                    } catch (InterruptedException e) {
                        e.printStackTrace();  // 예외 처리
                    }
                    if (sec == 0) {
                        System.out.println("Time Out!");  // 시간 초과 메시지 출력
                        Stages = false;  // 스테이지 선택 화면 비활성화
                        onStage = false;  // 게임 진행 화면 비활성화
                        finalScore = true;  // 최종 점수 화면 활성화
                        FishButton.setVisible(false);  // 물고기 버튼 비활성화
                        FishButton1.setVisible(false);  // 물고기1 버튼 비활성화
                        FishButton2.setVisible(false);  // 물고기2 버튼 비활성화
                        backButton.setVisible(false);  // 뒤로가기 버튼 비활성화
                        Bg = new ImageIcon(Main.class.getResource("../images/menuimage.png")).getImage();  // 배경 이미지 변경
                        replayButton.setVisible(true);  // 재시작 버튼 활성화
                        location = 3;  // 위치 플래그 업데이트 (최종 점수 화면)
                        sec = 50;  // 타이머 시간 초기화


                    }


                }

            }
        }

        myTimer myTimer = new myTimer();  // 타이머 객체 생성

        // 뒤로가기 함수
        public void backtrack() {
            if (location == 2) {  // 게임 진행 화면일 때
                Stages = true;  // 스테이지 선택 화면 활성화
                onStage = false;  // 게임 진행 화면 비활성화
                FishButton.setVisible(false);  // 물고기 버튼 비활성화
                FishButton1.setVisible(false);  // 물고기1 버튼 비활성화
                FishButton2.setVisible(false);  // 물고기2 버튼 비활성화
                RstageButton.setVisible(true);  // 오른쪽 스테이지 버튼 활성화
                LstageButton.setVisible(true);  // 왼쪽 스테이지 버튼 활성화
                stagestartButton.setVisible(true);  // 스테이지 시작 버튼 활성화
                replayButton.setVisible(false);  // 재시작 버튼 비활성화
                Bg = new ImageIcon(Main.class.getResource("../images/menuimage.png")).getImage();  // 배경 이미지 변경
                location = 1;  // 위치 플래그 업데이트 (스테이지 선택 화면)
                myTimer.interrupt();  // 타이머 스레드 중지
                sec = 50;  // 타이머 시간 초기화
                score = 0;  // 점수 초기화
                abcdf = "F";  // 점수 등급 초기화
                screenscore = Integer.toString(score);  // 화면에 표시될 점수 문자열 초기화


            } else if (location == 1) {  // 스테이지 선택 화면일 때
                Stages = false;  // 스테이지 선택 화면 비활성화
                startButton.setVisible(true);  // 시작 버튼 활성화
                endButton.setVisible(true);  // 종료 버튼 활성화
                RstageButton.setVisible(false);  // 오른쪽 스테이지 버튼 비활성화
                LstageButton.setVisible(false);  // 왼쪽 스테이지 버튼 비활성화
                stagestartButton.setVisible(false);  // 스테이지 시작 버튼 비활성화
                backButton.setVisible(false);  // 뒤로가기 버튼 비활성화
                replayButton.setVisible(false);  // 재시작 버튼 비활성화
                Bg = new ImageIcon(Main.class.getResource("../images/tempbg.jpg")).getImage();  // 배경 이미지 변경
                location = 0;  // 위치 플래그 업데이트 (메인 화면)
            } else {
                location = 0;  // 위치 초기화

            }

        }

    }