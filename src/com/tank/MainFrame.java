package com.tank;

public class MainFrame {
	
	public static void main(String[] args) throws InterruptedException {
		TankFrame tf = new TankFrame();
		for (int i=0;i<5;i++) {
			tf.enemyList.add(new Tank(150+i*50,50,Dir.DOWN,tf));
		}
		while(true) {
			Thread.sleep(50);
			tf.repaint();
		}
	}

}
