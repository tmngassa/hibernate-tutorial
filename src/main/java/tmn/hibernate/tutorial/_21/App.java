package tmn.hibernate.tutorial._21;

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
		
		// CRUD
		
		//Creating objects
		for (int i=0; i < 10; i++){
			UserDetail user =  new UserDetail();
			user.setUserName("Tomson M. Ngassa" + i);
			session.save(user);
		}	
		
		//Reading or Getting Object 
		
		UserDetail user = (UserDetail) session.get(UserDetail.class, 9);
		System.out.println( user.toString());
		
		//Update object
		
		user.setUserName("Pius N. Ngassa");
		session.update(user);
		user = (UserDetail) session.get(UserDetail.class, 9);
		System.out.println( "\nReading updated user:" + user.toString());
		
		
		//Deleting object
		user = (UserDetail) session.get(UserDetail.class, 10);
		session.delete(user);
		
		session.getTransaction().commit();
		session.close();
	}

}
