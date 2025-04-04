package levels;
/*-------------------Class For BackGround Images -------------------*/
import spaceShooter.Game;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background {
    private BufferedImage bg;

    Background() {
        bg = LoadSave.GetSpriteAtlas(LoadSave.BACKG_ATLUS);
    }

    void render(Graphics g) {
        // Draw tiled background
        for (int i = 0; i < Game.GAME_WIDTH; i += bg.getWidth()) {
            for (int j = 0; j < Game.GAME_HEIGHT; j += bg.getHeight()) {
                g.drawImage(bg, i, j, null);
            }
        }

        // Draw UI elements
        Font font = new Font("Arial", Font.BOLD, 20);
        g.setFont(font);
        
        // Draw pause instruction
        g.setColor(Color.YELLOW);
        g.drawString("Press Enter to Pause", Game.GAME_WIDTH/10-100, Game.GAME_HEIGHT-20);
        
        // Draw enemy count
        g.setColor(Color.WHITE);
        g.drawString("Enemies Left: " + EnemyManager.currentLevelEnemy, Game.GAME_WIDTH-200, 30);
        
        // Draw current level
        g.drawString("Level: " + EnemyManager.currentLevel, 20, 30);
    }
}
