package tmn.hibernate.tutorial._16;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tmn.hibernate.tutorial._16.UserDetail;
import tmn.hibernate.tutorial._16.Vehicle;
import tmn.hibernate.tutorial.util.HibernateUtil;

public class Main {

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
				vehicle.setUserDetail(user);

				Vehicle vehicle1 = new Vehicle();
				vehicle1.setVehicleName("PASSAT");
				vehicle1.setUserDetail(user);

				user.getVehicles().add(vehicle);
				user.getVehicles().add(vehicle1);

				session.persist(user);
				
				//session.save(vehicle);
				//session.save(vehicle1);

				session.getTransaction().commit();
				session.close();
	}

}
