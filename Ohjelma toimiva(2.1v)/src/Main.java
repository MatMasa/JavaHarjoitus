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
		 *  M��rit�mme alle String[][] NumeroNappiTeksti tauluun Laskimen n�pp�imist�� varten tarvittavat Numerot ja erikoismerkit.
		 *  T�m�n J�lkeen For loopin avulla luodaan jokaiselle merkille oma JButton, ActionListener ja asetetaan ne omaksi paneeliksi - 
		 *  my�hemp�� asettelua varten. 
		 *  T�ss� vaiheessa luodaan my�s Napeille oma fontti.
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
			pl("Ohjelman NumeroNappiTeksti taulussa tai siihen liittyviss� funktioissa on virhe");
			pl("Virhekoodi: "+Laskin1);
		}

		/**
		 *   Alla Luodaan laskimen numerokentt�� varten tarvittavat m��ritykset(kentta = new JTextfield();), 
		 *   Kuten mink� kokoinen meid�n kentt�mme on, mik� on kent�n taustav�ri, voiko kentt�� muokata suoraan
		 *   Ja Miss� kohdin meid�n laskimen numerot n�kyv�t kent�ll�.
		 *   
		 *   T�m�n J�lkeen M��ritell��n JPanel PaaPanel jonka teht�v�n� on hoitaa Laskimen asemmoinnin viimeiset vaiheet ja
		 *   Lopulta pistet��n laskin aktiiviseksi, M��ritell��n ikkunan koko ja mill� tavoin ohjelma sulkeutuu.
		 *   @author Jan
		 */
		kentta = new JTextField();
		kentta.setPreferredSize(new Dimension(100,75));
		kentta.setBackground(Color.WHITE);
		kentta.setEditable(false);
		kentta.setHorizontalAlignment(4);
		
			
		
		JPanel PaaPanel = new JPanel(new BorderLayout()); // -- P��paneeli Joka m��ritt�� laskimen osien lopulliset paikat Graffisessa liittym�ss�.
			PaaPanel.add(kentta, BorderLayout.PAGE_START);
			PaaPanel.add(NumeroNappiPaneeli);
			
		
		// ------- Alla on komennot jotka m��ritt�v�t laskimen Alkuper�isen ikkunan koon ja tuo muut vaadittavat toiminnot kuten laskimen nappulat.
		add(PaaPanel);	
		setTitle("Laskin");
		setSize(315,350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Ohjelman sulkemista varten.
		

	
}
	
	/** main(String[] args) K�ytet��n ainoastaan k�ytt�ohjeiden ja p��valikon aukaisuun
	 * 
	 * @param args ei mit��n
	 */
	
	public static void main(String[] args) {

		
		info(true); // Ekalla suorituskerralla (true) tulostaa ohjelman ohjeet, muuten (false) n�ytt�� tietoja ohjelmasta
		mainMenu();
		

	}
	
	
