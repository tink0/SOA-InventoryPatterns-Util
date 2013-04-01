package sk.tuke.seregely.dipl.util.entity;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import db.HibernateUtil;

public class EntityDAO<T> {

	private static final Log log = LogFactory.getLog(EntityDAO.class);

	private final SessionFactory sessionFactory = getSessionFactory();
	
	private final Session session;
	
	private String className;
	
	private String idName;
	
	public EntityDAO(String name, String id) {
		session = sessionFactory.openSession();
		className = name;
		idName = id;
	}

	protected SessionFactory getSessionFactory() {
		HibernateUtil.getSessionFactory();
		try {
			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}
	public void persist(T transientInstance) {
		log.debug("persisting Jazda instance");
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(transientInstance);
			tx.commit();
			log.debug("persist successful");
		} catch (HibernateException e) {
			log.error("persist failed", e);
			if(tx != null) tx.rollback();
			throw e;
		}
	}

	public void attachDirty(T instance) {
		log.debug("attaching dirty instance");
		try {
			sessionFactory.openSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}


	public void delete(T persistentInstance) {
		log.debug("deleting instance");
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(persistentInstance);
			log.debug("delete successful");
			tx.commit();
		} catch (HibernateException e) {
			log.error("delete failed", e);
			if(tx != null) tx.rollback();
			throw e;
		}
	}

	public T merge(T detachedInstance) {
		log.debug("merging Jazda instance");
		Transaction tx = null;
		try {
			tx = session.beginTransaction();		
			session.update(detachedInstance);
			log.debug("merge successful");
			tx.commit();
			return detachedInstance;
		} catch (HibernateException e) {
			log.error("merge failed", e);
			if(tx != null) tx.rollback();
			throw e;
		}
	}

	public T findById(int id) {
		log.debug("getting Jazda instance with id: " + id);
		try {
			Query query = session.createQuery("from "+className+" where "+idName+" = ?");
			query.setInteger(0, id);
			T instance =(T) query.uniqueResult();
			
			if (instance == null) {
				log.debug("get successful, no instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<T> findAll() {
		try {
			Query query = session.createQuery("from "+className);
			List<T> jazdy = query.list();
			return jazdy;
		} catch (HibernateException ex) {	
			log.debug("findAll Error:" +ex);
		} 
		return null;
	}
	
	public Session getSession() {
		return session;
	}
	
	public String getClassName() {
		return className;
	}
	
	public String getIdName() {
		return idName;
	}
	
	
}
