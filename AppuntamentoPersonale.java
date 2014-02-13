public class AppuntamentoPersonale extends Appuntamento {
	
	//CAMPI
	private Persona persona;

	//COSTRUTTORE
	public AppuntamentoPersonale (String desc, String d, int o, Persona p) {
		super(desc, d, o);
		persona = p;
	}

	//METODI
	public String toString() {
		return super.toString() + " con " + this.persona;
	}

	public int compareTo(AppuntamentoPersonale altro) {
		if (this.getGiorno() == altro.getGiorno()) {
			if (this.getOra() == altro.getOra())
				return 0;
			else if(this.getOra() > altro.getOra())
					return 1;
				else
					return -1;
		}
		else if(this.getGiorno() > altro.getGiorno())
				return 1;
			else 
				return -1;
	}

	//metodo get...
	public Persona getPersona() {
		return this.persona;
	}
}
