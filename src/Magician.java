import java.util.Timer;
import java.util.TimerTask;

/**
 * L�st den Zauber aus
 * Der Zauber erm�glicht es dem Spieler f�r einige Sekunden durch W�nde zu laufen. Dazu wird die Kollisionsabfrage der W�nde deaktiviert
 *
 */
public class Magician {
	//Deactivates walls for player

	/**
	 * Hier�ber geschieht der Aufruf aus dem Spiel
	 * @param args
	 */
	public static void use() {
		// TODO Auto-generated method stub

		//class for reactivating walls
		/**
		 * Countdown zur Reaktivierung der W�nde
		 * Nach Ablauf des Countdowns wird die Kollisionsabfrage der W�nde reaktiviert
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
