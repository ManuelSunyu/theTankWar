package com.tank;

public class MainFrame {
	
	public static void main(String[] args) throws InterruptedException {
		TankFrame tf = new TankFrame();
		int count =Integer.valueOf( (String) PropertyMgr.get("badtankCount"));
		for (int i=0;i<count;i++) {
			tf.enemyList.add(tf.gf.createTank(50+i*50,90+i*50,Dir.DOWN,Group.BAD,tf));
		}
		new Thread(()->new Audio("audio/war1.wav").loop()).start();
		while(true) {
			Thread.sleep(50);
			tf.repaint();
		}
	}

}
