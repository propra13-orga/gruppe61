
import java.io.FileReader;
import java.io.IOException;


public class GetRoom {

	 
	  public static void room(int i) throws IOException
	  {
		  double[] fallen = new double [11];
		  int[] richtung= new int [5];
		  double[] boss= new double [10];
	    
		  
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(0.01);
	    FileReader fr = new FileReader("src/Raum" + Globals.level + "-" + Globals.room + ".txt");
		int ch;		
	    int j=0;
	    int k=0;
	    int n=0;
	    int m=0;
	    Globals.shop.draw=false; // Nur damit nicht ständig ein shop vorhanden ist.
	    while( j<21 ){
	    	k=0;
	    	while ((ch=fr.read()) != -1 &&k<22){//lese jede Ziffer einzelt aus und speicher in Variable ch
	    		
	    	
	    	
	    	if (ch==120){//Erstelle Hier eine Wand weil char(ch)=x 

	    		StdDraw.filledSquare(0.05*k,1- 0.05*j, 0.026);
	    			    		}
	    	else if(ch==115){	//Erstelle Start char(115)=s
	    		Globals.startx=k*0.05;//Speicher Startkoordinaten (Spieler Start)
	    		Globals.starty=1-j*0.05;


	    		StdDraw.setPenColor(StdDraw.RED);//schreibe Start
	    		StdDraw.text(0.05*k,1-0.05*j, "Start");
	    		StdDraw.setPenColor(StdDraw.BLACK);
	    			}
	    	else if(ch==122){
	    		Globals.zielx=k*0.05;//Speicher Zielkoordinaten
	    		Globals.ziely=1-j*0.05;
	    		
	    		StdDraw.setPenColor(StdDraw.RED);//schreibe Ziel
	    		StdDraw.text(0.05*k,1- 0.05*j, "Ziel");
	    		StdDraw.setPenColor(StdDraw.BLACK);
	    		}
	    	else if(ch==101 && i!=1){		//Damit das Array nicht ständig überschrieben wird nur beim ersten Mal die Koordinaten speichern
	    		richtung[n]=1;	//Richtung in die sich die Falle bewegt (ändert sich in Wall)
	    		fallen[0+2*n]=k*0.05;	//Speichert die Koordinaten von den Gegnern
	    		fallen[1+2*n]=1-j*0.05;	
	    		n++;
	    		Globals.anzahlfallen=n;		
	    	    Globals.fallen = fallen;	//Speicher Koordinaten Fallen
	    	    Globals.richtung=richtung;	// Speicher Richtung
	    		}
	    	else if(ch==83 ){	//Damit nicht ständig überschrieben wird nur beim ersten Mal die Koordinaten speichern
	    		Globals.shop.x=k*0.05;	//Koordinaten für den Shop
	    		Globals.shop.y=1-j*0.05;
	    		Globals.shop.draw=true;
	    		}
	    	else if(ch==66 && i!=1){		//Damit das Array nicht ständig überschrieben wird nur beim ersten Mal die Koordinaten speichern
	    		boss[0+2*m]=k*0.05;
	    		boss[1+2*m]=1-j*0.05;
	    		m++;
	    		Globals.anzahlboss=m;		
	    		Globals.boss=boss;			//Speicher Koordinanten Boss
	    		}
	    	else if (ch==80 && i==0) //Keycode 80=p ->package
	    	{
	    		Globals.packet.x=k*0.05;
	    		Globals.packet.y=1-j*0.05;
	    		Globals.packet.draw=true;
	    	}
	    	k++;
	    	}
	    j++;
	    }
	    
	    

	    fr.close();
	    
	  
	    
	    }


}