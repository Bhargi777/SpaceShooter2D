package entities;
/*This class manages creation of bullet and his positions*/
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import utilz.LoadSave;

public class Bullet extends Entity {
	private BufferedImage bullet;

	public Bullet(float x, float y, int width, int height) {
		super(x, y, width, height);
		bullet = LoadSave.GetSpriteAtlas(LoadSave.BULLETS_ATLUS);
	}

	public void render(Graphics g) {
		// hardcoded value 22 player width
		g.drawImage(bullet, (int)x-(bullet.getWidth()/2)+22, (int)y-(bullet.getHeight()/2), null);
	}

	// Updating bullet Positions
	public void update() {
		y -= 1;
	}
	public void updateEnemyBullet(){y+=1;}

	public int getX() {
		return (int)x;
	}
	public int getY() {
		return (int)y;
	}
}
