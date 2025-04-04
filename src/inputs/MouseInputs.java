package inputs;

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import UI.Menu;
import spaceShooter.Game;
import spaceShooter.GamePanel;

public class MouseInputs extends Menu implements MouseListener, MouseMotionListener {
	private GamePanel gamePanel;
	private Rectangle playButton, helpButton, quitButton;
	private int width = 200;
	private int height = 50;

	public MouseInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		initButtons();
	}

	private void initButtons() {
		playButton = new Rectangle(Game.GAME_WIDTH / 3, Game.GAME_HEIGHT / 2, width, height);
		helpButton = new Rectangle(Game.GAME_WIDTH / 3, Game.GAME_HEIGHT / 2 + height + 10, width, height);
		quitButton = new Rectangle(Game.GAME_WIDTH / 3, Game.GAME_HEIGHT / 2 + 2 * (height + 10), width, height);
	}

	protected void Help() {
		JDialog helpDialog = new JDialog((Frame)null, "Game Help", true);
		helpDialog.setLayout(new BorderLayout());
		
		// Create help text
		String helpText = "<html><body style='width: 400px; padding: 10px;'>" +
			"<h2>Space Shooter 2D - Controls</h2>" +
			"<p><b>Movement:</b></p>" +
			"<ul>" +
			"<li>W or Up Arrow: Move up</li>" +
			"<li>A or Left Arrow: Move left</li>" +
			"<li>S or Down Arrow: Move down</li>" +
			"<li>D or Right Arrow: Move right</li>" +
			"</ul>" +
			"<p><b>Actions:</b></p>" +
			"<ul>" +
			"<li>Spacebar: Shoot</li>" +
			"<li>ESC: Return to menu</li>" +
			"<li>Backspace: Quit game</li>" +
			"</ul>" +
			"<p><b>Levels:</b></p>" +
			"<ul>" +
			"<li>Level 1: Basic enemies</li>" +
			"<li>Level 2: Faster enemies</li>" +
			"<li>Level 3: Multiple enemy types</li>" +
			"<li>Level 4: Advanced patterns</li>" +
			"<li>Level 5: Boss battle</li>" +
			"</ul>" +
			"</body></html>";

		JTextPane textPane = new JTextPane();
		textPane.setContentType("text/html");
		textPane.setText(helpText);
		textPane.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(textPane);
		helpDialog.add(scrollPane, BorderLayout.CENTER);
		
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(e -> helpDialog.dispose());
		helpDialog.add(closeButton, BorderLayout.SOUTH);
		
		helpDialog.pack();
		helpDialog.setLocationRelativeTo(null);
		helpDialog.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int xPos = e.getX();
		int yPos = e.getY();
		
		// Check if click is within button bounds
		if (xPos >= playButton.x && xPos <= playButton.x + width) {
			if (yPos >= playButton.y && yPos <= playButton.y + height) {
				Game.state = Game.GameState.GAME;
			} else if (yPos >= helpButton.y && yPos <= helpButton.y + height) {
				Help();
			} else if (yPos >= quitButton.y && yPos <= quitButton.y + height && Game.state == Game.GameState.MENU) {
				System.exit(0);
			} else if (yPos >= quitButton.y && yPos <= quitButton.y + height && Game.state == Game.GameState.RESUME) {
				Game.state = Game.GameState.MENU;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
}
