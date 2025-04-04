package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import levels.BulletsManager;
import levels.EnemyManager;
import spaceShooter.Game;
import utilz.LoadSave;

public class Player extends Entity {


	//by Using Concept of Abstraction (We declared Variables as private).
	private BufferedImage imgMain;
	private boolean up,down,right,left;
	protected float playerSpeed = 4.0f,playerHeight;
	private BulletsManager bulletsManager;

	private boolean canShoot;
	private int bulletCooldown;
	private final int COOLDOWN = 40;//Reload time
	
	
	
	
	public Player(float x, float y, int width, int height, BulletsManager bulletsManager) {
		super(x,y,width, height);
		//loadAnimation();
		this.bulletsManager = bulletsManager;
		canShoot = true;
		bulletCooldown = 0;
		updatePlayerSprite();
		playerHeight = imgMain.getHeight();
		
	}
	/*--------------------- Updating On Game Loop----------------------*/
	public void update() {
		updatePos();
		bulletReloadTime();
		updatePlayerSprite(); // Update sprite based on current level
		/* Non Used Method calls will use in Future For.
		updateHitbox();
		updateAnimationTick();
		setAnimation();
		*/
	}

	/*Manages Bullet Reload time*/
	private void bulletReloadTime() {
		if (bulletCooldown == 0) {
			canShoot = true;
		} else {
			bulletCooldown--;
		}
	}


	//-----------For Rendering Main Rocket/Bullet-----------------//
	public void render(Graphics g) {
	   // drawHitbox(g);
		g.drawImage(imgMain, (int)x, (int)y, imgMain.getWidth(),imgMain.getHeight(), null);//PlayerRocket
	}

	 /* Class's Method ---->Player Rockets Positions of where it can't Move..*/
	private void updatePos() {
		if(!left && !right && !up && !down)
			return;
		if(left && !right) {
			x-=playerSpeed;
		}
		else if(right && !left) {
			x+=playerSpeed;
		}
		if(up && !down) {
			y-=playerSpeed;
		}
		else if(down && !up) {
			y+=playerSpeed;
		}

		/* ---------------Method For  Rocket Positions Updation /Limitation ---------------*/
		if(x<0)
			x=0;
		else if (x> Game.GAME_WIDTH-imgMain.getWidth())
			x= Game.GAME_WIDTH-imgMain.getWidth();
		if(y<600)
			y=600;
		else if (y> Game.GAME_HEIGHT-imgMain.getHeight())
			y = Game.GAME_HEIGHT-imgMain.getHeight();
		
	}

	/*------------- Bullet Reload-----------------*/
	public void handleShoot() {
		if (canShoot) {
			bulletsManager.addBullet(x, y);
			canShoot = false;
			bulletCooldown = COOLDOWN;
		}
	}
	
	/*
	 	resetDirBooleans()---> No movement until we do not press any key of A/S/W/D or Starting Of The Game.
	*/
	public void resetDirBooleans() {
		left=false;
		right=false;
		up=false;
		down=false;
	}
	
	/*-------------------Encapsulations (private fields with public getters/setter)--------------------------*/
	public void setUp(Boolean up) {
		this.up = up;
	}
	public void setDown(Boolean down) {
		this.down = down;
	}
	public void setRight(Boolean right) {
		this.right = right;
	}
	public void setLeft(Boolean left) {
		this.left = left;
	}

	//---------------------- For Update Rocket BackSide Fire By Indexing----------------//
	/* public void updateAnimationTick() {
		aniTick++;
		if(aniTick>=aniSpeed) {
			aniTick=0;
			aniIndex++;
			if(aniIndex>=3)
				aniIndex =1;
		}
	}
	private void setAnimation() {
		PlayerAction=RUNNING;
	}
	*/

	/*---------------Animation of Rocket BackSide Fire ---------------------*/
	/*private void loadAnimation() {
		smoke=LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLUS);
		animation = new BufferedImage[2][3];
		for(int i=0;i<animation.length;i++) {
			for(int j=0;j<animation[i].length;j++) {
				animation[i][j]= smoke.getSubimage(j*190, i*200, 190, 200);
			}
		}
	} */

	private void updatePlayerSprite() {
		switch(EnemyManager.currentLevel) {
			case 1:
				imgMain = LoadSave.GetSpriteAtlas(LoadSave.MAIN_PLAYER);
				break;
			case 2:
				imgMain = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_TWO);
				break;
			case 3:
				imgMain = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_THREE);
				break;
			case 4:
				imgMain = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_FOUR);
				break;
			case 5:
				imgMain = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_FIVE);
				break;
			default:
				imgMain = LoadSave.GetSpriteAtlas(LoadSave.MAIN_PLAYER);
		}
	}
}