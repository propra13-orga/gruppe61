import java.util.Timer;
import java.util.TimerTask;


public class Protection {

	/**
	 * @param args
	 */
	public static void on() {
		// TODO Auto-generated method stub

		Globals.ruestung=true;
		
		//class for ending protection
		class end extends TimerTask 
		{
			@Override public void run()
			{
				//stop painting explosion
				Globals.ruestung=false;	
			}
		}
		
		//Protection holds 10 seconds
		Timer timer = new Timer();
		timer.schedule(new end(), 10000 );
		}
	

}
