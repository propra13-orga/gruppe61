import java.util.Timer;
import java.util.TimerTask;

/**stops enemy
 * SToppt die Bewegung der Fallen für einige Zeit 
 * @author jan
 *
 */

public class Stop {
	
	/**
	 * Hierüber erfolgt der Aufruf aus dem Spiel heraus
	 * @param args
	 */
	public static void use() {
		// TODO Auto-generated method stub

		//class for waking up enemy
		/**
		 * Countdown zur reaktivierung der Bewegung der Fallen
		 *
		 */
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
