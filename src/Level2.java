import java.awt.event.KeyEvent;

public class Level2 {
	 static void room()
     {
             //StdDraw.setCanvasSize(512,512);

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


public static void main(String[] args) {
        {

        	StdDraw.clear();
               //Initialosiere Level
               room();

               //Startpunkt
               double x=0.35;
               double y=.051;
               
               //Initialisiere Spielfigur am Startpunkt
               Level1.player(x,y);
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


                while (x>=0.001 && x<=1 )
                 
                {	//Buffering:
                	StdDraw.show(10);
                	
                	//Neu zeichnen:
                	StdDraw.clear();
                	room();
                	Level1.player(x,y);
                	
                	//damit die Falle nicht aus dem Feld läuft
                	if(i<0.97 && j<0.97 && p_1==1){
                		i_neu=i+0.01;
                		j_neu=j+0.01;
                		i=i_neu;
                		j=j_neu;
                		
                		}
                	else if((i>0.03 || j>0.03) &&p_1==0) {                	
                		i_neu=i-0.01;
                		j_neu=j-0.01;
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
                		k_neu=k+0.01;
                		l_neu=l+0.01;
                		k=k_neu;
                		l=l_neu;
                		
                		}
                	else if(k<0.97 && l<0.97 && p_2==2){
                			k_neu=k-0.01;
                			l_neu=l+0.01;
                			k=k_neu;
                			l=l_neu;
                		
                		}
                	else if(k>0.03 && l>0.03 &&p_2==3) {                	
                		k_neu=k-0.01;
                		l_neu=l-0.01;
                		k=k_neu;
                		l=l_neu;
                		}
                	else if(k>0.02 && l>0.03 &&p_2==0) {                	
                		k_neu=k+0.01;
                		l_neu=l-0.01;
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
                		n_neu=n+0.01;
                		m_neu=3*n_neu*n_neu-3*n_neu+1;
                		n=n_neu;
                		m=m_neu;
                		}
                	else if(n>0.03 && m>0.03 &&p_3==0) {                	
                		n_neu=n-0.01;
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
                	


                        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) //Move Left
                        {
                        	
                        	 

                                //Neue Koordinaten:
                                x_neu = x-0.005;
                                y_neu=y;

                                //Prüfe ob neuer Punkt zulässig
                                if (x_neu <= 0.05 || y_neu>=0.95){ //Wand
                                	x_neu=x;			}
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
                                if (x_neu >= 0.95|| y_neu>=0.95) //Wand
                                { x_neu=x; 
                                } 
                                
                                else{
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
                                if (y_neu>=0.95) //Wand
                                {	
                                	if(x_neu> 0.3 && x_neu< 0.4 &&y_neu<=0.05|| x_neu>0.7 && x_neu< 0.8)
                                	{//Beim Start/Ziel nur nach oben erlauben
                                		
                                        x=x_neu;
                                        y=y_neu;
                                	
                                	}
                                	
                                else{
                                        y_neu=y;}//Wenn wir nicht beim Start sind
                                } 
                                else{
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
                                if (y_neu<=0.05||y_neu>=0.95) //Wand
                                {
                                        y_neu=y;
                                } else{
                                x=x_neu;
                                y=y_neu;
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
                        if (y>1)
                        {
                     	  Level3.main(args);
                     	  break;
                     	  
                     	   
                        }
                       
                }



        }

}
}