//Ohjelman valikot, joiden kautta k�ytet��n ominaisuuksia:	
	
	/** mainMenu():P��valikkomoduuli, josta siirryt��n muihin alavalikkoihin, moduuleihin
	 * 
	 */
	public static void mainMenu() {
		java.util.Date date = new java.util.Date();
		
		try {
			int valinta = intSyote("\nP��valikko:\n1. Laskin 2. Muuntaja 3. Kello \n9. Tietoa ohjelmasta  0. Sulje ohjelma: ");
			
			if (valinta==1) {
				Main ikkuna = new Main();
				ikkuna.setVisible(true);
				pl("Graaffinen laskin on k�ynnistetty. Katso alapalkki!");
				mainMenu();
			
			}
				
			else if (valinta==2) {
				muuntajaMenu();  // muuntajaValikko, josta valitaan mit� muunnetaan ja miten
			}
			
			else if (valinta==3) {
				System.out.println(date); // tulostaa ajan muodossa viikonp�iv� kuukausi p�iv�m��r� kellonaika aikavy�hyke vuosi
				mainMenu();
			}
			
			else if (valinta==9) 
				info(false); // K�ynnist�� infomoduulin -> n�ytt�� ohjelman tiedot
			
				
			else if (valinta==0)
				lopetus();
		
			else 
				mainMenu();
			
		}
		catch(Exception e) { // Geneerinen, kattaa kaikki virhetilanteet ja suoritetaan jos ylemm�t virheviestit ei kattanut virhett�.
			
			virheTulostus(e);   // Virheenhallintamoduuli: ilmoitus virheest�, sen tulostus ja kirjaus lokitiedostoon
			
			
		}
		

	}
	
	/** muuntajaMenu(): moduuli, jossa valitaan mit� tyyppi� muunnetaan(pituus, massa, ...), muutettava yksikk�(kilometrit, mailit) ja mihin suuntaan muutetaan(e. mailit kilometreiksi)
	* int valinta: Kysyy k�ytt�j�lt� mink� tyyppisi� arvoja muutetaan
	* int tyyppi: Kysyy, mit� muutetaan valinta muuttujan m��ritt�m�st� kategoriasta
	* int suunta: Kysyy, mit� muutetaan ja miksi
	*/
	public static void muuntajaMenu() {
		int suunta=0,tyyppi;
		try {
			int valinta = intSyote("1. pituus 2. massa  \n5. Takaisin p��valikkoon, 0. Sulje ohjelma: ");
			if (valinta==1) {
				tyyppi=intSyote("1. Metri(m)<->jalka(f) 2. kilometri(km)<->maili(mi) 5. P��valikkoon 0. Sulje ohjelma");
				
				if (tyyppi==1) {
					suunta= intSyote("1. Metrit jaloiksi 2. jalat metreiksi 5. takaisin p��valikkoon 0. Sulje ohjelma");
					
					if (suunta==5)
						mainMenu();
					else if(suunta==0)
						lopetus();
					
					else if(suunta==1| suunta==2)
						pituusLasku(tyyppi,suunta);
					else {
						pl("Virheellinen numero!");
						muuntajaMenu();
					}
					
								
				}
					
					
	
				else if (tyyppi==2) {
					suunta= intSyote("1. kilometrit maileiksi 2. mailit kilometreiksi 5. P��valikko 0. Lopetus: ");
					
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
				pl("Siirryt��n p��valikkoon...");
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

/** virheTulostus(Exception e) virheenhallintamoduuli, joka hallitsee suurimman osan virheist�
 * 
 * @param e Parametri suurimmalle osalle virheilmoituksia
 */
	
	public static void virheTulostus(Exception e) {
		try {
			pl("Virheellinen sy�te");
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
	 * @param tyyppi Mit� tyyppi� muutetetaan( Esim. kilometrej� ja maileja)
	 * @param suunta Mihin suuntaan muutetaan (esim maileja kilometreiksi tai kilometreja maileiksi
	 */
	public static void pituusLasku(int tyyppi, int suunta) {
		double tulos=0;
		
		do {
			try {

				double A= doubleSyote("Sy�t� muutettava: ");
				if(tyyppi==1) {
					if(suunta==1) {
						pl("Metrit jaloiksi");
						tulos=(A/0.3048);
						System.out.print(A+" ");
						pf("metri� on %.3f",tulos);
						p(" Jalkaa\n");
						jatketaanko();
					}
					
					else if(suunta==2) {
						pl("Jalat metreiksi ");
						tulos=(A/3.2808);
						pf("Jalkaa on %.3f",tulos);
						pl(" metri�\n");
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
						pf(" Kilometri� on %.3f",tulos);
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
		p("T�h�n tulisi massalaskujen menu, toimii samalla tavalla kuin pituuslaskun metodit");
		mainMenu();
		
	}
	/**jatketaanko() : Kysyy k�ytt�j�lt� haluaako h�n muuntaa uudestaan, palata valikkoon vai lopettaa. buginen, ilmestyy kaksi kertaa n�yt�lle, vasta toisella kertaa hyv�ksyy vastauksen.
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
 *  Ohjelman k�ytt�ohjeet ja tiedot ohjelmasta
 * @param o Ohjelman k�ynnistyess� true, eli n�ytt�� k�ytt�hjeet, muuten tiedot ohjelmasta
 */
	
	
	public static void info(boolean o)  {
		
		if(o) {
			pl("Tiimi-10 ohjelmaportaali  (V2.15)\n");
			pl("Navigointi onnistuu n�pp�ilem�ll� haluttua ominaisuutta vastaavaa numeron�pp�int� ja painamalla enter -n�pp�int�.");
			pl("Ohjelman suorituksen pystyy keskeytt�m��n koska tahansa sy�tt�m�ll� numero 0 ja painamalla enter n�pp�int�.");
			
		}
		// kun k�ytt�j� k�ynnist�� infomoduulin itse, n�ytet��n vain tiedot ohjelmasta
		else {

			p("Tiimi-10 ohjelmaportaali  (V2.15, (C) 2018) Tekij�t: Jan Stockfelt, Matti Wallenius");
			mainMenu();
		}
	}
	/** lopetus(): lopetusmoduuli, joka ilmoittaa k�ytt�j�lle ohjelman sammuttamisesta, ja lopettaa sen suorittamisen
	 * 
	 */
	
	 
	public static void lopetus() {
		pl("Sammutetaan ohjelma...");
		System.exit(0);
	}
	
	/**intSyote(String teksti): pyyt�� k�ytt�j�lt� kokonaisluvun
	 * 
	 * @param teksti mahdollistaa tekstin lis��misen komennon sis�lle
	 * @return palauttaa k�ytt�j�n sy�tt�m�n kokonaisluvun
	 */
	
	public static int intSyote(String teksti) {
		pl(teksti);
		int v = lukija.nextInt();
		return  v;
	}
	
	/** doubleSyote(String teksti) pyyt�� k�ytt�j�lt� desimaaliluvun
	 * 
	 * @param teksti mahdollistaa tekstin lis��misen komennon sis�lle
	 * @return  palauttaa k�ytt�j�n sy�tt�m�n desimaaliluvun
	 */
	
	public static double doubleSyote(String teksti) {
		pl(teksti);
		double v = lukija.nextDouble();
		return  v;
	}

	
// Tekstikomentojen lyhennykset:
	
	/** p(string teksti): Lyhennys tekstin tulostamisesta samalle riville
	 * 
	 * @param teksti Teksti sy�tet��n moduulin kutsussa
	 */
	
	public static void p(String teksti) {
		System.out.print(teksti);
	}
	/** pl(string teksti): Lyhennys tekstin tulostamisesta eri riville
	 * 
	 * @param teksti  Teksti sy�tet��n moduulin kutsussa
	 */
	
	public static void pl(String teksti) {
		System.out.println(teksti);
	}
	/** pf(string teksti, double parametri): Lyhennys desimaalilukujen tulostamiseen
	 * 
	 * @param teksti ehdot jolla tulostetta muokataan(montako desimaalia luvussa)
	 * @param parametri Haluttu desimaaliluku, joka esitet��n py�ristettyn�
	 */
	
	public static void pf(String teksti, double parametri) {
		System.out.printf(teksti, parametri);
	}
	


	
/** 
 
* Alle Luodaan Laskimen n�pp�imi� varten tarvittavat "ActionListenerit" Joidenka avulla jokainen laskimen nappi pystyy toimimaan halutulla tavalla.
 * NumeroNappienToiminnot teht�v�n� on pit�� huolta ett� numerot n�kyv�t oikein Laskimen tekstikent�ll� ja tietenki varmistaa ett� painamalla numeron�pp�int�
 * Saadaan n�yt�lle tulemaan kyseinen numero Esim painamalla 6 saadaan n�kyville 6.
 * 
 * Cnapin teht�v�n� on varmistaa ett� laskimen "Clear" toiminto poistaa kaikki laskettavat toiminnot ett� pystyt��n aloittamaan tyhj�st�.
 * 
 * Backspacen Teht�v�n� on pit�� huoli ett� voidaan korjata merkki virheit�.
 * 
 * LaskentaListenerin teht�v�n� on m��ritt�� ett� ohjelma k�ytt�� oikeata funktiota (eli + tekee yhteen laskuja eik� mit��n muuta)
 * 
 * TulosLaskun teht�v�n� on ottaa LaskentaListenerin antama arvo ja suorittaa lopullinen laskimen laskenta toiminto.(Kerto,yhteen,vahennys ja jako laskut)
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
				System.out.println("�l� toista samaa operaattoria");
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