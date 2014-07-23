	package tmn.hibernate.tutorial._17_18;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tmn.hibernate.tutorial.util.HibernateUtil;


public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Vehicle v =  new Vehicle();
		v.setVehicleName("CAR");
		
		TwoWheeler t =  new TwoWheeler();
		t.setVehicleName("BIKE");
		t.setSteeringHandle("Bike steering Handle");
		
		FourWheeler f =  new FourWheeler();
		f.setVehicleName("PORSCHE");
		f.setSteeringWheel("Porsche steering wheel");
		
		session.save(v);
		session.save(t);
		session.save(f);
		
		session.getTransaction().commit();
		session.close();
	}

}
