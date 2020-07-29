package com.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	private static int  width=10;
	private static int  hight=10;

	private static final int speed=10;
	private int x;
	private int y;
	private Dir dir;
	private  boolean live=true;
	TankFrame tf = null;
	
	public Bullet(int x,int y,Dir dir,TankFrame tf) {
		super();
		this.x=x;
		this.y=y;
		this.dir=dir;
		this.tf=tf;
	}
	
	public void paint(Graphics g) {
		if(!live) {
			tf.listBullet.remove(this);
		}
		Color c =g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, width, hight);
		g.setColor(c);
		
		move();
		
	}
	
	private void move() {
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
		if(x<0|| y<0||y>TankFrame.GAME_HIGHT||x>TankFrame.GMAE_WIDTH) {
			live=false;
		}
	}
}
