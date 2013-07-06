import java.awt.event.KeyEvent;


public class Quest {
	private static int height=1;
	private static int i=1;

	public static void start() throws InterruptedException {
		Globals.quest.level=Globals.level;
		i=1;
		if (Globals.quest.level==1) 
		{
			while(true){
				//Buffering:
				StdDraw.show(10);
				paint();
				arrow(height);
				
				
				
				if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)){
					if (height%2==0){
						Globals.quest.draw=true;
						break;
					}
					else if (height%2==1){
						while(true){
							
						if (Globals.quest.array[1]==3 && Globals.quest.array[2]==1 && Globals.quest.array[3]==4 && Globals.quest.array[4]==1 ){
							i=2;
							paint();
							Globals.quest.draw=false;
							//if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)){
							//	break;
							//}
							StdDraw.show(5000);
							break;

						}
						else {
							i=3;
							paint();
							
							Globals.quest.draw=true;
							
							//boolean hasNextKeyTyped=StdDraw.hasNextKeyTyped();
							//if (hasNextKeyTyped){
							//	break;
							//}
							StdDraw.show(5000);
							break;
						}
						}
						
					break;	
					}
				}
				
				
				
				
				if (StdDraw.isKeyPressed(KeyEvent.VK_UP)){
					if(height%2==1){}
					else{
						height--;}
					
				}
				else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)){
					if(height%2==0){}
					else{
					height++;}
				}
				Thread.sleep(100);
		}
			
		}
		else if (Globals.quest.level==2)
		{
			while(true){
				//Buffering:
				StdDraw.show(10);
				paint();
				arrow(height);
				
				
				
				if (StdDraw.isKeyPressed(KeyEvent.VK_UP)){
					if(height%2==1){}
					else{
						height--;}
					
				}
				else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)){
					if(height%2==0){}
					else{
					height++;}
				}
				Thread.sleep(100);
			}
			
		}
		else if (Globals.quest.level==3)
		{
			while(true){
				//Buffering:
				StdDraw.show(10);
				paint();
				arrow(height);
				
				if (StdDraw.isKeyPressed(KeyEvent.VK_UP)){
					if(height%2==1){}
					else{
						height--;}
					
				}
				else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)){
					if(height%2==0){}
					else{
					height++;}
				}
				Thread.sleep(100);
				
			}
			
		}
		
	}

	private static void arrow(int height) {
		if (height%2==1)
		{
			//Life is chosen
			StdDraw.picture(0.05, .3, "pfeil_rechts.png",.1,.1);
		}
		else if (height%2==0) {
			//Health is chosen
			StdDraw.picture(0.05, .2, "pfeil_rechts.png",.1,.1);
		}
		
		
	}

	private static void paint() {
		//paint Text für Quest
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.clear(StdDraw.BLACK);
		
		if (Globals.quest.level==1){
			
			if(i==1){
			StdDraw.text(0.5, .9, "Hallo mein junger Student");
			StdDraw.textLeft(0, .85, "Ich habe schon auf jemanden, wie dich gewartet.");
			StdDraw.textLeft(0, .8, "Ich kann mich einfach nicht mehr an die ersten 4 Zahlen von PI erinnern.");
			StdDraw.textLeft(0, .75, "Leider sind sie hier überall verteilt.");
			StdDraw.textLeft(0, .7, "Such sie bitte für mich und");
			StdDraw.textLeft(0, .65, "achte darauf sie in der richtigen Reihenfolge einzusammeln.");
			
			StdDraw.text(0.5, 0.3, "Ich habe die Zahlen gefunden, hier sind sie.");
			StdDraw.text(0.5, 0.2, "Ok ich mach mich auf die Suche!");
			}
			else if(i==2){
				StdDraw.textLeft(0, .85, "Danke für deine Hilfe.");
				StdDraw.textLeft(0, .8, "Nun kann ich endlich den Kreisumfang berechnen.");
				StdDraw.textLeft(0, .75, "Level 2 wartet auf dich, aber zuerst muss du den Boss besiegen.");
			}
			else if(i==3){
				StdDraw.textLeft(0, .85, "Das kann nicht stimmen.");
				StdDraw.textLeft(0, .8, "Geh nochmal los und suche erneut.");
				StdDraw.textLeft(0, .75, "Denk dran die Reihenfolge muss stimmen.");
			}
			
		}
		else if (Globals.quest.level==2){
			
		}
		else if (Globals.quest.level==3){
			
		}
	}
	

}
