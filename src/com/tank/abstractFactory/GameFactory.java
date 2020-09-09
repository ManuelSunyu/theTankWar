package com.tank.abstractFactory;

import com.tank.Dir;
import com.tank.Group;
import com.tank.TankFrame;

public abstract class GameFactory {
	
	public abstract BaseTank createTank(int x, int y,Dir dir,Group group ,TankFrame tf);
	public abstract BaseExplode createExplode(int x, int y,TankFrame tf);
	public abstract BaseBullet createBullet(int x,int y,Dir dir,Group group,TankFrame tf);
}
