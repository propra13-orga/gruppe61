public class Netzwerk {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		class startServer implements Runnable {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Server.go();
			}

		}

		class startClient implements Runnable {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Client.go();
			}

		}
		Thread t1 = new Thread(new startServer());
		Thread t2 = new Thread(new startClient());

		t1.start();
		t2.start();

	}

}
