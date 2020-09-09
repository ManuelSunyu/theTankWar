package com.tank.abstractFactory;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.tank.DefaultFireStrategy;
import com.tank.Dir;
import com.tank.FireStrategy;
import com.tank.Group;
import com.tank.ResourceManager;
import com.tank.TankFrame;
import com.tank.abstractFactory.BaseTank;

public class RectTank extends BaseTank{
	
	 
	private static final int speed=3;
	public static int w=ResourceManager.tankD.getWidth();
	public static int h = ResourceManager.tankD.getHeight();
	
	private boolean living=true;
	private Random random = new Random();
	
	FireStrategy fs = new DefaultFireStrategy();
	
	public RectTank(int x,int y,Dir dir,Group group ,TankFrame tf) {
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
	
	@Override
	 public void paint(Graphics g) {
		 if(!living) {
			 tf.enemyList.remove(this);
		 }
		 switch(dir) {
			case LEFT:
				g.drawImage(this.group==Group.GOOD?ResourceManager.tankL:ResourceManager.tankL, x, y, null);
				break;
			case RIGHT:
				g.drawImage(this.group==Group.GOOD?ResourceManager.tankR:ResourceManager.tankR, x, y, null);
				break;
			case UP:
				g.drawImage(this.group==Group.GOOD?ResourceManager.tankU:ResourceManager.tankU, x, y, null);
				break;
			case DOWN:
				g.drawImage(this.group==Group.GOOD?ResourceManager.tankD:ResourceManager.tankD, x, y, null);
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
			if(x<0) x=RectTank.h/20;
			if(y<RectTank.w/2) y=RectTank.w/2;
			if(x>TankFrame.GMAE_WIDTH-RectTank.w)  x = TankFrame.GMAE_WIDTH-RectTank.w;
			if(y>TankFrame.GAME_HIGHT-RectTank.h) y = TankFrame.GAME_HIGHT-RectTank.h;
		}
		if(this.group==Group.BAD) {
			if(x<0) dir=Dir.RIGHT;
			if(y<RectTank.w/2)  dir=Dir.DOWN;
			if(x>TankFrame.GMAE_WIDTH-RectTank.w) dir=Dir.LEFT;
			if(y>TankFrame.GAME_HIGHT-RectTank.h) dir=Dir.UP;
		}
	}

	private void randomDir() {
		 int rand = random.nextInt(100);
		 if(rand<4) {
			 this.dir = Dir.values()[rand];
		 }
	}
	@Override
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
	
	public void die() {
		this.living=false;
		
	}
	 
}
