package com.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	
	private int x;
	private int y;
	private Dir dir = Dir.DOWN;
	private static final int speed=6;
	private boolean move = true;
	
	public Tank(int x,int y,Dir dir) {
		super();
		this.x=x;
		this.y=y;
		this.dir=dir;
	}
	
	 public void paint(Graphics g) {
		 Color c =g.getColor();
		 g.setColor(Color.YELLOW);
		 g.fillRect(x, y, 20, 20);
		 g.setColor(c);
		 move(dir);
	 }

	private void move(Dir dir) {
			if(!move) {
				return;
			}
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
	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public boolean isMove() {
		return move;
	}

	public void setMove(boolean move) {
		this.move = move;
	}
	 
}
