package com.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame{
	int x=200,y=300;
	
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
	}
	
	class MyKeyListener extends KeyAdapter{
		
		boolean bL = false;//左上
		boolean bR= false;//右上
		boolean bU = false;// 左下
		boolean bD = false;//右下
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			 switch(key) {
			 case KeyEvent.VK_A:
				 x-=10;
				 break;
			 case KeyEvent.VK_D:
				 x+=10;
				 break;
			 case KeyEvent.VK_W:
				 y-=10;
				 break;
			 case KeyEvent.VK_S:
				 y+=10;
				 break;
			 default:
				 break;
			 }
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		}
		
	}

}
