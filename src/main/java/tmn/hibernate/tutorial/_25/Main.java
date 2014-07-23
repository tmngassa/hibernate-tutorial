package tmn.hibernate.tutorial._25;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tmn.hibernate.tutorial.util.HibernateUtil;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		for(int i= 0; i< 10; i++){			
			UserDetail user = new UserDetail();
			user.setUserName("Tomson " +i);
			session.save(user);
		}
		
		
		Query q = session.createQuery("from UserDetail where userId > 5");
		Collection users = q.list();
		
		
		System.out.println("\nSize: " + users.size());
		
		session.getTransaction().commit();
		session.close();
		
	}

}
