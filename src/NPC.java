


public class NPC {

	/**
	 * @param args
	 */
	public static void go() {
		// TODO Auto-generated method stub

		
		StdDraw.setPenColor(StdDraw.WHITE);
		
		StdDraw.filledRectangle(.5, 1.03,0.6 , 0.03);
		StdDraw.setPenColor();


		if (Globals.level==1){
			if (Globals.room==1) StdDraw.text(0.5, 1.03, "Hüte dich vor den bösen Fallen, sie bewegen sich!");
			if (Globals.room==2) StdDraw.text(0.5, 1.03, "Vielleicht möchtest du etwas kaufen? Es könnte hilfreich sein..");
			if (Globals.room==3 && Globals.boss!=null) StdDraw.text(0.5, 1.03, "Töte diesen Schurken! Also lass es krachen...");
			if (Globals.room==3 && Globals.boss==null) StdDraw.text(0.5, 1.03, "Geschafft! Der ist erledigt. Und jetzt weiter");
		}
		if (Globals.level==2){
			if (Globals.room==1) StdDraw.text(0.5, 1.03, "Herzlichen Glückwunsch. Den ersten hast du geschafft");
			if (Globals.room==2) StdDraw.text(0.5, 1.03, "Hier hilft wohl nur ein kleiner Zauber...");
			if (Globals.room==3 && Globals.boss!=null) StdDraw.text(0.5, 1.03, "So ein mist, da ist ja noch so einer... Mach ihn fertig!");
		}
		if (Globals.level==3){
			if (Globals.room==1) StdDraw.text(0.5, 1.03, "Das war gar nicht so leicht. Aber Dir ist ja nix zu schwer");
			if (Globals.room==2) StdDraw.text(0.5, 1.03, "Ich glaube der es gibt noch einen letzten Bösewicht...");
			if (Globals.room==3 && Globals.boss!=null) StdDraw.text(0.5, 1.03, "Da ist er ja. Und schlimmer als alle anderen...");
		}
	}

}
