import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Panel extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	JLabel label;
    JPanel panel;
	JButton start;
	JButton end; 	
	
	public Panel(){
        this.setTitle("Menue");
        this.setSize(400, 200);
        panel = new JPanel();
 
        // Leeres JLabel-Objekt wird erzeugt
        label = new JLabel();
 
       end=new JButton("Beenden");
       start = new JButton("Start");
 
        //Buttons werden dem Listener zugeordnet
        start.addActionListener(this);
        end.addActionListener(this);
        
 
        //Buttons werden dem JPanel hinzugefügt
        panel.add(start);
        panel.add(end);
       
 
        //JLabel wird dem Panel hinzugefügt
        panel.add(label);
        this.add(panel);
        
        
        start.addActionListener(new ActionListener() {

			@Override	// initiate the game
			public void actionPerformed(ActionEvent arg0) {
				//Dungeon.initGame();
			}
		});
        
    	end.addActionListener(new ActionListener() {

			@Override	// terminate the program
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
    	});
    	
        
    }
 
    public static void main(String[] args)
    {
        // Ein neues Objekt der Klasse BeispielListener wird erzeugt
        // und sichtbar gemacht
        Panel bl = new Panel();
        bl.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
 
       
        
    }
