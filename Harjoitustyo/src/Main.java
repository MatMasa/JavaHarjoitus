import java.util.InputMismatchException; // K�ytt�j�n sy�te   v��r�n tyyppinen
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
	private static final Scanner lukija = new Scanner (System.in);
	public static void main(String[] args) {

		info(true); // Ekalla suorituskerralla (true) tulostaa ohjelman ohjeet, muuten (false) n�ytt�� tietoja ohjelmasta
		mainMenu();
		

	}
	
	
//Ohjelman valikot, joiden kautta k�ytet��n ominaisuuksia:	
	
	// P��valikko, josta siirryt��n muihin alavalikkoihin:
	public static void mainMenu() {
		java.util.Date date = new java.util.Date();
		pl("\nP��valikko:\n1. Laskin 2. Muuntaja 3. Kello 9. Tietoa ohjelmasta  0. Sulje ohjelma: ");
		try {
			int valinta = intSyote();
			if (valinta==1)
				mainMenu();
			else if (valinta==2) {
				muuntajaMenu();
			}
			
			else if (valinta==3) {
				System.out.println(date);
			}
			
			else if (valinta==9) 
				info(false);
			
				
			else if (valinta==0)
				p("Se o moro!");
		
		else
			mainMenu();
		}
		catch(Exception e) { // Geneerinen, kattaa kaikki virhetilanteet ja suoritetaan jos ylemm�t virheviestit ei kattanut virhett�.
			pl("Virheellinen sy�te. Sy�t� pelk�st��n kokonaisluku!");
			pl("Virhekoodi: "+e);
			
		}
		

	}

	// laskimen valikko, jonka kautta valitaan halutut rajoitukset, yms jotain:
	/*public static void laskinMenu() {
		
		p("Lasetaanko: ");
		try {
			int valinta = intSyote();
		}
		catch (InputMismatchException ime) {
			pl("Virheellinen sy�te. Sy�t� pelk�st��n kokonaisluku!");
			pl("Virhekoodi: "+ime);
		}
		catch (Exception e)  { 
			pl("Tuntematon virhe");
			pl("Virhekoodi: "+e); 
			

		}
		
	}*/
		
	
	
	//muuntajan valikko:
	
	public static double muuntajaMenu() {
		double vastaus=0;
		p("1. pituus 2. massa 3. Onnennumero ");
		int valinta = lukija.nextInt();
		if (valinta==1) {
			p("1. Metri(m)<->jalka(f) 2. kilometrit<->mailit");
			int tyyppi=lukija.nextInt();
			if (tyyppi==1) 
				p("1. Metrit jaloiksi 2. jalat metreiksi");

			else if (tyyppi==2) 
				p("1. kilometrit maileiksi 2. mailit kilometreiksi: ");
			
			int suunta=intSyote();
			vastaus = pituusLasku(tyyppi, suunta);
		}
			
		return vastaus;
	}
	
	
// Laskutomitukset: 
	
	public static double pituusLasku(int tyyppi, int suunta) {
		double tulos=0;
		double A= doubleSyote();
		if(tyyppi==2) {
			if(suunta==1) {
				tulos= A * 0.62137;
			}
			else if (suunta==2) {
				tulos= 1.609344*A;
			}
		}

		return tulos;
	}
	
	public static void massaLasku(int tyyppi, int suunta) {
		double tulos;
		
	}
	public static boolean jatketaanko() {
		return true;
	}
	
	
	
//Ohjemoduuli. n�ytt�� ohjelman k�ynnistyess� k�ytt�ohjeet:
	public static void info(boolean o)  {
		
		if(o) {
			pl("Tiimi-10 ohjelmaportaali  (V0.01b)\n");
			pl("Navigointi onnistuu n�pp�ilem�ll� haluttua ominaisuutta vastaavaa numeron�pp�int� ja painamalla enter -n�pp�int�.");
			pl("Ohjelman suorituksen pystyy keskeytt�m��n koska tahansa sy�tt�m�ll� numero 0 ja painamalla enter n�pp�int�.");
			
		}
		// kun k�ytt�j� k�ynnist�� infomoduulin itse, n�ytet��n vain tiedot ohjelmasta
		else {

			p("C�pirait 2018, ool raits ris��vd");
			mainMenu();
		}
	}
		
	
// K�ytt�j�n sy�tteen kysyminen
	
	// kokonaisluku:
	public static int intSyote() {
		int v = lukija.nextInt();
		return  v;
	}
	
	// Desimaaliluku:	
	public static double doubleSyote() {
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
	
}
