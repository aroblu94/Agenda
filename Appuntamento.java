import java.util.*;

public abstract class Appuntamento implements Comparable<Appuntamento> {
	
	//CAMPI
	private String descrizione, data;
	private int orario;

	//COSTRUTTORE
	public Appuntamento (String desc, String d, int o) {
		if (d.length() == 5) {
			int mm = Integer.parseInt(d.substring(0,2));
			int gg = Integer.parseInt(d.substring(3));
			if (mm>0 && mm<=12) {
				if(gg>0 && gg<=31) {
					descrizione = desc;
					data = d;
					orario = o;
				}
				else 
					throw new IllegalArgumentException ("Giorno non valido  ");
			}
			else
				throw new IllegalArgumentException ("Mese non valido ");
		}
		else 
			throw new IllegalArgumentException ("Data non valida ");
	}
			
			

	//METODI
	public boolean inConflitto(Appuntamento altro) {
		if (altro.getData().equals(this.data)) {
			if (altro.getOra() == (this.orario - 1) || altro.getOra() == this.orario || altro.getOra() == (this.orario + 1))
				return true;
		}
		return false;
	}

	public String toString() {
		return (this.data + " h: " + this.orario + ":00 " + this.descrizione);
	}

	public int compareTo(Appuntamento altro) {
		if (this.getMese() == altro.getMese()) {
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
		else if(this.getMese() > altro.getMese())	
				return 1;
			else
				return -1;
	}

	

	// metodi set & get ...
	public void setDescrizione(String descrizione){
		this.descrizione = descrizione;
	}

	public String getDescrizione(){
		return this.descrizione;
	}
	
	public void setData(String data){
		if (data.length() == 5) {
			int mese = Integer.parseInt(data.substring(0,2));
			int giorno = Integer.parseInt(data.substring(3));
			if (mese>0 && mese<=12) {
				if(giorno>0 && giorno<=31) {
					data = this.data;
				}
				else 
					throw new IllegalArgumentException ("Giorno non valido  ");
			}
			else
				throw new IllegalArgumentException ("Mese non valido ");
		}
		else 
			throw new IllegalArgumentException ("Data non valida ");
	}

	public int getGiorno(){
		return Integer.parseInt(data.substring(3));
	}

	public int getMese(){
		return Integer.parseInt(data.substring(0,2));
	}

	public String getData() {
		return this.data;
	}
		
	public int getOra() {
		return this.orario;
	}
	

}
