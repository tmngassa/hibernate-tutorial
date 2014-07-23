package tmn.hibernate.tutorial._22_23;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tmn.hibernate.tutorial.util.HibernateUtil;


public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Transient object
		UserDetail user =  new UserDetail();
		user.setUserName("Tomson M. Ngassa");
				
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//Persistence object	
		session.save(user);
		//Hibernate is doing insert
		
		//Updating user;
		user.setUserName("Pius N. Ngassa");
		user.setUserName("Joe Y. Ngassa");
		//stored updated user
		
		session.getTransaction().commit();
		session.close();
		
		//Detached object: after closing the session no update is persist in db
		user.setUserName("Many");
		
		
	}

}
