package spaceShooter;
/*      Mainly In this Class We're Creating Game Loop.
 *      And Deciding Size of Game's Height , Width.
 *      This class will.
  */
import java.awt.*;
import java.awt.image.BufferedImage;

import UI.Menu;
import UI.Resume;
import levels.LevelManager;
import utilz.LoadSave;

/**
 * Main game class that handles the game loop, window management, and state transitions.
 * Controls the overall game flow and rendering.
 */
public class Game implements Runnable {
	private GameWindow gameWindow;
	private final GamePanel gamePanel;
	private Thread gameThread;
	private final LevelManager levelManager;
	private final BufferedImage backGroundImage;
	private final Menu menu;
	private final Resume resume;
	private volatile boolean running = true;

	// Game loop settings
	private final int FPS_SET = 120;
	private final int UPS_SET = 200;

	/*-------------Instance Variables for Deciding Game Window-------------*/
	public static final int TILES_DEFAULT_SIZE = 80;
	public static final float SCALE = 1.04f;
	public static final int TILES_IN_WIDTH = 12;
	public static final int TILES_IN_HEIGHT = 10;
	public static final int TILES_SIZE = (int)(TILES_DEFAULT_SIZE * SCALE);
	public static final int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
	public static final int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;

	/**
	 * Represents the different states the game can be in.
	 */
	public enum GameState { 
		MENU,    // Main menu state
		GAME,    // Active gameplay state
		RESUME,  // Pause/resume menu state
		NEXT     // Level transition state
	}
	
	public static GameState state = GameState.MENU;

	/*--------------------Constructor---------------------*/
	public Game() {
		// Initialize final fields
		BufferedImage tempBackGroundImage = null;
		Menu tempMenu = null;
		Resume tempResume = null;
		LevelManager tempLevelManager = null;
		GamePanel tempGamePanel = null;
		GameWindow tempGameWindow = null;

		try {
			// Initialize game components
			tempBackGroundImage = LoadSave.GetSpriteAtlas(LoadSave.UI_BACK_G);
			if (tempBackGroundImage == null) {
				throw new RuntimeException("Failed to load background image");
			}
			
			tempMenu = new Menu();
			tempResume = new Resume();
			tempLevelManager = new LevelManager(this);
			
			// Create and setup game panel and window
			tempGamePanel = new GamePanel(this);
			tempGameWindow = new GameWindow(tempGamePanel);
			tempGamePanel.requestFocus();
			
			// Start the game loop
			startGameLoop();
		} catch (RuntimeException e) {
			System.err.println("Fatal error initializing game: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}

		// Assign the final fields after successful initialization
		this.backGroundImage = tempBackGroundImage;
		this.menu = tempMenu;
		this.resume = tempResume;
		this.levelManager = tempLevelManager;
		this.gamePanel = tempGamePanel;
		this.gameWindow = tempGameWindow;
	}

	/*-----------------Creating & Starting Thread For Game---------------*/
	private void startGameLoop() {
		gameThread = new Thread(this, "Game Thread");
		gameThread.start();
	}

	public void stop() {
		running = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.err.println("Game thread interrupted during shutdown: " + e.getMessage());
		}
	}

	/*-------------Game Loop-------------*/
	public void run() {
		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;
		
		long previousTime = System.nanoTime();
		int frames = 0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();
		double deltaU = 0;
		double deltaF = 0;

		while (running) {
			long currentTime = System.nanoTime();
			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;

			if (deltaU >= 1) {
				update();
				updates++;
				deltaU--;
			}

			if (deltaF >= 1) {
				gamePanel.repaint();
				frames++;
				deltaF--;
			}
			
			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames + "  |  UPS: " + updates);
				frames = 0;
				updates = 0;
			}

			// Use yield instead of sleep for better performance
			Thread.yield();
		}
	}

	/*--------------Update Method, Which is responsible for all updates in Game-------*/
	private void update() {
		try {
			switch (state) {
				case GAME:
					levelManager.update();
					break;
				case RESUME:
					resume.update();
					break;
				case MENU:
					menu.update();
					break;
				case NEXT:
					handleNextState();
					break;
				default:
					throw new IllegalStateException("Unknown game state: " + state);
			}
		} catch (RuntimeException e) {
			System.err.println("Error in game update: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private void handleNextState() {
		// Transition to next level or game state
		// This can be expanded to handle level progression
		state = GameState.GAME;
	}

	/*render() ---> often relates to graphical user interfaces (GUIs) and involves drawing components or graphics onto the screen....*/
	/*Note----> drawing is a part of rendering, but rendering involves a broader set of processes beyond just drawing individual elements.*/
	public void render(Graphics g) {
		try {
			if (backGroundImage != null) {
				g.drawImage(backGroundImage, 0, 0, null);
			}
			
			switch (state) {
				case GAME:
					levelManager.draw(g);
					break;
				case MENU:
					menu.render(g);
					break;
				case RESUME:
					resume.render(g);
					break;
				case NEXT:
					handleNextStateRendering(g);
					break;
				default:
					throw new IllegalStateException("Unknown game state: " + state);
			}
		} catch (RuntimeException e) {
			System.err.println("Error in game render: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private void handleNextStateRendering(Graphics g) {
		// Render transition effects or loading screen
		// This can be expanded to show level transition animations
		levelManager.draw(g);
	}

	/*------------Encapsulations (private fields with public getters/setter)---------------*/
	public LevelManager getLevelManager() {
		return levelManager;
	}

	public static void main(String[] args) {
		new Game();
	}
}
