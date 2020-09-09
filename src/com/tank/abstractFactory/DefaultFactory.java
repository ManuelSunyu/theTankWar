package com.tank.abstractFactory;

import com.tank.Bullet;
import com.tank.Dir;
import com.tank.Explode;
import com.tank.Group;
import com.tank.Tank;
import com.tank.TankFrame;

public  class DefaultFactory  extends GameFactory{

	@Override
	public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
		// TODO Auto-generated method stub
		return new Tank(x,y,dir,group,tf);
	}

	@Override
	public BaseExplode createExplode(int x, int y, TankFrame tf) {
		// TODO Auto-generated method stub
		return new Explode(x,y,tf);
	}

	@Override
	public BaseBullet createBullet(int x,int y,Dir dir,Group group,TankFrame tf) {
		// TODO Auto-generated method stub
		return new Bullet(x,y,dir,group,tf);
	}

}
