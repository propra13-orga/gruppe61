// Client.java

// import java.net.Socket;
import java.io.*;
import java.net.Socket;
/**
 * Client für den ersten Spieler
 * Dieser Client simuliert Spieler1.
 * Derzeit sendet er ein "ping" an den Server und druckt in der Konsole, die Nachricht, die er vom Server liest ("pong")
 * 
 * Geplant ist: Der Client sendet Bewegungsanweisungen an den Server, d.h. Kommandos wie "up", "down" etc. Diese können als String gelesen werden.
 * Der Server soll dann die Neuen Koordinaten berechnen und dem Client senden. Damit der Cient anhand der Koordinaten beider Spieler den Raum zeichnet.
 * 
 * @author jan
 *
 */
public class Client1 {
	private static void schreibeNachricht(Socket socket, String nachricht)
			throws IOException {
		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(
				socket.getOutputStream()));
		printWriter.print(nachricht);
		printWriter.flush();
	}

	private static String leseNachricht(Socket socket) throws IOException {
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

	static double leseDouble(Socket socket) throws IOException {
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		return ois.readDouble();
	}

	static void schreibeDouble(Socket socket, double x) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(
				socket.getOutputStream());
		oos.writeDouble(x);
		oos.flush();
	}

	private static void ping(Socket socket) throws IOException {

		schreibeNachricht(socket, "ping");

	}

	public static void go() {
		Client1 client = new Client1();
		int port = 1234; //willkür, wichtig ist nur >1024 und bei Server und Clients identisch

		try {
			Socket server = new Socket("localhost", port); // verbindet sich mit
			// Server

			ping(server);
			while (server.isConnected()) {
				String empfangeneNachricht = leseNachricht(server);

				// double x=leseDouble(server);
				// System.out.println("bla \n"+ x + "\n");

				if (empfangeneNachricht == "pong")
					System.out.println(empfangeneNachricht);
				ping(server);
				System.out.println("Client1 reads: " + empfangeneNachricht); //Druckt das gelesene
			}

		} catch (IOException e) { //Notwendig, sonst geht nix
			e.printStackTrace();
		}

	}

}