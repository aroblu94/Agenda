public class AgendaTester {

	private static boolean debug = false;	

	public static void main (String[] args) {
		Persona p1 = new Persona ("Mario", "Rossi");
		Agenda agenda = new Agenda(p1);
		Persona p2 = new Persona("Paolo", "Bianchi");
		Persona p3 = new Persona("Laura", "Ferrari");

		Appuntamento a1 = new AppuntamentoLavoro("riunione", "3-10", 13, "sala 1");
		Appuntamento a2 = new AppuntamentoLavoro("seminario", "3-12", 10, "aula magna");
		Appuntamento a3 = new AppuntamentoLavoro("riunione", "3-12", 11, "sala 2");
		Appuntamento a4 = new AppuntamentoPersonale("cena", "2-05", 20, p2);
		Appuntamento a5 = new AppuntamentoPersonale("visita", "2-04", 9, p3);
		Appuntamento a6 = new AppuntamentoLavoro("colloquio", "3-04", 10, "ufficio 10");
		Appuntamento a7 = new AppuntamentoPersonale("TEST", "3-04", 10, p3);

		if (debug) {
			System.out.println();
			System.out.println("DEBUG...");
			System.out.println();
			System.out.println(p1);
			System.out.println(p2);
			System.out.println(p3);
			System.out.println(a1);
			System.out.println(a2);
			System.out.println(a3);
			System.out.println(a4);
			System.out.println(a5);
			System.out.println(a6);
			System.out.println();
			System.out.println("ORA STAMPO...");
		}

		agenda.aggiungiAppuntamento(a1);	
		agenda.aggiungiAppuntamento(a2);
		agenda.aggiungiAppuntamento(a3);
		agenda.aggiungiAppuntamento(a4);
		agenda.aggiungiAppuntamento(a5);
		agenda.aggiungiAppuntamento(a6);
		agenda.aggiungiAppuntamento(a7);

		agenda.ordina();

		//Stampo l'agenda
		System.out.println();
		System.out.println(agenda);
		for(Appuntamento x : agenda)
			System.out.println(x);

		System.out.println();
		System.out.println("Percentuale appuntamenti di lavoro: " + agenda.statistiche("lavoro") + "%");
		System.out.println("Percentuale appuntamenti personali: " + agenda.statistiche("personale") + "%");

	}
}
