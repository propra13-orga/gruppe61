public class Netzwerk {

	/**Diese Methode soll das Netzwerk starten. Dazu wird zuerst in einem Thread der Server gestartet und dann in jeweils einem eigenen Thread die beiden Clients, die sich an den Server anmelden.
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

		class startClient1 implements Runnable {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Client1.go();
			}

		}
		
		class startClient2 implements Runnable {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Client2.go();
			}

		}
		
		//Server.client.isBound();
		
		Thread t1 = new Thread(new startServer());
		Thread t2 = new Thread(new startClient1());
		Thread t3 = new Thread(new startClient2());

		t1.start();
		t2.start();
		t3.start();

	}

}
