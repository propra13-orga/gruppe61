/**
 * steuert das Einsammeln der Zahlen für das Quest
 *
 */
public class Sammeln {

	/**
	 * Hierüber erfolgt der Aufruf aus dem Spiel heraus
	 */
	public static void use() {
		int i=0;
		while (i<=Globals.quest.length){
		if (Globals.quest.level==1 && Math.abs(Globals.quest.position[0+2*i]-Globals.x)<0.047 && Math.abs(Globals.quest.position[1+2*i]-Globals.y)<0.047){
			Globals.quest.array[Globals.quest.zeiger]=Globals.quest.zahlen[i];
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.text(Globals.quest.position[0+2*i],Globals.quest.position[1+2*i], ""+Globals.quest.zahlen[i]+"");
			StdDraw.setPenColor(StdDraw.BLACK);
			
			

			System.out.println(""+Globals.quest.array[Globals.quest.zeiger]);
			Globals.quest.zeiger++;
			
			}
		else if (Globals.quest.level==1 &&Globals.quest.zeiger>3){
			Globals.quest.draw=false;
			break;
		}
		//System.out.println(""+Globals.quest.zahlen[i]);
		//System.out.println(""+Globals.quest.position[0+2*i]);
		//System.out.println(""+Globals.quest.position[1+2*i]);
		
		i++;}
		}

}
