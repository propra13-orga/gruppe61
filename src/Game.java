import java.awt.event.KeyEvent;


public class Game {
	public static byte numberoflevels = 3;
	
	//Globale Variablen für die Level
	public static double Senk1_x(int levelnr)
	{
		if (levelnr==1)  return 0.3;
		if (levelnr==2) return 0;
		else return 0; //Es bleibt nur Level 3 übrig
	}
	public static double Senk1_y1(int levelnr)
	{
		if (levelnr==1) return 0;
		if (levelnr==2) return 0;
		else return 0; //Es bleibt nur Level3 übrig
	}
	public static double Senk1_y2(int levelnr)
	{
		if (levelnr==1) return 0.8;
		if (levelnr==2) return 0;
		else return 0;  //Es bleibt nur Level3 übrig
	}
	public static double Senk2_x(int levelnr)
	{
		if (levelnr==1) return 0.75;
		if (levelnr==2) return 0;
		else return 0;  //Es bleibt nur Level3 übrig
	}
	public static double Senk2_y1(int levelnr)
	{
		if (levelnr==1) return 1;
		if (levelnr==2) return 0;
		else return 0;  //Es bleibt nur Level3 übrig
	}
	public static double Senk2_y2(int levelnr)
	{
		if (levelnr==1) return 0.2;
		if (levelnr==2) return 0;
		else return 0;  //Es bleibt nur Level3 übrig
	}
	public static double Waag1_x1(int levelnr)
	{
		if (levelnr==1) return 0.3;
		if (levelnr==2) return 0;
		else return 0;  //Es bleibt nur Level3 übrig
	}
	public static double Waag1_x2(int levelnr)
	{
		if (levelnr==1) return 0.5;
		if (levelnr==2) return 0;
		else return .35;  //Es bleibt nur Level3 übrig
	}
	public static double Waag1_y(int levelnr)
	{
		if (levelnr==1) return 0.5;
		if (levelnr==2) return 0;
		else return 0.5;  //Es bleibt nur Level3 übrig
	}
	public static double Waag2_x1(int levelnr)
	{
		if (levelnr==1) return 0.5;
		if (levelnr==2) return 0;
		else return .55;  //Es bleibt nur Level3 übrig
	}
	public static double Waag2_x2(int levelnr)
	{
		if (levelnr==1) return 0.75;
		if (levelnr==2) return 0;
		else return 1;  //Es bleibt nur Level3 übrig
	}
	public static double Waag2_y(int levelnr)
	{
		if (levelnr==1) return 0.2;
		if (levelnr==2) return 0;
		else return .5;  //Es bleibt nur Level3 übrig
	}
	public static double Start_x(int levelnr)
	{
		if (levelnr==1) return 0;
		if (levelnr==2) return 0.35;
		else return 0;  //Es bleibt nur Level3 übrig
		//	,.25};
	}	
	public static double Start_y(int levelnr)
	{
		if (levelnr==1) return 0.15;
		if (levelnr==2) return 0;
		else return 1;  //Es bleibt nur Level3 übrig
	}
	public static double Finish_x(int levelnr)
	{
		if (levelnr==1) return 1;
		if (levelnr==2) return .75;
		else return .75;  //Es bleibt nur Level3 übrig
	}
	public static double Finish_y(int levelnr)
	{
		if (levelnr==1) return 0.758;
		if (levelnr==2) return 1;
		else return 0;  //Es bleibt nur Level3 übrig
	}
	   
