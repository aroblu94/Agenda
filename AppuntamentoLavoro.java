public class AppuntamentoLavoro extends Appuntamento {
	
	//CAMPI
	private String luogo;

	//COSTRUTTORE
	public AppuntamentoLavoro(String desc, String d, int o, String l) {
		super(desc, d, o);
		luogo = l;
	}

	//METODI
	public String toString() {
		return super.toString() + " - " + this.luogo;
	}

	public int compareTo(AppuntamentoLavoro altro) {
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

	// metodo get...
	public String getLuogo() {
		return this.luogo;
	}
}//non mi fa il commit non sao perchè, questo commento spero gli permetterà di farlo
