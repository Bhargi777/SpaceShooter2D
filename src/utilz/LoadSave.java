package utilz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

//Class for load the images.....
public class LoadSave {
	/*We are Loading image's name into String Variable.we Declared as "Static & final so that it can be directly accessed and Can't be changed further  "*/
	public static final String UI_BACK_G = "bg.png";
	public static final String  UI_TABLE = "menu_background.png";
	public static final String  UI_BUTTON= "button_atlas.png";
	public static final String BACKG_ATLUS= "black.png";
	public static final String BULLETS_ATLUS= "bullet - Copy.png";
	public static final String LEVEL_ONE = "greenbat.png";
	public static final String MAIN_PLAYER = "player.png";
	public static  final String LEVEL_TWO_ENEMY = "enemyBlack1.png";
	public static  final String LEVEL_TWO = "playerShip1_orange.png";
	public static  final String LEVEL_THREE_ENEMY = "enemyBlue1.png";
	public static  final String LEVEL_THREE = "playerShip1_blue.png";
	public static final String LEVEL_FOUR_ENEMY = "enemyGreen1.png";
	public static final String LEVEL_FOUR = "playerShip1_green.png";
	public static final String LEVEL_FIVE_ENEMY = "enemyRed1.png";
	public static final String LEVEL_FIVE = "playerShip1_red.png";
	/*
	public static  final String LEVEL_FOUR_ENEMY = "enemyGreen1.png";
	public static  final String LEVEL_FOUR = "playerShip1_green.png";
	public static  final String LEVEL_FIVE_ENEMY = "enemyRed1.png";
	public static  final String LEVEL_FIVE = "playerShip1_red.png";

	 */




	/*Method to Upload */
	public static BufferedImage GetSpriteAtlas(String fileName) {
		if (fileName == null || fileName.trim().isEmpty()) {
			System.err.println("Error: File name is null or empty");
			return null;
		}

		try {
			// First try to load from the res folder
			File file = new File("res/" + fileName);
			if (file.exists()) {
				return ImageIO.read(file);
			}

			// If not found in res folder, try classpath
			InputStream it = LoadSave.class.getResourceAsStream("/" + fileName);
			if (it != null) {
				return ImageIO.read(it);
			}

			// If still not found, try res folder with absolute path
			file = new File(System.getProperty("user.dir") + "/res/" + fileName);
			if (file.exists()) {
				return ImageIO.read(file);
			}

			System.err.println("Error: Could not find resource: " + fileName);
			return null;
		} catch (IOException e) {
			System.err.println("Error loading image: " + fileName);
			e.printStackTrace();
			return null;
		}
	}

}