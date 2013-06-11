import java.awt.event.KeyEvent;
import java.io.IOException;


public class Level11 {
	public static void main(String[] args) throws IOException{
		int r=1;
		String fileName;
		while (r<=3){
		GetRoom test = new GetRoom();
		if(r==1){
			 fileName="src/Raum1.txt";}
		else if(r==2)
		{
			 fileName="src/Raum2.txt";}
		else  {
			 fileName="src/Raum3.txt";}
		
		test.room(fileName);
		intplayer(test);
		intenemy(test);
		InformationBar.main(null);
		Globals.health=100;
     	Globals.life=3;
     	Globals.magician=0;
     	Globals.money=0;
     	

		Globals.x=test.arraylokal[0]*0.05;
		Globals.y=1-test.arraylokal[1]*0.05;

	

     	
     	
     	while (true)
        {
     	   		StdDraw.show(10);
     	   		
     	   		//Zeichne neu:
     	   		StdDraw.clear();
     	   		test.room(fileName);
     	   		intenemy(test);
     	   		player(Globals.x,Globals.y);
     	   		
                if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) //Move Left
                {	

                        //Neue Koordinaten:
                        Globals.xneu = Globals.x-0.005;
                        Globals.yneu=Globals.y;

                        Controller.check(fileName);
                        
                }
                else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) //Move right
                {

                      //Neue Koordinaten:
                        Globals.xneu = Globals.x+0.005;
                        Globals.yneu = Globals.y;
                        
                      //Prüfe ob neuer Punkt zulässig
                        Controller.check(fileName);
                        
                  
                }
                else if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) //Move up
                {
                      //Neue Koordinaten:
                		Globals.xneu = Globals.x;
                        Globals.yneu = Globals.y+0.005;
                        Controller.check(fileName);

                }
                else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) //Move Down
                {
                      //Neue Koordinaten:
                		Globals.xneu = Globals.x;
                        Globals.yneu = Globals.y-0.005;

                      //Prüfe ob neuer Punkt zulässig
                        Controller.check(fileName);
                }                           
                //Teste, ob Gegner/Falle berührt
                if ((0.55<=Globals.x && 0.65 >=Globals.x && 0.55<=Globals.y && 0.66 >=Globals.y)|| 0.10<=Globals.x && Globals.x<=0.2 && 0.45<=Globals.y && Globals.y<=0.55)
                {
             	  
             	   //Damages.setDamages();
             	   
             	 //Zurück zu letzten Checkpoint
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

	private static void intenemy(GetRoom array) {
		double x;
		double y;
		int n=array.arraylokal[10];
		int i=0;
		while (i<n){
			x=array.arraylokal[4+2*i];
			y=array.arraylokal[5+2*i];
			
			x=0.05*x;
			y=1-0.05*y;	
			
			Falle(x,y);
			i++;
				}
		}	

	private static void intplayer(GetRoom array) {
		double x;
		double y;
		x=array.arraylokal[0];
		y=array.arraylokal[1];
	
		x=0.05*x;
		y=1-0.05*y;	

		player(x,y);	

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
	private static void room(GetRoom test) throws IOException {
		 
	 String fileName="src/Test.txt";
		 test.room(fileName);
	}

}
