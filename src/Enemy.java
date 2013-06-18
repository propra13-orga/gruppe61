import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class Enemy {

    static boolean shout = true;

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void use() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		// enemy is shouting
		class activate extends TimerTask 
		{
			@Override public void run()
			{
				shout=true;	
			}
		}
		
		if (shout == true){
			shout=false;
			
		if (Globals.damages>0)
		{
			Globals.damages--;
			
			// check damages
			setDamages();
		
			//enemy doesn't shout during 5 sec
			Timer timer = new Timer();
			timer.schedule(new activate(), 5000 );
		}
		}
			
	}
	
	
	public static void setDamages() throws IOException, InterruptedException
	{
	
		if ( Globals.life > 0 ){
			
			Globals.health = Globals.health - 50;
			
			if(Globals.health == 0){
				Globals.life--;
				Globals.health = 100;
				
				//Back to start
				Globals.x=Globals.startx;
				Globals.y=Globals.starty;
			}

		}
	
		if ( Globals.life <= 0 ){
			
			Globals.x=Globals.startx;
			Globals.y=Globals.starty;
			
    	   	StdDraw.clear();
    	   	Menue.main(null);
    	}
	
		
   }
	
	
}


