package dao;

import pojos.User;
import static utils.HibernateUtils.getFactory;
import java.io.Serializable;
import org.hibernate.*;

public class UserDaoImpl implements IUserDao {
	// No data members, no ctor, no cleanUP
	
	
	
	@Override
	public String registerUser(User user) {
		String mesg = "User reg failed";
		//user : state : Transient
		// get the session from  session factory
		Session session = getFactory().openSession();
		//begin a transaction tx
		
		Transaction tx = session.beginTransaction();// DB conis pooled out -- wrapped in session obj, l1 cache clear
		try {
			//org.hibernate.session API : public Serializable save(object transientObjRef) throws HibernateEXc
			Serializable userId = session.save(user); // user ref is added in cache : Persistent
			tx.commit(); //Upon commit : Hibernate performs " auto dirty checking" : by comparing state of 
						// L1 cache with that of Db : DML will be fired (insert) 
			
			mesg = "user registered successfully with ID="+userId;
		}catch(RuntimeException e){
			if(tx != null)
				tx.rollback();
			throw e;
			
		}finally {
			if(session != null )
				session.close(); // return to the pool nd L1 cache is destroyed
		}
		
		return mesg;
	}

}
