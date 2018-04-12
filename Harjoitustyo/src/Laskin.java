import java.util.InputMismatchException; // K�ytt�j�n sy�te   v��r�n tyyppinen
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Laskin {
	private static final Scanner lukija = new Scanner (System.in);
	public static void main(String[] args) {

		info(true); // Ekalla suorituskerralla (true) tulostaa ohjelman ohjeet, muuten (false) tietoja ohjelmasta
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
				laskinMenu();
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
	public static void tila() {
		p("oho");
		mainMenu();
	}
	
	// laskimen valikko, jonka kautta valitaan halutut rajoitukset, yms jotain:
	public static void laskinMenu() {
		
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
		
	}
		
	
	
	//muuntajan valikko:
	
	public static int muuntajaMenu() {
		p("Muuntajavalikon viesti t�h�n: ");
		return 2;
	}
	
	
// Laskutomitukset: (t�m�n toteutus auki)
	
	//Laskin:
	
	
	
	//Muuntaja:

	
	
	
//Ohjemoduuli. n�ytt�� ohjelman k�ytt�ohjeet:
	public static void info(boolean o)  {
		
		if(o) {
			pl("T�h�n tulee ohjelman nimi, ehk� muutakin (V0.01b)\n");
			pl("Navigointi onnistuu n�pp�ilem�ll� haluttua ominaisuutta vastaavaa numeron�pp�int� ja painamalla enter -n�pp�int�.");
			pl("Ohjelman suorituksen pystyy keskeytt�m��n koska tahansa sy�tt�m�ll� numero 0 ja painamalla enter n�pp�int�.");
			
		}
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
