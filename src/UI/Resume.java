package UI;
/*---This class is for Menu and t Buttons and Heading----*/
import spaceShooter.Game;

import java.awt.Graphics;
import java.awt.*;


public class Resume {
    protected int height =50;//Height of Buttons.
    protected int width =200;
    protected int intialPos =200;
    protected Rectangle ResumeButton = new Rectangle(Game.GAME_WIDTH/3+height, intialPos+=50,width,height);
    protected Rectangle MenuButton = new Rectangle(Game.GAME_WIDTH/3+height, intialPos+=100,width,height);
    protected Rectangle quitButton = new Rectangle(Game.GAME_WIDTH/3+height, intialPos+=100,width,height);
    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Algerian", Font.CENTER_BASELINE, 50);
        g.setFont(font);
        g.setColor(Color.CYAN);
        g.drawString("Space Shooter 2d Game",Game.GAME_WIDTH/6,100);

        Font font1 = new Font("arial", Font.BOLD,30);
        g.setFont(font1);
        g.setColor(Color.PINK);
        g.drawString("Next", ResumeButton.x+ResumeButton.x/5,ResumeButton.y+35);

        Font font2 = new Font("arial", Font.BOLD,30);
        g.setFont(font2);
        g.drawString("Quit", MenuButton.x+MenuButton.x/5,MenuButton.y+35);

        Font font3 = new Font("arial", Font.BOLD,30);
        g.setFont(font3);
        g.drawString("Menu", quitButton.x+quitButton.x/5,quitButton.y+35);

        Font font4 = new Font("arial", Font.BOLD,20);
        g.setFont(font4);
        g.setColor(Color.white);
        g.drawString("Enter 'BackSpace' To Exit", Game.GAME_WIDTH/10-100,Game.GAME_HEIGHT);

        g2d.draw(ResumeButton);
        g2d.draw(MenuButton);
        g2d.draw(quitButton);


    }
}
