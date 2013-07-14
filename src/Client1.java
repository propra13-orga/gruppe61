// Client.java

// import java.net.Socket;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.Socket;

/**
 * Client für den ersten Spieler Dieser Client simuliert Spieler1. Derzeit
 * sendet er ein "ping" an den Server und druckt in der Konsole, die Nachricht,
 * die er vom Server liest ("pong")
 * 
 * Geplant ist: Der Client sendet Bewegungsanweisungen an den Server, d.h.
 * Kommandos wie "up", "down" etc. Diese können als String gelesen werden. Der
 * Server soll dann die Neuen Koordinaten berechnen und dem Client senden. Damit
 * der Cient anhand der Koordinaten beider Spieler den Raum zeichnet.
 * 
 * @author jan
 * 
 */
public class Client1 {

	/**
	 * Zeichnet den Raum, indem das Netzwerk-Spiel stattfindet
	 * 
	 * @param args
	 */
	public static void paintRoom(String[] args) {
		// TODO Auto-generated method stub

		double[] player1 = { Double.valueOf(args[0]), Double.valueOf(args[1]) };
		double[] player2 = { Double.valueOf(args[2]), Double.valueOf(args[3]) };
		boolean IsDoorOpen = Boolean.valueOf(args[4]);

		double[] ziel = { 1, .3 };

		// Zeichne Raum
		StdDraw.clear();
		// StdDraw.show(0);
		StdDraw.setPenColor();
		StdDraw.setPenRadius(.035);
		StdDraw.square(0.5, 0.5, 0.55);
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.filledSquare(ziel[0], ziel[1], 0.1);
		StdDraw.setPenColor(StdDraw.BLACK);

		// Ziel bzw Tür zeichnen:
		if (IsDoorOpen)
			StdDraw.text(ziel[0], ziel[1], "Ziel");
		else {
			Color braun = new Color(139, 69, 19);
			StdDraw.setPenColor(braun);
			StdDraw.line(ziel[0] + .045, ziel[1] + .1, ziel[0] + .045,
					ziel[1] - 0.1);
		}

		// Zeichne Schalter
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.filledSquare(.1, 0.3, .08);
		StdDraw.filledSquare(.9, 0.8, 0.08);

		// Zeichne Spieler:
		StdDraw.picture(player1[0], player1[1], "pi.png", .1, .1);
		StdDraw.picture(player2[0], player2[1], "sigma.png", .07, .07);
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

	public static void go() {
		Client1 client = new Client1();
		int port = 1234; // willkür, wichtig ist nur >1024 und bei Server und
							// Clients identisch

		try {
			Socket server = new Socket("localhost", port); // verbindet sich mit
			// Server

			while (server.isConnected()) {
				String empfangeneNachricht = leseNachricht(server);
				System.out.println("Client1 reads: " + empfangeneNachricht); // Druckt
																				// das
																				// gelesene
				// double x=leseDouble(server);
				// System.out.println("bla \n"+ x + "\n");

				StdDraw.show(0);

				// Parse empfangene Nachricht nach Leerzeichen
				String delims = "[ ]";
				String[] Daten = empfangeneNachricht.split(delims);

				paintRoom(Daten);
				System.out.println("\n" + Daten + "\n");

				// Move Player:
				String move = "no Move";
				if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) // Move Left
				{
					move = "left";

				} else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) // Move
																	// right
				{
					move = "right";

				} else if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) // Move up
				{
					move = "up";

				} else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) // Move Down
				{
					move = "down";
				}

				schreibeNachricht(server, move);

			}

		} catch (IOException e) { // Notwendig, sonst geht nix
			e.printStackTrace();
		}

	}

}