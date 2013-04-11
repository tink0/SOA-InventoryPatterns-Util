package sk.tuke.seregely.dipl.util.services;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

import sk.tuke.seregely.dipl.util.entity.DovolenkaExport;
import sk.tuke.seregely.dipl.util.entity.EntityDAO;
import sk.tuke.seregely.dipl.util.entity.PdExport;
import sk.tuke.seregely.dipl.util.entity.PnExport;

@WebService()
public class AttendanceExportService {

	final EntityDAO<PnExport> pnExportDAO = new EntityDAO<PnExport>("sk.tuke.seregely.dipl.util.entity.PnExport","idpn");
	final EntityDAO<PdExport> pdExportDAO = new EntityDAO<PdExport>("sk.tuke.seregely.dipl.util.entity.PdExport","id_pp");
	final EntityDAO<DovolenkaExport> dovolenkaExportDAO = new EntityDAO<DovolenkaExport>("sk.tuke.seregely.dipl.util.entity.DovolenkaExport","id_dovolenky");

	@WebMethod()
	public PnExport retrievePn(int id) {
		return pnExportDAO.findById(id);
	}
	
	@WebMethod()
	public PnExport createPn(int id, Date zaciatok, Date koniec, int zamestnanec) {
		PnExport novyExport = new PnExport( id, zaciatok, koniec, zamestnanec);
		
		pnExportDAO.persist(novyExport);
		
		return novyExport;
	}
	
	@WebMethod()
	public void deletePn(int id) {
		PnExport toDelete;
		toDelete = pnExportDAO.findById(id);
		pnExportDAO.delete(toDelete);
	}
	
	@WebMethod()
	public PnExport updatePn(PnExport export) {
		return pnExportDAO.merge(export);
	}
	
	@WebMethod()
	public PdExport retrievePd(int id) {
		return pdExportDAO.findById(id);
	}
	
	@WebMethod()
	public PdExport createPd(int id, Date zaciatok, Date koniec, int zamestnanec) {
		PdExport novyExport = new PdExport( id, zaciatok, koniec, zamestnanec);
		
		pdExportDAO.persist(novyExport);
		
		return novyExport;
	}
	
	@WebMethod()
	public void deletePd(int id) {
		PdExport toDelete;
		toDelete = pdExportDAO.findById(id);
		pdExportDAO.delete(toDelete);
	}
	
	@WebMethod()
	public PdExport updatePd(PdExport export) {
		return pdExportDAO.merge(export);
	}
	
	@WebMethod()
	public DovolenkaExport retrieveDovolenka(int id) {
		return dovolenkaExportDAO.findById(id);
	}
	
	@WebMethod()
	public DovolenkaExport createDovolenka(int id, Date zaciatok, Date koniec, int zamestnanec) {
		DovolenkaExport novyExport = new DovolenkaExport( id, zaciatok, koniec, zamestnanec);
		
		dovolenkaExportDAO.persist(novyExport);
		
		return novyExport;
	}
	
	@WebMethod()
	public void deleteDovolenka(int id) {
		DovolenkaExport toDelete;
		toDelete = dovolenkaExportDAO.findById(id);
		dovolenkaExportDAO.delete(toDelete);
	}
	
	@WebMethod()
	public DovolenkaExport updateDovolenka(DovolenkaExport export) {
		return dovolenkaExportDAO.merge(export);
	}
}
