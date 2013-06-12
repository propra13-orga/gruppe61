
public class Globals {
	
	//Saving variables:
		public static int health;
		public static int life;
		public static int magician;
		public static int money;
		public static int level;
		public static int room;
		public static boolean shot;
		public static int weapon;
		public static int stop;
		public static double x;
		public static double y;
		public static double xneu;
		public static double yneu;
		
		public static double[] arraylokal;// Speichert Position von den Fallen.
		public static int anzahlfallen;
		public static double[] falleneu;
		public static int[] richtung;
		
		
		public static double startx; // Speichert Startpunkt
		public static double starty;
		public static double zielx; 	//Speichert Zielpunkt
		public static double ziely;
		public static String fileName;	//File Name für den Raum
		
		
		
		
		
		
		
		//saving enemy's options:
		static public class enemy{
			//position:
			public static double x;
			public static double y;
			
			//stepsize in moves
			public static double step;
			
			public static boolean move;
			
		}
		
		//saving player's options:
		static public class player{
			//position
			public static double x;
			public static double y;
			
			//stepsize
			public static double step;
		}
		
		

		
}
