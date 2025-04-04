package levels;
/*
  This class is Managing EnemyShip's positions , collision with bullet .
*/
import java.awt.*;
import java.util.ArrayList;

import Level_Upgradation.Upgrade_Level;
import entities.EnemyShip;
import spaceShooter.Game;
import utilz.Constants;
import utilz.LoadSave;

public class EnemyManager implements Upgrade_Level {
	private ArrayList<EnemyShip> enemyShips;//Container for EnemyShip.
	private ArrayList<Point> arrayCoordinates;//Container for Coordinates.
	private BulletsManager bulletsManager;
	private int maxLevel= 5;
	public static  int currentLevelEnemy ;
	private int LevelOneCountDown =18;//LevelOneCountDown.
	private int LevelTwoCountDown = 23;
	private int LevelThreeCountDown=24;
	private int LevelFourCountDown=30;
	private int LevelFiveCountDown=35;
	public static int currentLevel=1;
	private int currentState[][];//for current Executing Level.


	/*----------Object Instantiation----------*/
	EnemyManager(BulletsManager bulletsManager) {
		enemyShips = new ArrayList<>();
		arrayCoordinates = new ArrayList<>();
		this.bulletsManager = bulletsManager;
		updateLevel();
	}


	/*-------------Level -1 (Toggle Right to Left |Even --> moveToRight(true)|Odd --->moveToRight(false) --------------*/
	public void LevelOne() {
		currentLevelEnemy=LevelOneCountDown;
		currentState = new int[Constants.EnemyConstants.EnemyLvlOneGrid.length][Constants.EnemyConstants.EnemyLvlOneGrid[0].length];
		for (int i=1;i<=Constants.EnemyConstants.EnemyLvlOneGrid.length;i++) {
			for (int j=1;j<=Constants.EnemyConstants.EnemyLvlOneGrid[0].length;j++) {
				if (Constants.EnemyConstants.EnemyLvlOneGrid[i-1][j-1] == 1) {
					currentState[i-1][j-1] = Constants.EnemyConstants.EnemyLvlOneGrid[i-1][j-1];
					/*Movement of EnemyShip*/
					if (i%2 == 0) {
						EnemyShip e = new EnemyShip(Game.TILES_SIZE*j, Game.TILES_SIZE*i, 45, 48, true, bulletsManager, LoadSave.LEVEL_ONE);
						enemyShips.add(e);
						arrayCoordinates.add(new Point(i-1, j-1));
					} else {
						EnemyShip e = new EnemyShip(Game.TILES_SIZE*j, Game.TILES_SIZE*i, 45, 48, false, bulletsManager,LoadSave.LEVEL_ONE);
						enemyShips.add(e);
						arrayCoordinates.add(new Point(i-1, j-1));
					}
				}
			}
		}
	}

	/*---------Level Two (MK Patter | Toggle-->moveToRight()----*/
	public void LevelTwo() {
		currentLevelEnemy=LevelTwoCountDown;
		currentState = new int[Constants.EnemyConstants.EnemyLvlTwoGrid.length][Constants.EnemyConstants.EnemyLvlTwoGrid[0].length];
		for (int i=1;i<=Constants.EnemyConstants.EnemyLvlTwoGrid.length;i++) {
			for (int j=1;j<=Constants.EnemyConstants.EnemyLvlTwoGrid[0].length;j++) {
				if (Constants.EnemyConstants.EnemyLvlTwoGrid[i-1][j-1] == 1) {
					currentState[i-1][j-1] = Constants.EnemyConstants.EnemyLvlTwoGrid[i-1][j-1];
					EnemyShip e = new EnemyShip(Game.TILES_SIZE*j, Game.TILES_SIZE*i, 45, 48, true, bulletsManager,LoadSave.LEVEL_TWO_ENEMY);
					enemyShips.add(e);
					arrayCoordinates.add(new Point(i-1, j-1));

				}
			}
		}
	}

