import java.util.Timer;
import java.util.TimerTask;


public class Magician {
	//Deactivates walls for player

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//class for reactivating walls
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
