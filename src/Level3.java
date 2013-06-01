import java.awt.event.KeyEvent;

public class Level3 {

public static void main(String[] args) {
        {

        	StdDraw.clear();
               //Initialosiere Level
               Level1.room();

               //Startpunkt
               double x=0;
               double y=.15;
               
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
               Level2.Falle(i,j);
               Level2.Falle(k,l);
               Level2.Falle(n,m);
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
                 StdDraw.show(10);
                 
               //Zeichne neu:
     	   		StdDraw.clear();
     	   		Level1.room();
     	   		Level1.player(x,y);
     	   		Level2.Falle(i,j);
     	   		Level2.Falle(k,l);
     	   		Level2.Falle(n,m);
                                 
                 //damit die Falle nicht aus dem Feld läuft
                 if(i<0.97 && j<0.97 && p_1==1){
                 i_neu=i+0.005;
                 j_neu=j+0.005;
                 i=i_neu;
                 j=j_neu;
                
                 }
                 else if((i>0.03 || j>0.03) &&p_1==0) {
                 i_neu=i-0.005;
                 j_neu=j-0.005;
                 i=i_neu;
                 j=j_neu;
                 }
                 else {
                 if (p_1==1){
                 p_1=0;}
                
                 else {
                 p_1=1;}
                 }
                //Ende der ersten beweglichen Falle
                
                 if(k<0.96 && l<0.97 && p_2==1){
                 k_neu=k+0.005;
                 l_neu=l+0.005;
                 k=k_neu;
                 l=l_neu;
                
                 }
                 else if(k<0.97 && l<0.97 && p_2==2){
                 k_neu=k-0.005;
                 l_neu=l+0.005;
                 k=k_neu;
                 l=l_neu;
                
                 }
                 else if(k>0.03 && l>0.03 &&p_2==3) {
                 k_neu=k-0.005;
                 l_neu=l-0.005;
                 k=k_neu;
                 l=l_neu;
                 }
                 else if(k>0.02 && l>0.03 &&p_2==0) {
                 k_neu=k+0.005;
                 l_neu=l-0.005;
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
                // Ende der zweiten beweglichen Falle

                 if(n<0.97 && m<0.97 && p_3==1){
                 n_neu=n+0.01;
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
                 //Ende der dritten beweglichen Falle
              

                        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) //Move Left
                        {
                        
                        

                                //Neue Koordinaten:
                                x_neu = x-0.005;
                                y_neu=y;

                                //Prüfe ob neuer Punkt zulässig
                                if (x_neu <= 0.05 || y_neu>=0.05 && y_neu<= 0.85 && x_neu<=0.35 && x_neu>=0.25|| y_neu<=0.55 && y_neu>=0.45 && x_neu<=0.55 && x_neu>=0.25 || y_neu<=0.95 && y_neu>=0.15 && x_neu<=0.8 && x_neu>=0.7 ){
                                    
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
                                if (y_neu>=0.95|| x_neu<=0.05|| x_neu>=0.95 || y_neu<=0.55 && y_neu>=0.45 && x_neu>=0.25 &&x_neu<=0.55 || x_neu>=0.45 && x_neu<=0.7 && y_neu<=0.25 && y_neu>=0.15|| x_neu<=0.8 && x_neu>=0.7 && y_neu<=0.95 &&y_neu>= 0.15 ) //Wand
                                {
                                        y_neu=y;
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
                                if (y_neu<=0.05|| x_neu<=0.05 || x_neu>=0.95 || y_neu<=0.55 && y>=0.45 && x_neu>=0.25 &&x_neu<=0.55 || x_neu>=0.45 && x_neu<=0.7 && y_neu<=0.25 && y_neu>=0.15||x_neu<=0.35 && x_neu>=0.25 && y_neu <= 0.85 && y_neu>=0.05) //Wand
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
                      //Teste, ob eine statische Falle berührt
                        if ((0.55<=x && 0.65 >=x && 0.55<=y && 0.66 >=y)|| 0.10<=x && x<=0.2 && 0.45<=y && y<=0.55)
                        {
                        	Globals.life--;
                     	   if (Globals.life<=0)
                     	   {
                     		   //Tot -> Zurück ins Menü
                     	   	StdDraw.clear();
                             Start.main(args);
                                 
                                break;
                     	   }
                     	   //Zurück zu letzten Checkpoint
                     	   x=0.01;
                     	   y=.15;  
                                

                        }
                        //Teste, ob im Ziel
                        if (x>1)
                        {
                        	Durchgezockt.main(args);
                        	break;
                     
                     
                        }
                }



        }

}
}