	public static double Enemy1Start_x(int levelnr)
	{
		if (levelnr==1) return 0.45;
		if (levelnr==2) return .5;
		else return 0.45; //Es bleibt nur Level3 übrig 
	}
	public static double Enemy1Start_y(int levelnr)
	{
		if (levelnr==1) return .6;
		if (levelnr==2) return .5;
		else return .5; //Es bleibt nur Level3 übrig
	}
	public static double Enemy2Start_x(int levelnr)
	{
		if (levelnr==1) return 0.15;
		if (levelnr==2) return 0.7;
		else return 0.5; //Es bleibt nur Level3 übrig
	}
	public static double Enemy2Start_y(int levelnr)
	{
		if (levelnr==1) return 0.5;
		if (levelnr==2) return 0.2;
		else return 0.7; //Es bleibt nur Level3 übrig
	}
	public static double Enemy3Start_x(int levelnr)
	{
		if (levelnr==1) return 0.15;
		if (levelnr==2) return .1;
		else return 0; //Es bleibt nur Level3 übrig
	}
	public static double Enemy3Start_y(int levelnr)
	{
		if (levelnr==1) return 0.5;
		if (levelnr==2) return 0.82;
		else return 0; //Es bleibt nur Level3 übrig
	}

	static double Enemy1_x;
	static double Enemy1_y;
	static double Enemy2_x;
	static double Enemy2_y;
	static double Enemy3_x;
	static double Enemy3_y;
	
	//Raum zeichnen:
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
		   StdDraw.filledSquare(Start_x(k), Start_y(k), 0.05); //Start
		   StdDraw.filledSquare(Finish_x(k), Finish_y(k), 0.05); //Ziel
		   
