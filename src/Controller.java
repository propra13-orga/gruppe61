import java.io.IOException;




public class Controller {	

	public static void playerleft() {	// Bewegt Spieler nach links	
        Globals.xneu = Globals.x-0.005;
        Globals.yneu=Globals.y;
		
	}

	public static void playerright() {	// Bewegt Spieler nach rechts
        Globals.xneu = Globals.x+0.005;
        Globals.yneu = Globals.y;
		
	}

	public static void playerup() {	// Bewegt Spieler nach oben
		Globals.xneu = Globals.x;
        Globals.yneu = Globals.y+0.005;
		
	}

	public static void playerdown() {	// Bewegt Spieler nach unten
		Globals.xneu = Globals.x;
        Globals.yneu = Globals.y-0.005;
		
	}

	public static void Falle(int i)throws IOException {// i gibt hier auch jeder Falle eine Nummer		 
		
		double[] array = new double [2];
		
		int k=Globals.richtung[i];
		if (k==1){
			array[0]=Globals.fallen[0+2*i]+0.01;	//Bewegungsrichtung 1 schräg nach oben	Richtung (1,1)
			array[1]=Globals.fallen[1+2*i]+0.01;
			
			Globals.falleneu=array;
			Wall.checkf(i);							//Überprüfe ob Wand erreicht.
		}
		else if(k==2){
			array[0]=Globals.fallen[0+2*i]+0.01;	//Bewegungsrichtung 2 schräg nach oben	Richtung	(1,0)
			array[1]=Globals.fallen[1+2*i]-0.01;
			Globals.falleneu=array;
			Wall.checkf(i);							//Überprüfe ob Wand erreicht.	
		}
		else if(k==3){
			array[0]=Globals.fallen[0+2*i]-0.01;	//Bewegungsrichtung 3 schräg nach unten	Richtung	(0,1)
			array[1]=Globals.fallen[1+2*i]+0.01;
			Globals.falleneu=array;
			Wall.checkf(i);							//Überprüfe ob Wand erreicht.
		}
		else if(k==4) {
			array[0]=Globals.fallen[0+2*i]-0.01;	//Bewegungsrichtung 4 schräg nach unten Richtung (0,0)
			array[1]=Globals.fallen[1+2*i]-0.01;
			Globals.falleneu=array;
			Wall.checkf(i);							//Überprüfe ob Wand erreicht.
		}
		

		
				
		
		
	}
	

}
