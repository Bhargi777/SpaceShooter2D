package UI;
/*---This class is for Menu and t Buttons and Heading----*/
import spaceShooter.Game;

import java.awt.Graphics;
import java.awt.*;


public class Menu {
    protected int height = 50;//Height of Buttons.
    protected int width = 200;
    protected Rectangle playButton = new Rectangle(Game.GAME_WIDTH/3, Game.GAME_HEIGHT/2, width, height);
    protected Rectangle helpButton = new Rectangle(Game.GAME_WIDTH/3, Game.GAME_HEIGHT/2 + height + 10, width, height);
    protected Rectangle quitButton = new Rectangle(Game.GAME_WIDTH/3, Game.GAME_HEIGHT/2 + 2 * (height + 10), width, height);

    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        
        // Draw title
        Font titleFont = new Font("Algerian", Font.CENTER_BASELINE, 50);
        g.setFont(titleFont);
        g.setColor(Color.CYAN);
        g.drawString("Space Shooter 2D Game", Game.GAME_WIDTH/6, 100);

        // Draw buttons
        Font buttonFont = new Font("Arial", Font.BOLD, 30);
        g.setFont(buttonFont);
        g.setColor(Color.PINK);
        
        // Draw button text
        g.drawString("Play", playButton.x + width/3, playButton.y + 35);
        g.drawString("Help", helpButton.x + width/3, helpButton.y + 35);
        g.drawString("Quit", quitButton.x + width/3, quitButton.y + 35);

        // Draw exit instruction
        Font instructionFont = new Font("Arial", Font.BOLD, 20);
        g.setFont(instructionFont);
        g.setColor(Color.WHITE);
        g.drawString("Press Backspace To Exit", 20, Game.GAME_HEIGHT - 20);

        // Draw button outlines
        g2d.setColor(Color.WHITE);
        g2d.draw(playButton);
        g2d.draw(helpButton);
        g2d.draw(quitButton);
    }

    protected void Help(){
        System.out.println("\n----------------Thank You------------We can't Help You\n");
    }
}
