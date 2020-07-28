package com.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame{

	private static final long serialVersionUID = 3140489942216917991L;
	
	Tank myTank = new Tank(200,200,Dir.DOWN);
	
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
		myTank.paint(g);
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
