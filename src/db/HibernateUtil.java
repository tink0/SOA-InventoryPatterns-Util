package db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import sk.tuke.seregely.dipl.util.entity.DovolenkaExport;
import sk.tuke.seregely.dipl.util.entity.GpsExport;
import sk.tuke.seregely.dipl.util.entity.PdExport;
import sk.tuke.seregely.dipl.util.entity.PnExport;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
           Configuration configuration = new Configuration()
   		 .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
   		 .setProperty("hibernate.connection.driver_class", 
   		 "org.postgresql.Driver")
   		 .setProperty("hibernate.connection.url", 
   		 "jdbc:postgresql://localhost/postgres")
   		 .setProperty("hibernate.connection.username", "postgres")
   		 .setProperty("hibernate.current_session_context_class","org.hibernate.context.ThreadLocalSessionContext")
   		 .setProperty("hibernate.connection.password", "superpass")
   		 .addClass(GpsExport.class)
   		 .addClass(PdExport.class)
   		 .addClass(PnExport.class)
   		 .addClass(DovolenkaExport.class);
           
           SessionFactory sessFact = configuration.buildSessionFactory();
            return sessFact;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}