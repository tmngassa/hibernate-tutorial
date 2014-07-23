package tmn.hibernate.tutorial._27;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tmn.hibernate.tutorial.util.HibernateUtil;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		int minUserId = 5;
		String username = "Tomson 8";
		
		Query q = session.createQuery("from UserDetail where userId > :id and userName= :name");
		q.setInteger("id", minUserId);
		q.setString("name", username);
		
//		q.setFirstResult(5);
//		q.setMaxResults(3);
		
		Collection<UserDetail> users = (Collection<UserDetail>)q.list();		
		
		//System.out.println("Size: " + users.size());
		
		for(UserDetail u : users){
			System.out.println("\nUser name: " + u.getUserName());
		}
		
		session.getTransaction().commit();
		session.close();
		
	}

}
