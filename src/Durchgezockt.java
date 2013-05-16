import java.awt.event.KeyEvent;


public class Durchgezockt {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StdDraw.clear();
		StdDraw.setPenRadius(.01);
		StdDraw.setPenColor();
		
		double x=0.75;
		double y=0.75;
		while (true)
		{
			StdDraw.show(0);
			StdDraw.clear();
			
			StdDraw.square(.5, .5, .5);
			StdDraw.line(0, .5, 1, .5);
			StdDraw.text(0.5, 0.85, "Du hast alle Level absolviert! Was nun?");
			StdDraw.text(0.5, 0.75, "Ich will nochmal");
			StdDraw.text(0.5, 0.25, "Ich hab keine Lust mehr");
			StdDraw.point(x, y);
			if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER))
				if (y>0.5) //Start gedrückt
				{
					Level1.main(args);
					break;
				}
				else System.exit(0);
			if (StdDraw.isKeyPressed(KeyEvent.VK_UP))
			{
				y=.75;
			}
			else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN))
			{
				y=.25;
			}
			
			
		}

	}

}
