package com.tank;

import com.tank.abstractFactory.BaseTank;

public class DefaultFireStrategy implements FireStrategy {

	@Override
	public void fire(BaseTank t) {
		 int bx = t.x+Tank.w/2-Bullet.width/2;
		 int by = t.y+Tank.h/2-Bullet.hight/2;
		// new Bullet(bx,by,t.dir,t.group,t.tf);
		 t.tf.gf.createBullet(bx,by,t.dir,t.group,t.tf);

		 if(t.group==Group.GOOD)
			 new Thread(()->new Audio("audio/tank_fire.wav"));
	}

}
