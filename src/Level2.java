import java.awt.Color;
import java.awt.event.KeyEvent;

public class Level2 {
	 static void room()
     {
             StdDraw.setCanvasSize(512,512);

                StdDraw.setPenColor(StdDraw.BLACK);

                StdDraw.setPenRadius(0.01);

                //Rand des Spielfelds:
                StdDraw.line(.0, .0, .0, 1);
                StdDraw.line( 0, 0, .3 , 0);
                StdDraw.line(.4, 0, 1 , 0);
                
                StdDraw.line(1,0,1,1);
                StdDraw.line(.8, 1,1 , 1);
                StdDraw.line(0, 1, .7, 1);

                //Wände:
                StdDraw.text(0.35, 0, "Start");

                StdDraw.text(.75, 1, "Ziel");
     }
   static void Fallen(double z,double k){
                //Statischer Gegner/Falle
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.filledSquare(z, k, 0.01);
                StdDraw.filledSquare(-z, k, 0.01);
                StdDraw.filledSquare(z, -k, 0.01);


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
               double x=0.35;
               double y=.051;
               
               //Initialisiere Spielfigur am Startpunkt
               player(x,y);
               //für die neuen Punkte der Spielfigur
               double x_neu;
               double y_neu;
               
               //Fallen Startpunkte
               double z=0.5;
               double k=0.5;
               
               //Initialisiere Fallen auf dem Feld
               Fallen(z,k);
               //Für die neuen Punkte der Falle
               double z_neu;
               double k_neu;
               int p =1;
             


                while (x>=0.001 && x<=1 )
                 
                {	
                   
                		
                	
                	
                	
                        //Ändere Stiftfarbe und Größe, um Spielfigur zu übermalen:


                        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) //Move Left
                        {
                        	StdDraw.setPenRadius(.07);
                        	StdDraw.setPenColor(Color.WHITE);
                        	StdDraw.filledSquare(z, k, 0.02);
                    	if(z<0.97 && k<0.97 && p==1){
                        	z_neu=z+0.001;
                        	k_neu=k+0.001;
                        	z=z_neu;
                        	k=k_neu;}
                        	else if(z>0.03 && k>0.03 &&p==0) {                	
                        	z_neu=z-0.001;
                        	k_neu=k-0.001;
                        	z=z_neu;
                        	k=k_neu;}
                        	else {
                        		if (p==1){p=0;}
                        		else {p=1;}
                        	}
                        		
                        	
                        	
                        	Fallen(z,k);
                        	 //Ändere Stiftfarbe und Größe, um Spielfigur zu übermalen:
                            StdDraw.setPenRadius(.07);
                            StdDraw.setPenColor(Color.WHITE);
                                //Neue Koordinaten:
                                x_neu = x-0.001;
                                y_neu=y;

                                //Prüfe ob neuer Punkt zulässig
                                if (x_neu <= 0.05 || y_neu>=0.95){ //Wand
                                	x_neu=x;			}
                                else
                                {
                                //Übermale alte Figur
                                StdDraw.point(x, y);
                                x=x_neu;
                                y=y_neu;
                                //Zeichne neue Figur
                                player(x,y);
                                }
                        }
                        else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) //Move right
                        {
                        	StdDraw.setPenRadius(.07);
                        	StdDraw.setPenColor(Color.WHITE);
                        	StdDraw.filledSquare(z, k, 0.02);
                    	if(z<0.97 && k<0.97 && p==1){
                        	z_neu=z+0.001;
                        	k_neu=k+0.001;
                        	z=z_neu;
                        	k=k_neu;}
                        	else if(z>0.03 && k>0.03 &&p==0) {                	
                        	z_neu=z-0.001;
                        	k_neu=k-0.001;
                        	z=z_neu;
                        	k=k_neu;}
                        	else {
                        		if (p==1){p=0;}
                        		else {p=1;}
                        	}
                        		
                        	
                        	
                        	Fallen(z,k);
                       	 //Ändere Stiftfarbe und Größe, um Spielfigur zu übermalen:
                            StdDraw.setPenRadius(.07);
                            StdDraw.setPenColor(Color.WHITE);
                              //Neue Koordinaten:
                                x_neu = x+0.001;
                                y_neu = y;
                              //Prüfe ob neuer Punkt zulässig
                                if (x_neu >= 0.95|| y_neu>=0.95) //Wand
                                { x_neu=x; 
                                } 
                                
                                else{
                              //Übermale alte Figur
                                StdDraw.point(x, y);
                                x=x_neu;
                                y=y_neu;
                                player(x,y);
                              }
                        }
                        else if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) //Move up
                        {	
                        	StdDraw.setPenRadius(.07);
                    		StdDraw.setPenColor(Color.WHITE);
                        	StdDraw.filledSquare(z, k, 0.02);
                    	if(z<0.97 && k<0.97 && p==1){
                        	z_neu=z+0.001;
                        	k_neu=k+0.001;
                        	z=z_neu;
                        	k=k_neu;}
                        	else if(z>0.03 && k>0.03 &&p==0) {                	
                        	z_neu=z-0.001;
                        	k_neu=k-0.001;
                        	z=z_neu;
                        	k=k_neu;}
                        	else {
                        		if (p==1){p=0;}
                        		else {p=1;}
                        	}
                        		
                        	
                        	
                        	Fallen(z,k);
                       	 //Ändere Stiftfarbe und Größe, um Spielfigur zu übermalen:
                            StdDraw.setPenRadius(.07);
                            StdDraw.setPenColor(Color.WHITE);
                              //Neue Koordinaten:
                                x_neu = x;
                                y_neu = y+0.001;
                              //Prüfe ob neuer Punkt zulässig
                                if (y_neu>=0.95) //Wand
                                {	
                                	if(x_neu> 0.3 && x_neu< 0.4 &&y_neu<=0.05|| x_neu>0.7 && x_neu< 0.8){//Beim Start/Ziel nur nach oben erlauben
                                		StdDraw.point(x, y);
                                        x=x_neu;
                                        y=y_neu;
                                        player(x,y);
                                	
                                }
                                	
                                else{
                                        y_neu=y;}//Wenn wir nicht beim Start sind
                                } 
                                else{
                              //Übermale alte Figur
                                StdDraw.point(x, y);
                                x=x_neu;
                                y=y_neu;
                                player(x,y);
                                }

                        }
                        else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) //Move Down
                        {	
                        	StdDraw.setPenRadius(.07);
                        	StdDraw.setPenColor(Color.WHITE);
                        	StdDraw.filledSquare(z, k, 0.02);
                        
                    	if(z<0.97 && k<0.97 && p==1){
                        	z_neu=z+0.001;
                        	k_neu=k+0.001;
                        	z=z_neu;
                        	k=k_neu;}
                        	else if(z>0.03 && k>0.03 &&p==0) {                	
                        	z_neu=z-0.001;
                        	k_neu=k-0.001;
                        	z=z_neu;
                        	k=k_neu;}
                        	else {
                        		if (p==1){p=0;}
                        		else {p=1;}
                        	}
                        		
                        	
                        	
                        	Fallen(z,k);
                       	 //Ändere Stiftfarbe und Größe, um Spielfigur zu übermalen:
                            StdDraw.setPenRadius(.07);
                            StdDraw.setPenColor(Color.WHITE);
                              //Neue Koordinaten:
                                x_neu = x;
                                y_neu = y-0.001;

                              //Prüfe ob neuer Punkt zulässig
                                if (y_neu<=0.05||y_neu>=0.95) //Wand
                                {
                                        y_neu=y;
                                } else{
                              //Übermale alte Figur
                                StdDraw.point(x, y);
                                x=x_neu;
                                y=y_neu;
                                player(x,y);
                                }
                        }
                        //Teste ob Gegner/Falle berührt
                        if (x<=z+0.02 && x>=z-0.02 && y<=k+0.02 && y>=k-0.02)
                        {
                     	   
                     	    StdDraw.clear();
                                Panel.main(args);//Das Fenster muss immer noch geschglossen werden 
                                 
                                break;
                                
                                

                        }
                        if (y>1)
                        {
                     	  new Level3();
                     	  break;
                     	  
                     	   
                        }
                       
                }



        }

}
}
