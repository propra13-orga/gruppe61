import java.awt.event.KeyEvent;
import java.io.IOException;


public class Level11 {
	public static void main(String[] args) throws IOException{
		int r=1;
		
		while (r<=3){
		
		if(r==1){
			 Globals.fileName="C:/Users/Nuck/workspace/gruppe61/src/Raum1.txt";}
		else if(r==2)
		{
			 Globals.fileName="C:/Users/Nuck/workspace/gruppe61/src/Raum2";}
		else  {
			 Globals.fileName="C:/Users/Nuck/workspace/gruppe61/src/Raum3";}
		
		GetRoom.room();
		intplayer();

		intenemy();
		InformationBar.main(null);
		Globals.health=100;
     	Globals.life=3;
     	Globals.magician=0;
     	Globals.money=0;
     	

		Globals.x=Globals.startx;
		Globals.y=Globals.starty;

	

     	
     	
     	while (true)
        {
     	   		StdDraw.show(10);
     	   		
     	   		//Zeichne neu:
     	   		StdDraw.clear();
     	   		
     	   		GetRoom.room();
     	   		int i=0;
     	   		while (i<Globals.anzahlfallen){
     				
     	   		Controller.Falle(i);
     	   		i++;
     	   		}
     	   		intenemy();
     	   		
     	   		player(Globals.x,Globals.y);
     	   		
                if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) //Move Left
                {	

                        //Neue Koordinaten:
                		Controller.playerleft();
                		
                		//Pr�fe ob der neuer Punkt zul�ssig
                        Wall.checkp();
                        
                }
                else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) //Move right
                {

                      //Neue Koordinaten:
                		Controller.playerright();
                	
                      //Pr�fe ob neuer Punkt zul�ssig
                        Wall.checkp();
                        
                  
                }
                else if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) //Move up
                {
                      	//Neue Koordinaten:
                		  Controller.playerup();
                		
                		//Pr�fe ob neuer Punkt zul�ssig
                          Wall.checkp();

                }
                else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) //Move Down
                {
                      //Neue Koordinaten:
                		Controller.playerdown();

                      //Pr�fe ob neuer Punkt zul�ssig
                        Wall.checkp();
                }                           
                //Teste, ob Gegner/Falle ber�hrt
                if ((0.55<=Globals.x && 0.65 >=Globals.x && 0.55<=Globals.y && 0.66 >=Globals.y)|| 0.10<=Globals.x && Globals.x<=0.2 && 0.45<=Globals.y && Globals.y<=0.55)
                {
             	  
             	   //Damages.setDamages();
             	   
             	 //Zur�ck zu letzten Checkpoint
             	  // x=0.01;
             	  // y=.15;
             			   
                        

                }
                //Teste, ob im Ziel:
                if (Globals.x>=1)
                {
             	   //Level2.main(args);
             	   break;
             
                }
        
        }
		r++;}
	}

	private static void intenemy() {
		
		int n=Globals.anzahlfallen;
		int i=0;
		while (i<n){


			Falle(Globals.arraylokal[0+2*i],Globals.arraylokal[1+2*i]);
			i++;
				}
		}	

	private static void intplayer() {


		player(Globals.startx,Globals.starty);	

		}

	static void player(double x,double y)
    {

        //Initialisiere Spielfigur als Punkt an der Koordinate (x,y):
		// StdDraw.setPenColor(StdDraw.BLUE);
		//StdDraw.setPenRadius(0.05);
		//StdDraw.point(x, y);
    	//Zeichne Spieler als Pi an Koordinate (x,y):
            StdDraw.picture(x, y,"pi.png",.05,.05);



    }
	   static void Falle(double i,double j){
           //bewegene Gegner/Falle
           StdDraw.setPenColor(StdDraw.YELLOW);
           StdDraw.filledSquare(i, j, 0.01);
           StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.square(i, j,0.01);


}
	

}
