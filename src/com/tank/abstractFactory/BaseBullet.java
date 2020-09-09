package com.tank.abstractFactory;

import java.awt.Graphics;

import com.tank.Tank;

public abstract class BaseBullet {
	 public abstract void paint(Graphics g);

	public abstract void collideWidth(BaseTank baseTank);
}
