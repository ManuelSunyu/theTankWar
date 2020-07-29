package com.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame{

	private static final long serialVersionUID = 3140489942216917991L;
	
	Tank myTank = new Tank(200,200,Dir.DOWN,this);
	Bullet b = new Bullet(200,50,Dir.DOWN,this);
	List<Bullet> listBullet = new ArrayList<>();
	static final int GMAE_WIDTH=600,GAME_HIGHT=800;
	
	public TankFrame() {
		this.setSize(GMAE_WIDTH,GAME_HIGHT);
		this.setResizable(false);
		this.setTitle("TheTankWat");
		this.setVisible(true);
		this.addKeyListener(new MyKeyListener());
		addWindowListener(new WindowAdapter() {
			@Override
			public void  windowClosing(WindowEvent e) {				
				System.exit(0);
			}
		});		
	}
	
	Image offScreenImage = null;
	@Override
	public void update(Graphics g) {//解决闪烁题
		if(offScreenImage==null) {
			offScreenImage=this.createImage(GMAE_WIDTH,GAME_HIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0,0, GMAE_WIDTH, GAME_HIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0 , 0 ,null);		
	}
	
	@Override
	public void paint(Graphics g) {
		
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("子弹的数量："+listBullet.size(), 10, 60);
		g.setColor(c);
		
		myTank.paint(g);
		for(int i=0;i<listBullet.size();i++) {
			listBullet.get(i).paint(g);
		}
	}
	
	
	class MyKeyListener extends KeyAdapter{
		
		boolean bL = false;
		boolean bR= false;
		boolean bU = false;
		boolean bD = false;
		
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			 switch(key) {
			 case KeyEvent.VK_A:
				 bL=true;
				 break;
			 case KeyEvent.VK_D:
				 bR=true;
				 break;
			 case KeyEvent.VK_W:
				 bU = true;
				 break;
			 case KeyEvent.VK_S:
				bD = true;
				 break;
			 default:
				 break;
			 }
			 setMainTankDir();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			 switch(key) {
			 case KeyEvent.VK_A:
				 bL = false;
				 break;
			 case KeyEvent.VK_D:
				 bR = false;
				 break;
			 case KeyEvent.VK_W:
				 bU = false;
				 break;
			 case KeyEvent.VK_S:
				bD = false;
				 break;
			 case KeyEvent.VK_K:
				 myTank.fire();
			  	 break;
			 default:
				 break;
			 }
			 setMainTankDir();
		}
		
		private void setMainTankDir() {
			myTank.setMove(true);
			if(bL)  myTank.setDir( Dir.LEFT);
			if(bR)  myTank.setDir( Dir.RIGHT);
			if(bU)  myTank.setDir( Dir.UP);
			if(bD)  myTank.setDir( Dir.DOWN);
			
			if(!bL && !bR && !bU && !bD) {
				myTank.setMove(false);
			}
		}
	}
	
	
	
}
