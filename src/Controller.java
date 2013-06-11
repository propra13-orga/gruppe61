import java.io.FileReader;
import java.io.IOException;


public class Controller {

	public static void check(String fileName) throws IOException{
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(0.01);
	    //String fileName="C:/Users/Nuck/workspace/TestRealm/src/Test.txt";
	    FileReader fr = new FileReader(fileName);
	    int ch;
	    int j=0;
	    int k=0;
	    double x=Globals.xneu;
	    double y=Globals.yneu;
	    double s;
	    double t;
	   
	    while( j<21 ){
	    	k=0;
	    	while ((ch=fr.read()) != -1 &&k<22){//lese jede Ziffer einzelt aus und speicher in Variable ch
	    		
	    	
	    	
	    	if (ch==120){//Erstelle einen Raum durch Textdatei
	    		s=k*0.05;
	    		t=1-j*0.05;

	    		if(s-0.05< x && x< s+0.05 && t-0.05<y && t+0.05>y  ){
	    			j=21;
	    			break;	
	    		}
	    		
	    			    }
		
	    			k++;}
	    	
	    		j++;
	    		if (j==21){
	    			Globals.x=Globals.xneu;
	    			Globals.y=Globals.yneu;
	    			
	    		}
	    		}
	fr.close();}	

}
