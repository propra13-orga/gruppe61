import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class Bomb {
	
	static boolean death=false;
	
	//Read actual position
		final static double x=Globals.x;
		final static double y=Globals.y;

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		
			
		
		if (Globals.weapon>0)
		{
			Globals.weapon--;
		
	
		//Paint bomb
		Globals.draw.bomb=true;
		
		//class for explosion
				class explode extends TimerTask 
				{
					@Override public void run()
					{
						//stop painting the bomb
						Globals.draw.bomb=false;
						
						//paint explosion
						Globals.draw.explosion=true;
						
						//checking potential damages
						//checking player:
						if (Math.abs(x-Globals.player.x)<=0.1 && Math.abs(y-Globals.player.y)<=0.1);
						{
							//Death
							if (Globals.life>0)
							{
								//Losing one life:
								Globals.life--;
								
								//Back to start position
								Globals.x=Globals.startx;
								Globals.y=Globals.starty;
							}
							else //No more lifes 
							{
								death=true;
							}
						}
					}
				}
				
				//class for ending explosion
				class end extends TimerTask 
				{
					@Override public void run()
					{
						//stop painting explosion
						Globals.draw.explosion=false;	
					}
				}
		
			
				//wait 4 seconds until explosion
				Timer timer = new Timer();
	    		timer.schedule(new explode(), 4000 );
	    		if (death)
	    		{
	    			//Back to menu
	    			Menue.main(null);
	    		}
	    		
	    		//display explosion for 1 second
	    		timer.schedule(new end(), 100 );
	    		
	    		
	}

	}
	
}
