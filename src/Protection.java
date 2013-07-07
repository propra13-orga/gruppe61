import java.util.Timer;
import java.util.TimerTask;

/**
 * R�stung
 * Falls Spieler R�stung tr�gt, reduziert sich der Schaden, den er durch die Fallen nimmt
 *
 */
public class Protection {

	/**
	 * Hier�ber erfolgt der Aufruf aus dem Spiel heraus
	 * @param args
	 */
	public static void on() {
		// TODO Auto-generated method stub

		Globals.ruestung=true;
		
		//class for ending protection
		/**
		 * Countdown bis die R�stung ihre Funktion verliert
		 * 
		 *
		 */
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
