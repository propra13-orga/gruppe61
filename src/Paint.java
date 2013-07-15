/**
 * Zeichnet alle wichtigen Inhalte
 * Hier werden Spieler, fallen und co gezeichnet. Die Position wird dafür jeweils aus den Globals ausgelesen
 *
 */
public class Paint {
	/**
	 * Zeichnet den Spieler an seine Koordinaten
	 * @param x
	 * @param y
	 */
	static void player(double x,double y)
    {

        //Initialisiere Spielfigur als Punkt an der Koordinate (x,y):
		// StdDraw.setPenColor(StdDraw.BLUE);
		//StdDraw.setPenRadius(0.05);
		//StdDraw.point(x, y);
    	//Zeichne Spieler als Pi an Koordinate (x,y):
            StdDraw.picture(x, y,"pi.png",.05,.05);



    }

	/**
	 * Zeichnet eine Falle
	 * @param i
	 * @param j
	 */
	   static void Falle(double i,double j){
        //bewegene Gegner/Falle
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.filledSquare(i, j, 0.01);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(i, j,0.01);


}

	   /**
	    * Zeichnet das Shopsymbol in den Raum
	    * @param x
	    * @param y
	    */
	public static void shop(double x, double y) {//Zeichne Shop
		StdDraw.picture(x, y, "shop.png",.05,.05);
		
	}

	/**
	 * Zeichnet ein Paket, in welchem sich Boni verstecken, die auch im Shop gekauft werden können
	 * @param x
	 * @param y
	 */
	public static void packet(double x, double y) {//Zeichne Packet
		StdDraw.picture(x, y, "package.png", .05,.05);
		
	}

	/**
	 * Zeichnet eine Bombe
	 * @param x
	 * @param y
	 */
	public static void bomb(double x, double y) {//Zeichne Bombe
		StdDraw.picture(x ,y , "bomb.png",.05,.05);
		
	}

	/**
	 * Zeichnet die Explosion der Bombe
	 * @param x
	 * @param y
	 */
	public static void explosion(double x, double y) {//Zeichne Explosion
		StdDraw.picture(x, y, "explosion.jpg",0.1,.1);
		Globals.draw.explosion=false;
		
	}

	/**
	 * Zeichnet den Professor (NPC)
	 * @param x
	 * @param y
	 */
	public static void npc(double x, double y) {
		StdDraw.picture(x,y, "professor.png", 0.05,0.05);
		
	}

	/**
	 * Zeichnet die Gegenstände, die für das quest benötigt werden. D.h. beim ersten Quest die Zahlen
	 */
	public static void quest() {
		if(Globals.quest.level==1 || Globals.quest.level==2){
		int i=0;
		while (i<=Globals.quest.length){
		StdDraw.setPenColor(StdDraw.RED);//Zeichne Questgegenstände ein.
		StdDraw.text(Globals.quest.position[0+2*i],Globals.quest.position[1+2*i], ""+Globals.quest.zahlen[i]+"");
		StdDraw.setPenColor(StdDraw.BLACK);
		i++;
		}
		}
		else if(Globals.quest.level==3 && Globals.quest.length>0){
			if(Globals.quest.schalter){
			StdDraw.picture(Globals.quest.position[0] ,Globals.quest.position[1] , "Schalteroff.jpg",.05,.05);
			
			}
			else{
			StdDraw.picture(Globals.quest.position[0] ,Globals.quest.position[1] , "Schalteron.jpg",.05,.05);
			}
			
		}
	}

	public static void speicher() {
		StdDraw.picture(Globals.speicher.x,Globals.speicher.y, "Speicherpunkt.png", 0.05,0.05);
		
	}

}
