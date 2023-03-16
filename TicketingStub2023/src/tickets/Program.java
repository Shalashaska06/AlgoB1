package tickets;

import javax.swing.JFrame;

import model.*;
import view.TicketingView;


/**
 * 
 * @author C. Mathy
 * @version 1.0
 */
public class Program  {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }

			private void createAndShowGUI() {
				var mainWindow = new JFrame("Ticketing");
				mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainWindow.setContentPane(new TicketingView(new PriceCalculator()));
				mainWindow.setSize(400, 350);
				mainWindow.setVisible(true);
				
			}
        });
    }
    
}
