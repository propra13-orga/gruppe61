import java.util.Timer;
import java.util.TimerTask;

//stops enemy
public class Stop {
	
	/**
	 * @param args
	 */
	public static void use() {
		// TODO Auto-generated method stub

		//class for waking up enemy
		class wakeup extends TimerTask 
		{
			@Override public void run()
			{
				Globals.enemy.move=true;	
			}
		}
		
		
		if (Globals.stop>0)
    	{
    		//stop enemy:
    		Globals.enemy.move=false;
    		Globals.stop--;
    		
    		//Wake up enemy in 3 seconds
    		Timer timer = new Timer();
    		timer.schedule(new wakeup(), 3000 );


    		
    	}
	}

}
