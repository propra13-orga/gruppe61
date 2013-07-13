import java.awt.Color;

/**
 * Raum für das Netzwerkspiel
 * In diesem Raum, soll das Netzwerkspiel stattfinden. 
 * Folgender Modus ist geplant:
 * Eingabe werden 5 Variablen. 4 Double und eine Boolean. Die vier double geben die Koordinaten der beiden Spieler an. Und die Boolean, ob das Quest gelöst ist und somit die Tür offen ist.
 * 
 * @author jan
 *
 */
public class NetzwerkRaum {

	private static double[] ziel={1,.3};
	
	/**Zeichnet den Raum, indem das Netzwerk-Spiel stattfindet
	 * 
	 * @param args
	 */
	public static void execute(double[] player1, double [] player2, boolean door) {
		// TODO Auto-generated method stub

		//Zeichne Raum
		StdDraw.clear();
		StdDraw.setPenRadius(.025);
		StdDraw.square(0.5, 0.5, 0.5);
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.filledSquare(ziel[0], ziel[1], 0.1);
		StdDraw.setPenColor(StdDraw.BLACK);
		
		//Ziel bzw Tür zeichnen:
		if (door) StdDraw.text(ziel[0], ziel[1], "Ziel");
		else {
		Color braun=new Color(139,69,19);
		StdDraw.setPenColor(braun);
		StdDraw.line(ziel[0], ziel[1]+.1, ziel[0], ziel[1]-0.1);
		}
		
		//Zeichne Schalter
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.filledSquare(.1, 0.3, .05);
		StdDraw.filledSquare(.9, 0.8, 0.05);
		
		//Zeichne Spieler:
		StdDraw.picture(player1[0], player1[1], "pi.png",.1,.1);
		StdDraw.picture(player2[0], player2[1], "sigma.png",.07,.07);
	}

}
