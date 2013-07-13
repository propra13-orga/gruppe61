import java.awt.Color;


public class NetzwerkRaum {

	private static double[] ziel={1,.3};
	
	/**Zeichnet den Raum, indem das Netzwerk-Spiel stattfindet
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StdDraw.clear();
		StdDraw.setPenRadius(.025);
		StdDraw.square(0.5, 0.5, 0.5);
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.filledSquare(ziel[0], ziel[1], 0.1);
		StdDraw.setPenColor(StdDraw.BLACK);
		
		StdDraw.text(ziel[0], ziel[1], "Ziel");
		
		Color braun=new Color(139,69,19);
		StdDraw.setPenColor(braun);
		StdDraw.line(ziel[0], ziel[1]+.1, ziel[0], ziel[1]-0.1);
		
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.filledSquare(.1, 0.3, .05);
		StdDraw.filledSquare(.9, 0.8, 0.05);
		
		StdDraw.picture(.5, 0.5, "pi.png",.1,.1);
		StdDraw.picture(.3, 0.7, "sigma.png",.07,.07);
	}

}
