import java.awt.Component;
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
import javax.swing.JOptionPane;

/**
 * Dieses Untermen� stellt den Spieler zwischen die Wahl, ob er alleine oder zu
 * zweit im Netzwerk spielen m�chte
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
		clip.loop(1000);

		double x = 0.15;

		while (true) {
			StdDraw.show(0);
			StdDraw.clear();

			// Drei Optionen m�glich:
			height = Math.abs(height % 3);

			// Zeichne Men�:
			StdDraw.square(.5, .5, .5);
			StdDraw.line(0, .33, 1, .33);
			StdDraw.line(0, .66, 1, 0.66);
			StdDraw.text(0.5, 0.8, "Ich spiel lieber alleine");
			StdDraw.text(0.5, 0.48, "Ich hab Freunde");
			if(Speicher.xneu!=0){
			StdDraw.text(0.5, 0.15, "Ich will meinen letzten Spielstand laden.");
			}
			else{
				StdDraw.text(0.5, 0.15, "Hab mich verklickt, will zur�ck");
			}

			// Zeichnet Pfeil, der Auswahl anzeigt
			StdDraw.picture(x, y(height), "pfeil_rechts.png", 0.05, 0.05);

			// �nderung der Auswahl:
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

			// Best�tigen
			if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER))
				if (height == 1) // Start gedr�ckt
				{
					
					Object[] options = {"Ja",
                    "Nein"};
					Component frame = null;
					int n = JOptionPane.showOptionDialog(frame,
					    "Willst du neue Level/Raum bauen?",
					    null,
					    JOptionPane.YES_NO_OPTION,
					    JOptionPane.QUESTION_MESSAGE,
					    null,     //do not use a custom Icon
					    options,  //the titles of buttons
					    options[0]); //default button title
					if (n == JOptionPane.YES_OPTION)
					{ MenuEditor editor = new MenuEditor();
					  editor.main();
					  Thread.sleep(200);
					  
					}
					if (n == JOptionPane.NO_OPTION) 
					{
					// Initialize variables with their defaults:
					Initialize.game();
					Thread.sleep(100);
					// Stop the music
					clip.stop();
					// Start game
					Game.start(1);

					break;
					//}
				} else if (height == 2) // Netzwerk gew�hlt
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
				} else if (Speicher.xneu!=0) // Zur�ck gew�hlt
				{
					// Stop the music
					clip.stop();
					//Lade altes Spiel
					Speicher.load();
					Thread.sleep(200);
					Game.start(2);
					
					break;
				}
				else{
					clip.stop();
					Thread.sleep(100);
					Menue.execute();
					
					break;
				}

		}
	}
}
}
