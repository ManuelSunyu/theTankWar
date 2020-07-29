package com.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	private static int  width=10;
	private static int  hight=10;

	private static final int speed=5;
	private int x;
	private int y;
	private Dir dir;
	
	public Bullet(int x,int y,Dir dir) {
		super();
		this.x=x;
		this.y=y;
		this.dir=dir;
	}
	
	public void paint(Graphics g) {
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
	}
}
