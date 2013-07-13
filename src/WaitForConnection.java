
public class WaitForConnection {

	/**
	 * @param args
	 */
	public static void execute() {
		// TODO Auto-generated method stub

		while (true) {
			
			StdDraw.show(0);
			StdDraw.clear();
			StdDraw.text(0.5, .8, "Warte auf zweiten Spieler");
			StdDraw.picture(.5, .5, "Loader.gif");
		}
		
	}

}
