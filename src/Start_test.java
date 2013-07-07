import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * STartet das Testlevel
 * Dafür werden nur Grundwerte initialisiert und in den Globals gespeichert, anschließend das Testlevel aufgerufen
 * @author jan
 *
 */
public class Start_test {

	/**
	 * 
	 * @param args
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @throws LineUnavailableException 
	 * @throws UnsupportedAudioFileException 
	 */
	public static void main(String[] args) throws InterruptedException, IOException, UnsupportedAudioFileException, LineUnavailableException {
		// TODO Auto-generated method stub

		Initialize.game();
		Test.main(null);
	}

}
