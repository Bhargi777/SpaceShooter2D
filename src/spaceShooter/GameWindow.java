package spaceShooter;

/*-
*  Game----> GamWindow
* ------------------- Visibility of GameWindow(using Java's awt/JFrame packages) -------------------*
* java.awt          ----> Java AWT (Abstract Window Toolkit) is one of the core packages provided by Java for
* 						   creating graphical user interfaces (GUIs) and handling basic graphics operations.
*                          It's one of the earliest GUI libraries in Java and is part of the Java Foundation Classes (JFC).
*
* javax.swing.JFrame.----> The JFrame class is part of the Java Swing library, which provides more advanced GUI components and features compared to the AWT library.
* 						    JFrame is a top-level container that represents a window in a Swing-based application. It extends the java.awt.
* 							Frame class and provides additional functionality specific to Swing.
*/

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

/**
 * GameWindow class manages the main application window.
 * Handles window creation, focus events, and game panel integration.
 */
public class GameWindow {
	private final JFrame jframe;

	/**
	 * Creates a new game window with the specified game panel.
	 *
	 * @param gamePanel The game panel to display in the window
	 * @throws IllegalArgumentException if gamePanel is null
	 */
	public GameWindow(GamePanel gamePanel) {
		if (gamePanel == null) {
			throw new IllegalArgumentException("GamePanel cannot be null");
		}

		jframe = new JFrame("Space Shooter 2D");
		setupWindow(gamePanel);
		setupFocusListener(gamePanel);
	}

	private void setupWindow(GamePanel gamePanel) {
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(gamePanel);
		jframe.setResizable(false); // Prevent window resizing for consistent gameplay
		jframe.pack();
		jframe.setLocationRelativeTo(null); // Center the window
		jframe.setVisible(true);
	}

	private void setupFocusListener(GamePanel gamePanel) {
		jframe.addWindowFocusListener(new WindowFocusListener() {
			@Override
			public void windowGainedFocus(WindowEvent e) {
				// Can be used to resume game or update UI when window gains focus
			}

			@Override
			public void windowLostFocus(WindowEvent e) {
				gamePanel.getGame().getLevelManager().windowFocusLost();
			}
		});
	}
}
