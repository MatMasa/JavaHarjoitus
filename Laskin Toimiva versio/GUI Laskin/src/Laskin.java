import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Laskin extends JFrame {

	private byte Laskenta;
	private double LaskentaNumero1 =0;
	private double LaskentaNumero2 =0;
	
	
	
	// ------------ Laskimen laskukenttä
	private JTextField kentta = new JTextField("0");
	
	
			
public Laskin() {
	
		// ------ Numero Näppäimet Alla
	JButton A1 = new JButton("1");
	NumeroNappienToiminnot Ykkonen = new NumeroNappienToiminnot(A1);
	A1.addActionListener(Ykkonen);
	
	JButton A2 = new JButton("2");
	NumeroNappienToiminnot Kakkonen = new NumeroNappienToiminnot(A2);
	A2.addActionListener(Kakkonen);
	
	JButton A3 = new JButton("3");
	NumeroNappienToiminnot Kolmonen = new NumeroNappienToiminnot(A2);
	A3.addActionListener(Kolmonen);
	
	JButton A4 = new JButton("4");
	NumeroNappienToiminnot Nelonen = new NumeroNappienToiminnot(A4);
	A4.addActionListener(Nelonen);
	
	JButton A5 = new JButton("5");
	NumeroNappienToiminnot Viitonen = new NumeroNappienToiminnot(A5);
	A5.addActionListener(Viitonen);
	
	JButton A6 = new JButton("6");
	NumeroNappienToiminnot Kuutonen = new NumeroNappienToiminnot(A6);
	A6.addActionListener(Kuutonen);
	
	JButton A7 = new JButton("7");
	NumeroNappienToiminnot Seiska = new NumeroNappienToiminnot(A7);
	A7.addActionListener(Seiska);
	
	JButton A8 = new JButton("8");
	NumeroNappienToiminnot Kahdeksan = new NumeroNappienToiminnot(A8);
	A8.addActionListener(Kahdeksan);
	
	JButton A9 = new JButton("9");
	NumeroNappienToiminnot Yhdeksan = new NumeroNappienToiminnot(A9);
	A9.addActionListener(Yhdeksan);
	
	JButton A0 = new JButton("0");
	NumeroNappienToiminnot Nolla = new NumeroNappienToiminnot(A0);
	A0.addActionListener(Nolla);
	
		
		// ----------------- Laskimen kerto,jako,plus ja miinus näppäimet
	
	
	JButton APlussa = new JButton("+");
	YhteenLasku yhteen = new YhteenLasku();
	APlussa.addActionListener(yhteen);
	
	
	JButton AMiinus = new JButton("-");
	VahennysLasku miinus = new VahennysLasku();
	AMiinus.addActionListener(miinus);
	
	JButton AKerto = new JButton("*");
	KertoLasku kerto = new KertoLasku();
	AKerto.addActionListener(kerto);
	
	JButton AJako = new JButton("/");
	JakoLasku jako = new JakoLasku();
	AJako.addActionListener(jako);
	
	JButton AYhteen = new JButton("=");
	TulosLasku tulos = new TulosLasku();
	AYhteen.addActionListener(tulos);
		
	
	
	
	// ------------------ Laskimen sulkeet ja , toiminnot
	
	
	JButton APilkku = new JButton(",");
	
	JButton ACE = new JButton("CE");
	
	
	JButton AC = new JButton("C");
	Cnappi C = new Cnappi();
	AC.addActionListener(C);
	
	
	JButton ABack = new JButton("BackSpace");
	Backspace Back = new Backspace();
	ABack.addActionListener(Back);
	
	// Tyjhä Nappi jotta saadaan myöhemmin Gridi asennoitua oikein
	JButton ATyhja = new JButton();
	
	
	
	// ---------- Luo Laskimelle laskenta kentän ja antaa sille määritykset kuten sen koon, onko se muokattavissa suoraan jne
	kentta = new JTextField();
	kentta.setPreferredSize(new Dimension(300,30));
	kentta.setBackground(Color.WHITE);
	kentta.setEditable(false);
	kentta.setHorizontalAlignment(4);
	
		
	
	
	
	JPanel Numerot = new JPanel(new GridLayout(4,5)); //---- Määrittää 4x5 Gridinn minkä mukaan yllä olevat nappulat on järjestetty laskimeen
	Numerot.setPreferredSize(new Dimension(300,250)); // ------ Määritää Gridin Dimensiot (Näppäin osion koon siis)
	Numerot.add(ACE); Numerot.add(A7); Numerot.add(A8); Numerot.add(A9); Numerot.add(AKerto);
	Numerot.add(AC); Numerot.add(A4); Numerot.add(A5); Numerot.add(A6); Numerot.add(AMiinus);
	Numerot.add(ABack); Numerot.add(A1); Numerot.add(A2); Numerot.add(A3); Numerot.add(APlussa);
	Numerot.add(ATyhja); Numerot.add(APilkku); Numerot.add(A0); Numerot.add(AJako); Numerot.add(AYhteen);
	
	
	
	JPanel PaaPanel = new JPanel(); // -- Pääpaneeli Joka määrittää laskimen osien lopulliset paikat Graffisessa liittymässä (kentta ja Numerot)
	PaaPanel.setLayout(new BoxLayout(PaaPanel, BoxLayout.Y_AXIS));
		PaaPanel.add(kentta);
		PaaPanel.add(Numerot);
	
	// ------- Alla on komennot jotka määrittävät laskimen Alkuperäisen ikkunan koon ja tuo muut vaadittavat toiminnot kuten laskimen nappulat
	add(PaaPanel);	
	setTitle("Laskin");
	setSize(300,425);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE); // Ohjelman sulkemista varten (rasti oikea yläkulma)
}
	
	

	
	public static void main(String[] args) {
		
		Laskin ikkuna = new Laskin();
		ikkuna.setVisible(true);
		

	}
