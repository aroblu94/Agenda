import java.io.*;
import java.util.*;

public class Main {

	private static boolean debug = false;

	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		Appuntamento app;

		System.out.println("Questo programma permette di memorizzare e gestire appuntamenti ");
		System.out.println("Inserisci il tuo nome e il tuo cognome (separati da uno spazio)");
		String nome = in.next();
		String cognome = in.next();
		System.out.println();

		Persona utente = new Persona(nome, cognome);
		if (debug)
			System.out.println("DEBUG = persona creata: " + utente);
		
		Agenda agenda = new Agenda(utente);
		if (debug) {
			System.out.println("DEBUG = agenda creata: " + agenda);
			System.out.println();
		}

		System.out.println("Benvenuto " + utente.getNome() + ", cosa vuoi fare? ");
		while(1==1) {
			System.out.println("1. Aggiungi appuntamento \n2. Rimuovi appuntamento \n3. Ordina gli appuntamenti \n4. Stampa l'agenda \n5. Esci \n");
			String selezione = in.next();
			int sel = Integer.parseInt(selezione);
			switch (sel) {
				case 1:
					System.out.println("Inserisci una descrizione per l'appuntamento");
					String descrizione = in.next();
					System.out.println("Inserisci la data nel formato MM-GG ");
					String data = in.next();
					System.out.println("Inserisci l'ora di inizio ");
					int ora = Integer.parseInt(in.next());
					System.out.println("E' un appuntamento personale o di lavoro? P/L ");
					String tipo = in.next();
					if (tipo.equals("p") || tipo.equals("P")) {
						System.out.println("Con chi hai l'appuntamento? (nome cognome)");
						String nome2 = in.next();
						String cognome2 = in.next();
						Persona chi = new Persona(nome2, cognome2);
						Appuntamento a = new AppuntamentoPersonale(descrizione, data, ora, chi);
						agenda.aggiungiAppuntamento(a);
					}
					else if (tipo.equals("l") || tipo.equals("L")) {
						System.out.println("Luogo dell'appuntamento? ");
						String dove = in.next();
						Appuntamento a = new AppuntamentoLavoro(descrizione, data, ora, dove);
						agenda.aggiungiAppuntamento(a);
					}
					else
						System.out.println("Hai sbagliato a digitare! ");
					System.out.println();
					break;
				case 2:
					System.out.println("Questa funzione e' ancora da implementare ");	//DA FARE
					String descrizione2 = in.next();
					//agenda.rimuoviAppuntamento(app.setDescrizione(descrizione2));
					System.out.println();
					break;
				case 3:
					System.out.println("Sto ordinando gli appuntamenti... Fatto! ");
					agenda.ordina();
					System.out.println();
					break;
				case 4:
					System.out.println(agenda);
					for(Appuntamento x : agenda)
						System.out.println(x);
					System.out.println();
					break;
				case 5:
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
	