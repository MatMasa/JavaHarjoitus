import java.util.InputMismatchException; // Käyttäjän syöte   väärän tyyppinen
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Laskin {
	private static final Scanner lukija = new Scanner (System.in);
	public static void main(String[] args) {

		info(true); // Ekalla suorituskerralla (true) tulostaa ohjelman ohjeet, muuten (false) tietoja ohjelmasta
		mainMenu();
		

	}
	
	
//Ohjelman valikot, joiden kautta käytetään ominaisuuksia:	
	
	// Päävalikko, josta siirrytään muihin alavalikkoihin:
	public static void mainMenu() {
		java.util.Date date = new java.util.Date();
		pl("\nPäävalikko:\n1. Laskin 2. Muuntaja 3. Kello 9. Tietoa ohjelmasta  0. Sulje ohjelma: ");
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
		catch(Exception e) { // Geneerinen, kattaa kaikki virhetilanteet ja suoritetaan jos ylemmät virheviestit ei kattanut virhettä.
			pl("Virheellinen syöte. Syötä pelkästään kokonaisluku!");
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
			pl("Virheellinen syöte. Syötä pelkästään kokonaisluku!");
			pl("Virhekoodi: "+ime);
		}
		catch (Exception e)  { 
			pl("Tuntematon virhe");
			pl("Virhekoodi: "+e);
			

		}
		
	}
		
	
	
	//muuntajan valikko:
	
	public static int muuntajaMenu() {
		p("Muuntajavalikon viesti tähän: ");
		return 2;
	}
	
	
// Laskutomitukset: (tämän toteutus auki)
	
	//Laskin:
	
	
	
	//Muuntaja:

	
	
	
//Ohjemoduuli. näyttää ohjelman käyttöohjeet:
	public static void info(boolean o)  {
		
		if(o) {
			pl("Tähän tulee ohjelman nimi, ehkä muutakin (V0.01b)\n");
			pl("Navigointi onnistuu näppäilemällä haluttua ominaisuutta vastaavaa numeronäppäintä ja painamalla enter -näppäintä.");
			pl("Ohjelman suorituksen pystyy keskeyttämään koska tahansa syöttämällä numero 0 ja painamalla enter näppäintä.");
			
		}
		else {

			p("Cöpirait 2018, ool raits risöövd");
			mainMenu();
		}
	}
		
	
// Käyttäjän syötteen kysyminen
	
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
