import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;


public class Main extends JFrame {
	private static final Scanner lukija = new Scanner (System.in);
	
	private double LaskentaNumero1 ;
	private double LaskentaNumero2 ;
	private JTextField kentta = new JTextField("");
	public enum LaskentaFunktio {
		YHTEEN, VAHENNYS, KERTO, JAKO;
	}
	private LaskentaFunktio Laskenta;
	
	
	public  Main() {
		
		
		JPanel NumeroNappiPaneeli = new JPanel(new GridLayout(4,4));
		NumeroNappiPaneeli.setPreferredSize(new Dimension(100, 50));
		
		/**
		 *  Määritämme alle String[][] NumeroNappiTeksti tauluun Laskimen näppäimistöä varten tarvittavat Numerot ja erikoismerkit.
		 *  Tämän Jälkeen For loopin avulla luodaan jokaiselle merkille oma JButton, ActionListener ja asetetaan ne omaksi paneeliksi - 
		 *  myöhempää asettelua varten. 
		 *  Tässä vaiheessa luodaan myös Napeille oma fontti.
		 *  @author Jan
		 */
		
		try {
		String[][] NumeroNappiTeksti = {
				{"C","7","8","9","*"},
				{"","4","5","6","-"},
				{"","1","2","3","+"},
				{"<<","","0","\u00F7","="}
		};
		

		
		
		final Font Nappula_Fontti = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		
		for (int i=0; i < NumeroNappiTeksti.length; i++) {
			for(int j=0; j < NumeroNappiTeksti[i].length; j++) {
				JButton Nappulat = new JButton(NumeroNappiTeksti[i][j]);
				Nappulat.setFont(Nappula_Fontti);
				NumeroNappiPaneeli.add(Nappulat);
				
				if(NumeroNappiTeksti[i][j].equals("C")) {
					
					Nappulat.addActionListener(new Cnappi());
					
				} else if(NumeroNappiTeksti[i][j].equals("<<")) {
					
					Nappulat.addActionListener(new Backspace());
				
				}else if(NumeroNappiTeksti[i][j].equals("*")) {
					
					Nappulat.addActionListener(new LaskentaListener(LaskentaFunktio.KERTO));
				
				}else if (NumeroNappiTeksti[i][j].equals("-")) {
					
					Nappulat.addActionListener(new LaskentaListener(LaskentaFunktio.VAHENNYS));
				
				}else if (NumeroNappiTeksti[i][j].equals("+")) {
					
					Nappulat.addActionListener(new LaskentaListener(LaskentaFunktio.YHTEEN));
				
				}else if (NumeroNappiTeksti[i][j].equals("=")) {
					
					Nappulat.addActionListener(new TulosLasku());
				
				}else if (NumeroNappiTeksti[i][j].equals("\u00F7")) {
					
					Nappulat.addActionListener(new LaskentaListener(LaskentaFunktio.JAKO));
				
				} else {
					Nappulat.addActionListener(new NumeroNappienToiminnot(Nappulat));
				}

				
				}
		
		}
	
		}catch(Exception Laskin1) {
			pl("Ohjelman NumeroNappiTeksti taulussa tai siihen liittyvissä funktioissa on virhe");
			pl("Virhekoodi: "+Laskin1);
		}

		/**
		 *   Alla Luodaan laskimen numerokenttää varten tarvittavat määritykset(kentta = new JTextfield();), 
		 *   Kuten minkä kokoinen meidän kenttämme on, mikä on kentän taustaväri, voiko kenttää muokata suoraan
		 *   Ja Missä kohdin meidän laskimen numerot näkyvät kentällä.
		 *   
		 *   Tämän Jälkeen Määritellään JPanel PaaPanel jonka tehtävänä on hoitaa Laskimen asemmoinnin viimeiset vaiheet ja
		 *   Lopulta pistetään laskin aktiiviseksi, Määritellään ikkunan koko ja millä tavoin ohjelma sulkeutuu.
		 *   @author Jan
		 */
		kentta = new JTextField();
		kentta.setPreferredSize(new Dimension(100,75));
		kentta.setBackground(Color.WHITE);
		kentta.setEditable(false);
		kentta.setHorizontalAlignment(4);
		
			
		
		JPanel PaaPanel = new JPanel(new BorderLayout()); // -- Pääpaneeli Joka määrittää laskimen osien lopulliset paikat Graffisessa liittymässä.
			PaaPanel.add(kentta, BorderLayout.PAGE_START);
			PaaPanel.add(NumeroNappiPaneeli);
			
		
		// ------- Alla on komennot jotka määrittävät laskimen Alkuperäisen ikkunan koon ja tuo muut vaadittavat toiminnot kuten laskimen nappulat.
		add(PaaPanel);	
		setTitle("Laskin");
		setSize(315,350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Ohjelman sulkemista varten.
		

	
}
	
	/** main(String[] args) Käytetään ainoastaan käyttöohjeiden ja päävalikon aukaisuun
	 * 
	 * @param args ei mitään
	 */
	
	public static void main(String[] args) {

		
		info(true); // Ekalla suorituskerralla (true) tulostaa ohjelman ohjeet, muuten (false) näyttää tietoja ohjelmasta
		mainMenu();
		

	}
	
	
//Ohjelman valikot, joiden kautta käytetään ominaisuuksia:	
	
	/** mainMenu():Päävalikkomoduuli, josta siirrytään muihin alavalikkoihin, moduuleihin
	 * 
	 */
	public static void mainMenu() {
		java.util.Date date = new java.util.Date();
		
		try {
			int valinta = intSyote("\nPäävalikko:\n1. Laskin 2. Muuntaja 3. Kello \n9. Tietoa ohjelmasta  0. Sulje ohjelma: ");
			
			if (valinta==1) {
				Main ikkuna = new Main();
				ikkuna.setVisible(true);
				pl("Graaffinen laskin on käynnistetty. Katso alapalkki!");
				mainMenu();
			
			}
				
			else if (valinta==2) {
				muuntajaMenu();  // muuntajaValikko, josta valitaan mitä muunnetaan ja miten
			}
			
			else if (valinta==3) {
				System.out.println(date); // tulostaa ajan muodossa viikonpäivä kuukausi päivämäärä kellonaika aikavyöhyke vuosi
				mainMenu();
			}
			
			else if (valinta==9) 
				info(false); // Käynnistää infomoduulin -> näyttää ohjelman tiedot
			
				
			else if (valinta==0)
				lopetus();
		
			else 
				mainMenu();
			
		}
		catch(Exception e) { // Geneerinen, kattaa kaikki virhetilanteet ja suoritetaan jos ylemmät virheviestit ei kattanut virhettä.
			
			virheTulostus(e);   // Virheenhallintamoduuli: ilmoitus virheestä, sen tulostus ja kirjaus lokitiedostoon
			
			
		}
		

	}
	
	/** muuntajaMenu(): moduuli, jossa valitaan mitä tyyppiä muunnetaan(pituus, massa, ...), muutettava yksikkö(kilometrit, mailit) ja mihin suuntaan muutetaan(e. mailit kilometreiksi)
	* int valinta: Kysyy käyttäjältä minkä tyyppisiä arvoja muutetaan
	* int tyyppi: Kysyy, mitä muutetaan valinta muuttujan määrittämästä kategoriasta
	* int suunta: Kysyy, mitä muutetaan ja miksi
	*/
	public static void muuntajaMenu() {
		int suunta=0,tyyppi;
		try {
			int valinta = intSyote("1. pituus 2. massa  \n5. Takaisin päävalikkoon, 0. Sulje ohjelma: ");
			if (valinta==1) {
				tyyppi=intSyote("1. Metri(m)<->jalka(f) 2. kilometri(km)<->maili(mi) 5. Päävalikkoon 0. Sulje ohjelma");
				
				if (tyyppi==1) {
					suunta= intSyote("1. Metrit jaloiksi 2. jalat metreiksi 5. takaisin päävalikkoon 0. Sulje ohjelma");
					
					if (suunta==5)
						mainMenu();
					else if(suunta==0)
						lopetus();
					
					else {
						pl("Virheellinen numero!");
						muuntajaMenu();
					}
					
					
					
					pituusLasku(tyyppi,suunta);
				}
					
					
	
				else if (tyyppi==2) {
					suunta= intSyote("1. kilometrit maileiksi 2. mailit kilometreiksi 5. Päävalikko 0. Lopetus: ");
					
					if (suunta==5)
						mainMenu();
					else if(suunta==0)
						lopetus();
					
					else if (suunta==1| suunta==2)
						pituusLasku(tyyppi, suunta);
					
					else {
						p("Virheellinen numero!");
						muuntajaMenu();
					}
				}
					
				
				else if(tyyppi==0)
					lopetus();
				
				else if(tyyppi==5)
					mainMenu();
				else {
					p("Virheellinen numero!");
					muuntajaMenu();
				}
					
				
			}
			
			else if (valinta==2)
				massaLasku();
			
			else if(valinta==5) {
				pl("Siirrytään päävalikkoon...");
				mainMenu();
			}
				else if(valinta==0)
					lopetus();
			
				else
					muuntajaMenu();
				
			
		}
		catch(Exception e) {
				virheTulostus(e);
			}
				
	
	}

/** virheTulostus(Exception e) virheenhallintamoduuli, joka hallitsee suurimman osan virheistä
 * 
 * @param e Parametri suurimmalle osalle virheilmoituksia
 */
	
	public static void virheTulostus(Exception e) {
		try {
			pl("Virheellinen syöte");
			pl("Virhekoodi: "+e);
			pl("Tulostetaan tiedostoon 'virheloki.txt'");
			PrintWriter virhe = new PrintWriter("virheloki.txt");
			virhe.println(e);
			virhe.close();
				
			
	      }
	      catch (Exception ie) {
	         throw new RuntimeException("Virhelokia ei voitu kirjoittaa", ie);
	      }
	}
	
	// Laskutomitukset: 
	
	/** pituusLasku(int tyyppi, int suunta)
	 *  Pituuslaskujen laskukaavat ja laskuprosessi 
	 * @param tyyppi Mitä tyyppiä muutetetaan( Esim. kilometrejä ja maileja)
	 * @param suunta Mihin suuntaan muutetaan (esim maileja kilometreiksi tai kilometreja maileiksi
	 */
	public static void pituusLasku(int tyyppi, int suunta) {
		double tulos=0;
		
		do {
			try {

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
					
					else if(suunta== 0)
						lopetus();
				}
				else
					pituusLasku(tyyppi,suunta);
			}
			catch (Exception e) {
				virheTulostus(e);
			}
			
		}
		while (jatketaanko());
			muuntajaMenu();
	}
	
