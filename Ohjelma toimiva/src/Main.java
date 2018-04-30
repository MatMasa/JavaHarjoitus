import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.GridLayout;


public class Main extends JFrame {
	private static final Scanner lukija = new Scanner (System.in);
	private byte Laskenta;
	private double LaskentaNumero1 =0;
	private double LaskentaNumero2 =0;
	
	private JTextField kentta = new JTextField("0");
	
	
	public Main() {
		
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
	
	JButton AJako = new JButton("÷");
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
	
	
	JButton ABack = new JButton("<<<");
	Backspace Back = new Backspace();
	ABack.addActionListener(Back);
	
	// Tyjhä Nappi jotta saadaan myöhemmin Gridi asennoitua oikein
	JButton ATyhja = new JButton("?");
	JButton ATyhja1 = new JButton();
	JButton ATyhja2 = new JButton();
	
	
	// ---------- Luo Laskimelle laskenta kentän ja antaa sille määritykset kuten sen koon, onko se muokattavissa suoraan jne
	kentta = new JTextField();
	kentta.setPreferredSize(new Dimension(300,30));
	kentta.setBackground(Color.WHITE);
	kentta.setEditable(false);
	kentta.setHorizontalAlignment(4);
	
		
	
	
	
	JPanel Numerot = new JPanel(new GridLayout(4,5)); //---- Määrittää 4x5 Gridinn minkä mukaan yllä olevat nappulat on järjestetty laskimeen
	Numerot.setPreferredSize(new Dimension(300,250)); // ------ Määritää Gridin Dimensiot (Näppäin osion koon siis)
	
	Numerot.add(AC);  Numerot.add(A7); Numerot.add(A8); Numerot.add(A9); Numerot.add(AKerto);
	
	Numerot.add(ATyhja1); Numerot.add(A4); Numerot.add(A5); Numerot.add(A6); Numerot.add(AMiinus);
	
	Numerot.add(ATyhja2);  Numerot.add(A1); Numerot.add(A2); Numerot.add(A3); Numerot.add(APlussa);
	
	
	Numerot.add(ABack); Numerot.add(ATyhja); Numerot.add(A0);  Numerot.add(AJako); Numerot.add(AYhteen);
	
	
	
	JPanel PaaPanel = new JPanel(); // -- Pääpaneeli Joka määrittää laskimen osien lopulliset paikat Graffisessa liittymässä (kentta ja Numerot)
	PaaPanel.setLayout(new BoxLayout(PaaPanel, BoxLayout.Y_AXIS));
		PaaPanel.add(kentta);
		PaaPanel.add(Numerot);
	
		// ------- Alla on komennot jotka määrittävät laskimen Alkuperäisen ikkunan koon ja tuo muut vaadittavat toiminnot kuten laskimen nappulat
		add(PaaPanel);	
		setTitle("Laskin");
		setSize(300,425);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Ohjelman sulkemista varten (rasti oikea yläkulma)
		

	
}
	
	
	
	public static void main(String[] args) {

		
		info(true); // Ekalla suorituskerralla (true) tulostaa ohjelman ohjeet, muuten (false) näyttää tietoja ohjelmasta
		mainMenu();
		

	}
	
	
//Ohjelman valikot, joiden kautta käytetään ominaisuuksia:	
	
	// Päävalikko, josta siirrytään muihin alavalikkoihin:
	public static void mainMenu() {
		java.util.Date date = new java.util.Date();
		
		try {
			int valinta = intSyote("\nPäävalikko:\n1. Laskin 2. Muuntaja 3. Kello \n9. Tietoa ohjelmasta  0. Sulje ohjelma: ");
			
			if (valinta==1) {
				Main ikkuna = new Main();
				ikkuna.setVisible(true);
				pl("Graaffinen laskin on käynnistetty. Katso alapalkki!");
				mainMenu();
			// tähän tulee laskimen "laukaisin"
			}
				
			else if (valinta==2) {
				muuntajaMenu();
			}
			
			else if (valinta==3) {
				System.out.println(date);
				mainMenu();
			}
			
			else if (valinta==9) 
				info(false);
			
				
			else if (valinta==0)
				lopetus();
		
			else 
				mainMenu();
			
		}
		catch(Exception e) { // Geneerinen, kattaa kaikki virhetilanteet ja suoritetaan jos ylemmät virheviestit ei kattanut virhettä.
			pl("Virheellinen syöte. Syötä pelkästään kokonaisluku!");
			pl("Virhekoodi: "+e);
			
		}
		

	}
	
	//muuntajan valikko: 
	
