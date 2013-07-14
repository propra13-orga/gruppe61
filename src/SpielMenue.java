import java.awt.event.KeyEvent;
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
 * Dieses Untermenü stellt den Spieler zwischen die Wahl, ob er alleine oder zu
 * zweit im Netzwerk spielen möchte
 * 
 * @author jan
 * 
 */
public class SpielMenue {

	private static double y(int height) {
		if (height % 3 == 1)
			return 0.8;
		else if (height % 3 == 2)
			return 0.48;
		else
			return .15;
	}

	static int height = 2;

	/**
	 * Startet das Programm
	 * 
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws UnsupportedAudioFileException
	 * @throws LineUnavailableException
	 */
	public static void execute() throws IOException, InterruptedException,
			UnsupportedAudioFileException, LineUnavailableException {
		// TODO Auto-generated method stub

		StdDraw.clear();
		StdDraw.setPenRadius(.01);
		StdDraw.setPenColor();

		File file = new File("src/Menusound.wav");
		AudioInputStream stream = AudioSystem.getAudioInputStream(file);
		AudioFormat format = stream.getFormat();

		// specify what kind of line we want to create
		DataLine.Info info = new DataLine.Info(Clip.class, format);
		// create the line
		Clip clip = (Clip) AudioSystem.getLine(info);
		// load the samples from the stream
		clip.open(stream);
		// begin playback of the sound clip
		clip.start();

		double x = 0.15;

		while (true) {
			StdDraw.show(0);
			StdDraw.clear();

			// Drei Optionen möglich:
			height = Math.abs(height % 3);

			// Zeichne Menü:
			StdDraw.square(.5, .5, .5);
			StdDraw.line(0, .33, 1, .33);
			StdDraw.line(0, .66, 1, 0.66);
			StdDraw.text(0.5, 0.8, "Ich spiel lieber alleine");
			StdDraw.text(0.5, 0.48, "Ich hab Freunde");
			StdDraw.text(0.5, 0.15, "Hab mich verklickt, will zurück");

			// Zeichnet Pfeil, der Auswahl anzeigt
			StdDraw.picture(x, y(height), "pfeil_rechts.png", 0.05, 0.05);

			// Änderung der Auswahl:
			if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
				if (height == 1) {
				} else if (height == 0)
					height = height + 2;
				else {
					height--;
				}

			} else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
				if (height == 0) {
				} else {
					height++;
				}
			}
			Thread.sleep(100);

			// Bestätigen
			if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER))
				if (height == 1) // Start gedrückt
				{
					// Initialize variables with their defaults:
					Initialize.game();
					// Stop the music
					clip.stop();
					// Start game
					Game.start();

					break;
				} else if (height == 2) // Netzwerk gewählt
				{
					// Netzwerk in eigenem Thread starten
					class startNetzwerk implements Runnable {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							Netzwerk.execute();
						}

					}

					Thread t = new Thread(new startNetzwerk());
					t.start();

					// WaitForConnection.execute();

					break;
				} else // Zurück gewählt
				{
					Menue.execute();
					break;
				}

		}
	}
}
