
public class  InformationBar {

	public static void main(String[] args) {
		
		StdDraw.setPenColor(StdDraw.WHITE);
		
		StdDraw.filledRectangle(0.5, -.03,0.6 , 0.03);
		
		StdDraw.setPenColor();

		StdDraw.picture(0, -0.03, "heart.png",0.05,0.05);
		StdDraw.textLeft(0.05,-0.03, ""+Globals.life);
		
		StdDraw.picture(0.15, -0.03, "red_cross.png",.05,.05);
		StdDraw.textLeft(0.18, -0.03, ""+Globals.health+"%");
		
		StdDraw.picture(0.35, -0.03, "magician.png",0.05,0.05);
		StdDraw.textLeft(0.38,-0.03, ""+Globals.magician);
		
		StdDraw.picture(0.5, -0.03, "bomb.png", 0.05,0.05);
		StdDraw.textLeft(0.53, -0.03, ""+Globals.weapon);
				
		StdDraw.picture(0.65, -0.03, "stop.png",0.05, 0.05);
		StdDraw.textLeft(0.68, -0.03, ""+Globals.stop);
		
		StdDraw.picture(0.75, -0.03, "money.png", 0.05,0.05);
		StdDraw.textLeft(0.78, -0.03, ""+Globals.money);
		
		
		
	}

}
