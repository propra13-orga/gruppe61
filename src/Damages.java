import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * setzt den Schaden
 * 
 *
 */
public class Damages {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub



	}
		
		
	public static void setDamages() throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException{
		
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
