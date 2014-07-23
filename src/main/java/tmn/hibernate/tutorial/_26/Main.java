package tmn.hibernate.tutorial._26;

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
		
		/*
		
		for(int i= 0; i< 10; i++){			
			UserDetail user = new UserDetail();
			user.setUserName("Tomson " +i);
			session.save(user);
		}
		
		
		Query q = session.createQuery("from UserDetail");
		q.setFirstResult(5);
		q.setMaxResults(3);
		
		Collection<UserDetail> users = (Collection<UserDetail>)q.list();		
		
		for(UserDetail u : users){
			System.out.println("\nUser name: " + u.getUserName());
		}
		
		*/
		
		Query q = session.createQuery("select userName from UserDetail");
		q.setFirstResult(5);
		q.setMaxResults(3);
		
		Collection<String> userNames = (Collection<String>)q.list();		
		
		for(String u : userNames){
			System.out.println("\nUser name: " + u);
		}
		session.getTransaction().commit();
		session.close();
		
	}

}
