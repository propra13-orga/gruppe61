/**
 * Klasse zum Speichern und laden.
 */
public class Speicher {
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
	public static double xneu;	//Speichert neue Position vom Spieler für die Bewegung
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
	
	public static String fileName;	//File Name für den Raum
	public static int boss_richtung;
	
	
	
	//Variablen fürs Speichern
	public static class speicher{

		public static boolean draw;
		public static double x;
		public static double y;
		
	}
	
	
	//Hier Variablen fürs Netzwerk
	public boolean server; //ist der Server online?
	public boolean client1; //ist Client1 verbunden?
	public boolean client2; //ist Client2 verbunden?
	
	// Hier alle Globalen Variablen fürs Quest
	public static class quest{


		public static boolean schalter;	//Ob Schalter auf on oder off steht.
		public static int level;		// Fürs Level eigentlich unwichtig da man nur das Level vom Level nimmt, aber falls man da was anderes haben will.
		public static boolean draw;		// Ob das Quest gestartet ist oder nicht.
		public static int[] array;	// Um Quest Gegenstände zusammeln		
		public static int[] zahlen;	// Um sich zu merken welche Zahlen ausgegeben werden.
		public static double[] position; // für die Position
		public static int length;		//nur die Anzahl der Questgegenstände
		public static int zeiger;		// ein Zeiger für die Reihenfolge
		public static boolean ready;	// wenn das Quest abgeschlossen ist um irgendwelche sachen freizuschalten.
		
		
		
		
		
	}
	
	
	
	// Hier wird der NPC gespeichert.
	public static class npc{
		public static double x;
		public static double y;
		public static boolean npc;		// Ob der NPC gezeichnet werden soll oder nicht steht immer nur im ersten Level bzw kann man auch woanders hinsetzten.
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

