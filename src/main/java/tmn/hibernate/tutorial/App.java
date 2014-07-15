package tmn.hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tmn.hibernate.tutorial.model.Employee;

import com.ranga.util.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Employee employee = new Employee();
        employee.setName("Ranga Reddy");
        employee.setAge(25);
        
        long employeeId  = (Long)session.save(employee);
        employee = (Employee) session.get(Employee.class, employeeId);
        
        System.out.println(employee);

        session.save(employee);
        session.getTransaction().commit();
                
        session.close();        
    }
}
