import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Laskin extends JFrame {
// Laskimen numero näppäimet alla

	
	private JButton A1 = new JButton("1");
	// testaa action listeneriä, malli, koita saada aikaan 1+1 = 2 näkymän ja näppäinten avulla
	
	private JButton A2 = new JButton("2");
	private JButton A3 = new JButton("3");
	private JButton A4 = new JButton("4");
	private JButton A5 = new JButton("5");
	private JButton A6 = new JButton("6");
	private JButton A7 = new JButton("7");
	private JButton A8 = new JButton("8");
	private JButton A9 = new JButton("9");
	private JButton A0 = new JButton("0");
	
	
	
	// Laskimen kerto,jako,plus ja miinus näppäimet
	private JButton APlussa = new JButton("+");
	private JButton AMiinus = new JButton("-");
	private JButton AKerto = new JButton("*");
	private JButton AJako = new JButton("jako");
	private JButton AYhteen = new JButton("=");
	// Laskimen sulkeet ja , toiminnot
	private JButton ASulku1 = new JButton("(");
	private JButton ASulku2 = new JButton(")");
	private JButton APilkku = new JButton(",");
	private JButton APotenssi2 = new JButton("x2");
	private JButton APotenssiX = new JButton("xY");
	private JButton ASIN = new JButton("sin");
	private JButton ACOS = new JButton("cos");
	private JButton ATAN = new JButton("tan");
	private JButton ANelio = new JButton("V");
	private JButton AKymmenenX = new JButton("10x");
	private JButton ALog = new JButton("log");
	private JButton AExp = new JButton("Exp");
	private JButton AMod = new JButton("Mod");
	private JButton AYla = new JButton("ylos");
	private JButton ACE = new JButton("CE");
	private JButton AC = new JButton("C");
	private JButton ABack = new JButton("BackSpace");
	private JButton APii = new JButton("pii");
	private JButton AFactorial = new JButton("n!");
	private JButton Aplusmiinus = new JButton("plusmiinus");
	
	
	// Laskimen laskukenttä
	private JTextField kentta = new JTextField("0");
	
	// Laskimen
	
			
public Laskin() {
	
	
	JPanel Numerot = new JPanel(new GridLayout(7,5));
	Numerot.add(APotenssi2); Numerot.add(APotenssiX); Numerot.add(ASIN); Numerot.add(ACOS); Numerot.add(ATAN);
	Numerot.add(ANelio); Numerot.add(AKymmenenX); Numerot.add(ALog); Numerot.add(AExp); Numerot.add(AMod);
	Numerot.add(AYla); Numerot.add(ACE); Numerot.add(AC); Numerot.add(ABack); Numerot.add(AJako);
	Numerot.add(APii); Numerot.add(A7); Numerot.add(A8); Numerot.add(A9); Numerot.add(AKerto);
	Numerot.add(AFactorial); Numerot.add(A4); Numerot.add(A5); Numerot.add(A6); Numerot.add(AMiinus);
	Numerot.add(Aplusmiinus); Numerot.add(A1); Numerot.add(A2); Numerot.add(A3); Numerot.add(APlussa);
	Numerot.add(ASulku1); Numerot.add(ASulku2); Numerot.add(A0); Numerot.add(APilkku); Numerot.add(AYhteen);
	
	
	/*
	Numerot.add(A7); Numerot.add(A8); Numerot.add(A9);
	Numerot.add(A4); Numerot.add(A5); Numerot.add(A6);
	Numerot.add(A1); Numerot.add(A2); Numerot.add(A3);
	*/

	
	this.setLayout(new GridLayout(0,1));
	this.add("Top", kentta);
	this.add("", Numerot);
	
	
	setTitle("Laskin");
	setSize(325,450);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE); // Ohjelman sulkemista varten (rasti oikea yläkulma)
}
	
	

	
	
	public static void main(String[] args) {
		
		Laskin ikkuna = new Laskin();
		ikkuna.setVisible(true);

	}

}
