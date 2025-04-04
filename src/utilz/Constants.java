package utilz;

public class Constants {
	/*-- At Present Directions & PlayerConstants Class are not in used. */
	public static class Directions{

		public static final int LEFT=0;
		public static final int UP=1;
		public static final int RIGHT=2;
		public static final int DOWN=3;
	}
	public static class PlayerConstants{
		public static final int IDLE=0;
		public static final int RUNNING=1;


		public static int getSpriteAmount(int player_action) {
			switch(player_action) {
			case RUNNING: return 3;
			case IDLE: return 3;
			
			default: return 3;
			
			}
		}
	}
	/*
		------------ Level Creation of Game ------------------
		1 ---> Enemy will be rendered that Position.
		0 ---> Empty Position.

	 */
	public static class EnemyConstants{
		public static final int EnemyLvlOneGrid[][] = new int[][]{
			{1, 0, 1, 0, 1, 0, 1, 0, 1},
			{0, 1, 0, 1, 0, 1, 0, 1, 0},
			{1, 0, 1, 0, 1, 0, 1, 0, 1},
			{0, 1, 0, 1, 0, 1, 0, 1, 0}
		};
		public static final int EnemyLvlTwoGrid[][] = new int[][]{
				{1, 0, 0, 0, 1, 1, 0, 0, 1},
				{1, 1, 0, 1, 1, 1, 0, 1, 0},
				{1, 0, 1, 0, 1, 1, 1, 0, 0},
				{1, 0, 0, 0, 1, 1, 0, 1, 0},
				{1, 0, 0, 0, 1, 1, 0, 0, 1}
		};
		public static final int EnemyLvlThreeGrid[][] = new int[][]{
				{1, 0, 0, 1, 0, 0, 1, 0, 0,1},
				{0, 1, 1, 0, 1, 1, 0, 1, 1,0},
				{1, 0, 0, 1, 0, 0, 1, 0, 0,1},
				{0, 1, 1, 0, 1, 1, 0, 1, 1,0},
				{1, 0, 0, 1, 0, 0, 1, 0, 0,1}
		};

		public static final int EnemyLvlFourGrid[][] = new int[][]{
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
				{1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
				{1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
				{1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
				{1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
				{1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
				{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
		};

		public static final int EnemyLvlFiveGrid[][] = new int[][]{
				{1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
				{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
				{1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
				{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
				{1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
				{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
				{1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1}
		};
	}
}
