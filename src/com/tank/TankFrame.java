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

import com.tank.abstractFactory.BaseBullet;
import com.tank.abstractFactory.BaseExplode;
import com.tank.abstractFactory.BaseTank;
import com.tank.abstractFactory.DefaultFactory;
import com.tank.abstractFactory.GameFactory;
import com.tank.abstractFactory.RectFactory;

public class TankFrame extends Frame{

	private static final long serialVersionUID = 3140489942216917991L;
	
	public List<BaseBullet> listBullet = new ArrayList<>();
	public List<BaseTank> enemyList = new ArrayList<>();
	public List<BaseExplode> explodes = new ArrayList<>();
	
	public GameFactory gf = new RectFactory();
	
	public BaseTank myTank =gf.createTank(300,700,Dir.UP,Group.GOOD,this); //new Tank(300,700,Dir.UP,Group.GOOD,this);
	public Bullet b = new Bullet(200,50,Dir.DOWN,Group.GOOD,this);	


	public static final int GMAE_WIDTH=600,GAME_HIGHT=900;
	public TankFrame() {
		this.setSize(GMAE_WIDTH,GAME_HIGHT);
		this.setResizable(false);
		this.setTitle("TheTankWar");
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
		for(int i=0;i<enemyList.size();i++) {
			enemyList.get(i).paint(g);
		}
		//爆炸
		
		for(int i=0;i<explodes.size();i++) {
			explodes.get(i).paint(g);
		}
		
		for(int i=0 ; i<listBullet.size();i++) {
			for(int j=0;j<enemyList.size();j++) {
				listBullet.get(i).collideWidth(enemyList.get(j));
			}
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
			myTank.move=true;
			if(bL)  myTank.dir= Dir.LEFT;
			if(bR)  myTank.dir= Dir.RIGHT;
			if(bU)  myTank.dir= Dir.UP;
			if(bD)  myTank.dir= Dir.DOWN;
			
			if(!bL && !bR && !bU && !bD) {
				myTank.move=false;
			}
		}
	}
	
	
	
}
