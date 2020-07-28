package com.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame{
	int x=200,y=300;
	
	boolean bL = false;
	boolean bR= false;
	boolean bU = false;
	boolean bD = false;
	
	Dir dir=Dir.DOWN;
	
	private static final int speed = 10;
	
	public TankFrame() {
		this.setSize(1000,800);
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
	
	@Override
	public void paint(Graphics g) {
		g.fillRect(x, y, 20, 20);
		switch(dir) {
			case LEFT:
				x-=speed;
				break;
			case RIGHT:
				x+=speed;
				break;
			case UP:
				y-=speed;
				break;
			case DOWN:
				y+=speed;
				break;
			default:break;
		}
	}
	
	class MyKeyListener extends KeyAdapter{
		
		
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
			 default:
				 break;
			 }
			 setMainTankDir();
		}
		
		private void setMainTankDir() {
			if(bL) dir = Dir.LEFT;
			if(bR) dir = Dir.RIGHT;
			if(bU) dir = Dir.UP;
			if(bD) dir = Dir.DOWN;
		}
	}
	
	
	
}
