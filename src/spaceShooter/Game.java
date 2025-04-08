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

public class Game implements Runnable {
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	private LevelManager levelManager;
	private BufferedImage backGroundImage;
	private Menu menu;
	private Resume resume;
	private volatile boolean running = true;

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

	/*
		----------------Enum for Game States---------------
	 enum --->	Java, an enum, short for enumeration, is a special data type used to define a set of named constants.
	          	These constants represent a fixed number of possible values for a variable.
	          	enum is a special 'class' that represents a group of constants (enumerated values).
	*/
	public enum GameState { MENU, GAME, RESUME, NEXT }
	public static GameState state = GameState.MENU;

	/*--------------------Constructor---------------------*/
	public Game() {
		try {
			initClasses();
			gamePanel = new GamePanel(this);
			gameWindow = new GameWindow(gamePanel);
			gamePanel.requestFocus();
			startGameLoop();
		} catch (Exception e) {
			System.err.println("Error initializing game: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
	}

	private void initClasses() {
		backGroundImage = LoadSave.GetSpriteAtlas(LoadSave.UI_BACK_G);
		if (backGroundImage == null) {
			throw new RuntimeException("Failed to load background image");
		}
		menu = new Menu();
		resume = new Resume();
		levelManager = new LevelManager(this);
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
			System.err.println("Error stopping game thread: " + e.getMessage());
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
					// Handle level transition or next state
					break;
				default:
					throw new IllegalStateException("Unknown game state: " + state);
			}
		} catch (Exception e) {
			System.err.println("Error in game update: " + e.getMessage());
			e.printStackTrace();
			// Don't exit the game, just log the error
		}
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
					// Handle next state rendering
					break;
				default:
					throw new IllegalStateException("Unknown game state: " + state);
			}
		} catch (Exception e) {
			System.err.println("Error in game render: " + e.getMessage());
			e.printStackTrace();
			// Don't exit the game, just log the error
		}
	}

	/*------------Encapsulations (private fields with public getters/setter)---------------*/
	public LevelManager getLevelManager() {
		return levelManager;
	}

	public static void main(String[] args) {
		new Game();
	}
}
