import java.lang.*;
import java.util.*;

public class Agenda implements Iterable<Appuntamento> {

	//CAMPI
	private Vector<Appuntamento> appuntamenti;
	private Persona titolare;

	//COSTRUTTORE
	public Agenda (Persona t) {
		titolare = t;
		appuntamenti = new Vector<Appuntamento>();
	}

	//METODI
	public void aggiungiAppuntamento(Appuntamento a) {
		appuntamenti.add(a);
	}

	public void rimuoviAppuntamento(Appuntamento a) {
		appuntamenti.remove(a);
	}

	public void ordina() {
		Collections.sort(appuntamenti);
	}

	public Iterator<Appuntamento> iterator() {
		return this.appuntamenti.iterator();
	}

	//Ridefinisco l'iteratore
	/*public Iterator<Appuntamento> iterator() {
		Iterator<Appuntamento> it = new Iterator<Appuntamento>() {
			private int currentIndex = 0;

			public boolean hasNext() {
				return (currentIndex < appuntamenti.size() && !appuntamenti.isEmpty());
	    	}

			public Appuntamento next() {
	        	return appuntamenti.get(currentIndex++);
	    	}

			public void remove() {
			    appuntamenti.remove(currentIndex -1);
			}
		};
		return it;

	}*/

	//METODO ALTERNATIVO (Iterable è all'interno del toString())
	public String toString(){
		/*String titolo = new String ("Agenda di " + this.titolare + "\n");
		Iterator<Appuntamento> elenco = (this.appuntamenti).iterator();
		while(elenco.hasNext()){
			Appuntamento a = elenco.next();
			if(a instanceof Appuntamento){
				return titolo + a.toString();
			}
			else{
				return titolo + a.toString();
			}
		}
		return titolo + "L'agenda e' vuota";*/
		return "Agenda di " + this.titolare + "\n" + "=====================";

	}

	public int statistiche(String tipo) {
		int percentuale = 0;
		int l = 0;
		int p = 0;
		if (tipo.equals("lavoro")) {
			for (Appuntamento x : appuntamenti){
				if(x instanceof AppuntamentoLavoro)
					l++;
			}
			percentuale = l / appuntamenti.size() * 100;
		}
		else if (tipo.equals("personale")) {
			for (Appuntamento x : appuntamenti) {
				if(x instanceof AppuntamentoPersonale)
					p++;
			}
			percentuale = p / appuntamenti.size() * 100;
		}
		return percentuale;
	}

	//Get vettore...
	public Vector<Appuntamento> getVettore() {
		return this.appuntamenti;
	}


}