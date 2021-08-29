package utils;
import static utils.HibernateUtils.getFactory;
import org.hibernate.SessionFactory;

public class TestHibernate {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory())  // getting SessionFactory
		{
			System.out.println("Hibernate is up n running !!!"+sf);
		} catch(Exception e ) {
			e.printStackTrace();
		}

	}

}
