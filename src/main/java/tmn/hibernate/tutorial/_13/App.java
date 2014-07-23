package tmn.hibernate.tutorial._13;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tmn.hibernate.tutorial._13.UserDetail;
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
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("FIAT PUNTO");
		
		user.setVehicle(vehicle);
		
		session.save(user);
		session.save(vehicle);
		
		session.getTransaction().commit();
		session.close();


	}

}
