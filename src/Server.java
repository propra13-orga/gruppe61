// Server.java

// import java.net.ServerSocket;
// import java.net.Socket;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Server.
 * Derzeitige Arbeit: Akzeptiere zwei Clients und empfange deren Pings und sende Pongs zurück.
 * Es wird in der Konsole ausgedruckt, von wem  der Server das Ping empfangen hat
 * 
 * Geplant: Server soll Bewegungsanweisungen ("down", "right", etc) vom Client empfangen und daraufhin die neuen Koordinaten berechnen. Diese sollen an die Clients gesendet werden, damit diese damit den Raum zeichnen können
 * 
 * @author jan
 *
 */
public class Server {
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

	static void schreibeNachricht(Socket socket, String nachricht)
			throws IOException {
		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(
				socket.getOutputStream()));
		printWriter.print(nachricht);
		printWriter.flush();
	}

	static void pong(Socket socket) throws IOException {

		schreibeNachricht(socket, "pong");

	}

	static Socket client = null;
	static Socket client2 = null;

	public static void go() {
		Server server = new Server();
		int port = 1234;

		class startClient1 implements Runnable {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				try {
					while (client.isConnected()) {
						String nachricht;
						nachricht = leseNachricht(client);
						System.out.println("Client1 says: " + nachricht);
						if (true /* nachricht=="ping" */) {

							pong(client);
							// System.out.println("Server says: pong \n");
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		class startClient2 implements Runnable {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				try {
					while (client2.isConnected()) {
						String nachricht;
						nachricht = leseNachricht(client2);
						System.out.println("Client2 says: " + nachricht + "\n");
						if (true /* nachricht=="ping" */) {

							pong(client2);
							// System.out.println("Server says: pong \n");
						}
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
			client2 = serverSocket.accept();
			Thread t1 = new Thread(new startClient1());
			t1.start();
			Thread t2 = new Thread(new startClient2());
			t2.start();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}