// ------------ Alla Kaikki laskenta metodit ja mut tarvittavat Funktiot jotta laskin tekee juuri sen mitä haluamme.

	private class NumeroNappienToiminnot implements ActionListener {

		private String y;
		
		public NumeroNappienToiminnot(JButton x) {
			this.y = x.getText();
			
		}
		public void actionPerformed(ActionEvent e) {
			if (!kentta.getText().equals("0")) {
				kentta.setText(kentta.getText() +y);
			} else {
				kentta.setText("");
				actionPerformed(e);
			}
		}
		
	} // ----------- NumeroNappienToiminnot Sulut
	private class Cnappi implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			kentta.setText("0");
			LaskentaNumero1 = 0;
			LaskentaNumero2 = 0;
			Laskenta = 0;
			
			}
		
	}
	private class Backspace implements ActionListener {

		String x;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			if(kentta.getText().length() > 0) {
				
				StringBuilder rakenne = new StringBuilder(kentta.getText());
				rakenne.deleteCharAt(kentta.getText().length() -1);
				x = rakenne.toString();
				
				}
					kentta.setText(x);
		}
		
	}
	private class YhteenLasku implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (LaskentaNumero1 == 0) {
				LaskentaNumero1 = Double.parseDouble(kentta.getText());
				kentta.setText("");
			} else {
				LaskentaNumero2 = Double.parseDouble(kentta.getText());
				kentta.setText("");
			}
			Laskenta = 1;
		}
		
	}
	private class VahennysLasku implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (LaskentaNumero1 == 0) {
				LaskentaNumero1 = Double.parseDouble(kentta.getText());
				kentta.setText("");
			} else {
				LaskentaNumero2 = Double.parseDouble(kentta.getText());
				kentta.setText("");
			}
			Laskenta = 2;
			
		}
		
	}
	private class KertoLasku implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (LaskentaNumero1 == 0) {
				LaskentaNumero1 = Double.parseDouble(kentta.getText());
				kentta.setText("");
			} else {
				LaskentaNumero2 = Double.parseDouble(kentta.getText());
				kentta.setText("");
			}
			Laskenta = 3;
			
		}
	}
	private class JakoLasku implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (LaskentaNumero1 == 0) {
				LaskentaNumero1 = Double.parseDouble(kentta.getText());
				kentta.setText("");
			} else {
				LaskentaNumero2 = Double.parseDouble(kentta.getText());
				kentta.setText("");
			}
			Laskenta = 4;
			
		}
	}
	private class TulosLasku implements ActionListener {
		 @Override
	        public void actionPerformed(ActionEvent e) {
	            LaskentaNumero2 = Double.parseDouble(kentta.getText());
	 
	            if (Laskenta == 4) {
	                kentta.setText(Double.toString((Math.round((LaskentaNumero1 / LaskentaNumero2) * 100)) / 100));
	            } else if (Laskenta == 3) {
	                kentta.setText(Double.toString(LaskentaNumero1 * LaskentaNumero2));
	            } else if (Laskenta == 1) {
	                kentta.setText(Double.toString(LaskentaNumero1 + LaskentaNumero2));
	            } else if (Laskenta == 2) {
	                kentta.setText(Double.toString(LaskentaNumero1 - LaskentaNumero2));
	            } else {
	                kentta.setText(String.valueOf(LaskentaNumero1));
	            }
	                LaskentaNumero1 = Double.parseDouble(kentta.getText());
	        }
	}
	
	// JakoLasku = 4, KertoLasku = 3, VahennysLasku = 2, YhteenLasku = 1,
	
	
	
	/*
	private class CalculationListener implements ActionListener {

		private final CalcFunction operation;
		
		public CalculationListener(CalcFunction function) {
			this.operation = function;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (LaskentaNumero1 == 0) {
				LaskentaNumero1 = Double.parseDouble(kentta.getText());
				kentta.setText("");
			} else {
				LaskentaNumero2 = Double.parseDouble(kentta.getText());
				kentta.setText("");
			}
			
		}
		
	}
*/
}
