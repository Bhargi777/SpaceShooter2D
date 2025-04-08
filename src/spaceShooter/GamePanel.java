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

/**
 
 * Extends JPanel to provide custom rendering and input capabilities.
 */
public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final MouseInputs mouseInputs;
	private final Game game;

	/**
	 * Creates a new GamePanel with the specified game instance.
	 * Initializes input handlers and sets up the panel size.
	 *
	 * @param game The game instance to associate with this panel
	 */
	public GamePanel(Game game) {
		if (game == null) {
			throw new IllegalArgumentException("Game instance cannot be null");
		}
		
		this.game = game;
		this.mouseInputs = new MouseInputs(this);
		
		setPanelSize();
		setupInputHandlers();
	}

	private void setupInputHandlers() {
		addKeyListener(new KeyBoardinputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}

	/**
	 * Sets the panel size to match the game dimensions.
	 * Ensures consistent sizing across different platforms.
	 */
	private void setPanelSize() {
		Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
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
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.render(g);
	}

	/**
	 * Returns the associated game instance.
	 *
	 * @return The game instance
	 */
	public Game getGame() {
		return game;
	}
}
