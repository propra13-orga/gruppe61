
public class Paint {
	static void player(double x,double y)
    {

        //Initialisiere Spielfigur als Punkt an der Koordinate (x,y):
		// StdDraw.setPenColor(StdDraw.BLUE);
		//StdDraw.setPenRadius(0.05);
		//StdDraw.point(x, y);
    	//Zeichne Spieler als Pi an Koordinate (x,y):
            StdDraw.picture(x, y,"pi.png",.05,.05);



    }

	   static void Falle(double i,double j){
        //bewegene Gegner/Falle
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.filledSquare(i, j, 0.01);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(i, j,0.01);


}

	public static void shop(double x, double y) {//Zeichne Shop
		StdDraw.picture(x, y, "shop.png",.05,.05);
		
	}

	public static void packet(double x, double y) {//Zeichne Packet
		StdDraw.picture(x, y, "package.png", .05,.05);
		
	}

	public static void bomb(double x, double y) {//Zeichne Bombe
		StdDraw.picture(x ,y , "bomb.png",.05,.05);
		
	}

	public static void explosion(double x, double y) {//Zeichne Explosion
		StdDraw.picture(Bomb.x, Bomb.y, "explosion.jpg",0.1,.1);
		Globals.draw.explosion=false;
		
	}

}
