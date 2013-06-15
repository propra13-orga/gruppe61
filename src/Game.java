import java.awt.event.KeyEvent;
import java.io.IOException;


public class Game {
	
private static void intenemy() {

int n=Globals.anzahlfallen;	//Gehe alle Fallen durch und zeichne sie mit Hilfe der Globalen Variablen.
int i=0;
while (i<n){


Paint.Falle(Globals.fallen[0+2*i],Globals.fallen[1+2*i]);
i++;
}
}	

private static void intplayer() {


Paint.player(Globals.startx,Globals.starty);	

}

public static void main(String[] args) throws IOException, InterruptedException{

		
	Initialize.main(null);

	int p;	// Laufvariable damit in GetRoom nicht immer die Fallen und so mehrfach ausgelesen werden und die Koordinaten in Globals verändert werden.



	p=0;
	GetRoom.room(p);	// Hier sollte p=0 sein alle Daten in GetROom gelesen werden.
	intplayer();	// Initialisiere Player

	intenemy();	// Initialisiere Fallen und zeichne hiermit auch immer wieder die neue Position
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
      {	p=1;
             
        StdDraw.show(10);
     
        //Zeichne neu:
        StdDraw.clear();
     
        GetRoom.room(p);	//Hier sollte p irgendwas ungleich 0 sein damit das array in dem die Fallen gespeichert sind nicht überschrieben wird.
     
        InformationBar.main(null);
     
        int i=0;
        while (i<Globals.anzahlfallen){
        	Controller.Falle(i);
        	i++;
        }
        intenemy();	//siehe oben
     
        Paint.player(Globals.x,Globals.y);	// Zeichnet den Spieler.
     

        //Move Player:
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
        
        //Actions:
        if (StdDraw.hasNextKeyTyped())
        {
        if(StdDraw.isKeyPressed(KeyEvent.VK_S)) //stop enemy
        {
     	   Stop.main(null);
     	   Thread.sleep(100);
     	  
     	  
        }
        else if(StdDraw.isKeyPressed(KeyEvent.VK_W)) //deactivates walls for player
        	{
        		Magician.main(null);
        		Thread.sleep(100);
        	}
        
        }
        
        
        //Teste, ob Gegner/Falle berührt
        int j=0;
        while (j<Globals.anzahlfallen){
        	
        	if (Globals.fallen[0+2*j]-0.05< Globals.x && Globals.x<Globals.fallen[0+2*j] +0.05 && Globals.fallen[1+2*j]-0.05<Globals.y && Globals.fallen[1+2*j]+0.05>Globals.y)
        	{
        		Damages.setDamages();
             
        		//Zurück zu letzten Checkpoint
        		Globals.x=Globals.startx;
        		Globals.y=Globals.starty;
  
        	}
        	j++;
        }
        
        //Teste, ob im Ziel (Ziele immer oben oder rechts
        if (Globals.x >1 ||  Globals.y>1) //Ziel
        {
        	if (Globals.room<3)
        		{
        		//Einen Raum weiter gehen
        		Globals.room++;
        		}
        	else // Schon in Raum3 -> Level up
        	{
        		Globals.level++;
        		Globals.room=1;
        	}
        	
        	//Lese neuen Raum aus
        	GetRoom.room(0);
        		
        	//Setze Spieler auf neue Position
        	Globals.x=Globals.startx;
        	Globals.y=Globals.starty;
        }
        else if (Globals.x <0 || Globals.y< 0) // Start
        {
        	if (Globals.room>1) 
        	{
        		//Einen Raum zurück
        		Globals.room--;
        		
        		//Lese neuen Raum aus
            	GetRoom.room(0);
            	Globals.x=Globals.zielx;
            	Globals.y=Globals.ziely;
        	}
        	else //Sind in Raum 1. In Raum 1 geht es nicht zurück. Level down soll nicht möglich sein
        	{
        		//Verhindere ein Weitergehen:
        		Globals.x=Globals.startx;
        		Globals.y=Globals.starty;
        	}
        }
        
        
      }
}








}