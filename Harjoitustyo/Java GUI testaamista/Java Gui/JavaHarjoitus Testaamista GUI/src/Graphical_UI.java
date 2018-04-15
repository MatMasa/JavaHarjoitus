import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphical_UI extends JFrame {

	public Graphical_UI() {
		initUI(); 
	
	
	
	
	}
	// Metodi Ikkunan luontiin (Nimi, Koko, aloitus positio jne)
	public final void initUI() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		panel.setLayout(null);
		
		JButton LopetusNappula = new JButton("Lopeta"); // Luo Napin jonka avulla saadaan ohjelma suljettua
								// x ja y akseli. T‰m‰n j‰lkeen m‰‰ritell‰‰n nappulan dimensiot leveys ja korkeus.
		LopetusNappula.setBounds(200,375,80,30);
		LopetusNappula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) { // Tekee actionin jonka avulla ohjelma sulkeutuu
				System.exit(0);
			}
		
		});
		
		panel.add(LopetusNappula);
		
		setTitle("Laskin");
		setSize(300,450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Ohjelman sulkemista varten (rasti oikea yl‰kulma)
	}
	
	
	public static void main(String[] args) {
		Graphical_UI ex = new Graphical_UI();
		ex.setVisible(true);

	}

}
