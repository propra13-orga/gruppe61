
public class Initialize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Initialize inventory
		Globals.health=100;
		Globals.life=3;
		Globals.magician=0;
		Globals.money=20;
		Globals.stop=30;
		
		//Initialize enemy
		Globals.enemy.x=0.5;
		Globals.enemy.y=0.5;
		Globals.enemy.step=0.005;
		Globals.enemy.move=true;
		
		//Initialize player
		Globals.player.x=0.2;
		Globals.player.y=0.2;
		Globals.player.step=0.005;
		
		StdDraw.setCanvasSize(600, 600);
		
		
	
	}

}
