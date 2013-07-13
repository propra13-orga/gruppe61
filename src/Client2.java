// Client.java

// import java.net.Socket;
import java.io.*;
import java.net.Socket;
/**
 * Client f�r Spieler 2
 * Arbeitet genauso, wie Client, nur soll hier�ber Spieler2 laufen.
 * @author jan
 *
 */
public class Client2 {
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

	private static void ping(Socket socket) throws IOException {

		schreibeNachricht(socket, "ping");

	}

	public static void go() {
		Client1 client = new Client1();
		int port = 1234;

		try {
			Socket server = new Socket("localhost", port); // verbindet sich mit
															// Server

			ping(server);
			while (server.isConnected()) {
				String empfangeneNachricht = leseNachricht(server);

				if (empfangeneNachricht == "pong")
					System.out.println(empfangeneNachricht);
				ping(server);
				System.out
						.println("Client2 reads: " + empfangeneNachricht);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}