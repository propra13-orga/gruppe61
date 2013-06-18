


public class NPC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		StdDraw.setPenColor(StdDraw.WHITE);
		
		StdDraw.filledRectangle(.5, 1.03,0.6 , 0.03);
		StdDraw.setPenColor();
		StdDraw.text(0.5, 1.03, "Level: "+Globals.level+" Raum: "+Globals.room);
	}

}
