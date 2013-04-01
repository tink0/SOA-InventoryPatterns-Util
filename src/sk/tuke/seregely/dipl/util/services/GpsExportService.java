package sk.tuke.seregely.dipl.util.services;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

import sk.tuke.seregely.dipl.util.entity.EntityDAO;
import sk.tuke.seregely.dipl.util.entity.GpsExport;


@WebService()
public class GpsExportService {
	
	final EntityDAO<GpsExport> gpsExportDAO = new EntityDAO("sk.tuke.seregely.dipl.util.entity.GpsExport","id");

	@WebMethod()
	public GpsExport retrieve(int id) {
		return gpsExportDAO.findById(id);
	}
	
	@WebMethod()
	public GpsExport create(Date zaciatok, Date koniec, int idJazdy, int vozidlo, int vodic) {
		GpsExport novyExport = new GpsExport(vozidlo, idJazdy, zaciatok, koniec, vodic);
		
		gpsExportDAO.persist(novyExport);
		
		return novyExport;
	}
	
	@WebMethod()
	public void delete(int id) {
		GpsExport toDelete;
		toDelete = gpsExportDAO.findById(id);
		gpsExportDAO.delete(toDelete);
	}
	
	@WebMethod()
	public GpsExport update(GpsExport export) {
		return gpsExportDAO.merge(export);
	}
	
	
}