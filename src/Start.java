import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Start {

	/**
	 * Start des Spiels Diese Klasse startet das Spiel, dazu wird zuerst das
	 * Menü aufgerufen. Alle weiteren Funktionsaufrufe geschehen aus dem Spiel
	 * heraus
	 * 
	 * @param args
	 *            Keine Eingabe nötig. Es wird keine Eingabe verarbeitet
	 * @throws LineUnavailableException
	 *             Muss sein (wegen Musik)
	 * @throws UnsupportedAudioFileException
	 *             Muss sein (wegen Musik)
	 * @throws InterruptedException
	 *             Muss sein (wegen Start/Stopp (bspw. Bewgegung der Fallen
	 *             stoppen))
	 * @throws IOException
	 *             Muss sein (wegen Netzwerk)
	 */
	public static void main(String[] args) throws IOException,
			InterruptedException, UnsupportedAudioFileException,
			LineUnavailableException {
		// TODO Auto-generated method stub

		Menue.execute();
	}

}
