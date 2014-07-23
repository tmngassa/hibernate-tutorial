package tmn.hibernate.tutorial._07;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tmn.hibernate.tutorial._07.UserDetail;
import tmn.hibernate.tutorial.util.HibernateUtil;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Storing object
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		UserDetail user = new UserDetail();
		user.setUserName("Tomson M. Ngassa");
		user.setAddress("First address");
		user.setJoinDate(new Date());
		user.setDescription("User description");
		
		UserDetail user2 = new UserDetail();
		user2.setUserName("Pius N. Ngassa");
		user2.setAddress("First address 2");
		user2.setJoinDate(new Date());
		user2.setDescription("User description 2");

		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();

		// ------ Retrieving object
		/*
		user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();

		user = (UserDetail) session.get(UserDetail.class, 1);

		System.out.println(user.toString());
		session.getTransaction().commit();
		session.close();
		*/
	}

}
