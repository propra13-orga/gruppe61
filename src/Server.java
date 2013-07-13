// Server.java

// import java.net.ServerSocket;
// import java.net.Socket;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

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

	static void schreibeNachricht(Socket socket, String nachricht)
			throws IOException {
		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(
				socket.getOutputStream()));
		printWriter.print(nachricht);
		printWriter.flush();
	}

	private class ponger implements Runnable {
		public void run() {
			while (client.isConnected()) {
				try {
					String nachricht = leseNachricht(client);
					System.out.println("client says: " + nachricht + " \n ");
					pong(client);
					if (nachricht == "ping")
						pong(client);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	static void pong(Socket socket) throws IOException {

		schreibeNachricht(socket, "pong");

	}

	static Socket client = null;

	public static void go() {
		Server server = new Server();
		int port = 1234;
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			client = serverSocket.accept();
			while (client.isConnected()) {
				String nachricht = leseNachricht(client);
				System.out.println("client says: " + nachricht);
				if (true /* nachricht=="ping" */) {

					pong(client);
					// System.out.println("Server says: pong \n");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}