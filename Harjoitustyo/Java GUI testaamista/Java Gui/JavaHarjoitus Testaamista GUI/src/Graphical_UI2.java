import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphical_UI2 extends JFrame {
	
	// Kayttiskentat
	
	private JTextField kentta;
	private JButton nappula;
	private JTextArea alue;
	private JLabel otsikko;
	private JTextField viestikentta;
	
	public Graphical_UI2() {
		
		kentta = new JTextField("Kentta");
		nappula = new JButton("Nappula");
		alue = new JTextArea(3,7);
		otsikko = new JLabel("Otsikko");
		
		viestikentta = new JTextField("Viestikenttä");
		viestikentta.setEditable(false);
		
		setLayout(new FlowLayout());
		
		add(kentta);
	    add(nappula);
	    add(alue);
	    add(otsikko);
	    add(viestikentta);
		
	}
	
	public static void main(String[] args) {
		
		Graphical_UI2 ikkuna = new Graphical_UI2();
		ikkuna.setTitle("Laskin");
	    ikkuna.pack();
	    ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    ikkuna.setVisible(true);

	}

}
