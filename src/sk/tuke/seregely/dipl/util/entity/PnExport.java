package sk.tuke.seregely.dipl.util.entity;

import java.util.Date;

public class PnExport {

	private int idPn;
	private Date zaciatok;
	private Date koniec;
	private int zamestnanec;
	
	public PnExport() {
		
	}
	
	public PnExport( int id, Date zaciatok, Date koniec, int vodic) {
		this.idPn = id;
		this.zaciatok = zaciatok;
		this.koniec = koniec;
		this.zamestnanec = vodic;
	}

	public int getIdPn() {
		return idPn;
	}
	public void setIdPn(int id) {
		this.idPn = id;
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