	public static double muuntajaMenu() {
		double vastaus=0; int suunta=0,tyyppi;
		int valinta = intSyote("1. pituus 2. massa  \n5. Takaisin päävalikkoon, 0. Sulje ohjelma: ");
		if (valinta==1) {
			tyyppi=intSyote("1. Metri(m)<->jalka(f) 2. kilometrit(km)<->mailit(mi) 5. Päävalikkoon");
			if (tyyppi==1) {
				suunta= intSyote("1. Metrit jaloiksi 2. jalat metreiksi 5. takaisin päävalikkoon 0. Lopetus");
				if (suunta==5)
					mainMenu();
				else if(suunta==0)
					lopetus();
			}
				
				

			else if (tyyppi==2) {
				suunta= intSyote("1. kilometrit maileiksi 2. mailit kilometreiksi 5. Päävalikko: ");
				if (suunta==5)
					mainMenu();
				else if(suunta==0)
					lopetus();
			}
				
			
			
			else if(tyyppi==0)
				lopetus();
			
			else if(tyyppi==5)
				mainMenu();
			
			
			
			
			pituusLasku(tyyppi,suunta);
		}
		
		else if(valinta==5) {
			pl("Siirrytään päävalikkoon...");
			mainMenu();
		}
			else if(valinta==0)
				lopetus();
			
		return vastaus;
	}
	
	
// Laskutomitukset: 
	
	public static void pituusLasku(int tyyppi, int suunta) {
		double tulos=0;
		
		do {

			double A= doubleSyote("Syötä muutettava: ");
			if(tyyppi==1) {
				if(suunta==1) {
					pl("Metrit jaloiksi");
					tulos=(A/0.3048);
					System.out.print(A+" ");
					pf("metriä on %.3f",tulos);
					p(" Jalkaa\n");
					jatketaanko();
				}
				
				else if(suunta==2) {
					pl("Jalat metreiksi ");
					tulos=(A/3.2808);
					pf("Jalkaa on %.3f",tulos);
					pl(" metriä\n");
					jatketaanko();
				}
				
				else if(suunta==5)
					mainMenu();
							
			}
			
			else if (tyyppi==2) {
				if(suunta==1) {
					pl("kilometrit maileiksi");
					tulos= A * 0.62137;
					System.out.print(A);
					pf(" Kilometriä on %.3f",tulos);
					pl(" Mailia");
					jatketaanko();
				}
				else if (suunta==2) {
					pl("Mailit kilometreiksi");
					tulos= 1.609344*A;
					pf("tulos on %.3f",tulos);
					jatketaanko();
				}
				
				else if(suunta==5)
					mainMenu();
			}
			
		}
		while (jatketaanko());
			muuntajaMenu();
	}
	
	public static void massaLasku(int tyyppi, int suunta) {
		double tulos;
		
	}
	public static boolean jatketaanko() {
		int jatketaanko=intSyote("Haluatko muuntaa uudestaan? 1=K 2=EI 0= sulje ohjelma: ");
		if (jatketaanko == 1 )
			return true;
		
		else if(jatketaanko==0) {
			lopetus();
			return false;
		}
		
		else
			return false;
	}
	
	
	
//Ohjemoduuli. näyttää ohjelman käynnistyessä käyttöohjeet:
	public static void info(boolean o)  {
		
		if(o) {
			pl("Tiimi-10 ohjelmaportaali  (V1.01b)\n");
			pl("Navigointi onnistuu näppäilemällä haluttua ominaisuutta vastaavaa numeronäppäintä ja painamalla enter -näppäintä.");
			pl("Ohjelman suorituksen pystyy keskeyttämään koska tahansa syöttämällä numero 0 ja painamalla enter näppäintä.");
			
		}
		// kun käyttäjä käynnistää infomoduulin itse, näytetään vain tiedot ohjelmasta
		else {

			p("Tiimi-10 ohjelmaportaali  (V1.01b, (C) 2018) Tekijät: Jan Stockfelt, Matti Wallenius");
			mainMenu();
		}
	}
	public static void lopetus() {
		pl("Sammutetaan ohjelma...");
		System.exit(0);
	}
	
// Käyttäjän syötteen kysyminen
	
	// kokonaisluku:
	public static int intSyote(String teksti) {
		pl(teksti);
		int v = lukija.nextInt();
		return  v;
	}
	
	// Desimaaliluku:	
	public static double doubleSyote(String teksti) {
		pl(teksti);
		double v = lukija.nextDouble();
		return  v;
	}

	
// Tekstikomentojen lyhennykset
	
	//teksti samalle riville:
	public static void p(String teksti) {
		System.out.print(teksti);
	}
	//teksti eri riveille:
	public static void pl(String teksti) {
		System.out.println(teksti);
	}
	// Desimaalilukujen tulostus:
	public static void pf(String teksti, double parametri) {
		System.out.printf(teksti, parametri);
	}
	

	private class NumeroNappienToiminnot implements ActionListener {

		private String y ;
		
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


} // Sulkee ohjelman mainin 