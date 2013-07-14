
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Feind
 *
 */
public class Enemy {

    static boolean shout = true;

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 * @throws LineUnavailableException 
	 * @throws UnsupportedAudioFileException 
	 */
	public static void use() throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException {
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
	
	
	public static void setDamages() throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException
	{
		
	
		int damage;
		if(Globals.ruestung) damage=20;
		else damage=50;
		
		if ( Globals.life > 0 ){
			
			Globals.health = Math.max(Globals.health - damage, 0);
			
			if(Globals.health == 0){
				Globals.life--;
				Globals.health = 100;
			}
			

		}
		
		if ( Globals.life <= 0 ){
			
			
    	   	StdDraw.clear();
    	   	Menue.execute();

		
	}
	
		
   }
	
	
}


