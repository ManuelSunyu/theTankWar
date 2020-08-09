package com.tank;

import java.awt.Graphics;

public class Tank {
	
	private int x;
	private int y;
	private Dir dir = Dir.UP;
	private static final int speed=6;
	private boolean move = false;
	public static int w=ResourceManager.tankD.getWidth();
	public static int h = ResourceManager.tankD.getHeight();
	private TankFrame tf=null;
	private boolean living=true;
	
	public Tank(int x,int y,Dir dir,TankFrame tf) {
		super();
		this.x=x;
		this.y=y;
		this.dir=dir;
		this.tf=tf;
	}
	
	 public void paint(Graphics g) {
		 if(!living) {
			 tf.enemyList.remove(this);
		 }
		 switch(dir) {
			case LEFT:
				g.drawImage(ResourceManager.tankL, x, y, null);
				break;
			case RIGHT:
				g.drawImage(ResourceManager.tankR, x, y, null);
				break;
			case UP:
				g.drawImage(ResourceManager.tankU, x, y, null);
				break;
			case DOWN:
				g.drawImage(ResourceManager.tankD, x, y, null);
				break;
			default:break;
		}
		
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
	
	 public void fire() {
		 int bx = this.x+Tank.w/2-Bullet.width/2;
		 int by = this.y+Tank.h/2-Bullet.hight/2;
		 tf.listBullet.add(new Bullet(bx,by,dir,tf));
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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void die() {
		this.living=false;
		
	}
	 
}
