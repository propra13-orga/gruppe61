import java.awt.Color;
import java.awt.event.KeyEvent;

public class Level3 {
	static void zwischenwaende()
	{
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(0.01);
		StdDraw.line(0.3,0, 0.3, 0.8); //senkrechte Zwischenwand
        StdDraw.line(0.75, 1, .75, .2); //senkrechte Zwishcenwand
        StdDraw.line(0.3, .5, 0.5, .5); //waagerechte Zwischenwand
        StdDraw.line(0.75, 0.2, 0.5, 0.2); //waagerechte Zwischenwand
	}
   static void Falle1(double i,double j){
                //bewegene Gegner/Falle
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.filledSquare(i, j, 0.01);


     }
   static void Falle2(double k,double l){
       //bewegene Gegner/Falle
       StdDraw.setPenColor(StdDraw.RED);
       StdDraw.filledSquare(k, l, 0.01);
       
   }
   static void Falle3(double n,double m){
       //bewegene Gegner/Falle
       StdDraw.setPenColor(StdDraw.RED);
       StdDraw.filledSquare(n, m, 0.01);


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
               Level1.room();

               //Startpunkt
               double x=0;
               double y=.15;
               
               //Initialisiere Spielfigur am Startpunkt
               player(x,y);
               //für die neuen Punkte der Spielfigur
               double x_neu;
               double y_neu;
               
               //Fallen Startpunkte
               double i=0.5;
               double j=0.5;
               double k=0.7;
               double l=0.2;
               double n=0.1;
               double m=0.82;
               
               
               //Initialisiere Fallen auf dem Feld
               Falle1(i,j);
               Falle2(k,l);
               //Falle3(n,m);
               //Für die neuen Punkte der Falle
               double i_neu;
               double j_neu;
               double k_neu;
               double l_neu;
               double n_neu;
               double m_neu;
               
               
               int p_1 =1;
               int p_2 =1;
               int p_3 =1;


                while (true)
                 
                {	
                	StdDraw.show(1);
                	//damit das Feld nach der Falle wieder weiß wird
                	//Weissmacher(i,j,0,0);
                	//Weissmacher(k,l,0,0);
                	//Weissmacher(n,m,0,0);
                    StdDraw.setPenRadius(.06);
                    StdDraw.setPenColor(Color.WHITE);
                    StdDraw.filledSquare(i, j, 0.02);
                    StdDraw.filledSquare(k, l, 0.02);
                    StdDraw.filledSquare(n, m, 0.02);
                    
                	
                	//damit die Falle nicht aus dem Feld läuft
                	if(i<0.97 && j<0.97 && p_1==1){
                		i_neu=i+0.001;
                		j_neu=j+0.001;
                		i=i_neu;
                		j=j_neu;
                		
                		}
                	else if((i>0.03 || j>0.03) &&p_1==0) {                	
                		i_neu=i-0.001;
                		j_neu=j-0.001;
                		i=i_neu;
                		j=j_neu;
                		}
                	else {
                		if (p_1==1){
                			p_1=0;}
                		
                		else {
                			p_1=1;}
                			}
                	                	
                	Falle1(i,j);//Ende der ersten beweglichen Falle
                	
                	if(k<0.96 && l<0.97 && p_2==1){
                		k_neu=k+0.001;
                		l_neu=l+0.001;
                		k=k_neu;
                		l=l_neu;
                		
                		}
                	else if(k<0.97 && l<0.97 && p_2==2){
                			k_neu=k-0.001;
                			l_neu=l+0.001;
                			k=k_neu;
                			l=l_neu;
                		
                		}
                	else if(k>0.03 && l>0.03 &&p_2==3) {                	
                		k_neu=k-0.001;
                		l_neu=l-0.001;
                		k=k_neu;
                		l=l_neu;
                		}
                	else if(k>0.02 && l>0.03 &&p_2==0) {                	
                		k_neu=k+0.001;
                		l_neu=l-0.001;
                		k=k_neu;
                		l=l_neu;
                		}
                	else {
                		if (p_2==1){
                			p_2=2;}
                		
                		else if(p_2==2) {
                			p_2=3;}
                		else if (p_2==3){
                			p_2=0;}
                		else{
                			p_2=1;}
                		}
                			

                	Falle2(k,l); // Ende der zweiten beweglichen Falle

                	if(n<0.97 && m<0.97 && p_3==1){
                		n_neu=n+0.001;
                		m_neu=3*n_neu*n_neu-3*n_neu+1;
                		n=n_neu;
                		m=m_neu;
                		}
                	else if(n>0.03 && m>0.03 &&p_3==0) {                	
                		n_neu=n-0.001;
                		m_neu=3*n_neu*n_neu-3*n_neu+1;
                		n=n_neu;
                		m=m_neu;
                		}
                	
                	else {
                		if (p_3==1){
                			p_3=0;}
                		
                		else {
                			p_3=1;}
                			}
                	Falle3(n,m); //Ende der dritten beweglichen Falle
                	

                		
                	
                	zwischenwaende();
                	
                        //Ändere Stiftfarbe und Größe, um Spielfigur zu übermalen:
                		StdDraw.setPenRadius(.06);
                		StdDraw.setPenColor(Color.WHITE);


                        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) //Move Left
                        {
                        	
                        	 

                                //Neue Koordinaten:
                                x_neu = x-0.001;
                                y_neu=y;

                                //Prüfe ob neuer Punkt zulässig
                                if (x_neu>=0.95|| x_neu<=0.35 && x_neu>=0.25 && y_neu>=0.05 && y_neu<0.85 || x<= 0.8 && x_neu>=0.7 && y_neu<=0.95 && y_neu>=0.25 ||x_neu<=0.8 && x_neu>=0.45 && y_neu<=0.25 && y_neu>0.15 ) //Wand
                                {	x_neu=x;			}
                                else
                                {
                                //Übermale alte Figur
                                //Weissmacher(0,0,x,y);
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
                              //Prüfe ob neuer Punkt zulässig
                                if (x_neu>=0.95|| x_neu<=0.35 && x_neu>=0.25 && y_neu>=0.05 && y_neu<0.85 || x<= 0.8 && x_neu>=0.7 && y_neu<=0.95 && y_neu>=0.25 ||x_neu<=0.8 && x_neu>=0.45 && y_neu<=0.25 && y_neu>0.15 ) //Wand
                                { x_neu=x; 
                                } 
                                
                                else{
                              //Übermale alte Figur
                                //Weissmacher(0,0,x,y);
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
                              //Prüfe ob neuer Punkt zulässig
                                if (x_neu>=0.95|| x_neu<=0.35 && x_neu>=0.25 && y_neu>=0.05 && y_neu<0.85 || x<= 0.8 && x_neu>=0.7 && y_neu<=0.95 && y_neu>=0.25 ||x_neu<=0.8 && x_neu>=0.45 && y_neu<=0.25 && y_neu>0.15 ) //Wand
                                {	
                                	if(x_neu> 0.3 && x_neu< 0.4 &&y_neu<=0.05|| x_neu>0.7 && x_neu< 0.8){//Beim Start/Ziel nur nach oben erlauben
                                		//Weissmacher(0,0,x,y);
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
                                //Weissmacher(0,0,x,y);
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

                              //Prüfe ob neuer Punkt zulässig
                                if (x_neu>=0.95|| x_neu<=0.35 && x_neu>=0.25 && y_neu>=0.05 && y_neu<0.85 || x<= 0.8 && x_neu>=0.7 && y_neu<=0.95 && y_neu>=0.25 ||x_neu<=0.8 && x_neu>=0.45 && y_neu<=0.25 && y_neu>0.15 ) //Wand
                                {
                                        y_neu=y;
                                } else{
                              //Übermale alte Figur
                                //Weissmacher(0,0,x,y);
                                StdDraw.point(x, y);
                                x=x_neu;
                                y=y_neu;
                                player(x,y);
                                }
                        }
                        //Teste ob Gegner/Falle berührt
                        if ((x<=i+0.04 && x>=i-0.04 && y<=j+0.04 && y>=j-0.04)|| x<=k+0.04 && x>=k-0.04 && y<=l+0.04 && y>=l-0.04 || x<=n+0.04 && x>=n-0.04 && y<=m+0.04 && y>=m-0.04)
                        {
                     	   
                     	    
                        	//Tot -> Zurück ins Menü
                    	   	StdDraw.clear();
                            Menue.main(args);
                                break;
                                
                                

                        }
                      //Teste, ob eine statische Falle berührt
                        if ((0.55<=x && 0.65 >=x && 0.55<=y && 0.66 >=y)|| 0.10<=x && x<=0.2 && 0.45<=y && y<=0.55)
                        {
                     	   	//Tot -> Zurück ins Menü
                     	   	StdDraw.clear();
                             Menue.main(args);
                                 
                                break;
                                
                                

                        }
                        if (y>1)
                        {
                     	  Level3.main(args);
                     	  break;
                     	  
                     	   
                        }  
                }



        }

}
}
