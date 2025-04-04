package spaceShooter;

/*----------------Class for HandLing GamePanel---------------
*java.awt.Graphics--->The Graphics class in Java AWT (Abstract Window Toolkit) provides methods for drawing graphics onto various surfaces,
*                      such as windows, panels, and images. It allows you to perform various graphical operations, including drawing shapes,
*                      text, and images.
*
*/
import java.awt.Dimension;
import static spaceShooter.Game.GAME_HEIGHT;
import static spaceShooter.Game.GAME_WIDTH;
import java.awt.Graphics;

import javax.swing.JPanel;
import inputs.KeyBoardinputs;
import inputs.MouseInputs;


public class GamePanel extends JPanel {
	private MouseInputs mouseinputs;
	private Game game;

	/*---------------GamePanel Constructor, Here We're Handling KeyBoard & MouseInputs-------*/
	public GamePanel(Game game) {
		mouseinputs=new MouseInputs(this);//
	    this.game=game;
		setPanelsize();
	
		addKeyListener(new KeyBoardinputs(this));
		addMouseListener(mouseinputs);
		addMouseMotionListener(mouseinputs);
	}


	/*This setPanelsize()---> method appears to be part of a class responsible for setting the size of a panel,
	                          likely within a Swing or AWT-based graphical application.
	 */
	private void setPanelsize() {
		Dimension size=new Dimension(GAME_WIDTH,GAME_HEIGHT);
		setMinimumSize(size);
		setMaximumSize(size);
		setPreferredSize(size);
		System.out.println("size: "+GAME_WIDTH +" : "+ GAME_HEIGHT);
		
	}

	/*
	This paintComponent()-->
								method appears to override the paintComponent method inherited from a Swing or AWT component,
	                            likely a JPanel, and it's used for custom painting.

	  		 					The method overrides the paintComponent method inherited from the superclass (likely JPanel).
	  		 					This method is called automatically whenever Swing determines that the panel needs to be redrawn,
	          					such as when it's first displayed, resized, or requested to repaint.

	  It super.paintComponent(g)--->
	  							to ensure that any default painting behavior provided by the superclass is executed.
	  							This is important to avoid potential artifacts and ensure proper painting of the component's border, background, and other default elements.


	*/
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.render(g);
		
	}

	public Game getGame() {
		return game;
	}
}
