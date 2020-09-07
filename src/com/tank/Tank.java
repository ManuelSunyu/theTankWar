package com.tank;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Tank {
	
	 int x;
	 int y;
	 Dir dir = Dir.UP;
	private static final int speed=3;
	private boolean move = true;
	public static int w=ResourceManager.tankGD.getWidth();
	public static int h = ResourceManager.tankGD.getHeight();
	TankFrame tf=null;
	private boolean living=true;
	private Random random = new Random();
	 Group group = Group.BAD;
	
	Rectangle rect = new Rectangle();
	FireStrategy fs = new DefaultFireStrategy();
	
	public Tank(int x,int y,Dir dir,Group group ,TankFrame tf) {
		super();
		this.x=x;
		this.y=y;
		this.dir=dir;
		this.tf=tf;
		this.group=group;
		rect.x=this.x;
		rect.y=this.y;
		rect.height=h;
		rect.width=w;
		
	}
	
	 public void paint(Graphics g) {
		 if(!living) {
			 tf.enemyList.remove(this);
		 }
		 switch(dir) {
			case LEFT:
				g.drawImage(this.group==Group.GOOD?ResourceManager.tankGL:ResourceManager.tankBL, x, y, null);
				break;
			case RIGHT:
				g.drawImage(this.group==Group.GOOD?ResourceManager.tankGR:ResourceManager.tankBR, x, y, null);
				break;
			case UP:
				g.drawImage(this.group==Group.GOOD?ResourceManager.tankGU:ResourceManager.tankBU, x, y, null);
				break;
			case DOWN:
				g.drawImage(this.group==Group.GOOD?ResourceManager.tankGD:ResourceManager.tankBD, x, y, null);
				break;
			default:break;
		}
		
		 move();
	 }
	 
	
	 
	private void move() {
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
		if(this.group==Group.BAD) {
			if(random.nextInt(50)>40) this.fire();
			randomDir();
		}
		
		
		boundsCheck();
		rect.x=this.x;
		rect.y=this.y;
	}
	
	 private void boundsCheck() {
		if(this.group==Group.GOOD) {
			if(x<0) x=Tank.h/20;
			if(y<Tank.w/2) y=Tank.w/2;
			if(x>TankFrame.GMAE_WIDTH-Tank.w)  x = TankFrame.GMAE_WIDTH-Tank.w;
			if(y>TankFrame.GAME_HIGHT-Tank.h) y = TankFrame.GAME_HIGHT-Tank.h;
		}
		if(this.group==Group.BAD) {
			if(x<0) dir=Dir.RIGHT;
			if(y<Tank.w/2)  dir=Dir.DOWN;
			if(x>TankFrame.GMAE_WIDTH-Tank.w) dir=Dir.LEFT;
			if(y>TankFrame.GAME_HIGHT-Tank.h) dir=Dir.UP;
		}
	}

	private void randomDir() {
		 int rand = random.nextInt(100);
		 if(rand<4) {
			 this.dir = Dir.values()[rand];
		 }
	}

	public void fire() {
		fs.fire(this);
		/*if(this.group==Group.GOOD) {
			fs= new FourDirFireStrategy();
			fs.fire(this);
		}
		if(this.group==Group.BAD) {
			fs.fire(this);
		}*/
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

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public TankFrame getTf() {
		return tf;
	}

	public void setTf(TankFrame tf) {
		this.tf = tf;
	}
	 
}
