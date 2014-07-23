package tmn.hibernate.tutorial._33;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tmn.hibernate.tutorial.util.HibernateUtil;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("\n\nFirst Session");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetail user1 = (UserDetail) session.get(UserDetail.class, 1);
		user1.setUserName("Joe");
		
		UserDetail user2 = (UserDetail) session.get(UserDetail.class, 1);
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("\n\nSecond Session");
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
		user2 = (UserDetail) session2.get(UserDetail.class, 1);
		
		session2.getTransaction().commit();
		session2.close();
	}

}
