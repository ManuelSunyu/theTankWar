package com.tank;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.tank.abstractFactory.BaseBullet;
import com.tank.abstractFactory.BaseTank;

public class Bullet extends BaseBullet{
	public static int  width=ResourceManager.bulletD.getWidth();
	public static int  hight=ResourceManager.bulletD.getHeight();

	private static final int speed=10;
	private int x;
	private int y;
	private Dir dir;
	private  boolean living=true;
	TankFrame tf = null;
	private Group group = Group.BAD;
	
	Rectangle rect = new Rectangle();
	
	public Bullet(int x,int y,Dir dir,Group group,TankFrame tf) {
		super();
		this.x=x;
		this.y=y;
		this.dir=dir;
		this.tf=tf;
		this.group=group;
		
		rect.x=this.x;
		rect.y=this.y;
		rect.height=hight;
		rect.width=width;		
		tf.listBullet.add(this);
	}
	
	@Override
	public void paint(Graphics g) {
		if(!living) {
			tf.listBullet.remove(this);
		}
		switch(dir) {
			case LEFT:
				g.drawImage(ResourceManager.bulletL, x, y, null);
				break;
			case RIGHT:
				g.drawImage(ResourceManager.bulletR, x, y, null);
				break;
			case UP:
				g.drawImage(ResourceManager.bulletU, x, y, null);
				break;
			case DOWN:
				g.drawImage(ResourceManager.bulletD, x, y, null);
				break;
			default:break;
		}
		
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
		rect.x=this.x;
		rect.y=this.y;
		if(x<0|| y<0||y>TankFrame.GAME_HIGHT||x>TankFrame.GMAE_WIDTH) {
			living=false;
		}
		
	}
	@Override
	public void collideWidth(BaseTank tank) {
		if(this.group==tank.group) {
			return;
		}
		if(this.rect.intersects(tank.rect)) {
			tank.die();
			this.die();
			tf.explodes.add(tf.gf.createExplode(x, y, tf));
		}
	}

	private void die() {
		this.living=false;
	}
}
