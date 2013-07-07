import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Endgegner
 * Diese Klasse stellt den Endgegner dar und steuert seine Bewegung (ab Level3)
 */
public class Boss {

	/**
	 * Über diese Subklasse geschieht der Aufruf aus dem Programm
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 * @throws LineUnavailableException 
	 * @throws UnsupportedAudioFileException 
	 */
	public static void go() throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException {
		// TODO Auto-generated method stub

		/**
		 * Diese Subklasse arbeitet nur, wenn ein Boss existiert, dies wird in Getroom ausgelesen
		 */
		if(Globals.boss!=null){
			//Only active if "Boss" exists
			
			//Read position position
			double x=Globals.boss[0];
			double y=Globals.boss[1];
			StdDraw.picture(x, y, "boss.png",0.05,.05);
			double[] array = new double [2];
			
			
			//Move Boss (only in Level 2 an higher):
			/**
			 * Wenn Level hoch genug (>2) =>Bewegung des Bosses ermöglichen. Diese funktioniert, wie die Bewegung der Fallen
			 */
			if (Globals.level>2){
				
			
			int k=Globals.richtung[0];
			if (k==1){
				array[0]=x+Globals.enemy.step;	//Bewegungsrichtung 1 schräg nach oben	Richtung (1,1)
				array[1]=y+Globals.enemy.step;
				Globals.boss_neu=array;
				Wall.checkb();							//Überprüfe ob Wand erreicht.
			}
			else if(k==2){
				array[0]=x+Globals.enemy.step;	//Bewegungsrichtung 2 schräg nach oben	Richtung	(1,0)
				array[1]=y-Globals.enemy.step;
				Globals.boss_neu=array;
				Wall.checkb();							//Überprüfe ob Wand erreicht.	
			}
			else if(k==3){
				array[0]=x-Globals.enemy.step;	//Bewegungsrichtung 3 schräg nach unten	Richtung	(0,1)
				array[1]=y+Globals.enemy.step;

				Globals.boss_neu=array;
				Wall.checkb();							//Überprüfe ob Wand erreicht.
			}
			else if(k==4) {
				array[0]=x-Globals.enemy.step;	//Bewegungsrichtung 4 schräg nach unten Richtung (0,0)
				array[1]=y-Globals.enemy.step;

				Globals.boss_neu=array;
				Wall.checkb();							//Überprüfe ob Wand erreicht.
			}
			else if(k==5) {
				array[0]=x-Globals.enemy.step;	//Bewegungsrichtung 5 nach links Richtung (0,.)
				array[1]=y;
				Globals.boss_neu=array;
				Wall.checkb();							//Überprüfe ob Wand erreicht.
			}
			else if(k==6) {
				array[0]=x+Globals.enemy.step;	//Bewegungsrichtung 6 nach rechts Richtung (1,.)
				array[1]=y;
				Globals.boss_neu=array;
				Wall.checkb();							//Überprüfe ob Wand erreicht.
			}
			else if(k==7) {
				array[0]=x;	//Bewegungsrichtung 7 nach unten Richtung (.,0)
				array[1]=y-Globals.enemy.step;
				Globals.boss_neu=array;
				Wall.checkb();								//Überprüfe ob Wand erreicht.
			}
			else if(k==8) {
				array[0]=x;	//Bewegungsrichtung 8 nach oben Richtung (.,1)
				array[1]=y+Globals.enemy.step;
				Globals.boss_neu=array;
				Wall.checkb();							//Überprüfe ob Wand erreicht.
			
				
			
			
			}
			}
			
			/*
			//In level 3 (and maybe higher) Boss can drop bombs
			if (Globals.level>2){
				Globals.bombing=false;
				//class for droping the bomb
				class bomb extends TimerTask 
				{
					@Override public void run()
					{
						//stop painting explosion
						Globals.bombing=true;
					}
				}
				
				//drop bomb every 4 seconds:
				while (Globals.boss!=null)
				{
					if (Globals.bombing){
						
						//Cheating: Set player on Boss' position, because Bomb uses players position, then reset player
						double x_p=Globals.x;
						double y_p=Globals.y;
						Globals.x=Globals.boss[0];
						Globals.y=Globals.boss[1];
						Bomb.use();
						Globals.x=x_p;
						Globals.y=y_p;
						Globals.bombing=false;
					}
				Timer timer = new Timer();
	    		timer.schedule(new bomb(), 4000 );
				
				}
			}
			*/
			//check if player touches boss:
			/**
			 * Abfrage, ob Spieler den Boss berührt.
			 * Falls der Gegner den Boss berührt, stirbt der Spieler und wird an den letzten Checkpoint gesetzt
			 */
			if (!Globals.bombing){ //Our cheating (see above) causes this exception
				if (Math.abs(Globals.x-Globals.boss[0])<=0.05 && Math.abs(Globals.y-Globals.boss[1])<0.05){
					if (Globals.life>0) {
						//Reduce lifes
						Globals.life--;
						
						//Set player back to Start
						Globals.x=Globals.startx;
						Globals.y=Globals.starty;
					}else Menue.main(null);
					}
				}
			}
		}
	}
	

