import java.io.FileReader;
import java.io.IOException;


public class GetRoom {

	 public int[] arraylokal;
	  public void room(String[] args) throws IOException
	  {
		  int[] array = new int [11];

		  
	    
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(0.01);
	    String fileName="C:/Users/Nuck/workspace/gruppe61/src/Raum1";
	    FileReader fr = new FileReader(fileName);
	    int ch;
	    int j=0;
	    int k=0;
	    int n=0;
	    while( j<21 ){
	    	k=0;
	    	while ((ch=fr.read()) != -1 &&k<22){//lese jede Ziffer einzelt aus und speicher in Variable ch
	    		
	    	
	    	
	    	if (ch==120){//Erstelle einen Raum durch Textdatei

	    		StdDraw.filledSquare(0.05*k,1- 0.05*j, 0.026);
	    			    		}
	    	else if(ch==115){
	    		array[0]=k;//Speicher Startkoordinaten (Spieler Start)
	    		array[1]=j;

	    		StdDraw.setPenColor(StdDraw.RED);//schreibe Start
	    		StdDraw.text(0.05*k,1-0.05*j, "Start");
	    		StdDraw.setPenColor(StdDraw.BLACK);
	    			}
	    	else if(ch==122){
	    		array[2]=k;//Speicher Zielkoordinaten
	    		array[3]=j;
	    		StdDraw.setPenColor(StdDraw.RED);//schreibe Ziel
	    		StdDraw.text(0.05*k,1- 0.05*j, "Ziel");
	    		StdDraw.setPenColor(StdDraw.BLACK);
	    		}
	    	else if(ch==101){//Speichert die Koordinaten von den Gegnern

	    		array[4+2*n]=k;
	    		array[5+2*n]=j;
	    			
	    		n++;
	    	}
	    	k++;
	    	}
	    j++;}
	    
	    array[10]=n;
	    this.arraylokal = array;
	    fr.close();}
}