package com.tank;

import java.awt.Graphics;

public class Tank {
	
	private int x;
	private int y;
	private Dir dir = Dir.DOWN;
	private static final int speed=6;
	private boolean move = true;
	private static int w=20;
	private static int h = 20;
	private TankFrame tf=null;
	
	public Tank(int x,int y,Dir dir,TankFrame tf) {
		super();
		this.x=x;
		this.y=y;
		this.dir=dir;
		this.tf=tf;
	}
	
	 public void paint(Graphics g) {
		 
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
		 tf.listBullet.add(new Bullet(x+4,y+4,dir,tf));
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
