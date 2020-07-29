package com.tank;

public class MainFrame {
	
	public static void main(String[] args) throws InterruptedException {
		TankFrame tf = new TankFrame();
		while(true) {
			Thread.sleep(50);
			tf.repaint();
		}
	}

}
