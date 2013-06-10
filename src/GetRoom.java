

import java.io.FileReader;
import java.io.IOException;


public class GetRoom {

	 public int[] arraylokal;
	  public void room(String[] args) throws IOException
	  {
		  int[] array = new int [11];

		  
	    
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(0.01);
	    String fileName="C:\\Users\\Nuck\\workspace\\TestRealm\\src\\Test";
	    FileReader fr = new FileReader(fileName);
	    int ch;
	    int j=0;
	    int k=0;
	    int n=0;
	    while( j<20 ){
	    	k=0;
	    	while ((ch=fr.read()) != -1 &&k<21){
	    		System.out.println(ch);
	    	
	    	
	    	if (ch==120)
	    		{StdDraw.filledSquare(0.05*k+0.025,1- 0.05*j+0.025, 0.026);
	    			    		}
	    	else if(ch==115){
	    		array[0]=k;
	    		array[1]=j;
	    		StdDraw.setPenColor(StdDraw.RED);
	    		StdDraw.text(0.05*k+0.025,1-0.05*j+0.025, "Start");
	    		StdDraw.setPenColor(StdDraw.BLACK);
	    			}
	    	else if(ch==122){
	    		array[2]=k;
	    		array[3]=j;
	    		StdDraw.setPenColor(StdDraw.RED);
	    		StdDraw.text(0.05*k+0.025,1- 0.05*j+0.025, "Ziel");
	    		StdDraw.setPenColor(StdDraw.BLACK);
	    		}
	    	else if(ch==101){
	    		array[4+n]=k;
	    		array[5+n]=j;
	    		
	    		
	    		n++;
	    		
	    		
	    	}
	    	k++;
	    	}
	    j++;}
	    
	    array[10]=n;
	    this.arraylokal = array;
	    
	  fr.close();
	  
	  }
}