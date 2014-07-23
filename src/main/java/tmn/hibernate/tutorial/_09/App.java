package tmn.hibernate.tutorial._09;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tmn.hibernate.tutorial._09.Address;
import tmn.hibernate.tutorial._09.UserDetail;
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
		
		Address addr1 =  new Address();
		addr1.setCity("Kumba");
		addr1.setPincode("5678");
		addr1.setState("SW");
		addr1.setStreet("Kumba town street");
		
		user.setHomeAddress(addr);
		user.setOfficeAddress(addr1);
		
		session.save(user);
		session.getTransaction().commit();
		session.close();

	}
}
