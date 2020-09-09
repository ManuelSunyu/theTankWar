package com.tank.abstractFactory;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.tank.Dir;
import com.tank.Group;
import com.tank.TankFrame;

public abstract class BaseTank {
	public int x;
	public int y;
	public Dir dir = Dir.UP;
	public TankFrame tf=null;
	public Group group = Group.BAD;
	public Rectangle rect = new Rectangle();
	public boolean move = true;

	
	public abstract void paint(Graphics g);
	public abstract void fire();
	public abstract void die();
}
