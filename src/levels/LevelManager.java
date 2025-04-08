package levels;
import java.awt.Graphics;

import static spaceShooter.Game.*;

import entities.Player;
import spaceShooter.Game;
import utilz.LoadSave;

public class LevelManager {
	private Player player;
	private Background bg;
	protected EnemyManager enemyManager;
	private BulletsManager bulletsManager;

	public LevelManager() {
		// Default constructor
	}

	public LevelManager(Game game) {
		bg = new Background();
		bulletsManager = new BulletsManager();
		enemyManager = new EnemyManager(bulletsManager);
		player = new Player(GAME_WIDTH/3, GAME_HEIGHT-48, (int)(64*SCALE), (int)(40*SCALE), bulletsManager);
	}

	public void draw(Graphics g) {
		bg.render(g);
		bulletsManager.render(g);
		enemyManager.render(g);
		player.render(g);
	}

	public void update() {
		player.update();
		enemyManager.update();
		bulletsManager.update();
	}

	public void windowFocusLost() {
		player.resetDirBooleans();
	}

	public Player getPlayer() {
		return player;
	}
}
