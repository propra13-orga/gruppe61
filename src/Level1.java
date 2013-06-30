import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;



public class Level1 {
        static void room()
        {
                //StdDraw.setCanvasSize(512,512);

                   StdDraw.setPenColor(StdDraw.BLACK);
                   
                   //Hintergrundbild:
                   StdDraw.picture(.5, .5, "f95.png", 1, 1);
                   StdDraw.setPenRadius(0.01);

                   //Rand des Spielfelds:
                   StdDraw.line(0.0, 0.0, 0.0, 0.10);
                   StdDraw.line(0.0, 0.20, 0.0,1);
                   StdDraw.line(0, 0,1 , 0);
                   //StdDraw.line(1,0,1,1);
                   StdDraw.line(1,0,1,0.7);
                   StdDraw.line(1, 0.85, 1, 1);
                   StdDraw.line(1, 1, 0, 1);

                   //Wände:
                   StdDraw.text(0, .15, "Start");
                   StdDraw.line(0.3,0, 0.3, 0.8); //senkrechte Zwischenwand
                   StdDraw.line(0.75, 1, .75, .2); //senkrechte Zwishcenwand
                   StdDraw.line(0.3, .5, 0.5, .5); //waagerechte Zwischenwand
                   StdDraw.line(0.75, 0.2, 0.5, 0.2); //waagerechte Zwischenwand
                   StdDraw.text(1, 0.758, "Ziel");

                   //Statischer Gegner/Falle
                   //StdDraw.setPenColor(StdDraw.RED);
                   StdDraw.setPenColor(StdDraw.YELLOW);
                   StdDraw.filledSquare(0.6, .6, 0.01);
                   StdDraw.filledSquare(0.15, .5, 0.01);
                   StdDraw.setPenColor(StdDraw.BLACK);
                   StdDraw.square(0.6, .6,0.01);
                   StdDraw.square(0.15, .5,0.01);
                   
                   //InformationBar
                   InformationBar.use();
               


        }

        static void player(double x,double y)
        {

//                //Initialisiere Spielfigur als Punkt an der Koordinate (x,y):
//                StdDraw.setPenColor(StdDraw.BLUE);
//                StdDraw.setPenRadius(0.05);
//                StdDraw.point(x, y);
        	//Zeichne Spieler als Pi an Koordinate (x,y):
                StdDraw.picture(x, y,"pi.png",.08,.08);



        }





   public static void main(String[] args) throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException {
           {
        	   
        	   Globals.health=100;
          	   Globals.life=3;
          	   Globals.magician=0;
          	   Globals.money=0;

        	   StdDraw.clear();
                  //Initialosiere Level
                  room();

                  //Startpunkt
                  double x=0.01;
                  double y=.15;

                  //Initialisiere Spielfigur am Startpunkt
                   player(x,y);
                   double x_neu;
                   double y_neu;

                   while (true)
                   {
                	   		StdDraw.show(10);
                	   		
                	   		//Zeichne neu:
                	   		StdDraw.clear();
                	   		room();
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
                        	  
                        	  Enemy.use();
                        	   
                        	 //Zurück zu letzten Checkpoint
                        	  // x=0.01;
                        	  // y=.15;
                        			   
                                   

                           }
                           //Teste, ob im Ziel:
                           if (x>=1)
                           {
                        	   Level2.main(args);
                        	   break;
                        
                           }
                   
                   }
           }
   }
}
