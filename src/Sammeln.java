/**
 * steuert das Einsammeln der Zahlen f�r das Quest oder bet�tigen von Schalter
 *
 */
public class Sammeln {

	/**
	 * Hier�ber erfolgt der Aufruf aus dem Spiel heraus
	 */
	public static void use() {
		if (Globals.quest.level==1|| Globals.quest.level==2){
		int i=0;
		while (i<=Globals.quest.length){
		if ( Math.abs(Globals.quest.position[0+2*i]-Globals.x)<0.047 && Math.abs(Globals.quest.position[1+2*i]-Globals.y)<0.047){
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
		else if (Globals.quest.level==2 &&Globals.quest.zeiger>1){
			Globals.quest.draw=false;
			break;
		}
		//System.out.println(""+Globals.quest.zahlen[i]);
		//System.out.println(""+Globals.quest.position[0+2*i]);
		//System.out.println(""+Globals.quest.position[1+2*i]);
		
		i++;}
		}
	
	else if(Globals.quest.level==3){//Schalter bet�tigen und damit das Quest abschlie�en.
		if ( Math.abs(Globals.quest.position[0]-Globals.x)<0.047 && Math.abs(Globals.quest.position[1]-Globals.y)<0.047){
		if (Globals.quest.schalter){
			Globals.quest.schalter=false;
			Globals.quest.ready=true;
			Globals.room=3;
		}
		else {
			Globals.quest.schalter=true;
			
			Globals.room=2;
			}
		}
		}
	}
}
