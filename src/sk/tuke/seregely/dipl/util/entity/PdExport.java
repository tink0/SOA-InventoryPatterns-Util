package sk.tuke.seregely.dipl.util.entity;

import java.util.Date;

public class PdExport {

	private int idPd;
	private Date zaciatok;
	private Date koniec;
	private int zamestnanec;
	
	public PdExport() {
		
	}
	
	public PdExport( int id, Date zaciatok, Date koniec, int vodic) {
		this.idPd = id;
		this.zaciatok = zaciatok;
		this.koniec = koniec;
		this.zamestnanec = vodic;
	}

	public int getIdPd() {
		return idPd;
	}
	public void setIdPd(int id) {
		this.idPd = id;
	}
	
	public Date getZaciatok() {
		return zaciatok;
	}
	public void setZaciatok(Date zaciatok) {
		this.zaciatok = zaciatok;
	}
	public Date getKoniec() {
		return koniec;
	}
	public void setKoniec(Date koniec) {
		this.koniec = koniec;
	}
	public int getVodic() {
		return zamestnanec;
	}
	public void setVodic(int vodic) {
		this.zamestnanec = vodic;
	}
}