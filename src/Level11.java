

import java.awt.event.KeyEvent;
import java.io.IOException;


public class Level11 {
	public static void main(String[] args) throws IOException{
		GetRoom test = new GetRoom();
		room(test);
		intplayer(test);
		intenemy(test);
		
		Globals.health=100;
     	Globals.life=3;
     	Globals.magician=0;
     	Globals.money=0;
     	
		double x;
		double y;
		double x_neu;
		double y_neu;
		x=test.arraylokal[0];
		y=test.arraylokal[1];
	
		x=0.05*x;
		y=1-0.05*y;
     	
     	
     	while (true)
        {
     	   		StdDraw.show(10);
     	   		
     	   		//Zeichne neu:
     	   		StdDraw.clear();
     	   		room(test);
     	   		intenemy(test);
     	   		player(x,y);
     	   		
                if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) //Move Left
                {

                        //Neue Koordinaten:
                        x_neu = x-0.005;
                        y_neu=y;

                        //Prüfe ob neuer Punkt zulässig
                        if (x_neu <= 0.05 || y_neu>=0.05 && y_neu<= 0.85 && x_neu<=0.35 && x_neu>=0.25|| y_neu<=0.55 && y_neu>=0.45 && x_neu<=0.55 && x_neu>=0.25 || y_neu<=0.95 && y_neu>=0.15 && x_neu<=0.8 && x_neu>=0.7 )
                        {
                                
                                x_neu=x; //Keine Bewegung möglich
                                }
                        
                        else
                        {
                        x=x_neu;
                        y=y_neu;
                        }
                }
                else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) //Move right
                {

                      //Neue Koordinaten:
                        x_neu = x+0.005;
                        y_neu = y;
                      //Prüfe ob neuer Punkt zulässig
                        if (x_neu>=0.95|| x_neu<=0.35 && x_neu>=0.25 && y_neu>=0.05 && y_neu<0.85 || x<= 0.8 && x_neu>=0.7 && y_neu<=0.95 && y_neu>=0.25 ||x_neu<=0.8 && x_neu>=0.45 && y_neu<=0.25 && y_neu>0.15 ) //Wand
                        {
                                if ((x_neu<=0.05 && 0.1<=y && y<=0.25) || (x_neu>=0.95 && (y>=0.65 && y<=0.9))) //Start oder Zielbereich
                                {
                                        x=x_neu;
                                        y=y_neu;
                                } else {
                                x_neu=x; //Keine Bewegung möglich
                                }
                      } else{
                        x=x_neu;
                        y=y_neu;
                      }
                }
                else if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) //Move up
                {
                      //Neue Koordinaten:
                        x_neu = x;
                        y_neu = y+0.005;
                      //Prüfe ob neuer Punkt zulässig
                        if (y_neu>=0.95|| x_neu<=0.05|| x_neu>=0.95 || y_neu<=0.55 && y_neu>=0.45 && x_neu>=0.25 &&x_neu<=0.55 || x_neu>=0.45 && x_neu<=0.7 && y_neu<=0.25 && y_neu>=0.15|| x_neu<=0.8 && x_neu>=0.7 && y_neu<=0.95 &&y_neu>= 0.15 ) //Wand
                        {
                                y_neu=y;
                        } else{
                        x=x_neu;
                        y=y_neu;
                        }

                }
                else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) //Move Down
                {
                      //Neue Koordinaten:
                        x_neu = x;
                        y_neu = y-0.005;

                      //Prüfe ob neuer Punkt zulässig
                        if (y_neu<=0.05|| x_neu<=0.05 || x_neu>=0.95 || y_neu<=0.55 && y>=0.45 && x_neu>=0.25 &&x_neu<=0.55 || x_neu>=0.45 && x_neu<=0.7 && y_neu<=0.25 && y_neu>=0.15||x_neu<=0.35 && x_neu>=0.25 && y_neu <= 0.85 && y_neu>=0.05) //Wand
                        {
                                y_neu=y;
                        } else{
                        x=x_neu;
                        y=y_neu;
                        }
                }                           
                //Teste, ob Gegner/Falle berührt
                if ((0.55<=x && 0.65 >=x && 0.55<=y && 0.66 >=y)|| 0.10<=x && x<=0.2 && 0.45<=y && y<=0.55)
                {
             	  
             	   //Damages.setDamages();
             	   
             	 //Zurück zu letzten Checkpoint
             	   x=0.01;
             	   y=.15;
             			   
                        

                }
                //Teste, ob im Ziel:
                if (x>=1)
                {
             	   //Level2.main(args);
             	   break;
             
                }
        
        }
	}

	private static void intenemy(GetRoom array) {
		double x;
		double y;
		int n=array.arraylokal[10];
		int i=0;
		while (i<n){
			x=array.arraylokal[4+2*i];
			y=array.arraylokal[5+2*i];
			
			x=0.05*x;
			y=1-0.05*y;	
			
			Falle(x,y);
			i++;
				}
		}	

	private static void intplayer(GetRoom array) {
		double x;
		double y;
		x=array.arraylokal[0];
		y=array.arraylokal[1];
	
		x=0.05*x;
		y=1-0.05*y;	

		player(x,y);	

		}

	static void player(double x,double y)
    {

        //Initialisiere Spielfigur als Punkt an der Koordinate (x,y):
		// StdDraw.setPenColor(StdDraw.BLUE);
		//StdDraw.setPenRadius(0.05);
		//StdDraw.point(x, y);
    	//Zeichne Spieler als Pi an Koordinate (x,y):
            StdDraw.picture(x, y,"pi.png",.05,.05);



    }
	   static void Falle(double i,double j){
           //bewegene Gegner/Falle
           StdDraw.setPenColor(StdDraw.YELLOW);
           StdDraw.filledSquare(i, j, 0.01);
           StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.square(i, j,0.01);


}
	private static void room(GetRoom test) throws IOException {
		 
		 
		 test.room(null);
	}

}



