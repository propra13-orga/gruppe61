import java.awt.event.KeyEvent;


public class Game {
	
	//Globale Variablen für die Level
	static double[] Senk1_x = {0.3,0,0};
	static double[] Senk1_y1={0,0,0};
	static double[] Senk1_y2={0.8,0};
	static double[] Senk2_x={0.75,0};
	static double[] Senk2_y1={1,0,0};
	static double[] Senk2_y2={0.2,0,0};
	static double[] Waag1_x1={0.3,0,0};
	static double[] Waag1_x2={0.5,0,.35};
	static double[] Waag1_y={0.5,0,0.5};
	static double[] Waag2_x1={0.5,0,.55};
	static double[] Waag2_x2={0.75,0,1};
	static double[] Waag2_y={0.2,0,.5};
	static double[] Start_x={0,0.35,0,.25};
	static double[] Start_y={0.15,0,1};
	static double[] Finish_x={1,.75,.75};
	static double[] Finish_y={0.758,1,0};
	   
	static double Enemy1_x=0.45;
	static double Enemy1_y=.6;
	static double Enemy2_x=0.15;
	static double Enemy2_y=0.5;


	
	
	static void room(int k)
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
		   StdDraw.filledSquare(Start_x[k], Start_y[k], 0.05); //Start
		   StdDraw.filledSquare(Finish_x[k], Finish_y[k], 0.05); //Ziel
		   
		   //Zwischenwände:
		   StdDraw.setPenColor(StdDraw.BLACK);
		   StdDraw.line(Senk1_x[k],Senk1_y1[k], Senk1_x[k], Senk1_y2[k]); //senkrechte Zwischenwand
		   StdDraw.line(Senk2_x[k], Senk2_y1[k], Senk2_x[k],Senk2_y2[k]); //senkrechte Zwishcenwand
		   StdDraw.line(Waag1_x1[k],Waag1_y[k], Waag1_x2[k], Waag1_y[k]); //waagerechte Zwischenwand
		   StdDraw.line(Waag2_x1[k], Waag2_y[k], Waag2_x2[k], Waag2_y[k]); //waagerechte Zwischenwand
		   
		   	  
	}
	
	//Prüfen, ob Schritt zulässig:
	public static int isvalid(double x, double y,int k)
	{
		if (x<=.5 || x>=.95 || y<=0.5 || y>=.95)
		{
			if (x>=0.95 && Math.abs(y-Finish_y[k])<=0.6 )
			{
				return 1; //Ziel
			}
			else if (x<=0.5 && y-Start_y[k]<=.6 || Start_y[k]-y>=0.6) {
				return 2; //Start
			}
			else return 3; //Wall
		}
		else if (Math.abs(x-Senk1_x[k])<=0.5 && Math.abs((Senk1_y1[k]+Senk1_y2[k])/2-y)<= Math.abs((Senk1_y1[k]+Senk1_y2[k])/2-Senk1_y1[k])+.5) //Senk1
				{
				return 3; //Wall ->invalid Move
				}
			else if (Math.abs(x-Senk2_x[k]) <=0.5 && Math.abs((Senk2_y1[k]+Senk1_y2[k])/2-y)<= Math.abs((Senk2_y1[k]+Senk2_y2[k])/2-Senk2_y1[k])+.5) //Senk2
			{
				return 3; //Wall ->invalid Move
			}
			else if (Math.abs(y-Waag1_y[k])<=0.5 && Math.abs((Waag1_x1[k]+Waag1_x1[k])/2-x) <= Math.abs((Waag1_x1[k]+Waag1_x1[k])/2-Waag1_x1[k])+0.5) //Waag1
			{
				return 3; //Wall ->invalid Move
			}
			else if (Math.abs(y-Waag2_y[k])<=0.5 && Math.abs((Waag2_x1[k]+Waag2_x1[k])/2-x) <= Math.abs((Waag2_x1[k]+Waag2_x1[k])/2-Waag2_x1[k])+0.5) //Waag2
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

	
	//Spieler einzeichnen:
	static void player(double x,double y) 
	{
		
		//Initialisiere Spielfigur als Punkt an der Koordinate (x,y):
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.setPenRadius(0.05);
		StdDraw.point(x, y);
	}
	
	

	
	public static void main(String[] args) {
	
		//Initialisiere Variablen
		int k=0; //Zählt das Level
		double x=Start_x[k];
		double y=Start_y[k];
		double x_neu;
		double y_neu;
		
		int direction=1;
		room(k);
		player(x,y);                  
		while (true)
		{
			
			//Position des Beweglichen Feindes:
			if (Enemy1_y>=0.95)
			{
				direction=-1;
				Enemy1_y=0.94;
			}
			else if (Enemy1_y<=0.5)
			{
				direction=1;
				Enemy1_y=.06;
			}
			else
			{
				Enemy1_y=Enemy1_y+direction*0.01;
			}
			
			//Ändere Stiftfarbe und Größe, um Spielfigur zu übermalen:
			StdDraw.setPenRadius(.07);
			StdDraw.setPenColor(StdDraw.WHITE);  
			
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
			//auf Gültigkeit prüfen
			if (isvalid(x_neu,y_neu,k)==3)
					{
						//Wall
						x=x_neu;
						y=y_neu;
					}
			else if (isvalid(x_neu,y_neu,k)==1)
			{
				//Level down
				if (k>0) //Nur dann gibt es niedrigeres Level
					{
					k=k-1;
				
					//Neues Level Zeichnen:
					StdDraw.clear();
					room(k);
				
					//Spieler auf neue Startposition setzen:
					x=Start_x[k];
					y=Start_x[k];
					
					//Spieler einzeichnen:
					player(x,y);
					}
				else
				{
					//Übermale alte Figur
					StdDraw.point(x, y);
					
					//Zeichne neue Figur
					x=x_neu;
					y=y_neu;
					player(x,y); 
				}
			}
					
			else if (isvalid(x_neu,y_neu,k)==2) 
			{
				//Level up:
				if (k<1)
				{
				k=k+1;
				//Neues Level Zeichnen:
				StdDraw.clear();
				room(k);
				
				//Spieler auf neue Startposition setzen:
				x=Start_x[k];
				y=Start_x[k];
				
				//Spieler einzeichnen:
				player(x,y);
				}
				else //Durchgezockt
				{
					Panel.main(args);
				}
			}
			else if (isvalid(x_neu,y_neu,k)==4) 
			{
				//Tod
				Panel.main(args);
			}
			else //Alles ok
			{
				//Übermale alte Figur
				   StdDraw.point(x, y);
				   
				   //Zeichne neue Figur
				   x=x_neu;
				   y=y_neu;
				   room(k);
				   player(x,y); 
			}
		}
		

	}
	
}

