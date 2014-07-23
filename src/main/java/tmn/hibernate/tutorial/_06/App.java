package tmn.hibernate.tutorial._06;

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
        user.setAddress("First address");
        user.setJoinDate(new Date());
        user.setDescription("User description");
        
        session.save(user);
        session.getTransaction().commit();
        session.close();
        
        //------ Retrieving object
        
        user = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        
        user = (UserDetails) session.get(UserDetails.class, 1 );
        
        System.out.println(user.toString());
        session.getTransaction().commit();
        session.close();     
        
       
    }
}
