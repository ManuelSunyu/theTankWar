package com.tank;

import java.awt.Graphics;
import java.awt.Rectangle;
/**
 * ��ը
 * @author sy
 *
 */
public class Explode {
	public static int  width=ResourceManager.explodes[0].getWidth();
	public static int  hight=ResourceManager.explodes[0].getHeight();

	private int x;
	private int y;
	TankFrame tf=null;
	private int step=0;

	public Explode(int x,int y,TankFrame tf) {
		super();
		this.x=x;
		this.y=y;
		this.tf=tf;
	}
	
	public void paint(Graphics g) {
		g.drawImage(ResourceManager.explodes[step++], x, y, null);
		if(step>=ResourceManager.explodes.length) {
			tf.explodes.remove(this);
		}
	}
}
