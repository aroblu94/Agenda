public class Persona {

	//CAMPI
	private String nome, cognome;

	//COSTRUTTORE
	public Persona (String n, String c) {
		nome = n;
		cognome = c;
	}

	//METODI
	public String toString() {
		return this.nome + " " + this.cognome;
	}

	// set e get...
	public String getNome() {
		return this.nome;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setPersona(String n, String c) {
		this.nome = n;
		this.cognome = c;
	}


}