	/*------------Level Three ()|wave Pattern |---------*/
	public void LevelThree() {
		currentLevelEnemy=LevelThreeCountDown;
		currentState = new int[Constants.EnemyConstants.EnemyLvlThreeGrid.length][Constants.EnemyConstants.EnemyLvlThreeGrid[0].length];
		for (int i=1;i<=Constants.EnemyConstants.EnemyLvlThreeGrid.length;i++) {
			for (int j=1;j<=Constants.EnemyConstants.EnemyLvlThreeGrid[0].length;j++) {
				if (Constants.EnemyConstants.EnemyLvlThreeGrid[i-1][j-1] == 1) {
						EnemyShip e = new EnemyShip(Game.TILES_SIZE*j, Game.TILES_SIZE*i, 45, 48, true, bulletsManager, LoadSave.LEVEL_THREE_ENEMY);
						enemyShips.add(e);
						arrayCoordinates.add(new Point(i-1, j-1));

				}
			}
		}
	}

	public void LevelFour() {
		currentLevelEnemy=LevelFourCountDown;
		currentState = new int[Constants.EnemyConstants.EnemyLvlFourGrid.length][Constants.EnemyConstants.EnemyLvlFourGrid[0].length];
		for (int i=1;i<=Constants.EnemyConstants.EnemyLvlFourGrid.length;i++) {
			for (int j=1;j<=Constants.EnemyConstants.EnemyLvlFourGrid[0].length;j++) {
				if (Constants.EnemyConstants.EnemyLvlFourGrid[i-1][j-1] == 1) {
					currentState[i-1][j-1] = Constants.EnemyConstants.EnemyLvlFourGrid[i-1][j-1];
					EnemyShip e = new EnemyShip(Game.TILES_SIZE*j, Game.TILES_SIZE*i, 45, 48, true, bulletsManager, LoadSave.LEVEL_FOUR_ENEMY);
					enemyShips.add(e);
					arrayCoordinates.add(new Point(i-1, j-1));
				}
			}
		}
	}

	public void LevelFive() {
		currentLevelEnemy=LevelFiveCountDown;
		currentState = new int[Constants.EnemyConstants.EnemyLvlFiveGrid.length][Constants.EnemyConstants.EnemyLvlFiveGrid[0].length];
		for (int i=1;i<=Constants.EnemyConstants.EnemyLvlFiveGrid.length;i++) {
			for (int j=1;j<=Constants.EnemyConstants.EnemyLvlFiveGrid[0].length;j++) {
				if (Constants.EnemyConstants.EnemyLvlFiveGrid[i-1][j-1] == 1) {
					currentState[i-1][j-1] = Constants.EnemyConstants.EnemyLvlFiveGrid[i-1][j-1];
					EnemyShip e = new EnemyShip(Game.TILES_SIZE*j, Game.TILES_SIZE*i, 45, 48, true, bulletsManager, LoadSave.LEVEL_FIVE_ENEMY);
					enemyShips.add(e);
					arrayCoordinates.add(new Point(i-1, j-1));
				}
			}
		}
	}

	/*----------Handling attack and removing EnemyShip --------*/
	public void update(){
		for (int i=0;i<enemyShips.size();i++) {
			if (enemyShips.get(i).handleAttack()) {
				enemyShips.remove(i);//
				currentLevelEnemy-=1;//Count Down For current State.
				if( currentLevelEnemy==0){ Score(); }//For scoreboard .|Score()----checked exit condition---False--->updateLevel().
				currentState[arrayCoordinates.get(i).x][arrayCoordinates.get(i).y] = 0;

			}
		}
/*-------At time of calling Update() ,how many enemy Has Added into enemyShip container that will be updating wrt UPS */
		for (int i=0;i<enemyShips.size();i++) {
			enemyShips.get(i).update();
		}
	}
	public void render(Graphics g) {
		for (int i=0;i<enemyShips.size();i++) {
			//if(enemyShips.get(i).moveToRight) //For more updation of level.
				enemyShips.get(i).render(g);
        }
	}
	public void Score() {
		if(maxLevel<currentLevel){
			System.exit(0);//System. exit(0) method terminates JVM which results in termination of the currently running program too.
		}
		 updateLevel();
	}
	/*-----------Level Upgrade---------*/
	private void updateLevel() {
		//Game.state = Game.gameState.RESUME;
		switch (currentLevel++){
			case 1:LevelOne();
				break;
			case 2:LevelTwo();
				break;
			case 3:LevelThree();
				break;
			case 4:LevelFour();
				break;
			case 5:LevelFive();
				break;
			default:break;
		}
	}

}