	 /** massaLasku(): Toimii samalla periaatteella kuin pituusLasku moduuli, "Ominaisuus julkaistaan versiossa v3" 
	  * 
	  */
	public static void massaLasku() {
		p("Tähän tulisi massalaskujen menu, toimii samalla tavalla kuin pituuslaskun metodit");
		mainMenu();
		
	}
	/**jatketaanko() : Kysyy käyttäjältä haluaako hän muuntaa uudestaan, palata valikkoon vai lopettaa. buginen, ilmestyy kaksi kertaa näytölle, vasta toisella kertaa hyväksyy vastauksen.
	 * 
	 * @return palauttaa True: jatketaan  laskemista samoilla muutettavilla False: Palataan muuntajavalikkoon
	 */
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
	
	
	
/** info(boolean o)
 *  Ohjelman käyttöohjeet ja tiedot ohjelmasta
 * @param o Ohjelman käynnistyessä true, eli näyttää käyttöhjeet, muuten tiedot ohjelmasta
 */
	
	
	public static void info(boolean o)  {
		
		if(o) {
			pl("Tiimi-10 ohjelmaportaali  (V2.15)\n");
			pl("Navigointi onnistuu näppäilemällä haluttua ominaisuutta vastaavaa numeronäppäintä ja painamalla enter -näppäintä.");
			pl("Ohjelman suorituksen pystyy keskeyttämään koska tahansa syöttämällä numero 0 ja painamalla enter näppäintä.");
			
		}
		// kun käyttäjä käynnistää infomoduulin itse, näytetään vain tiedot ohjelmasta
		else {

			p("Tiimi-10 ohjelmaportaali  (V2.15, (C) 2018) Tekijät: Jan Stockfelt, Matti Wallenius");
			mainMenu();
		}
	}
	/** lopetus(): lopetusmoduuli, joka ilmoittaa käyttäjälle ohjelman sammuttamisesta, ja lopettaa sen suorittamisen
	 * 
	 */
	
	 
	public static void lopetus() {
		pl("Sammutetaan ohjelma...");
		System.exit(0);
	}
	
