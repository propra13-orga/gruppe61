// Server.java

// import java.net.ServerSocket;
// import java.net.Socket;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server. Derzeitige Arbeit: Akzeptiere zwei Clients und empfange deren Pings
 * und sende Pongs zurück. Es wird in der Konsole ausgedruckt, von wem der
 * Server das Ping empfangen hat
 * 
 * Geplant: Server soll Bewegungsanweisungen ("down", "right", etc) vom Client
 * empfangen und daraufhin die neuen Koordinaten berechnen. Diese sollen an die
 * Clients gesendet werden, damit diese damit den Raum zeichnen können
 * 
 * @author jan
 * 
 */
public class Server {

	// Initialize Variabbles
	private static double[] player1 = { 0.2, .6 };
	private static double[] player2 = { 0.6, 0.3 };
	private static boolean openDoor = false; // ist Tür schon offen?
	private static boolean schalter1 = false; // ist Schalter1 aktiv?
	private static boolean schalter2 = false; // ist Schalter2 aktiv?
	private static double[] Schalter1 = { .1, 0.3 }; // Koordinaten des ersten
														// Schalters (dieselben
														// wie im NetzwerkRaum)
	private static double[] Schalter2 = { .9, 0.8, }; // Koordinaten des zweiten
														// Schalters (dieselben
														// wie im NetzwerkRaum)

	/**
	 * Steuert die Bewegung der beiden Spieler. Es wird die Bewegungsrichtung
	 * ausgelesen und entsprechend die neue position der Spieler berechnet.
	 * 
	 * @param direction
	 *            die Richtung, in die Spieler bewegt werden soll
	 * @param player
	 *            Angabe, welcher Spieler bewegt werden soll. Erster oder
	 *            zweiter
	 */
	private static void move(String direction, int player) {
		double stepsize = 0.0015; // Schrittweite

		double x;
		double y;

		// Lese ursprüngliche Koordinaten aus.
		if (player == 1) {
			x = player1[0];
			y = player1[1];
		} else {
			x = player2[0];
			y = player2[1];
		}

		// Berechne neue Koordinaten von Spieler1 (inklusive Validätsprüfung)
		if (direction.equals("up")) {
			y = Math.min(y + stepsize, .98);
		} else if (direction.equals("down")) {
			y = Math.max(y - stepsize, 0.03);
		} else if (direction.equals("right")) {
			x = Math.min(x + stepsize, .98);
		} else if (direction.equals("left")) {
			x = Math.max(x - stepsize, 0.03);
		}

		// Überschreibe alte Koordinaten durch neue:
		if (player == 1) {
			player1[0] = x;
			player1[1] = y;
		} else {
			player2[0] = x;
			player2[1] = y;
		}

	}

	/**
	 * Aktiviert bzw deaktiviert die Schalter
	 */
	private static void checkSchalter() {

		double tol = 0.08; // Toleranz bei Abfragen (wegen Schaltern

		// Prüfe, ob Schalter1 aktiv
		if ((Math.abs(player1[0] - Schalter1[0]) < tol && Math.abs(player1[1]
				- Schalter1[1]) < tol)
				|| (Math.abs(player2[0] - Schalter1[0]) < tol && Math
						.abs(player2[1] - Schalter1[1]) < tol)) {
			schalter1 = true;
		} else
			schalter1 = false;

		// Prüfe, ob Schalter2 aktiv
		if ((Math.abs(player1[0] - Schalter2[0]) < tol && Math.abs(player1[1]
				- Schalter2[1]) < tol)
				|| (Math.abs(player2[0] - Schalter2[0]) < tol && Math
						.abs(player2[1] - Schalter2[1]) < tol)) {
			schalter2 = true;
		} else
			schalter2 = false;

		// Prüfe, ob beide Schalter gleichzeitig aktiv, öffne dann die Tür
		if (schalter1 && schalter2) {
			openDoor = true;
		}

	}

	/**
	 * Liest den String aus, der an das jeweilige Socket gesendet wurde
	 * 
	 * @param socket
	 *            Das Socket, von dem gelesen werden soll
	 * @return Der gelesene String
	 * @throws IOException
	 *             muss sein, da Netzwerk
	 */
	static String leseNachricht(Socket socket) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		char[] buffer = new char[200];
		int anzahlZeichen = bufferedReader.read(buffer, 0, 200); // blockiert
		// bis
		// Nachricht
		// empfangen
		String nachricht = new String(buffer, 0, anzahlZeichen);
		return nachricht;
	}

	/**
	 * Schickt eine Nachricht in Form eines Strings an das gewünschte Socket
	 * 
	 * @param socket
	 *            Socket, an das gesendet werden soll
	 * @param nachricht
	 *            Die Nachricht, die Übermittelt werden soll
	 * @throws IOException
	 *             muss sein, da Netzwerk
	 */
	static void schreibeNachricht(Socket socket, String nachricht)
			throws IOException {
		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(
				socket.getOutputStream()));
		printWriter.print(nachricht);
		printWriter.flush();
	}

	static Socket client = null;
	static Socket client2 = null;

	/**
	 * Hauptklasse, hierüber geschieht der Aufruf aus dem Spiel heraus.
	 */
	public static void go() {
		Server server = new Server();
		int port = 1234;

		/**
		 * Startet Client1, der Spieler1 steuert
		 * @author jan
		 *
		 */
		class startClient1 implements Runnable {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				try {
					while (client.isConnected()) {
						// Lese Bewegungsauftrag des Clients
						String direction;
						direction = leseNachricht(client);
						System.out.println("Client1 says: " + direction);

						// player2=Schalter2;
						player2 = Schalter1;

						// Führe Bewegung aus und prüfe Schalter
						move(direction, 1);
						checkSchalter();

						// Überführe Doubles in Strings und sende diese
						String string = String.valueOf(player1[0]) + " "
								+ String.valueOf(player1[1]) + " "
								+ String.valueOf(player2[0]) + " "
								+ String.valueOf(player2[1]) + " "
								+ String.valueOf(openDoor);
						schreibeNachricht(client, string);

						
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		/**
		 * Startet den zweiten Client, der Spieler2 steuert
		 * @author jan
		 *
		 */
		class startClient2 implements Runnable {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				try {
					while (client2.isConnected()) {
						// Lese Bewegungsauftrag des Clients
						String direction;
						direction = leseNachricht(client);
						System.out.println("Client1 says: " + direction);

						// player1=Schalter2;
						//player1 = Schalter1;

						// Führe Bewegung aus und prüfe Schalter
						move(direction, 1);
						checkSchalter();

						// Überführe Doubles in Strings und sende diese
						String string = String.valueOf(player1[0]) + " "
								+ String.valueOf(player1[1]) + " "
								+ String.valueOf(player2[0]) + " "
								+ String.valueOf(player2[1]) + " "
								+ String.valueOf(openDoor);
						schreibeNachricht(client, string);

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		try {
			ServerSocket serverSocket = new ServerSocket(port);
			client = serverSocket.accept();
			// client2 = serverSocket.accept();
			Thread t1 = new Thread(new startClient1());
			t1.start();
			// Thread t2 = new Thread(new startClient2());
			// t2.start();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}