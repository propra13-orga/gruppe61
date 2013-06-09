
public class Damages {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub



	}
		
		
	public static void setDamages(){
		
		
		//if (Globals.health == 0) Globals.life--;
		
		if ( Globals.life > 0 ){
			
			/*for(int i = Globals.life; i > 0 ; i--){
				
				Globals.health = Globals.health - 20; //every death -20%
				
				if(Globals.health == 0) Globals.life--;
				
			}*/
			
			Globals.health = Globals.health - 50;
			
			if(Globals.health == 0){
				Globals.life--;
				Globals.health = 100;
			}
			

		}
		
		if ( Globals.life <= 0 ){
			
			
    	   	StdDraw.clear();
    	   	Menue.main(null);

		
	}
		
		/* if (Globals.weapon != 0){
			
			for(int i = 0; i < Globals.weapon ; i++){
				
				if ( Globals.shot == true ){
					
					Globals.health = Globals.health - 20; // every shot - 20%
					 if(Globals.health == 0) Globals.life--;
					
				}
	
				
			}
			
			
		}
		
		
		if ( Globals.magician != 0 ){
			
			for(int i = 0; i < Globals.magician; i++){
				Globals.health = Globals.health + 40; //every magician + 40%
				
			}
			
				


	}
		*/
		
	}

}
