import java.util.*;

public abstract class Appuntamento implements Comparable<Appuntamento> {
	
	//CAMPI
	private String descrizione, data;
	private int orario;
	private int mm = 0;
	private int gg = 0;
	private String month = "";
	private String day = "";

	//COSTRUTTORE
	public Appuntamento (String desc, String d, int o) {
		Scanner token = new Scanner(d);
		token.useDelimiter("-");
		String month = token.next();
		String day = token.next();
		mm = Integer.parseInt(month);
		gg = Integer.parseInt(day);
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
			
			

	//METODI
	public boolean inConflitto(Appuntamento altro) {
		if (altro.getData().equals(this.data)) {
			if (altro.getOra() == (this.orario - 1) || altro.getOra() == this.orario || altro.getOra() == (this.orario + 1))
				return true;
		}
		return false;
	}

	public String toString() {
		String stringaMese = "";
		switch(mm) {
			case 1:
				stringaMese = "gennaio";
				break;
			case 2:
				stringaMese = "febbraio";
				break;
			case 3:
				stringaMese = "marzo";
				break;
			case 4:
				stringaMese = "aprile";
				break;
			case 5:
				stringaMese = "maggio";
				break;
			case 6:
				stringaMese = "giugno";
				break;
			case 7:
				stringaMese = "luglio";
				break;
			case 8:
				stringaMese = "agosto";
				break;
			case 9:
				stringaMese = "settembre";
				break;
			case 10:
				stringaMese = "ottobre";
				break;
			case 11:
				stringaMese = "novembre";
				break;
			case 12:
				stringaMese = "dicembre";
				break;
		}
		return (this.getGiorno() + " " + stringaMese + ", ore " + this.orario + ":00 " + this.descrizione);
		//return (this.getGiorno() + "-" + this.getMese() + " ore " + this.orario + ":00 " + this.descrizione);
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
	
	/*public void setData(String data){
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
	}*/

	public int getGiorno(){
		return gg; //Integer.parseInt(data.substring(3));
	}

	public int getMese(){
		return mm; //Integer.parseInt(data.substring(0,2));
	}

	public String getData() {
		return this.data;
	}
		
	public int getOra() {
		return this.orario;
	}
	

}
