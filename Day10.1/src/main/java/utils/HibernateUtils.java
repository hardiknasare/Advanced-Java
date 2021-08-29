package utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory factory;
	
	// ensuring singleton obj creation of the session factory i.e EAGER 
	static {
		System.out.println("In static init block");
		factory = new Configuration().configure().buildSessionFactory(); //accessing the hibernate cfg file
	}
	
	public static SessionFactory getFactory() { // getter for Session Factory
		return factory;
	}
	
}
