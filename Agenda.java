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
	    boolean inConflitto = false;
		for (Appuntamento tmp : this) {
		    if (tmp.inConflitto(a)) {
		        inConflitto = true;
			break;
		    }
		}
		if (!inConflitto) appuntamenti.add(a);
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

	public String toString(){
		return "Agenda di " + this.titolare + "\n" + "=====================";
	}

	public int statistiche(String tipo) {
		int percentuale = 0;
		int k = 0;
		if (tipo.equals("lavoro")) {
			for (Appuntamento x : appuntamenti){
				if(x instanceof AppuntamentoLavoro)
					k++;
			}
			percentuale = 100 * k / appuntamenti.size();
		}
		else if (tipo.equals("personale")) {
			for (Appuntamento x : appuntamenti) {
				if(x instanceof AppuntamentoPersonale)
					k++;
			}
			percentuale = 100 * k / appuntamenti.size();
		}
		return percentuale;
	}

	//Get vettore...
	public Vector<Appuntamento> getVettore() {
		return this.appuntamenti;
	}


}
