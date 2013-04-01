package sk.tuke.seregely.dipl.util.entity;

import java.util.Date;

public class GpsExport {

	private int id;
	private int idVozidla;
	private int idJazdy;
	private Date zaciatok;
	private Date koniec;
	private int vodic;
	
	public GpsExport() {
		
	}
	
	public GpsExport( int idVozidla, int idJazdy, Date zaciatok, Date koniec, int vodic) {
		
		this.idVozidla = idVozidla;
		this.idJazdy = idJazdy;
		this.zaciatok = zaciatok;
		this.koniec = koniec;
		this.vodic = vodic;
	}
	
	public int getIdVozidla() {
		return idVozidla;
	}
	public void setIdVozidla(int idVozidla) {
		this.idVozidla = idVozidla;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdJazdy() {
		return idJazdy;
	}
	public void setIdJazdy(int idJazdy) {
		this.idJazdy = idJazdy;
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
		return vodic;
	}
	public void setVodic(int vodic) {
		this.vodic = vodic;
	}
}
