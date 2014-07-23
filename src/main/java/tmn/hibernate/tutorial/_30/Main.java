package tmn.hibernate.tutorial._30;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.hql.internal.ast.tree.RestrictableStatement;

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
		
		
		Criteria c =  session.createCriteria(UserDetail.class);
		c.add(Restrictions.or(Restrictions.between("userId", 0, 3), Restrictions.between("userId", 7, 9)));
		/*
		Restrictions.like("userName", "Tomson%"))
		.add(Restrictions.gt("userId", 5))
		.add(Restrictions.between("userId", 5, 8));
		*/
		List<UserDetail> users = (List<UserDetail>)c.list();		
		
		
		for(UserDetail u : users){
			System.out.println("\nUser name: " + u.getUserName());
		}
		session.getTransaction().commit();
		session.close();
		
	}

}
