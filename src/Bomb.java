import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Diese Klasse ist für den Abwurf und die Zündung der Bomben da
 * Zuerst wird die aktuelle Position des Spielers gelsen, um dort die Bombe zu platzieren. Dann wird sie dort gezeichnet und ein Countdown gestartet.
 * Danach erfolgt die Explosion. Schaden nehmen können durch die Explosion nur Spieler und Endgegner, die Fallen sind davon unberührt.
 */
public class Bomb {
	
	static boolean death=false;
	
	//Read actual position
	static double x;
	static double y;

	/**
	 * 
	 * Diese Klasse wird aufgerufen, um den Vorgang zu starten
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 * @throws LineUnavailableException 
	 * @throws UnsupportedAudioFileException 
	 *
	 * 
	 */
	public static void use() throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException {
		// TODO Auto-generated method stub

		//final double x=Globals.x;
		//final double y=Globals.y;
		x=Globals.x;
		y=Globals.y;
		
		if (Globals.weapon>0)
		{
			Globals.weapon--;
		
	
		//Paint bomb
		Globals.draw.bomb=true;
		
		//class for explosion
		/**
		 * Diese Klasse simuliert den Countdown bis die Bombe explodiert.
		 */
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
						if (Math.abs(x-Globals.x)<=0.1 && Math.abs(y-Globals.y)<=0.1)
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
						//checking boss
						if (Globals.quest.ready && Globals.boss!=null && Math.abs(x-Globals.boss[0])<=0.1 && Math.abs(y-Globals.boss[1])<=0.1){
							Globals.boss=null;
						}
					}
					
				}
				
				//class for ending explosion
				/**
				 * Diese Klasse beendet die Zeichnung der Explosion nach wenigen Sekunden. Auch dies geschieht5 implizit durch einen Countdown
				 */
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
	    			Menue.execute();
	    		}
	    		
	    		//display explosion for 1 second
	    		timer.schedule(new end(), 100 );
	    		
	    		
		}

	
	}
	
}
