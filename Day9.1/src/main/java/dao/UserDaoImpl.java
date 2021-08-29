package dao;

import pojos.User;
import static utils.HibernateUtils.getFactory;

import java.io.Serializable;

import org.hibernate.*;

public class UserDaoImpl implements IUserDao {
	// unlike jdbc here in hibernate, there is no data mem, ctor ,etc

	@Override
	public String registerUser(User user) {
		String mesg = "User Reg failed";
		// here state of User is : TRANSIENT
		
		// step 1 : getting the created session from sesssionFactory
		Session session = getFactory().openSession();
		Session session2 = getFactory().openSession();
		System.out.println("comparison :"+ (session == session2) ); // False

		// Anything, everything in the session has to be done with transaction so,
		// beginning a transaction
		Transaction tx = session.beginTransaction();//empty L1 cache is created
		System.out.println("Is session open : "+session.isOpen()); // True
		System.out.println("Is session connected to DB :"+session.isConnected()); // True
		try {
			// org,hibernate.Session API crud methods : Serializable sav(Object transientObjRef) 
			// it throws HibernateException if something goes wrong
			
			Serializable userId = session.save(user); // user reference is added in L1cache
			//state of User : PERSISTENT ( jab bhi 11 cache ka part hoga state persisten hoga)
			
			tx.commit();// main operation is carried out when tx is commited DML will be fired(CRUD op)
			// at this time hibernate does dirty checking automatically 
			// means compairing state by state of L1 cache with DB and apllies necessary changes 			
			
			mesg = "User registered successfully with ID = "+userId;
			System.out.println("Is session open : "+session.isOpen()); // True
			System.out.println("Is session connected to DB :"+session.isConnected()); // True
		} catch (RuntimeException e) { // in hibernate we are going to deal with unchecked exception
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (session != null)
				session.close();
		}
		
		System.out.println("Is session open : "+session.isOpen()); // False
		System.out.println("Is session connected to DB :"+session.isConnected()); // False
		
		return mesg;
	}
	
	@Override
	public String registerUserbyWithGetCurrentSession(User user) {
		String mesg = "User Reg failed";
		// here state of User is : TRANSIENT
		
		// step 1 : getting the created session from sesssionFactory
		Session session = getFactory().getCurrentSession();
		Session session2 = getFactory().getCurrentSession();
		
		System.out.println("comparison :"+ (session == session2) ); // True
		
		// Anything, everything in the session has to be done with transaction so,
		// beginning a transaction
		Transaction tx = session.beginTransaction();//empty L1 cache is created
		System.out.println("Is session open : "+session.isOpen()); // True
		System.out.println("Is session connected to DB :"+session.isConnected()); // True
		
		try {
			// org,hibernate.Session API crud methods : Serializable sav(Object transientObjRef) 
			// it throws HibernateException if something goes wrong
			
			Serializable userId = session.save(user); // user reference is added in L1cache
			//state of User : PERSISTENT ( jab bhi 11 cache ka part hoga state persisten hoga)
			
			tx.commit();// main operation is carried out when tx is commited DML will be fired(CRUD op)
			// at this time hibernate does dirty checking automatically 
			// means compairing state by state of L1 cache with DB and apllies necessary changes
			
			//in case of getCurrentsession hibernate automaticaly closes the transaction just after commit
			// pooling out DB closing connections and destroying L1 cache
			
			mesg = "User registered successfully with ID = "+userId;
			
			System.out.println("Is session open : "+session.isOpen()); // False
			System.out.println("Is session connected to DB :"+session.isConnected()); // False
			System.out.println();
			
		} catch (RuntimeException e) { // in hibernate we are going to deal with unchecked exception
			if (tx != null)
				tx.rollback();
			throw e;
		}
		System.out.println("Is session open : "+session.isOpen()); // False
		System.out.println("Is session connected to DB :"+session.isConnected()); // False
		return mesg;
	}

	@Override
	public User getUserDetails(int userId) {
		User user = null;
		
		// getting session
		Session session = getFactory().getCurrentSession();
		
		//begin transaction
		Transaction tx = session.beginTransaction();
		
		try {
			
			user = session.get(User.class, userId);
			tx.commit(); // if not written memoryleak occurs
		}
		catch (RuntimeException e) { // in hibernate we are going to deal with unchecked exception
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return user;
	}
}
