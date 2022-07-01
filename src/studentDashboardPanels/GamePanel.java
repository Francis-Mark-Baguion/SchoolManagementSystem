package studentDashboardPanels;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener {
	
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGTH = 600;
	static final int UNIT_SIZE = 25;
	static final int GAME_UNIT = (SCREEN_HEIGTH*SCREEN_WIDTH)/UNIT_SIZE;
	static final int Delay = 100;
	final int x[] = new int[GAME_UNIT];
	final int y[] = new int[GAME_UNIT];
	int BodyParts = 6;
	int ApplesEaten;
	int Applex;
	int Appley;
	char Direction = 'R';
	Timer timer;
	boolean Running = false;
	Random random;
	GamePanel (){
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_HEIGTH,SCREEN_WIDTH));
		this.setFocusable(true);
		this.setBackground(Color.black);
		this.addKeyListener(new MyKeyAdapter());
		StartGame();
	}
	
	public void StartGame() {
		NewApple();
		Running = true;
		timer = new Timer(Delay,this);
		timer.start();
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	public void draw (Graphics g) {
		if(Running) {
			/*
			for (int i =0;i<SCREEN_HEIGTH/UNIT_SIZE;i++) {
				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGTH);
				g.drawLine(0, i*UNIT_SIZE,SCREEN_WIDTH ,i*UNIT_SIZE );
			
		}
		*/
			g.setColor(Color.red);
			g.fillOval(Applex, Appley, UNIT_SIZE, UNIT_SIZE);
		
			for (int i = 0;i<BodyParts;i++) {
				if(i==0) {
					g.setColor(Color.green);
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			}
				else {
					g.setColor(new Color(45,180,0));
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			}
		}
			g.setColor(Color.red);
			g.setFont(new Font("Times New Roman",Font.BOLD,40));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Score:"+ApplesEaten, (SCREEN_WIDTH-metrics.stringWidth("Score:"+ApplesEaten))/2,g.getFont().getSize());
		}
		
		else {
			GameOver(g);
		}
	}
	
	public void NewApple() {
		Applex = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
		Appley = random.nextInt((int)(SCREEN_HEIGTH/UNIT_SIZE))*UNIT_SIZE;
	}
	public void move () {
		for(int i = BodyParts;i>0;i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		switch(Direction) {
		case 'U': y[0] = y[0] - UNIT_SIZE;
		break;
		
		case 'D': y[0] = y[0] + UNIT_SIZE;
		break;
		
		case 'L': x[0] = x[0] - UNIT_SIZE;
		break;
		
		case 'R': x[0] = x[0] + UNIT_SIZE;
		break;
		}
	}
	public void CheckApple() {
		if((x[0]==Applex)&&(y[0]==Appley)) {
			BodyParts++;
			ApplesEaten++;
			NewApple();
		}
		
	}
	public void CheckCollision() {
		for (int i = BodyParts;i>0;i--) {
			if((x[0]==x[i])&& (y[0]==y[i])) {
				Running = false;
			}
		}
		if (x[0]<0) {
			Running = false;
		}
		if (x[0]>SCREEN_WIDTH) {
			Running = false;
		}
		if (y[0]<0) {
			Running = false;
		}
		if (y[0]>SCREEN_HEIGTH) {
			Running = false;
		}
		if(!Running) {
			timer.stop();
		}
	}
	public void GameOver(Graphics g) {
		g.setColor(Color.red);
		g.setFont(new Font("Times New Roman",Font.BOLD,40));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Score:"+ApplesEaten, (SCREEN_WIDTH-metrics.stringWidth("Score:"+ApplesEaten))/2,g.getFont().getSize());
		
		g.setColor(Color.red);
		g.setFont(new Font("Times New Roman",Font.BOLD,75));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH-metrics1.stringWidth("Game Over"))/2, SCREEN_HEIGTH/2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(Running) {
			move();
			CheckApple();
			CheckCollision();
		}
		repaint();
		
		
	}
	
		
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if(Direction != 'R') {
					Direction = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(Direction != 'L') {
					Direction = 'R';
				}
				break;
			case KeyEvent.VK_UP:
				if(Direction != 'D') {
					Direction = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if(Direction != 'U') {
					Direction = 'D';
				}
				break;
			}
		}
		
		
	}
	

	
}