	/**intSyote(String teksti): pyytää käyttäjältä kokonaisluvun
	 * 
	 * @param teksti mahdollistaa tekstin lisäämisen komennon sisälle
	 * @return palauttaa käyttäjän syöttämän kokonaisluvun
	 */
	
	public static int intSyote(String teksti) {
		pl(teksti);
		int v = lukija.nextInt();
		return  v;
	}
	
	/** doubleSyote(String teksti) pyytää käyttäjältä desimaaliluvun
	 * 
	 * @param teksti mahdollistaa tekstin lisäämisen komennon sisälle
	 * @return  palauttaa käyttäjän syöttämän desimaaliluvun
	 */
	
	public static double doubleSyote(String teksti) {
		pl(teksti);
		double v = lukija.nextDouble();
		return  v;
	}

	
// Tekstikomentojen lyhennykset:
	
	/** p(string teksti): Lyhennys tekstin tulostamisesta samalle riville
	 * 
	 * @param teksti Teksti syötetään moduulin kutsussa
	 */
	
	public static void p(String teksti) {
		System.out.print(teksti);
	}
	/** pl(string teksti): Lyhennys tekstin tulostamisesta eri riville
	 * 
	 * @param teksti  Teksti syötetään moduulin kutsussa
	 */
	
	public static void pl(String teksti) {
		System.out.println(teksti);
	}
	/** pf(string teksti, double parametri): Lyhennys desimaalilukujen tulostamiseen
	 * 
	 * @param teksti ehdot jolla tulostetta muokataan(montako desimaalia luvussa)
	 * @param parametri Haluttu desimaaliluku, joka esitetään pyöristettynä
	 */
	
