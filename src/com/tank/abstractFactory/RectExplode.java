package com.tank.abstractFactory;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.tank.ResourceManager;
import com.tank.TankFrame;
import com.tank.abstractFactory.BaseExplode;
/**
 * ±¬Õ¨
 * @author sy
 *
 */
public class RectExplode extends BaseExplode{
	public static int  width=ResourceManager.rectExplodes[0].getWidth();
	public static int  hight=ResourceManager.rectExplodes[0].getHeight();

	private int x;
	private int y;
	TankFrame tf=null;
	private int step=0;

	public RectExplode(int x,int y,TankFrame tf) {
		super();
		this.x=x;
		this.y=y;
		this.tf=tf;
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(ResourceManager.rectExplodes[step++], x, y, null);
		if(step>=ResourceManager.rectExplodes.length) {
			tf.explodes.remove(this);
		}
	}
}
