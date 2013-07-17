import javax.swing.JFrame; //imports JFrame library
import javax.swing.JButton; //imports JButton library
import java.awt.GridLayout; //imports GridLayout library
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
*Hier gib'ts eine Karte mit JButtons(21x21), wo man zeichen kann, in welchem Platz sollen die Waende, Boss etc. stehen.
*/

public class LevelEditor extends JFrame implements ActionListener{
 
       /** * */
	private static final long serialVersionUID = 1L;
		JFrame frame=new JFrame(); //creates frame
        static JButton[][] grid; //names the grid of buttons
        static String [][] karte;
        static String sig;
        static String empty = "      ";
		
		
        public LevelEditor(){ //constructor
                frame.setLayout(new GridLayout(21,21)); //set layout
                grid=new JButton[21][21]; //allocate the size of grid
                for(int y=0; y<21; y++){
                        for(int x=0; x<21; x++){
                                grid[x][y]=new JButton("      "); //creates new button 
                                frame.add(grid[x][y]); //adds button to grid
                                grid[x][y].addActionListener(this); 
                                grid(x,y);
                                
                        }
                }
   
                
                frame.setTitle("Level Editor");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack(); //sets appropriate size for frame
                frame.setVisible(true); //makes frame visible

					
           }
        
      
            
		public static String[][] check(){
			
			for(int j=0; j<21;j++) 
			{
				for(int i=0;i<21;i++)
				{
					
					if (grid[i][j].getText() == "x") karte[i][j] ="x";
					if (grid[i][j].getText() == "s") karte[i][j] ="s";
				    if (grid[i][j].getText() == "z") karte[i][j] ="z";
				    if (grid[i][j].getText() == "B") karte[i][j] ="B";
				    if (grid[i][j].getText() == "NP")karte[i][j] ="NP";
				    if (grid[i][j].getText() == "q") karte[i][j] ="q";
				    if (grid[i][j].getText() == "empty") karte[i][j] =" ";
			     
			
			}
			}
			return karte;
			
		}
		

		public static void action(String sign) {
			// TODO Auto-generated method stub
			
			sig = sign;
			
		}
		

		
		
		public void grid(final int i, final int j){
			
			grid[i][j].addActionListener(
            	    new ActionListener() {
            	        public void actionPerformed(ActionEvent e) {
            	        	if (grid[i][j].getText() == sig)  
                          		
                      		{grid[i][j].setText(empty); }
                        	else 
                      		{ grid[i][j].setText(sig); }
            	         	        
            	        }
            	    	
            	    });
			
  
		}

		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	

}