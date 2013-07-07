import java.io.IOException;



/**
 * Steuerung von Spieler und Falle
 */
public class Controller {	

	/**
	 * Spieler nach Links
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void playerleft()throws IOException, InterruptedException {	// Bewegt Spieler nach links	
        Globals.xneu = Globals.x-0.005;
        Globals.yneu=Globals.y;
        Wall.checkp();
	}

	/**
	 * Spieler nach rechts
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void playerright()throws IOException, InterruptedException {	// Bewegt Spieler nach rechts
        Globals.xneu = Globals.x+0.005;
        Globals.yneu = Globals.y;
        Wall.checkp();
	}

	/**
	 * Spieler nach oben
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void playerup()throws IOException, InterruptedException {	// Bewegt Spieler nach oben
		Globals.xneu = Globals.x;
        Globals.yneu = Globals.y+0.005;
        Wall.checkp();
	}

	/**
	 * Spieler nach unten
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void playerdown()throws IOException, InterruptedException {	// Bewegt Spieler nach unten
		Globals.xneu = Globals.x;
        Globals.yneu = Globals.y-0.005;
        Wall.checkp();
	}

	/**
	 * Steuerung der Falle
	 * @param i
	 * @throws IOException
	 */
	public static void Falle(int i)throws IOException {// i gibt hier auch jeder Falle eine Nummer		 
		/**
		 * Bewegung nur, falls nicht durch Spieler unterbunden
		 */
		if (Globals.enemy.move) //Check if move is allowed
		{
		
			double[] array = new double [2];
		
			int k=Globals.richtung[i];
			/**
			 * Bewegungsrichtung 1 schräg nach oben	Richtung (1,1)
			 */
			if (k==1){
				array[0]=Globals.fallen[0+2*i]+Globals.enemy.step;	//Bewegungsrichtung 1 schräg nach oben	Richtung (1,1)
				array[1]=Globals.fallen[1+2*i]+Globals.enemy.step;
			
				Globals.falleneu=array;
				Wall.checkf(i);							//Überprüfe ob Wand erreicht.
			}
			/**
			 * Bewegungsrichtung 2 schräg nach oben	Richtung	(1,0)
			 */
			else if(k==2){
				array[0]=Globals.fallen[0+2*i]+Globals.enemy.step;	//Bewegungsrichtung 2 schräg nach oben	Richtung	(1,0)
				array[1]=Globals.fallen[1+2*i]-Globals.enemy.step;
				Globals.falleneu=array;
				Wall.checkf(i);							//Überprüfe ob Wand erreicht.	
			}
			/**
			 * Bewegungsrichtung 3 schräg nach unten	Richtung	(0,1)
			 */
			else if(k==3){
				array[0]=Globals.fallen[0+2*i]-Globals.enemy.step;	//Bewegungsrichtung 3 schräg nach unten	Richtung	(0,1)
				array[1]=Globals.fallen[1+2*i]+Globals.enemy.step;
				Globals.falleneu=array;
				Wall.checkf(i);							//Überprüfe ob Wand erreicht.
			}
			/**
			 * Bewegungsrichtung 4 schräg nach unten Richtung (0,0)
			 */
			else if(k==4) {
				array[0]=Globals.fallen[0+2*i]-Globals.enemy.step;	//Bewegungsrichtung 4 schräg nach unten Richtung (0,0)
				array[1]=Globals.fallen[1+2*i]-Globals.enemy.step;
				Globals.falleneu=array;
				Wall.checkf(i);							//Überprüfe ob Wand erreicht.
			}
			/**
			 * Bewegungsrichtung 5 nach links Richtung (0,.)
			 */
			else if(k==5) {
				array[0]=Globals.fallen[0+2*i]-Globals.enemy.step;	//Bewegungsrichtung 5 nach links Richtung (0,.)
				array[1]=Globals.fallen[1+2*i];
				Globals.falleneu=array;
				Wall.checkf(i);							//Überprüfe ob Wand erreicht.
			}
			/**
			 * Bewegungsrichtung 6 nach rechts Richtung (1,.)
			 */
			else if(k==6) {
				array[0]=Globals.fallen[0+2*i]+Globals.enemy.step;	//Bewegungsrichtung 6 nach rechts Richtung (1,.)
				array[1]=Globals.fallen[1+2*i];
				Globals.falleneu=array;
				Wall.checkf(i);							//Überprüfe ob Wand erreicht.
			}
			/**
			 * Bewegungsrichtung 7 nach unten Richtung (.,0)
			 */
			else if(k==7) {
				array[0]=Globals.fallen[0+2*i];	//Bewegungsrichtung 7 nach unten Richtung (.,0)
				array[1]=Globals.fallen[1+2*i]-Globals.enemy.step;
				Globals.falleneu=array;
				Wall.checkf(i);							//Überprüfe ob Wand erreicht.
			}
			/**
			 * Bewegungsrichtung 8 nach oben Richtung (.,1)
			 */
			else if(k==8) {
				array[0]=Globals.fallen[0+2*i];	//Bewegungsrichtung 8 nach oben Richtung (.,1)
				array[1]=Globals.fallen[1+2*i]+Globals.enemy.step;
				Globals.falleneu=array;
				Wall.checkf(i);							//Überprüfe ob Wand erreicht.
		}
				
		}
		
	}
	

}
