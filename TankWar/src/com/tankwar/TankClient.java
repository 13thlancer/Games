package com.tankwar;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TankClient extends Frame{
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;
	
	
	Tank myTank = new Tank(50, 50, true, Direction.STOP, this);
	
	Wall w1 = new Wall(100,200,20,150,this),w2 = new Wall(300,100,300,20,this);
	
	List<Explode> explodes = new ArrayList<Explode>();
	List<Missile> missiles = new ArrayList<Missile>();
	List<Tank> tanks = new ArrayList<Tank>();
	
	Blood b = new Blood();
	
	Image offScreenImage = null;
	
	public void paint(Graphics g){
		g.drawString("missiles count:"+missiles.size(), 10, 50);
		g.drawString("missiles life:"+myTank.getLife(), 10, 70);
		
		
		if(tanks.size() <= 0) {
			for(int i=0;i<Integer.parseInt(PropertyMgr.getProperty("reProduceTankCount"));i++) {
				tanks.add(new Tank(50+40*(i+1), 50, false, Direction.D, this));
				}
			}
		
		for(int i=0; i<missiles.size(); i++){
			Missile m = missiles.get(i);
			m.hitTanks(tanks);
			m.draw(g);
			m.hitTank(myTank);
			m.hitWall(w1);
			m.hitWall(w2);
			//if(!m.isLive()) missiles.remove(m);
			//else m.draw(g);
		}
		
		for(int i=0;i<explodes.size();i++) {
			Explode e = explodes.get(i);
			e.draw(g);
		}
		
		for(int i=0;i<tanks.size();i++) {
			Tank t = tanks.get(i);
			t.collidesWithWall(w1);
			t.collidesWithWall(w2);
			t.collidesWithTanks(tanks);
			t.draw(g);
		}
			
		myTank.draw(g);
		myTank.eat(b);
		w1.draw(g);
		w2.draw(g);
		b.draw(g);
	}
	
	public void update(Graphics g){
		if(offScreenImage == null){
			offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH,GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	public void launchFrame(){
		
		Properties props = new Properties();
		try {
			props.load(this.getClass().getClassLoader().getResourceAsStream("config/tank.properties"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		int initTankCount = Integer.parseInt(PropertyMgr.getProperty("initTankCount"));
		for(int i=0;i<10;i++) {
			tanks.add(new Tank(50+40*(i+1), 50, false, Direction.D, this));
		}
		
		this.setLocation(200, 100);
		this.setSize(GAME_WIDTH,GAME_HEIGHT);
		this.setTitle("TankWar");
		this.addWindowListener(new WindowAdapter(){

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		this.setResizable(false);
		this.setBackground(Color.GREEN);
		this.addKeyListener(new KeyMonitor());
		setVisible(true);
		
		new Thread(new PaintThread()).start();
	}
	
	public static void main(String[] args) {
		TankClient tc = new TankClient();
		tc.launchFrame();		
	}
	
	private class PaintThread implements Runnable{
		
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private class KeyMonitor extends KeyAdapter{

		public void keyReleased(KeyEvent e) {
			myTank.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			myTank.keyPressed(e);
		}
		
	}
}
