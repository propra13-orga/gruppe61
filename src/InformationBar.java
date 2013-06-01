
public class  InformationBar {

	public static void main(String[] args) {
		
		StdDraw.setPenColor(StdDraw.BLACK);

		StdDraw.picture(0, -0.03, "heart.png",0.05,0.05);
		StdDraw.textLeft(0.05,-0.03, ""+Globals.life);
		
		StdDraw.picture(0.15, -0.03, "red_cross.png",.05,.05);
		StdDraw.textLeft(0.18, -0.03, ""+Globals.health+"%");
		
		StdDraw.picture(0.35, -0.03, "magician.png",0.05,0.05);
		StdDraw.textLeft(0.38,-0.03, ""+Globals.magician);
		
		StdDraw.picture(0.5, -0.03, "money.png", 0.05,0.05);
		StdDraw.textLeft(0.53, -0.03, ""+Globals.money);
	}

}
