package tmn.hibernate.tutorial._12;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tmn.hibernate.tutorial._12.Address;
import tmn.hibernate.tutorial._12.UserDetail;
import tmn.hibernate.tutorial.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		// Storing object
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		UserDetail user = new UserDetail();
		user.setUserName("Tomson M. Ngassa");

		Address addr = new Address();
		addr.setCity("Kumba");
		addr.setPincode("1234");
		addr.setState("SW");
		addr.setStreet("Ngassa street");

		Address addr1 = new Address();
		addr1.setCity("Kumba");
		addr1.setPincode("5678");
		addr1.setState("SW");
		addr1.setStreet("Kumba town street");

		user.getListOfAddresses().add(addr);
		user.getListOfAddresses().add(addr1);

		session.save(user);
		session.getTransaction().commit();
		session.close();
	
		session = sessionFactory.openSession();
		user = (UserDetail) session.get(UserDetail.class, 1);
		session.close();
		System.out.println("Size: " + user.getListOfAddresses().size());
	}
}