	public static void save() {
		if(Math.abs(Globals.speicher.x-Globals.x)<0.047 && Math.abs(Globals.speicher.y-Globals.y)<0.047){
		System.out.println("gespeichert");
		
		
		Speicher.health=Globals.health;
		Speicher.life=Globals.life;
		Speicher.magician=Globals.magician;
		Speicher.weapon=Globals.weapon;
		Speicher.ep=Globals.ep;
		Speicher.stop=Globals.stop;
		Speicher.money=Globals.money;
		
		Speicher.level =Globals.level;
		Speicher.room =Globals.room;
		Speicher.shot=Globals.shot;
		
		
		 Speicher.wall =Globals.wall; //are walls deactivated?
		 Speicher.damages=Globals.damages; // amount of enemies damages
	     Speicher.shout_now=Globals.shout_now;
	     Speicher.ruestung=Globals.ruestung;

		
		 Speicher.x =Globals.x;		//Speichert Position vom Spieler
		 Speicher.y=Globals.y;
		 Speicher.xneu=Globals.xneu;	//Speichert neue Position vom Spieler für die Bewegung
		 Speicher.yneu=Globals.yneu;
		
		 Speicher.fallen=Globals.fallen;// Speichert Position von den Fallen.so wie die neuen Position wenn die Fallen sich bewegen.
		 Speicher.anzahlfallen=Globals.anzahlfallen;
		 Speicher.falleneu=Globals.falleneu;
		 Speicher.richtung=Globals.richtung;	// gibt eine Richtung an in die sich die Falle bewegt.
		
		 Speicher.anzahlboss=Globals.anzahlboss;	// Speichert Position vom Boss
		 Speicher.boss=Globals.boss;
		 Speicher.boss_neu=Globals.boss_neu;
		 Speicher.bombing=Globals.bombing; //is boss bombing?
		 Speicher.health_boss=Globals.health_boss; 
		
		 Speicher.startx=Globals.startx; 	// Speichert Startpunkt
		 Speicher.starty=Globals.starty;
		 Speicher.zielx=Globals.zielx; 	//Speichert Zielpunkt
		 Speicher.ziely=Globals.ziely;
		
		 Speicher.fileName=Globals.fileName;	//File Name für den Raum
		 Speicher.boss_richtung=Globals.boss_richtung;
		 
		 		Speicher.speicher.draw=Globals.speicher.draw;
		 		Speicher.speicher.x=Globals.speicher.x;
		 		Speicher.speicher.y=Globals.speicher.y;
		 
		 		 Speicher.quest.array=Globals.quest.array;
		 		 Speicher.quest.level=Globals.quest.level;
		 		 Speicher.quest.schalter=Globals.quest.schalter;
		 		 Speicher.quest.position=Globals.quest.position;
				 Speicher.quest.zahlen=Globals.quest.zahlen;
				 Speicher.quest.draw=Globals.quest.draw;
				 Speicher.quest.length=Globals.quest.length;
				 Speicher.quest.zeiger=Globals.quest.zeiger;
				 Speicher.quest.ready=Globals.quest.ready;
				 
				 Speicher.npc.x=Globals.npc.x;
				 Speicher.npc.y=Globals.npc.y;
				 Speicher.npc.npc=Globals.npc.npc;
				 
				 Speicher.draw.bomb=Globals.draw.bomb;
				 Speicher.draw.explosion=Globals.draw.explosion;
				 
				 Speicher.packet.draw=Globals.packet.draw;
				 Speicher.packet.x=Globals.packet.x;
				 Speicher.packet.y=Globals.packet.y;
				 
				 Speicher.shop.draw=Globals.shop.draw;
				 Speicher.shop.x=Globals.shop.x;
				 Speicher.shop.y=Globals.shop.y;
				 
				 Speicher.enemy.step=Globals.enemy.step;
				 Speicher.enemy.move=Globals.enemy.move;
				 Speicher.enemy.x=Globals.enemy.x;
				 Speicher.enemy.y=Globals.enemy.y;
				 
				 Speicher.player.step=Globals.player.step;
				 Speicher.player.x=Globals.player.x;
				 Speicher.player.y=Globals.player.y;
				 
				 
		}
		
	}
	public static void load() {

		
		Globals.health=Speicher.health;
		Globals.life=Speicher.life;
		Globals.magician=Speicher.magician;
		Globals.weapon=Speicher.weapon;
		Globals.ep=Speicher.ep;
		Globals.stop=Speicher.stop;
		Speicher.money=Globals.money;
		
		Globals.level=Speicher.level;
		Globals.room=Speicher.room;
		Globals.shot=Speicher.shot;
		
		
		Globals.wall= Speicher.wall; //are walls deactivated?
		Globals.damages=Speicher.damages; // amount of enemies damages
	    Globals.shout_now=Speicher.shout_now;
	    Globals.ruestung=Speicher.ruestung;

		
		 Globals.x=Speicher.x;		//Speichert Position vom Spieler
		 Globals.y=Speicher.y;
		 Globals.xneu=Speicher.xneu;	//Speichert neue Position vom Spieler für die Bewegung
		 Globals.yneu=Speicher.yneu;
		
		 Globals.fallen=Speicher.fallen;// Speichert Position von den Fallen.so wie die neuen Position wenn die Fallen sich bewegen.
		 Globals.anzahlfallen=Speicher.anzahlfallen;
		 Globals.falleneu=Speicher.falleneu;
		 Globals.richtung=Speicher.richtung;	// gibt eine Richtung an in die sich die Falle bewegt.
		
		 Globals.anzahlboss=Speicher.anzahlboss;	// Speichert Position vom Boss
		 Globals.boss=Speicher.boss;
		 Globals.boss_neu=Speicher.boss_neu;
		 Globals.bombing=Speicher.bombing; //is boss bombing?
		 Globals.health_boss=Speicher.health_boss; 
		
		 Globals.startx=Speicher.startx; 	// Speichert Startpunkt
		 Globals.starty=Speicher.starty;
		 Globals.zielx=Speicher.zielx; 	//Speichert Zielpunkt
		 Globals.ziely=Speicher.ziely;
		
		 Globals.fileName=Speicher.fileName;	//File Name für den Raum
		 Globals.boss_richtung=Speicher.boss_richtung;
		 
		 		 Globals.speicher.draw=Speicher.speicher.draw;
		 		 Globals.speicher.x=Speicher.speicher.x;
		 		 Globals.speicher.y=Speicher.speicher.y;
		 
		 		 Globals.quest.array=Speicher.quest.array;
		 		 Globals.quest.level=Speicher.quest.level;
		 		 Globals.quest.schalter=Speicher.quest.schalter;
		 		 Globals.quest.position=Speicher.quest.position;
		 		 Globals.quest.zahlen=Speicher.quest.zahlen;
		 		 Globals.quest.draw=Speicher.quest.draw;
		 		 Globals.quest.length=Speicher.quest.length;
		 		 Globals.quest.zeiger=Speicher.quest.zeiger;
		 		 Globals.quest.ready=Speicher.quest.ready;
				 
		 		 Globals.npc.x=Speicher.npc.x;
		 		 Globals.npc.y=Speicher.npc.y;
		 		 Globals.npc.npc=Speicher.npc.npc;
				 
		 		 Globals.draw.bomb=Speicher.draw.bomb;
		 		 Globals.draw.explosion=Speicher.draw.explosion;
				 
		 		 Globals.packet.draw=Speicher.packet.draw;
		 		 Globals.packet.x=Speicher.packet.x;
		 		 Globals.packet.y=Speicher.packet.y;
				 
		 		 Globals.shop.draw=Speicher.shop.draw;
		 		 Globals.shop.x=Speicher.shop.x;
		 		 Globals.shop.y=Speicher.shop.y;
				 
		 		 Globals.enemy.step=Speicher.enemy.step;
		 		 Globals.enemy.move=Speicher.enemy.move;
		 		 Globals.enemy.x=Speicher.enemy.x;
		 		 Globals.enemy.y=Speicher.enemy.y;
				 
		 		 Globals.player.step=Speicher.player.step;
		 		 Globals.player.x=Speicher.player.x;
				 Globals.player.y=Speicher.player.y;
		
	
	}

}
