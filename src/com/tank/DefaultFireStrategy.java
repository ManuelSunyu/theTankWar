package com.tank;

public class DefaultFireStrategy implements FireStrategy {

	@Override
	public void fire(Tank t) {
		 int bx = t.x+Tank.w/2-Bullet.width/2;
		 int by = t.y+Tank.h/2-Bullet.hight/2;
		 new Bullet(bx,by,t.dir,t.group,t.tf);
		 if(t.getGroup()==Group.GOOD)
			 new Thread(()->new Audio("audio/tank_fire.wav"));
	}

}
