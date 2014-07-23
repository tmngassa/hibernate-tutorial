package tmn.hibernate.tutorial._05;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tmn.hibernate.tutorial.util.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        UserDetails user =  new UserDetails();
        user.setUserId(1);
        user.setUserName("Tomson M. Ngassa");
        user.setAddress("My address");
        user.setJoinDate(new Date());
        user.setDescription("User description");        
        session.save(user);
        session.getTransaction().commit();
                
        session.close();        
        
       
    }
}