	public static void pf(String teksti, double parametri) {
		System.out.printf(teksti, parametri);
	}
	


	
/** 
 
* Alle Luodaan Laskimen näppäimiä varten tarvittavat "ActionListenerit" Joidenka avulla jokainen laskimen nappi pystyy toimimaan halutulla tavalla.
 * NumeroNappienToiminnot tehtävänä on pitää huolta että numerot näkyvät oikein Laskimen tekstikentällä ja tietenki varmistaa että painamalla numeronäppäintä
 * Saadaan näytölle tulemaan kyseinen numero Esim painamalla 6 saadaan näkyville 6.
 * 
 * Cnapin tehtävänä on varmistaa että laskimen "Clear" toiminto poistaa kaikki laskettavat toiminnot että pystytään aloittamaan tyhjästä.
 * 
 * Backspacen Tehtävänä on pitää huoli että voidaan korjata merkki virheitä.
 * 
 * LaskentaListenerin tehtävänä on määrittää että ohjelma käyttää oikeata funktiota (eli + tekee yhteen laskuja eikä mitään muuta)
 * 
 * TulosLaskun tehtävänä on ottaa LaskentaListenerin antama arvo ja suorittaa lopullinen laskimen laskenta toiminto.(Kerto,yhteen,vahennys ja jako laskut)
 * @author Jan
 *
 */
	private class NumeroNappienToiminnot implements ActionListener {
		
		
		private String y;
		
		
		public NumeroNappienToiminnot(JButton x) {
			this.y = x.getText();
			
		}
		
		
		public void actionPerformed(ActionEvent e) {
			try {
				
				if (!kentta.getText().equals("0")) {
				kentta.setText(kentta.getText() +y);
					}
			
				else {
				kentta.setText("");
				actionPerformed(e);
					}
			
			}catch(Exception NumeroNappiListener) {
				pl("Numeronappien toimintaan tuli jokin vika!");
				pl("Virhekoodi: "+NumeroNappiListener);
			}
		}
	
	}
	private class Cnappi implements ActionListener {

		

		@Override
		public void actionPerformed(ActionEvent e) {
			kentta.setText("0");
			LaskentaNumero1 = 0;
			LaskentaNumero2 = 0;
			Laskenta = null;
			
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
	private class TulosLasku implements ActionListener {
		
		
			
		@Override
	        public void actionPerformed(ActionEvent e) {
	         try {
			 LaskentaNumero2 = Double.parseDouble(kentta.getText());
			 
			
			
			 
			 	 if (Laskenta == LaskentaFunktio.JAKO ) {
			 		 if(LaskentaNumero1 == 0 || LaskentaNumero2 == 0) {
			 			 System.out.println("Jakajan tai jaettavan operaattori ei saa olla 0");
			 		 } else {
	                kentta.setText(Double.toString((Math.round((LaskentaNumero1 / LaskentaNumero2) * 100)) / 100));
			 		 }
	            } else if (Laskenta == LaskentaFunktio.KERTO) {
	                kentta.setText(Double.toString(LaskentaNumero1 * LaskentaNumero2));
	            } else if (Laskenta == LaskentaFunktio.YHTEEN) {
	                kentta.setText(Double.toString(LaskentaNumero1 + LaskentaNumero2));
	            } else if (Laskenta == LaskentaFunktio.VAHENNYS) {
	                kentta.setText(Double.toString(LaskentaNumero1 - LaskentaNumero2));
	            } else {
	                kentta.setText(String.valueOf(LaskentaNumero1));
	            }
			 	LaskentaNumero1 = Double.parseDouble(kentta.getText());   
			 	Laskenta = null; 
	         }catch(Exception TulosLaskuListener) {
	     		pl("Laskimen laskentaan tuli virhe!");
	    		pl("Virhekoodi: "+TulosLaskuListener);
	    	} 
	        }
		
	}
	private class LaskentaListener implements ActionListener {

		
		
		private final LaskentaFunktio operation;
		
		public LaskentaListener(LaskentaFunktio Laskenta) {
			this.operation = Laskenta;
			
			
			
			
		}
		
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(kentta.getText().isEmpty()) {
				System.out.println("Älä toista samaa operaattoria");
			}
			else {
					if (LaskentaNumero1 == 0) {
						LaskentaNumero1 = Double.parseDouble(kentta.getText());
						kentta.setText("");
			} 		else {
						LaskentaNumero2 = Double.parseDouble(kentta.getText());
						kentta.setText("");
			}
					Laskenta = operation;
		}
		
	}
		
}
	
	
} // Sulkee ohjelman mainin 