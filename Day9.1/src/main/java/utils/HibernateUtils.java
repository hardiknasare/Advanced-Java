package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory factory;
	
	// creating single instance.
	static {
		factory = new Configuration().configure().buildSessionFactory();
	}
	
	public static SessionFactory getFactory() {
		return factory;
	}
}