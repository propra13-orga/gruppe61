import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Netzwerk {

	/**Diese Methode soll das Netzwerk starten. Dazu wird zuerst in einem Thread der Server gestartet und dann in jeweils einem eigenen Thread die beiden Clients, die sich an den Server anmelden.
	 * Bisher noch mit eigener Main Klasse. Dies ist nur zu Testzwecken. Später soll daraus ein <code> execute() <\code> o.ä. werden.
	 * @param args
	 */
	public static void execute() {
		// TODO Auto-generated method stub

		//Um den Server in eigenem Thread zu starten
		class startServer implements Runnable {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Server.go();
			}

		}

		//Um Client1 in eigenem Thread zu starten
		class startClient1 implements Runnable {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Client1.go();
				} catch (InterruptedException | UnsupportedAudioFileException
						| LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		
		//Um Client2 in eigenem Thread zu starten
		class startClient2 implements Runnable {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Client2.go();
				} catch (InterruptedException | UnsupportedAudioFileException
						| LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		
		//Starte Server und beide Clients 
		Thread t1 = new Thread(new startServer());
		Thread t2 = new Thread(new startClient1());
		//Thread t3 = new Thread(new startClient2());

		t1.start();
		t2.start();
		//t3.start();

	}

}
