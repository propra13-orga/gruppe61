
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
          
           //Wände:
           StdDraw.text(0, .15, "Start");
           StdDraw.line(0.3,0, 0.3, 0.8);
           StdDraw.line(0.75, 1, .75, .2);
           StdDraw.line(0.3, .5, 0.5, .5);
           StdDraw.line(0.75, 0.2, 0.5, 0.2);
           StdDraw.text(1, 0.758, "Ziel");
          
           //Statischer Gegner/Falle
           StdDraw.setPenColor(StdDraw.RED);
           StdDraw.square(0.6, .6, 0.01);
           StdDraw.square(0.15, .5, 0.01);
          
         
    }
   
    static void player(double x,double y)
    {
       
        //Initialisiere Spielfigur als Punkt an der Koordinate (x,y):
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setPenRadius(0.05);
        StdDraw.point(x, y);
                 
           while (true)
           { if (StdDraw.hasNextKeyTyped())
           {
           
               if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT))
               {
                   //Move Left
                   x=x-0.01;
                  
               }
               else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT))
               {
                   //Move right
                   x=x+0.01;
               }
               else if (StdDraw.isKeyPressed(KeyEvent.VK_UP))
               {
                   //Move up
                   y=y+0.01;
               }
               else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN))
               {
                   //Move Down
                   y=y-0.01;
               }
               StdDraw.clear();
               room();
               player(x,y);
              
           }
           }
          

       
    }
   
   

   
   
   public static void main(String[] args) {
       {
         
          //Initialosiere Level
          room();
         
          //Startpunkt
          double x=0;
          double y=.15;
         
          //Initialisiere Spielfigur am Startpunkt
           player(x,y);

 
      

       }
 
  

   

    /**
     * @param args
     */
   

}
}
