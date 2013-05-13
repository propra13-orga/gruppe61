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
                  double x=0.051;
                  double y=.15;

                  //Initialisiere Spielfigur am Startpunkt
                   player(x,y);
                   double x_neu;
                   double y_neu;

                   while (x>=0.001 && x<=1 )
                   {
                           //�ndere Stiftfarbe und Gr��e, um Spielfigur zu �bermalen:
                           StdDraw.setPenRadius(.07);
                           StdDraw.setPenColor(Color.WHITE);

                           if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) //Move Left
                           {

                                   //Neue Koordinaten:
                                   x_neu = x-0.001;
                                   y_neu=y;

                                   //Pr�fe ob neuer Punkt zul�ssig
                                   if ((x_neu<=0.05 && 0.1<=y && y<=0.25) || (x_neu>=0.95 && (y>=0.65 && y<=0.9)) || ( x_neu>=0.25 && x_neu<=0.35 && y<=0.85) || (0.70<=x_neu && x_neu<=0.8 && y>=0.15) || (0.45<=x_neu && 0.55<=x_neu && 0.15<=y && y<=0.25) || y_neu>0.95 || (0.25<=x_neu && x_neu<=0.55 && y_neu>=0.45 && y_neu<=0.55) || (0.45<=x_neu && x_neu<=0.75 && 0.15<=y_neu && y_neu<=0.25) || y_neu<=0.05) //Wand
                                   {
                                           if ((x_neu<=0.05 && 0.1<=y && y<=0.25) || (x_neu>=0.95 && (y>=0.65 && y<=0.9))) //Start oder Zielbereich =>Bewegung m�glich
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
                                   if ((x_neu<=0.05 && 0.1<=y && y<=0.25) || (x_neu>=0.95 && (y>=0.65 && y<=0.9)) || ( x_neu>=0.25 && x_neu<=0.35 && y<=0.85) || (0.70<=x_neu && x_neu<=0.8 && y>=0.15) || (0.45<=x_neu && 0.55<=x_neu && 0.15<=y && y<=0.25) || y_neu>0.95 || (0.25<=x_neu && x_neu<=0.55 && y_neu>=0.45 && y_neu<=0.55) || (0.45<=x_neu && x_neu<=0.75 && 0.15<=y_neu && y_neu<=0.25) || y_neu<=0.05) //Wand
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
                                   if ((x_neu<=0.05 && 0.1<=y && y<=0.25) || (x_neu>=0.95 && (y>=0.65 && y<=0.9)) || ( x_neu>=0.25 && x_neu<=0.35 && y<=0.85) || (0.70<=x_neu && x_neu<=0.8 && y>=0.15) || (0.45<=x_neu && 0.55<=x_neu && 0.15<=y && y<=0.25) || y_neu>0.95 || (0.25<=x_neu && x_neu<=0.55 && y_neu>=0.45 && y_neu<=0.55) || (0.45<=x_neu && x_neu<=0.75 && 0.15<=y_neu && y_neu<=0.25) || y_neu<=0.05) //Wand
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
                                   if ((x_neu<=0.05 && 0.1<=y && y<=0.25) || (x_neu>=0.95 && (y>=0.65 && y<=0.9)) || ( x_neu>=0.25 && x_neu<=0.35 && y<=0.85) || (0.70<=x_neu && x_neu<=0.8 && y>=0.15) || (0.45<=x_neu && 0.55<=x_neu && 0.15<=y && y<=0.25) || y_neu>0.95 || (0.25<=x_neu && x_neu<=0.55 && y_neu>=0.45 && y_neu<=0.55) || (0.45<=x_neu && x_neu<=0.75 && 0.15<=y_neu && y_neu<=0.25) || y_neu<=0.05) //Wand
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
                           if ((0.55<=x && 0.65 >=x && 0.55<=y && 0.65 >=y)|| 0.1<=x && x<=0.2 && 0.45<=y && y<=0.55)
                           {
                        	   
                        	    StdDraw.clear();
                                   Panel.main(args);//Das Fenster muss immer noch geschglossen werden 
                                    
                                   break;
                                   
                                   

                           }
                          
                   }



           }





        /**
         * @param args
         */


}
}