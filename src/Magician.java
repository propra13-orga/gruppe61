import java.util.Timer;
import java.util.TimerTask;

/**
 * Löst den Zauber aus
 * Der Zauber ermöglicht es dem Spieler für einige Sekunden durch Wände zu laufen. Dazu wird die Kollisionsabfrage der Wände deaktiviert
 *
 */
public class Magician {
	//Deactivates walls for player

	/**
	 * Hierüber geschieht der Aufruf aus dem Spiel
	 * @param args
	 */
	public static void use() {
		// TODO Auto-generated method stub

		//class for reactivating walls
		/**
		 * Countdown zur Reaktivierung der Wände
		 * Nach Ablauf des Countdowns wird die Kollisionsabfrage der Wände reaktiviert
		 *
		 */
				class activate extends TimerTask 
				{
					@Override public void run()
					{
						Globals.wall=true;	
					}
				}
				
				if (Globals.magician>0)
				{
					Globals.magician--;
					//Deactivate walls for player
					Globals.wall=false;
				
					//Reactivate walls in 5 seconds
					Timer timer = new Timer();
					timer.schedule(new activate(), 5000 );
				}
	}

}
