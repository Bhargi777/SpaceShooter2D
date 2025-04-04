package levels;

import entities.Bullet;

import java.awt.*;
import java.util.ArrayList;

public class BulletsManager {
    private ArrayList<Bullet> bullets;

    BulletsManager() {
        bullets = new ArrayList<>();
    }

    /*--- This method manages Bullet positions wrt to game frame and destroys when bullet passes out of the window frame  */
    public void update() {
        for (int i=0;i<bullets.size();i++) {
            if (bullets.get(i).getY() > 0)
                bullets.get(i).update();
            else {
                bullets.remove(i);
            }
        }
    }

    public void render(Graphics g) {
        // rendering bullets
        for (int i=0;i<bullets.size();i++) {
            bullets.get(i).render(g);
        }
    }
    /*
        addBullet()--> this method allows adding a new bullet to the game or simulation at the specified position (x, y).
    */
    public void addBullet(float x, float y) {
        Bullet tmp = new Bullet(x, y, 0, 0);
        bullets.add(tmp);
    }

    /*---------Encapsulations (private fields with public getters/setter)----------*/
    public ArrayList<Bullet> getBullets() {
        return bullets;
    }
}
