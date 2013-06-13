
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

}
