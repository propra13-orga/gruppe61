import java.awt.event.KeyEvent;
import java.io.IOException;


public class Menue {
	

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
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
			StdDraw.text(0.5, 0.75, "Start");
			StdDraw.text(0.5, 0.25, "Beenden");
			StdDraw.point(x, y);
			if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER))
				if (y>0.5) //Start gedrückt
				{
					//Initialize variables with their defaults:
					Initialize.game();
					//Start game
					Game.start();
					
					
					
					/*
					//Saving checkpoints:
					Globals.level=1;
					Globals.room=1;
					*/
					
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
