/**
 * Hier werden einige Variablen gespeichert, auf die im Laufe des Spiels von verschiedenen Klassen zugegriffen werden.
 * 
 *
 */
public class Globals {
	
	//Saving variables:
	
	public static int health;
		public static int life;
		public static int magician;
		public static int weapon;
		public static int ep;
		public static int stop;
		public static int money;
		
		public static int level;
		public static int room;
		public static boolean shot;
		
		
		public static boolean wall; //are walls deactivated?
		public static int damages = 30; // amount of enemies damages
	    public static boolean shout_now;
	    public static boolean ruestung;

		
		public static double x;		//Speichert Position vom Spieler
		public static double y;
		public static double xneu;	//Speichert neue Position vom Spieler f�r die Bewegung
		public static double yneu;
		
		public static double[] fallen;// Speichert Position von den Fallen.so wie die neuen Position wenn die Fallen sich bewegen.
		public static int anzahlfallen;
		public static double[] falleneu;
		public static int[] richtung;	// gibt eine Richtung an in die sich die Falle bewegt.
		
		public static int anzahlboss;	// Speichert Position vom Boss
		public static double[] boss;
		public static double[] boss_neu;
		public static boolean bombing; //is boss bombing?
		public static int health_boss; 
		
		public static double startx; 	// Speichert Startpunkt
		public static double starty;
		public static double zielx; 	//Speichert Zielpunkt
		public static double ziely;
		
		public static String fileName;	//File Name f�r den Raum
		public static int boss_richtung;
		
		
		
		// Hier alle Globalen Variablen f�rs Quest
		public static class quest{

			public static int level;
			public static boolean draw;
			public static int[] array;	// Um Quest Gegenst�nde zusammeln		
			public static int[] zahlen;	// Um sich zu merken welche Zahlen ausgegeben werden.
			public static double[] position; // f�r die Position
			public static int length;
			public static int zeiger;		// ein Zeiger f�r die Reihenfolge
			
			
			
		}
		
		
		
		// Hier wird der NPC gespeichert.
		public static class npc{
			public static double x;
			public static double y;
			public static boolean npc;
		}
		
		
		
		
		//Hier wird gespeichert, ob einige Details gezeichnet werden
		static public class draw{
			public static boolean bomb;
			public static boolean explosion;
		}
		
		//Options about packages
		static public class packet{
			public static boolean draw; //Should a packet be drawn?
			
			//coordinates:
			public static double x;
			public static double y;
		}
		
		//Information about the shop:
		public static class shop {
			public static boolean draw; //Is there a shop in the level?
			
			//coordinates:
			public static double x;
			public static double y;
		}
		
		
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
