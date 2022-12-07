package db;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import model.TShirt;

public class ProductDao {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() throws HibernateException {
		
		if(sessionFactory== null) {
			
			try {
				Configuration configuration = new Configuration().configure().addAnnotatedClass(TShirt.class);
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
													applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

}
