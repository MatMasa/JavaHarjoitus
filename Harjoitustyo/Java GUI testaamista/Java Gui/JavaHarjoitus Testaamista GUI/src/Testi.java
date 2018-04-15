
import java.awt.Container;
import java.util.*;
import javax.swing.*;

public class Testi extends JFrame {
	
	
	List<JButton> buttonList = new ArrayList<JButton>();
	for(int i = 0; i < 8; i++) {
	    JButton button = new JButton();
	    buttonList.add(button);
	    
	}
	
	


	
	
	public static void main(String[] args) {
	Testi ikkuna = new Testi();
		ikkuna.setTitle("Paneeleja");
		ikkuna.pack();
		ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ikkuna.setVisible(true);
		
	
}
	
}



	



