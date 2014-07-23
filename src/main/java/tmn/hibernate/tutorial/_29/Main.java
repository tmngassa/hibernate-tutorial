package tmn.hibernate.tutorial._29;

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
		UserDetail user = new UserDetail();
		user.setUserName("Tomson");
		session.save(user);
		
		Query q = session.getNamedQuery("UserDetail.byId");
		q.setInteger("myId", 0);
		List<UserDetail> users = (List<UserDetail>)q.list();
		*/
		
		Criteria c =  session.createCriteria(UserDetail.class);
		c.add(Restrictions.eq("userName", "Tomson"));
		
		List<UserDetail> users = (List<UserDetail>)c.list();		
		
		
		for(UserDetail u : users){
			System.out.println("\nUser name: " + u.getUserName());
		}
		
		session.getTransaction().commit();
		session.close();
		
	}

}
