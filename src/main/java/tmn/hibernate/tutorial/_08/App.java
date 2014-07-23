package tmn.hibernate.tutorial._08;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tmn.hibernate.tutorial._08.UserDetail;
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
		
		Address addr =  new Address();
		addr.setCity("Kumba");
		addr.setPincode("1234");
		addr.setState("SW");
		addr.setStreet("Ngassa street");
		
		user.setAddress(addr);
		
		session.save(user);
		session.getTransaction().commit();
		session.close();

	}

}
