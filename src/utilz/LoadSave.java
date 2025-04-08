package utilz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

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
			throw new IllegalArgumentException("File name cannot be null or empty");
		}

		try {
			// Try loading from classpath first (preferred method)
			InputStream it = LoadSave.class.getResourceAsStream("/" + fileName);
			if (it != null) {
				return ImageIO.read(it);
			}

			// If not found in classpath, try res folder
			Path resPath = Paths.get("res", fileName);
			File file = resPath.toFile();
			if (file.exists()) {
				return ImageIO.read(file);
			}

			// If still not found, try absolute path
			Path absolutePath = Paths.get(System.getProperty("user.dir"), "res", fileName);
			file = absolutePath.toFile();
			if (file.exists()) {
				return ImageIO.read(file);
			}

			throw new IOException("Resource not found: " + fileName);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load image: " + fileName, e);
		}
	}

}