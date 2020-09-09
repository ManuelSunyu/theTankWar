package com.tank.abstractFactory;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.tank.Dir;
import com.tank.Group;
import com.tank.ResourceManager;
import com.tank.Tank;
import com.tank.TankFrame;
import com.tank.abstractFactory.BaseBullet;

public class RectBullet extends BaseBullet{
	public static int  width=ResourceManager.rectBulletD.getWidth();
	public static int  hight=ResourceManager.rectBulletD.getHeight();

	private static final int speed=10;
	private int x;
	private int y;
	private Dir dir;
	private  boolean living=true;
	TankFrame tf = null;
	private Group group = Group.BAD;
	
	Rectangle rect = new Rectangle();
	
	public RectBullet(int x,int y,Dir dir,Group group,TankFrame tf) {
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
				g.drawImage(ResourceManager.rectBulletL, x, y, null);
				break;
			case RIGHT:
				g.drawImage(ResourceManager.rectBulletR, x, y, null);
				break;
			case UP:
				g.drawImage(ResourceManager.rectBulletU, x, y, null);
				break;
			case DOWN:
				g.drawImage(ResourceManager.rectBulletD, x, y, null);
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
