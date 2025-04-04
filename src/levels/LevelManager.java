package levels;
import java.awt.Graphics;
import java.util.logging.Level;

import static spaceShooter.Game.*;

import entities.Player;
import spaceShooter.Game;
import utilz.LoadSave;

public class LevelManager {
	private Game game;
	private Player player;

	private Background bg;
	protected EnemyManager enemyManager;
	private BulletsManager bulletsManager;

	public LevelManager(){}
	/*-----------------Constructor where Initializing Objects of Required References of Class--------- */
	public LevelManager(Game game) {
		bg = new Background();
		bulletsManager = new BulletsManager();
		enemyManager = new EnemyManager(bulletsManager);
		player=new Player(GAME_WIDTH/3,GAME_HEIGHT-48,(int)(64*SCALE),(int)(40*SCALE), bulletsManager);//Initial Position of Player Rocket
	}
	public static void init(){

	}


	/*------------This Rendering All objects of Game --------------*/
	public void draw(Graphics g) {
		bg.render(g);//BackGround Image
		bulletsManager.render(g);//To manage Bullets Positions
		enemyManager.render(g);//To manage EnemyShip Positions
		player.render(g);//To manage Player Positions
	}

	/*------------Updating positions of Objects of Game--------------*/
	public void update() {
		player.update(); //Player Moment.
		enemyManager.update();//EnemyShip Moment.
		bulletsManager.update();//Bullet Moment.
	}

	/*-----------For Focus Lost Of Window Positions-----------------*/
	public void windowFocusLost() {
		player.resetDirBooleans();
	}

	/*----------Encapsulations (private fields with public getters/setter) -------------------*/
	public Player getPlayer() {
		return player;
	}


	
}
