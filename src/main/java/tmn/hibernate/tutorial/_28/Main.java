package tmn.hibernate.tutorial._28;

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
		UserDetail user = new UserDetail();
		user.setUserName("Tomson");
		session.save(user);
		
		int minUserId = 5;
		*/
		Query q = session.getNamedQuery("UserDetail.byId");
		//Query q = session.getNamedQuery("UserDetail.byName");
		q.setInteger(0, 0);
		
//		q.setFirstResult(5);
//		q.setMaxResults(3);
		
		Collection<UserDetail> users = (Collection<UserDetail>)q.list();		
		
		System.out.println("Size: " + users.size());
		
		for(UserDetail u : users){
			System.out.println("\nUser name: " + u.getUserName());
		}
		
		session.getTransaction().commit();
		session.close();
		
	}

}
