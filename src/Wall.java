import java.io.FileReader;
import java.io.IOException;


public class Wall {

	public static void checkp() throws IOException{
		

	    // Wie bei GetRoom nur diesmal zum überprüfen ob wir an einer Wand sind
	    FileReader fr = new FileReader("src/Raum" + Globals.room + ".txt");
	    int ch;
	    int j=0;
	    int k=0;
	    double x=Globals.xneu;
	    double y=Globals.yneu;
	    double s;
	    double t;
	   
	    while( j<21 ){
	    	k=0;
	    	while ((ch=fr.read()) != -1 &&k<22){
	    		
	    	
	    	
	    	if (ch==120){
	    		s=k*0.05;
	    		t=1-j*0.05;

	    		if(s-0.05< x && x< s+0.05 && t-0.05<y && t+0.05>y) {	// Wenn wir eine Wand erreichen dürfen wir in dieswe Richtung nicht weiter laufen.
	    			j=21;												// Weil sonst nur die 2 Schleife beendet wird
	    			break;	
	    		}
	    		
	    			    }
		
	    			k++;}
	    	
	    		j++;
	    		if (j==21){		//sollte keine Wand im Weg stehen speicher die neue Position, die später gezeichnet wird.
	    			Globals.x=Globals.xneu;
	    			Globals.y=Globals.yneu;
	    			
	    		}
	    		}
	fr.close();}

	public static void checkf(int i) throws IOException{
		

		// Wie bei GetRoom nur diesmal zum überprüfen ob wir an einer Wand sind
	    FileReader fr = new FileReader("src/Raum" + Globals.room + ".txt");
	    int ch;
	    int j=0;
	    int k=0;
	    double x=Globals.falleneu[0];
	    double y=Globals.falleneu[1];
	   
	    double s;
	    double t;
	   
	    while( j<21 ){
	    	k=0;
	    	while ((ch=fr.read()) != -1 &&k<22){
	    		
	    	
	    	
	    	if (ch==120){
	    		s=k*0.05;
	    		t=1-j*0.05;
	    		int r = (int) (Math.random()*8+1);
	    		if(s-0.05< x && x< s+0.05 && t-0.05<y && t+0.05>y || x>0.99 || x<0.01 || y<0.01 || y>0.99 ){	// Wenn wir eine Wand erreichen dann soll die Falle ihre Richtung ändern
	    			Globals.richtung[i]=r;
	    			j=21;
	    			break;	
	    		}
	    		
	    			    }
		
	    			k++;}
	    	
	    		j++;
	    		if (j==21){
	    			
	    			Globals.fallen[0+2*i]=Globals.falleneu[0];		// wenn die Falle in keiner Wand landet ändert sich die Richtung nicht und die neue Position wird gespeichert und später gezeichnet.
	    			Globals.fallen[1+2*i]=Globals.falleneu[1];
	    			
	    			
	    		}
	    		}
	fr.close();}

}

