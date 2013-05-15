import java.awt.Color;
import java.awt.event.KeyEvent;
public class Level3 {
	 public static double Start_x=.25;
	static public double Start_y=1;
	static public double Finish_x=.75;
	static public double Finish_y=0;
	
	static public double Waag1_x1=0;
	static public double Waag1_x2=.35;
	static public double Waag1_y=.5;
	static public double Waag2_x1=.55;
	static public double Waag2_x2=1;
	static public double Waag2_y=.5;
	
	static public double Enemy1_x=0.45;
	static public double Enemy1_y=.5;
	static public double Enemy2_x=0.5;
	static public double Enemy2_y=0.7;
	
	
	static void room()
    {
		StdDraw.setCanvasSize(512,512);

		   StdDraw.setPenColor(StdDraw.BLACK);
		  
		   StdDraw.setPenRadius(0.01);
		   
		   //Rand des Spielfelds:
		   StdDraw.line(0, 0, 0, 1);
		   StdDraw.line(0, 0, 1,0);
		   StdDraw.line(1, 1,1 , 0);
		   StdDraw.line(1, 1, 0, 1);
		   
		   //Start & Zielbereich weiß:
		   StdDraw.setPenColor(StdDraw.WHITE);
		   StdDraw.filledSquare(Start_x, Start_y, 0.05); //Start
		   StdDraw.filledSquare(Finish_x, Finish_y, 0.05); //Ziel
		   
		   //Zwischenwände:
		   StdDraw.setPenColor(StdDraw.BLACK);
//		   StdDraw.line(Senk1_x,Senk1_y1, Senk1_x, Senk1_y2); //senkrechte Zwischenwand
//		   StdDraw.line(Senk2_x, Senk2_y1, Senk2_x,Senk2_y2); //senkrechte Zwishcenwand
		   StdDraw.line(Waag1_x1,Waag1_y, Waag1_x2, Waag1_y); //waagerechte Zwischenwand
		   StdDraw.line(Waag2_x1, Waag2_y, Waag2_x2, Waag2_y); //waagerechte Zwischenwand
		   
		   	  
	}
	public static int isvalid(double x, double y)
	{
		if (x<=.5 || x>=.95 || y<=0.5 || y>=.95)
		{
			if (x>=0.95 && Math.abs(y-Finish_y)<=0.6 )
			{
				return 1; //Ziel
			}
			else if (x<=0.5 && y-Start_y<=.6 || Start_y-y>=0.6) {
				return 2; //Start
			}
			else return 3; //Wall
		}
			else if (Math.abs(y-Waag1_y)<=0.5 && Math.abs((Waag1_x1+Waag1_x1)/2-x) <= Math.abs((Waag1_x1+Waag1_x1)/2-Waag1_x1)+0.5) //Waag1
			{
				return 3; //Wall ->invalid Move
			}
			else if (Math.abs(y-Waag2_y)<=0.5 && Math.abs((Waag2_x1+Waag2_x1)/2-x) <= Math.abs((Waag2_x1+Waag2_x1)/2-Waag2_x1)+0.5) //Waag2
			{
				return 3; //Wall ->invalid Move
			}
			else if (Math.abs(x-Enemy1_x)<=0.5 && Math.abs(y-Enemy1_y)<=0.5)
			{
				return 4; //Enemy1 -> Death
			}
			else if (Math.abs(x-Enemy2_x)<=0.5 && Math.abs(y-Enemy2_y)<=0.5)
			{
				return 4; //Enemy -> Death
			}
			else {
				return 0; //Move is valid
			}
		}
	static void enemy(double x,double y) //Gegner Einzeichnen
{
	StdDraw.setPenColor(StdDraw.RED);
	StdDraw.filledSquare(x, y, 0.03);
}
	static void player(double x,double y) //Spieler einzeichnen
    {

            //Initialisiere Spielfigur als Punkt an der Koordinate (x,y):
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.setPenRadius(0.05);
            StdDraw.point(x, y);
    }

	public static void main(String[] args) 
        {

               //Initialisiere Level
               room();
               double x=Start_x;
               double y=Start_y;
               
               double x_neu;
               double y_neu;
               
               player(x,y);
               enemy(Enemy1_x,Enemy1_y);
               enemy(Enemy2_x,Enemy2_y);
               byte direction=1;
               
               
               while (x>=0 && x<=1)
               {
            	 //Ändere Stiftfarbe und Größe, um Spielfigur zu übermalen:
    			StdDraw.setPenRadius(.07);
    			StdDraw.setPenColor(StdDraw.WHITE);
    			
    			//Übermale alte Gegner
    			StdDraw.filledSquare(Enemy1_x, Enemy1_y,0.05);
    			StdDraw.filledSquare(Enemy2_x, Enemy2_y,0.05);
            	 
            	 //Position des Beweglichen Feindes:
       			if (Enemy1_y>=0.95)
       			{
       				direction=-1;
       				Enemy1_y=0.94;
       				Enemy2_x=0.94;
       			}
       			else if (Enemy1_y<=0.5)
       			{
       				direction=1;
       				Enemy1_y=.06;
       				Enemy2_x=0.06;
       			}
       			else
       			{
       				Enemy1_y=Enemy1_y+direction*0.01;
       				Enemy2_x=Enemy2_x+direction*0.01;
       			}
       			
       			//Zeichne neue Gegner
       			enemy(Enemy1_x,Enemy1_y);
       			enemy(Enemy2_x,Enemy2_y);
       		  
    			
    			//Tastatureingabe auslesen
    			if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) //Move Left
    			{
    				//Neue Koordinaten:
    				   x_neu = x-0.001;
    				   y_neu=y;
    			}
    			else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) //Move right
    			{
    				//Neue Koordinaten:
    				   x_neu = x+0.001;
    				   y_neu=y;
    			}
    			 else if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) //Move up
    			   {
    				 //Neue Koordinaten:
    				   x_neu = x;
    				   y_neu = y+0.001;
    			   }
    			 else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) //Move Down
    			   {
    				 //Neue Koordinaten:
    				   x_neu = x;
    				   y_neu = y-0.001;
    			   }
    			 else 
    			 	{
    				 x_neu=x; 
    				 y_neu=y;
    				}
    			if (isvalid(x_neu,y_neu)==4)
    			{
    				//Gegner Berührt -> Tot
    				Panel.main(null);
    				break;
    			}
    			else if (isvalid(x_neu,y_neu)==1)
    			{
    				//Ziel erreicht
    				StdDraw.clear();
    				StdDraw.text(0.5, 0.5, "Herzlichen Glückwunsch! Alle Level geschafft");
    				break;
    			}
    			else if (isvalid(x_neu,y_neu)==2)
    			{
    				//Start-Bereich -> Level zurück
    				new Level2();
    				break;
    			}
    			else if (isvalid(x_neu,y_neu)==5)
    			{
    				//Alles ok
    				
    				//Übermale alte Figur
                    StdDraw.point(x, y);
    				x=x_neu;
    				y=y_neu;
    				
    				//Zeichne neue Figur
                    player(x,y);
    			}
    			
    			
    			

       			
               }
        }
	
}
