import java.io.FileReader;
import java.io.IOException;


public class Wall {

	public static void checkp() throws IOException{
		

	    //String fileName="C:/Users/Nuck/workspace/TestRealm/src/Test.txt";
	    FileReader fr = new FileReader(Globals.fileName);
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

	public static void checkf(int i) throws IOException{
		

	    //String fileName="C:/Users/Nuck/workspace/TestRealm/src/Test.txt";
	    FileReader fr = new FileReader(Globals.fileName);
	    int ch;
	    int j=0;
	    int k=0;
	    double x=Globals.falleneu[0];
	    double y=Globals.falleneu[1];
	   
	    double s;
	    double t;
	   
	    while( j<21 ){
	    	k=0;
	    	while ((ch=fr.read()) != -1 &&k<22){//lese jede Ziffer einzelt aus und speicher in Variable ch
	    		
	    	
	    	
	    	if (ch==120){//Erstelle einen Raum durch Textdatei
	    		s=k*0.05;
	    		t=1-j*0.05;

	    		if(s-0.05< x && x< s+0.05 && t-0.05<y && t+0.05>y  ){
	    			if(Globals.richtung[i]==1){
	    				Globals.richtung[i]=2;
	    			}
	    			else if(Globals.richtung[i]==2){
	    				Globals.richtung[i]=3;
	    			}
	    			else if(Globals.richtung[i]==3){
	    				Globals.richtung[i]=4;
	    			}
	    			else{Globals.richtung[i]=1;}
	    			j=21;
	    			break;	
	    		}
	    		
	    			    }
		
	    			k++;}
	    	
	    		j++;
	    		if (j==21){
	    			
	    			Globals.arraylokal[0+2*i]=Globals.falleneu[0];
	    			Globals.arraylokal[1+2*i]=Globals.falleneu[1];
	    			
	    			
	    		}
	    		}
	fr.close();}

}

