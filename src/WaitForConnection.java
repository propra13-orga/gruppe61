/**
 * Ladebildschirm Dieser Bildschirm soll angezeigt werden, wen ein Spieler sich
 * für das Netzwerkspiel angemeldet hat, aber noch kein zweiter verbunden ist
 * 
 * @author jan
 * 
 */
public class WaitForConnection {

	/**
	 * Hierüber wird er aufgerufen
	 * 
	 * @param args
	 */
	public static void execute() {
		// TODO Auto-generated method stub

		StdDraw.show(0);
		StdDraw.clear();
		StdDraw.text(0.5, .8, "Warte auf zweiten Spieler");
		StdDraw.picture(.5, .5, "Loader.gif");

	}

}
