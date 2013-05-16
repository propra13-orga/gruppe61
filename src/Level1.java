import java.awt.Color;
import java.awt.event.KeyEvent;



public class Level1 {
        static void room()
        {
                StdDraw.setCanvasSize(512,512);

                   StdDraw.setPenColor(StdDraw.BLACK);

                   StdDraw.setPenRadius(0.01);

                   //Rand des Spielfelds:
                   StdDraw.line(0.0, 0.0, 0.0, 0.10);
                   StdDraw.line(0.0, 0.20, 0.0,1);
                   StdDraw.line(0, 0,1 , 0);
                   //StdDraw.line(1,0,1,1);
                   StdDraw.line(1,0,1,0.7);
                   StdDraw.line(1, 0.85, 1, 1);
                   StdDraw.line(1, 1, 0, 1);

                   //W�nde:
                   StdDraw.text(0, .15, "Start");
                   StdDraw.line(0.3,0, 0.3, 0.8); //senkrechte Zwischenwand
                   StdDraw.line(0.75, 1, .75, .2); //senkrechte Zwishcenwand
                   StdDraw.line(0.3, .5, 0.5, .5); //waagerechte Zwischenwand
                   StdDraw.line(0.75, 0.2, 0.5, 0.2); //waagerechte Zwischenwand
                   StdDraw.text(1, 0.758, "Ziel");

                   //Statischer Gegner/Falle
                   StdDraw.setPenColor(StdDraw.RED);
                   StdDraw.filledSquare(0.6, .6, 0.01);
                   StdDraw.filledSquare(0.15, .5, 0.01);


        }

        static void player(double x,double y)
        {

                //Initialisiere Spielfigur als Punkt an der Koordinate (x,y):
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.setPenRadius(0.05);
                StdDraw.point(x, y);

                   //}



        }





   public static void main(String[] args) {
           {

                  //Initialosiere Level
                  room();

                  //Startpunkt
                  double x=0.01;
                  double y=.15;

                  //Initialisiere Spielfigur am Startpunkt
                   player(x,y);
                   double x_neu;
                   double y_neu;

                   while (x>=0.001 && x<=1 )
                   {
                 StdDraw.show(0);
                           //�ndere Stiftfarbe und Gr��e, um Spielfigur zu �bermalen:
                           StdDraw.setPenRadius(.053);
                           StdDraw.setPenColor(Color.WHITE);

                           if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) //Move Left
                           {

                                   //Neue Koordinaten:
                                   x_neu = x-0.001;
                                   y_neu=y;

                                   //Pr�fe ob neuer Punkt zul�ssig
                                   if (x_neu <= 0.05 || y_neu>=0.05 && y_neu<= 0.85 && x_neu<=0.35 && x_neu>=0.25|| y_neu<=0.55 && y_neu>=0.45 && x_neu<=0.55 && x_neu>=0.25 || y_neu<=0.95 && y_neu>=0.15 && x_neu<=0.8 && x_neu>=0.7 ){
                                           
                                           x_neu=x; //Keine Bewegung m�glich
                                           }
                                   
                                   else
                                   {
                                   //�bermale alte Figur
                                   StdDraw.point(x, y);
                                   x=x_neu;
                                   y=y_neu;
                                   //Zeichne neue Figur
                                   player(x,y);
                                   }
                           }
                           else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) //Move right
                           {

                                 //Neue Koordinaten:
                                   x_neu = x+0.001;
                                   y_neu = y;
                                 //Pr�fe ob neuer Punkt zul�ssig
                                   if (x_neu>=0.95|| x_neu<=0.35 && x_neu>=0.25 && y_neu>=0.05 && y_neu<0.85 || x<= 0.8 && x_neu>=0.7 && y_neu<=0.95 && y_neu>=0.25 ||x_neu<=0.8 && x_neu>=0.45 && y_neu<=0.25 && y_neu>0.15 ) //Wand
                                   {
                                           if ((x_neu<=0.05 && 0.1<=y && y<=0.25) || (x_neu>=0.95 && (y>=0.65 && y<=0.9))) //Start oder Zielbereich
                                           {
                                                 //�bermale alte Figur
                                                   StdDraw.point(x, y);
                                                   x=x_neu;
                                                   y=y_neu;
                                                   //Zeichne neue Figur
                                                   player(x,y);
                                           } else {
                                           x_neu=x; //Keine Bewegung m�glich
                                           }
                                 } else{
                                 //�bermale alte Figur
                                   StdDraw.point(x, y);
                                   x=x_neu;
                                   y=y_neu;
                                   player(x,y);
                                 }
                           }
                           else if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) //Move up
                           {
                                 //Neue Koordinaten:
                                   x_neu = x;
                                   y_neu = y+0.001;
                                 //Pr�fe ob neuer Punkt zul�ssig
                                   if (y_neu>=0.95|| x_neu<=0.05|| x_neu>=0.95 || y_neu<=0.55 && y_neu>=0.45 && x_neu>=0.25 &&x_neu<=0.55 || x_neu>=0.45 && x_neu<=0.7 && y_neu<=0.25 && y_neu>=0.15|| x_neu<=0.8 && x_neu>=0.7 && y_neu<=0.95 &&y_neu>= 0.15 ) //Wand
                                   {
                                           y_neu=y;
                                   } else{
                                 //�bermale alte Figur
                                   StdDraw.point(x, y);
                                   x=x_neu;
                                   y=y_neu;
                                   player(x,y);
                                   }

                           }
                           else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) //Move Down
                           {
                                 //Neue Koordinaten:
                                   x_neu = x;
                                   y_neu = y-0.001;

                                 //Pr�fe ob neuer Punkt zul�ssig
                                   if (y_neu<=0.05|| x_neu<=0.05 || x_neu>=0.95 || y_neu<=0.55 && y>=0.45 && x_neu>=0.25 &&x_neu<=0.55 || x_neu>=0.45 && x_neu<=0.7 && y_neu<=0.25 && y_neu>=0.15||x_neu<=0.35 && x_neu>=0.25 && y_neu <= 0.85 && y_neu>=0.05) //Wand
                                   {
                                           y_neu=y;
                                   } else{
                                 //�bermale alte Figur
                                   StdDraw.point(x, y);
                                   x=x_neu;
                                   y=y_neu;
                                   player(x,y);
                                   }
                           }
                           //Teste ob Gegner/Falle ber�hrt
                           if ((0.57<=x && 0.63 >=x && 0.57<=y && 0.63 >=y)|| 0.12<=x && x<=0.18 && 0.47<=y && y<=0.53)
                           {
                        	   	//Tot -> Zur�ck ins Men�
                        	   	StdDraw.clear();
                                Menue.main(args);
                                    
                                   break;
                                   
                                   

                           }
                           if ((x>=0.95 && (y>=0.7 && y<=0.85)));
                           {
                         new Level2();
                        
                           }
                          
                   }



           }





        /**
* @param args
*/


}
}