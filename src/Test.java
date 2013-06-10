import java.awt.event.KeyEvent;

public class Test {
	
	static double shop_x=0.8;
    static double shop_y=0.8;
    
    static double weapon_x=0.3;
    static double weapon_y=0.7;
    
    static boolean draw_weapon = true;
	
        static void room()
        {
                //StdDraw.setCanvasSize(512,512);

                   StdDraw.setPenColor(StdDraw.BLACK);

                   StdDraw.setPenRadius(0.01);
                   StdDraw.picture(.5, .5, "f95.png", 1, 1);

                   //Paint walls:
                   StdDraw.line(0, 0, 0, 1);
                   StdDraw.line(0, 0,1,0);
                   StdDraw.line(0,1,1,1);
                   StdDraw.line(1,0,1,1);
                   
                   //paint shop symbol
                   StdDraw.picture(shop_x, shop_y, "shop.png",.05,.05);
                   
                   //paint weapon symbol
                   if (draw_weapon == true) StdDraw.picture(weapon_x, weapon_y, "bomb.png", .05,.05);
                   
                   //Paint InformationBar
                   InformationBar.main(null);

        }

        static void player()
        {
        	//Paint player at his position
        	StdDraw.picture(Globals.player.x, Globals.player.y,"pi.png",.08,.08);
        }
        
        static void enemy()
        {
        	//Paint enemy at his position
        	StdDraw.setPenColor(StdDraw.YELLOW);
            StdDraw.filledSquare(Globals.enemy.x, Globals.enemy.y,0.01);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.square(Globals.enemy.x, Globals.enemy.y,0.01);
        	
        }
        
        
        static void isvalid(double x, double y) throws InterruptedException{
        	//check out if new position (x,y) is valid, i.e. is wall or enemy touched
        	
        	//checkout wall:
        	if (x<=0.05 || y<=0.05 || x>=0.95 || y>=0.95)
        	{
        		//no move possible -> nothing to update
        		StdDraw.filledCircle(1, 1, 0.05);
        	}
        	
        	//checkout enemy:
        	else if(Math.abs(x-Globals.enemy.x)<=0.05 && Math.abs(y-Globals.enemy.y)<=0.05) 
        	{
        		//enemy touched
        		Damages.setDamages();
        		Globals.player.x=0.2;
        		Globals.player.y=0.2;
        		
        	}
        	
        	//checkout shop:
        	else if(Math.abs(x-shop_x)<=0.05 && Math.abs(y-shop_y)<=0.05)
        	{
        		Shop.main(null);
        	}
        	
        	else if(Math.abs(x-weapon_x)<=0.05 && Math.abs(y-weapon_y)<=0.05)
        	{
        		if (draw_weapon == true) Globals.weapon++;
        		draw_weapon = false;
        		Globals.player.x= x;
        		Globals.player.y= y;
        	}
        	
        	else {
        		//update position
        		Globals.player.x= x;
        		Globals.player.y= y;
        	}
        }

        
        

   public static void main(String[] args) throws InterruptedException {
           {

        	   
        	   StdDraw.clear();
                  //Paint room
                  room();

                  //Paint player&enemy
                   player();
                   enemy();
                   
                  //Variable for checking new position
                  double x_neu=Globals.player.x;
                  double y_neu=Globals.player.y;

                   while (true)
                   {
                	   //Buffering:	
                	   StdDraw.show(10);
                             
                	   

                	   //Move Player:
                           if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) //Move Left
                           {

                                   //New position:
                                   x_neu = Globals.player.x-Globals.player.step;
                                   y_neu=Globals.player.y;

                                   
                           }
                           else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) //Move right
                           {

                                 //new position:
                                   x_neu = Globals.player.x+Globals.player.step;
                                   y_neu = Globals.player.y;
                                 
                           }
                           else if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) //Move up
                           {
                                 //new position:
                                   x_neu = Globals.player.x;
                                   y_neu = Globals.player.y+Globals.player.step;
                                
                           }
                           else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) //Move Down
                           {
                                 //new position:
                                   x_neu = Globals.player.x;
                                   y_neu = Globals.player.y-Globals.player.step;

                           }
                           if(StdDraw.isKeyPressed(KeyEvent.VK_S)) 
                           {
                        	   Stop.main(null);
                        	   Thread.sleep(100);
                        	  
                        	  
                           }
                           
                           //checkout if move is valid
                           isvalid(x_neu,y_neu);
                          
                           //move enemy:
                           if (Globals.enemy.move)
                           {
                        	   Globals.enemy.x=(Globals.enemy.x+Globals.enemy.step)%1;
                           }
                           
                           //repaint
                           StdDraw.clear();
                           room();
                           player();
                           enemy();
                          
                   
                	   }
                   
                   



           }





        /**
* @param args
*/


}
}