		   //Zwischenwände:
		   StdDraw.setPenColor(StdDraw.BLACK);
		   StdDraw.line(Senk1_x(k),Senk1_y1(k), Senk1_x(k), Senk1_y2(k)); //senkrechte Zwischenwand
		   StdDraw.line(Senk2_x(k), Senk2_y1(k), Senk2_x(k),Senk2_y2(k)); //senkrechte Zwishcenwand
		   StdDraw.line(Waag1_x1(k),Waag1_y(k), Waag1_x2(k), Waag1_y(k)); //waagerechte Zwischenwand
		   StdDraw.line(Waag2_x1(k), Waag2_y(k), Waag2_x2(k), Waag2_y(k)); //waagerechte Zwischenwand
		   
		   	  
	}
	
	//Prüfen, ob Schritt zulässig:
	public static int isvalid(double x, double y,int k) //(x,y) Koordinaten, k gibt das Level an
	{
		if (x<=.5 || x>=.95 || y<=0.5 || y>=.95)
		{
			if (x>=0.95 && Math.abs(y-Finish_y(k))<=0.6 )
			{
				return 1; //Ziel
			}
			else if (x<=0.5 && y-Start_y(k)<=.6 || Start_y(k)-y>=0.6) {
				return 2; //Start
			}
			else return 3; //Wall
		}
		else if (Math.abs(x-Senk1_x(k))<=0.5 && Math.abs((Senk1_y1(k)+Senk1_y2(k))/2-y)<= Math.abs((Senk1_y1(k)+Senk1_y2(k))/2-Senk1_y1(k))+.5) //Senk1
				{
				return 3; //Wall ->invalid Move
				}
			else if (Math.abs(x-Senk2_x(k)) <=0.5 && Math.abs((Senk2_y1(k)+Senk1_y2(k))/2-y)<= Math.abs((Senk2_y1(k)+Senk2_y2(k))/2-Senk2_y1(k))+.5) //Senk2
			{
				return 3; //Wall ->invalid Move
			}
			else if (Math.abs(y-Waag1_y(k))<=0.5 && Math.abs((Waag1_x1(k)+Waag1_x1(k))/2-x) <= Math.abs((Waag1_x1(k)+Waag1_x1(k))/2-Waag1_x1(k))+0.5) //Waag1
			{
				return 3; //Wall ->invalid Move
			}
			else if (Math.abs(y-Waag2_y(k))<=0.5 && Math.abs((Waag2_x1(k)+Waag2_x1(k))/2-x) <= Math.abs((Waag2_x1(k)+Waag2_x1(k))/2-Waag2_x1(k))+0.5) //Waag2
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
			}else if (Math.abs(x-Enemy3_x)<=0.5 && Math.abs(y-Enemy3_y)<=0.5)
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
	//Gegner einzeichnen:
	static void enemy(double x, double y)
	{
		StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledSquare(0.6, .6, 0.01);
        StdDraw.filledSquare(0.15, .5, 0.01);
	}
	
	static double move_enemy(int levelnr)
	{
		if (levelnr==1) //In Level 1 sind Gegner statisch
			return 0;
		if (levelnr==2) return 0.001;
		else //Es bleibt nur Level3 übrig
		{
			return .001;
		}
	}

	
	public static void main(String[] args) {
	
		//Initialisiere Variablen
		int k=1; //Zählt das Level
		double x=Start_x(k);
		double y=Start_y(k);
		double x_neu;
		double y_neu;
		double direction;
		Enemy1_x=Enemy1Start_x(k);
		Enemy1_y=Enemy1Start_y(k);
		Enemy2_x=Enemy2Start_x(k);
		Enemy2_y=Enemy2Start_y(k);
		Enemy3_x=Enemy3Start_x(k);
		Enemy3_y=Enemy3Start_y(k);
		
		//Initialisiere Level::
		player(x,y);
		enemy(Enemy1_x,Enemy1_y);
		enemy(Enemy2_x,Enemy2_y);
		enemy(Enemy3_x,Enemy3_y);
		room(k);
		
		while (true)
		{
			//Buffering:
			StdDraw.show(0);
			
			//Position des Beweglichen Feindes:
			direction=move_enemy(k);
			if (Enemy1_y>=0.95)
			{
				direction=-direction;
				Enemy1_y= Enemy1_y+3*direction;
			}
			else if (Enemy1_y<=0.5)
			{
				direction=-direction;
				Enemy1_y=Enemy1_y+3*direction;
			}
			else
			{
				Enemy1_y=Enemy1_y+direction;
			}
			
			//In Level3 nur Bewegung in eine Dimension
			if (k==3)
			{
				//Mache Bewegung Rückgänig
				Enemy1_y=Enemy1Start_y(k);
				Enemy2_x=Enemy2Start_x(k);
				Enemy3_y=Enemy3Start_y(k);
				Enemy3_x=Enemy3Start_x(k);
			}
						
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
			 else //keine (gültige) Taste gedrückt
			 	{
				 x_neu=x; 
				 y_neu=y;
				}	
			
			//auf Gültigkeit prüfen
			int check=isvalid(x_neu,y_neu,k);
			if (check==3)
					{
						//Wand -> stehen bleiben
						x_neu=x;
						y_neu=y;
					}
			else if (check==1)
			{
				//Level down
				if (k>0) //Nur dann gibt es niedrigeres Level
					{
					k=k-1;
				
					//Spieler auf neue Startposition setzen:
					x_neu=Finish_x(k)-0.06;
					y_neu=Finish_x(k)-.06;
					}
//				else
//				{
//					x_neu=Start_x(k);
//					y_neu=Start_y(k);
//				}
			}
					
			else if (check==2) 
			{
				//Level up:
				if (k<numberoflevels) //Nur dann gibt es höheres Level
				{
				k=k+1;
				
				//Spieler auf neue Startposition setzen:
				x_neu=Start_x(k);
				y_neu=Start_x(k);
				}
				else //Durchgezockt
				{
					Panel.main(args);
				}
			}
			else if (check==4) 
			{
				//Tod
				Panel.main(args);
				break;
			}
//			else //Alles ok
//			{
//				//Übermale alte Figur
//				   StdDraw.point(x, y);
//				   
//				   //Zeichne neue Figur
//				   x=x_neu;
//				   y=y_neu;
//				   room(k);
//				   player(x,y); 
//			}
			
			//neu zeichnen:
			StdDraw.clear();
			enemy(Enemy1_x,Enemy1_y);
			enemy(Enemy2_x,Enemy2_y);
			enemy(Enemy3_x,Enemy3_y);
			x=x_neu;
			y=y_neu;
			player(x,y);
			room(k);
			
		}
		

	}
	
}

