import java.io.IOException;




public class Controller {

	public static void playerleft() {
        Globals.xneu = Globals.x-0.005;
        Globals.yneu=Globals.y;
		
	}

	public static void playerright() {
        Globals.xneu = Globals.x+0.005;
        Globals.yneu = Globals.y;
		
	}

	public static void playerup() {
		Globals.xneu = Globals.x;
        Globals.yneu = Globals.y+0.005;
		
	}

	public static void playerdown() {
		Globals.xneu = Globals.x;
        Globals.yneu = Globals.y-0.005;
		
	}

	public static void Falle(int i)throws IOException {// i gibt hier auch jeder Falle eine Nummer		 
		
		double[] array = new double [2];
		
		int k=Globals.richtung[i];
		if (k==1){
			array[0]=Globals.arraylokal[0+2*i]+0.01;
			array[1]=Globals.arraylokal[1+2*i]+0.01;
			System.out.println(Globals.arraylokal[1+2*i]);
			Globals.falleneu=array;
			Wall.checkf(i);
		}
		else if(k==2){
			array[0]=Globals.arraylokal[0+2*i]+0.01;
			array[1]=Globals.arraylokal[1+2*i]-0.01;
			Globals.falleneu=array;
			Wall.checkf(i);
		}
		else if(k==3){
			array[0]=Globals.arraylokal[0+2*i]-0.01;
			array[1]=Globals.arraylokal[1+2*i]+0.01;
			Globals.falleneu=array;
			Wall.checkf(i);
		}
		else {
			array[0]=Globals.arraylokal[0+2*i]+0.01;
			array[1]=Globals.arraylokal[1+2*i]+0.01;
			Globals.falleneu=array;
			Wall.checkf(i);
		}
		

		
				
		
		
	}
	

}
