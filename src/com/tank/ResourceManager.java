package com.tank;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceManager {
	
	public static BufferedImage tankGL,tankGR,tankGU,tankGD;
	public static BufferedImage bulletL,bulletR,bulletU,bulletD;
	public static BufferedImage rectBulletL,rectBulletR,rectBulletU,rectBulletD;
	public static BufferedImage tankL,tankR,tankU,tankD;

	public static BufferedImage[] explodes = new BufferedImage[16];
	public static BufferedImage tankBL,tankBR,tankBU,tankBD;
	public static BufferedImage[] rectExplodes = new BufferedImage[16];
	
	static {
		try {
			tankL = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
			tankR = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
			tankU = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
			tankD = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
			tankGU = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
			tankGL = ImageUtil.rotateImage(tankGU, -90);
			tankGR = ImageUtil.rotateImage(tankGU, 90);
			tankGD = ImageUtil.rotateImage(tankGU, 180);
			
			tankBU = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
			tankBL = ImageUtil.rotateImage(tankBU, -90);
			tankBR = ImageUtil.rotateImage(tankBU, 90);
			tankBD = ImageUtil.rotateImage(tankBU, 180);
			
			/*bulletL = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
			bulletR = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
			bulletU = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
			bulletD = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));*/
			bulletU = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
			bulletL = ImageUtil.rotateImage(bulletU, -90);
			bulletR = ImageUtil.rotateImage(bulletU, 90);
			bulletD = ImageUtil.rotateImage(bulletU, 180);
			
			rectBulletU = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
			rectBulletL = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
			rectBulletR = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
			rectBulletD =ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
			
			
			
			for(int i=0;i<16;i++) {
				explodes[i]=ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
			}
			for(int i=0;i<11;i++) {
				rectExplodes[i]=ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/"+i+".gif"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
