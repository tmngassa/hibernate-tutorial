package tmn.hibernate.tutorial._31;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import tmn.hibernate.tutorial.util.HibernateUtil;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		/*
		for(int i= 0; i<10; i++){			
			UserDetail user = new UserDetail();
			user.setUserName("Tomson " + i);
			session.save(user);
		}
		*/
		
		UserDetail userExample =  new UserDetail();
		userExample.setUserId(1);
		userExample.setUserName("Tomson%");

		Example example = Example.create(userExample).enableLike();
		
		Criteria c =  session.createCriteria(UserDetail.class)					  
							.add(example);
		
		//.addOrder(Order.desc("userId"));
		
		List<UserDetail> users = (List<UserDetail>)c.list();		
		
		for(UserDetail u : users){
			System.out.println("\nUser name: " + u.getUserName());
		}
		session.getTransaction().commit();
		session.close();
		
	}

}
