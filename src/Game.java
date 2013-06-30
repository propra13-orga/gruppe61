import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


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

public static void start() throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException{

	File file = new File("src/level.wav");
	AudioInputStream stream = AudioSystem.getAudioInputStream(file);
	AudioFormat format = stream.getFormat();
	DataLine.Info info = new DataLine.Info(Clip.class, format);
	Clip clip = (Clip)AudioSystem.getLine(info);
	clip.open(stream);
	clip.start();
	
	int p;	// Laufvariable damit in GetRoom nicht immer die Fallen und so mehrfach ausgelesen werden und die Koordinaten in Globals ver�ndert werden.
	p=0;
	GetRoom.room(p);	// Hier sollte p=0 sein alle Daten in GetROom gelesen werden.
	
	intplayer();	// Initialisiere Player

	intenemy();	// Initialisiere Fallen und zeichne hiermit auch immer wieder die neue Position


	Globals.x=Globals.startx;	// �bergabe von den Startkoordinaten
	Globals.y=Globals.starty;	

     
      while (true) 
      {	p=1;
             
        StdDraw.show(10);
     
        //Zeichne neu:
        StdDraw.clear();
     
        GetRoom.room(p);	//Hier sollte p irgendwas ungleich 0 sein damit das array in dem die Fallen gespeichert sind nicht �berschrieben wird.
     
        InformationBar.use();
        
        NPC.go();
        
        //paint shop symbol
        if (Globals.shop.draw) {Paint.shop(Globals.shop.x,Globals.shop.y);}
        
        //paint packet symbol
        if (Globals.packet.draw) {Paint.packet(Globals.packet.x,Globals.packet.y);}
        
        //Paint bomb
        if (Globals.draw.bomb) {Paint.bomb(Bomb.x,Bomb.y);}

        //paint explosion
        if (Globals.draw.explosion) {Paint.explosion(Bomb.x,Bomb.y);}
     
        Boss.go();
        
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
               
        }
        else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) //Move right
        {

        	//Neue Koordinaten:
        	Controller.playerright();
        
        }
        else if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) //Move up
        {
        	//Neue Koordinaten:
        	Controller.playerup();

        }
        else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) //Move Down
        {
        	//Neue Koordinaten:
        	Controller.playerdown();

        }
        
        //Actions:
        if (StdDraw.hasNextKeyTyped())
        {
        if(StdDraw.isKeyPressed(KeyEvent.VK_S)) //stop enemy
        {
     	   Stop.use();
     	   Thread.sleep(100);
     	  
     	  
        }
        else if(StdDraw.isKeyPressed(KeyEvent.VK_W)) //deactivates walls for player
        	{
        		Magician.use();
        		Thread.sleep(100);
        	}
        else if(StdDraw.isKeyPressed(KeyEvent.VK_B))
        {
        	Bomb.use();
        	Thread.sleep(100);
        }
        }
       
       
        
        //Teste, ob Gegner/Falle ber�hrt
        int j=0;
        while (j<Globals.anzahlfallen){
        	
        	if (Math.abs(Globals.fallen[0+2*j]- Globals.x)<0.049  && Math.abs(Globals.fallen[1+2*j]-Globals.y)<0.049)
        	{
        		Enemy.use();
             
        		//Zur�ck zu letzten Checkpoint
        		//Globals.x=x;
        		//Globals.y=Globals.starty;
  
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
        		if(Globals.boss==null){ //Wenn Boss tot, dann Level up
        		Globals.level++;
        			Globals.room=1;
        			Globals.health_boss=3;
        			
        			//Pr�fe, ob durchgezockt
        			if(Globals.level>3) { Durchgezockt.go(); clip.stop(); }
        		
        			
        		}
        		else 
        		{
        			//Verbiete Bewgung manuell:
        			Globals.x=Globals.zielx; 
        			Globals.y=Globals.ziely;
        			//break;
        		}
        		
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
        		//Einen Raum zur�ck
        		Globals.room--;
	        		
        		//Lese neuen Raum aus
        		GetRoom.room(2);
            	Globals.x=Globals.zielx;
            	Globals.y=Globals.ziely;
        	}
        	else //Sind in Raum 1. In Raum 1 geht es nicht zur�ck. Level down soll nicht m�glich sein
        	{
        		//Verhindere ein Weitergehen:
        		Globals.x=Globals.startx;
        		Globals.y=Globals.starty;
        	}
        }
        
        
      }
}




}