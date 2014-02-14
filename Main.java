import java.io.*;
import java.util.*;

public class Main {

	private static boolean debug = false;

	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		Appuntamento app;
		String descrizione = "";
		String data = "";
		int ora = 0;
		String tipo = "";
		String nome = "";
		String cognome = "";
		Persona chi = null;
		Appuntamento a = null;
		String dove = "";

		System.out.println("Questo programma permette di memorizzare e gestire appuntamenti ");
		System.out.println("Inserisci nome e cognome (separati da uno spazio)");
		nome = in.next();
		cognome = in.next();
		System.out.println();

		Persona utente = new Persona(nome, cognome);
		if (debug)
			System.out.println("DEBUG = persona creata: " + utente);
		
		Agenda agenda = new Agenda(utente);
		if (debug) {
			System.out.println("DEBUG = agenda creata: " + agenda);
			System.out.println();
		}

		System.out.println("Benvenuto " + utente.getNome());
		while(1==1) {
			System.out.println("Scegli cosa vuoi fare \n1. Aggiungi appuntamento \n2. Rimuovi appuntamento \n3. Ordina gli appuntamenti \n4. Stampa l'agenda \n5. Ottieni statistiche \n6. Esci \n");
			String selezione = in.next();
			int sel = Integer.parseInt(selezione);
			switch (sel) {
				case 1:
					System.out.println("Inserisci una descrizione per l'appuntamento");
					descrizione = in.next();
					System.out.println("Inserisci la data nel formato MM-GG ");
					data = in.next();
					System.out.println("Inserisci l'ora di inizio ");
					ora = Integer.parseInt(in.next());
					System.out.println("E' un appuntamento personale o di lavoro? P/L ");
					tipo = in.next();
					if (tipo.equals("p") || tipo.equals("P")) {
						System.out.println("Con chi hai l'appuntamento? (nome cognome)");
						nome = in.next();
						cognome = in.next();
						chi = new Persona(nome, cognome);
						a = new AppuntamentoPersonale(descrizione, data, ora, chi);
						agenda.aggiungiAppuntamento(a);
					}
					else if (tipo.equals("l") || tipo.equals("L")) {
						System.out.println("Luogo dell'appuntamento? ");
						dove = in.next();
						a = new AppuntamentoLavoro(descrizione, data, ora, dove);
						agenda.aggiungiAppuntamento(a);
					}
					else
						System.out.println("Hai sbagliato a digitare! ");
					System.out.println();
					break;
				case 2:	//NON RIMUOVE
					System.out.println("Inserisci una descrizione per l'appuntamento");
					descrizione = in.next();
					System.out.println("Inserisci la data nel formato MM-GG ");
					data = in.next();
					System.out.println("Inserisci l'ora di inizio ");
					ora = Integer.parseInt(in.next());
					System.out.println("E' un appuntamento personale o di lavoro? P/L ");
					tipo = in.next();
					if (tipo.equals("p") || tipo.equals("P")) {
						System.out.println("Con chi hai l'appuntamento? (nome cognome)");
						nome = in.next();
						cognome = in.next();
						chi = new Persona(nome, cognome);
						a = new AppuntamentoPersonale(descrizione, data, ora, chi);
						agenda.rimuoviAppuntamento(a);
					}
					else if (tipo.equals("l") || tipo.equals("L")) {
						System.out.println("Luogo dell'appuntamento? ");
						dove = in.next();
						a = new AppuntamentoLavoro(descrizione, data, ora, dove);
						agenda.rimuoviAppuntamento(a);
					}
					else
						System.out.println("Hai sbagliato a digitare! ");
					System.out.println();
					break;
				case 3:
					if(!agenda.getVettore().isEmpty()) {
						System.out.println("Sto ordinando gli appuntamenti... ");
						agenda.ordina();
						System.out.println("... \n... Fatto! \n");
					}
					else
						System.out.println("Nessun appuntamento trovato! ");
					break;
				case 4:
					System.out.println(agenda);
					for(Appuntamento x : agenda)
						System.out.println(x);
					System.out.println();
					break;
				case 5:
					System.out.println("Percentuale appuntamenti di lavoro: " + agenda.statistiche("lavoro") + "%");
					System.out.println("Percentuale appuntamenti personali: " + agenda.statistiche("personale") + "%");
					break;
				case 6:
					System.exit(0);
					break;
				default:
					System.out.println("Hai sbagliato tasto, riprova! ");
					break;
			}
			System.out.println();
		}

	}


}
	
