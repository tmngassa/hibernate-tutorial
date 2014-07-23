package tmn.hibernate.tutorial._04;

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
        
        UserDetails user = new UserDetails();
        user.setUserName("Tomson");
       
        session.save(user);
        session.getTransaction().commit();
                
        session.close();        
    }
}
