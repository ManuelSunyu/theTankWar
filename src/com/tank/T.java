package com.tank;

public class T {
	
	public static void main(String[] args) throws InterruptedException {
		TankFrame tf = new TankFrame();
		while(true) {
			Thread.sleep(100);
			tf.repaint();
		}
	}

}
