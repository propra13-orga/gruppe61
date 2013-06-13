import java.awt.event.KeyEvent;
import java.io.IOException;


public class Level11 {
	public static void main(String[] args) throws IOException{
		int r=1;
		int p;				// Laufvariable damit in GetRoom nicht immer die Fallen und so mehrfach ausgelesen werden und die Koordinaten in Globals verändert werden.
		while (r<=3){		//Auswahl vom Raum.
		
		if(r==1){

			 Globals.fileName="src/Raum1.txt";}
		else if(r==2)
		{
			 Globals.fileName="src/Raum2.txt";}
		else  {
			 Globals.fileName="src/Raum3.txt";}

		p=0;
		GetRoom.room(p);	// Hier sollte p=0 sein alle Daten in GetROom gelesen werden.
		intplayer();		// Initialisiere Player 
		
		intenemy();			// Initialisiere Fallen und zeichne hiermit auch immer wieder die neue Position
		/*
		InformationBar.main(null);
		Globals.health=100;
     	Globals.life=3;
     	Globals.magician=0;
     	Globals.money=0;
     	*/

		Globals.x=Globals.startx;	// Übergabe von den Startkoordinaten
		Globals.y=Globals.starty;	

	

     	
     	
     	while (true)
        {		p=1;
        		
     	   		StdDraw.show(10);
     	   		
     	   		//Zeichne neu:
     	   		StdDraw.clear();
     	   	
     	   		GetRoom.room(p);		//Hier sollte p irgendwas ungleich 0 sein damit das array in dem die Fallen gespeichert sind nicht überschrieben wird.
     	   		
     	   		InformationBar.main(null);
     	   		
     	   		int i=0;
     	   		while (i<Globals.anzahlfallen){
     	   		Controller.Falle(i);
     	   		i++;
     	   		}
     	   		intenemy();	//siehe oben
     	   		
     	   		Paint.player(Globals.x,Globals.y);	// Zeichnet den Spieler.
     	   		
                if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) //Move Left
                {	

                        //Neue Koordinaten:
                		Controller.playerleft();
                		
                		//Prüfe ob der neuer Punkt zulässig
                        Wall.checkp();
                        
                }
                else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) //Move right
                {

                      //Neue Koordinaten:
                		Controller.playerright();
                	
                      //Prüfe ob neuer Punkt zulässig
                        Wall.checkp();
                        
                  
                }
                else if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) //Move up
                {
                      	//Neue Koordinaten:
                		  Controller.playerup();
                		
                		//Prüfe ob neuer Punkt zulässig
                          Wall.checkp();

                }
                else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) //Move Down
                {
                      //Neue Koordinaten:
                		Controller.playerdown();

                      //Prüfe ob neuer Punkt zulässig
                        Wall.checkp();
                }                           
                //Teste, ob Gegner/Falle berührt
                int j=0;
                while (j<Globals.anzahlfallen){
                	
                if (Globals.arraylokal[0+2*j]-0.05< Globals.x && Globals.x<Globals.arraylokal[0+2*j] +0.05 && Globals.arraylokal[1+2*j]-0.05<Globals.y && Globals.arraylokal[1+2*j]+0.05>Globals.y)
                		{
             	   Damages.setDamages();
             	   
             	 //Zurück zu letzten Checkpoint
             	   Globals.x=0.01;
             	   Globals.y=.15;
  
                		}
                j++;
                }
                //Teste, ob im Ziel:
                if (Globals.x>=1)
                {
             	   //Level2.main(args);
             	   break;
             
                }
        
        }
		r++;}
	}

	private static void intenemy() {
		
		int n=Globals.anzahlfallen;	//Gehe alle Fallen durch und zeichne sie mit Hilfe der Globalen Variablen.
		int i=0;
		while (i<n){


			Paint.Falle(Globals.arraylokal[0+2*i],Globals.arraylokal[1+2*i]);
			i++;
				}
		}	

	private static void intplayer() {


		Paint.player(Globals.startx,Globals.starty);	

		}





}
