import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JOptionPane;


public class Shop {
	static int price=5;
	static int height=1;

	static void paint() {
		//Paint the Shop
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.clear(StdDraw.BLACK);
		
		//Head
		StdDraw.text(0.5, .9, "Willkommen im Shop");
		StdDraw.textLeft(0, .8, "Du hast noch "+Globals.money+" Münzen zur Verfügung");
		StdDraw.textLeft(0, .75, "Was möchtest du nun kaufen?");
		
		//Char
		StdDraw.text(0.2, .6, "Artikel");
		StdDraw.text(.5, .6, "Dein Inventar");
		StdDraw.text(0.8, .6, "Preis");
		
		//Objects to buy
		StdDraw.picture(0.2, .5, "heart.png", 0.1, .1);
		StdDraw.text(0.5,.5,""+Globals.life);
		StdDraw.text(0.8, .5, ""+price+" Münzen");
		
		StdDraw.picture(.2, .4, "red_cross.png",0.1,.1);
		StdDraw.text(0.5,.4,""+Globals.health+" %");
		StdDraw.text(0.8, .4, ""+price+" Münzen");
		
		StdDraw.picture(.2, .3, "magician.png",0.1,.1);
		StdDraw.text(0.5,.3,""+Globals.magician);
		StdDraw.text(0.8, .3, ""+price+" Münzen");
		
		StdDraw.picture(.2, .2, "bomb.png",0.1,.1);
		StdDraw.text(0.5,.2,""+Globals.weapon);
		StdDraw.text(0.8, .2, ""+price+" Münzen");
		
		StdDraw.picture(.2, .1, "stop.png",.1,.1);
		StdDraw.text(0.5, 0.1, ""+Globals.stop);
		StdDraw.text(0.8, 0.1, ""+price+" Münzen");
		
		//Option to leave the shop
		StdDraw.textLeft(.2, 0.02, "Genug Shopping für heute, ich will weiter zocken!");
	
	}
	
	static void arrow(int height) {
		//Painting the right arrow. Height is descending by rising value
		
		//Counting the height modulo #Options 
		//height=height%4;
		
		if (height%6==1)
		{
			//Life is chosen
			StdDraw.picture(0.05, .5, "pfeil_rechts.png",.1,.1);
		}
		else if (height%6==2) {
			//Health is chosen
			StdDraw.picture(0.05, .4, "pfeil_rechts.png",.1,.1);
		}
		else if (height%6==3) {
			//Magician is chosen
			StdDraw.picture(0.05, .3, "pfeil_rechts.png",.1,.1);
		}
		else if (height%6==4) {
			//Stop is chosen
			StdDraw.picture(0.05, .2, "pfeil_rechts.png",.1,.1);
		}
		else if (height%6==5) {
			//Stop is chosen
			StdDraw.picture(0.05, .1, "pfeil_rechts.png",.1,.1);
		}
		else StdDraw.picture(0.05, .002, "pfeil_rechts.png",.1,.1);
		
	}
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public static void use() throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		
		
		while (true){
			//Buffering:
			StdDraw.show(10);
			
			
			paint();
			arrow(height);
			if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)){
				//Checkout the height to checkout the chosen option
				if (height%6==0){
					//return to game
					
					break;
				}
				else if(height%6==1){
					//Life is chosen
					if (Globals.money>=price){
						//Enough money to buy in
						Globals.life++;
						Globals.money=Globals.money-price;
					}
					else JOptionPane.showMessageDialog(null, "Du hast zu wenig Geld.");
					
				}
				else if (height%6==2){
					//Health is chosen
					if (Globals.health<100){
						if (Globals.money>=price){
							Globals.health=Math.min(100, Globals.health+20) ; //100% is the max
							Globals.money=Globals.money-price;
						}
						else JOptionPane.showMessageDialog(null, "Du hast zu wenig Geld.");
					}
					else JOptionPane.showMessageDialog(null, "Du hast genug Gesundheit.");
					
				}
				else if (height%6==3){
					//Magician is chosen
					if (Globals.money>=price ){
						//Enough money to buy in
						Globals.magician++;
						Globals.money=Globals.money-price;
					}
					else JOptionPane.showMessageDialog(null, "Du hast zu wenig Geld.");
				}
				else if (height%6==4){
					//Weapon is chosen
					if (Globals.money>=price ){
						//Enough money to buy in
						Globals.weapon++;
						Globals.money=Globals.money-price;
					}
					else JOptionPane.showMessageDialog(null, "Du hast zu wenig Geld.");
				}
				else if (height%6==5){
					//Stop is chosen
					if (Globals.money>=price ){
						//Enough money to buy in
						Globals.stop++;
						Globals.money=Globals.money-price;
					}
					else JOptionPane.showMessageDialog(null, "Du hast zu wenig Geld.");
				}
				

			}
				
			if (StdDraw.isKeyPressed(KeyEvent.VK_UP)){
				if(height%6==1){}
				else{
					height--;}
				
			}
			else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)){
				if(height%6==0){}
				else{
				height++;}
			}
			Thread.sleep(100);
			
		}
		
	}

}

