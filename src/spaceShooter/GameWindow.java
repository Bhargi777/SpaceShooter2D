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

public class GameWindow {
	private JFrame jframe;
	public GameWindow(GamePanel gamepanel) {
		jframe= new JFrame();
		
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//To set Exit click to  close
		jframe.add(gamepanel);//jframe adding gamePanel.
		jframe.setResizable(true);//for customize gameWindow by Users.
		jframe.pack();
		jframe.setVisible(true);//Initially visibility is false we have to give pass 'true' for visibility of window.

		/*-------All about focus of game Window------*/
		jframe.addWindowFocusListener(new WindowFocusListener() {

			@Override
			public void windowGainedFocus(WindowEvent e) {
				
				
			}

			@Override
			public void windowLostFocus(WindowEvent e) {
				gamepanel.getGame().getLevelManager().windowFocusLost();//gamePanel--->Game--->levelManager---->checking focus of window
				
			}
		});
	}
}
