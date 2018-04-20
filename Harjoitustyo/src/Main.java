import java.util.Scanner;

public class Main {
	private static final Scanner lukija = new Scanner (System.in);
	public static void main(String[] args) {

		info(true); // Ekalla suorituskerralla (true) tulostaa ohjelman ohjeet, muuten (false) n‰ytt‰‰ tietoja ohjelmasta
		mainMenu();
		

	}
	
	
//Ohjelman valikot, joiden kautta k‰ytet‰‰n ominaisuuksia:	
	
	// P‰‰valikko, josta siirryt‰‰n muihin alavalikkoihin:
	public static void mainMenu() {
		java.util.Date date = new java.util.Date();
		
		try {
			int valinta = intSyote("\nP‰‰valikko:\n1. Laskin 2. Muuntaja 3. Kello \n9. Tietoa ohjelmasta  0. Sulje ohjelma: ");
			
			if (valinta==1)
				mainMenu(); // t‰h‰n tulee laskimen "laukaisin"
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
		catch(Exception e) { // Geneerinen, kattaa kaikki virhetilanteet ja suoritetaan jos ylemm‰t virheviestit ei kattanut virhett‰.
			pl("Virheellinen syˆte. Syˆt‰ pelk‰st‰‰n kokonaisluku!");
			pl("Virhekoodi: "+e);
			
		}
		

	}
	
	//muuntajan valikko: 
	
	public static double muuntajaMenu() {
		double vastaus=0; int suunta=0,tyyppi;
		int valinta = intSyote("1. pituus 2. massa  \n5. Takaisin p‰‰valikkoon, 0. Sulje ohjelma: ");
		if (valinta==1) {
			tyyppi=intSyote("1. Metri(m)<->jalka(f) 2. kilometrit(km)<->mailit(mi)");
			if (tyyppi==1) 
				suunta= intSyote("1. Metrit jaloiksi 2. jalat metreiksi");

			else if (tyyppi==2) 
				suunta= intSyote("1. kilometrit maileiksi 2. mailit kilometreiksi: ");
			
			else if(tyyppi==0)
				lopetus();
			
			
			pituusLasku(tyyppi,suunta);
		}
		
		else if(valinta==5) {
			pl("Siirryt‰‰n p‰‰valikkoon...");
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

			double A= doubleSyote("Syˆt‰ muutettava: ");
			if(tyyppi==1) {
				if(suunta==1) {
					pl("Metrit jaloiksi");
					tulos=(A/0.3048);
					System.out.print(A+" ");
					pf("metri‰ on %.3f",tulos);
					p(" Jalkaa\n");
					jatketaanko();
				}
				
				else if(suunta==2) {
					pl("Jalat metreiksi ");
					tulos=(A/3.2808);
					pf("Jalkaa on %.3f",tulos);
					pl(" metri‰\n");
					jatketaanko();
				}
							
			}
			
			else if (tyyppi==2) {
				if(suunta==1) {
					pl("kilometrit maileiksi");
					tulos= A * 0.62137;
					System.out.print(A);
					pf(" Kilometri‰ on %.3f",tulos);
					pl(" Mailia");
					jatketaanko();
				}
				else if (suunta==2) {
					pl("Mailit kilometreiksi");
					tulos= 1.609344*A;
					pf("tulos on %.3f",tulos);
					jatketaanko();
				}
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
	
	
	
//Ohjemoduuli. n‰ytt‰‰ ohjelman k‰ynnistyess‰ k‰yttˆohjeet:
	public static void info(boolean o)  {
		
		if(o) {
			pl("Tiimi-10 ohjelmaportaali  (V1.01b)\n");
			pl("Navigointi onnistuu n‰pp‰ilem‰ll‰ haluttua ominaisuutta vastaavaa numeron‰pp‰int‰ ja painamalla enter -n‰pp‰int‰.");
			pl("Ohjelman suorituksen pystyy keskeytt‰m‰‰n koska tahansa syˆtt‰m‰ll‰ numero 0 ja painamalla enter n‰pp‰int‰.");
			
		}
		// kun k‰ytt‰j‰ k‰ynnist‰‰ infomoduulin itse, n‰ytet‰‰n vain tiedot ohjelmasta
		else {

			p("Tiimi-10 ohjelmaportaali  (V1.01b, (C) 2018) Tekij‰t: Jan Stockfelt, Matti Wallenius");
			mainMenu();
		}
	}
	public static void lopetus() {
		pl("Sammutetaan ohjelma...");
		System.exit(0);
	}
	
// K‰ytt‰j‰n syˆtteen kysyminen
	
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
	
}
