package tmn.hibernate.tutorial._24;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tmn.hibernate.tutorial.util.HibernateUtil;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Transient object
		/*
		UserDetail user = new UserDetail();
		user.setUserName("Tomson M. Ngassa");
		*/
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		UserDetail user =  (UserDetail) session.get(UserDetail.class, 1);		
		
		//session.save(user);
		session.getTransaction().commit();
		session.close();
		
		
		//Reopen session
		
		//user.setUserName("Updated username after session close");
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		//user.setUserName("Change after update");
		
		session.getTransaction().commit();
		session.close();
		

	}

}
