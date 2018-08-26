package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dto.Address;
import dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserName("Shubh");
			
		UserDetails user2 = new UserDetails();
		user2.setUserName("Anant");
		
		Address addr = new Address();
		addr.setStreet("Home Street Name");
		addr.setCity("Bangalore");
		addr.setPincode("560037");
		
		user.setHomeAddress(addr);
		
		Address addr2 = new Address();
		addr2.setStreet("Office Street Name");
		addr2.setCity("Varanasi");
		addr2.setPincode("226001");
		
		user.setOfficeAddress(addr2);
	
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
//		session.save(user2);

		session.getTransaction().commit();
		session.close();
		
		sessionFactory.close();
	}
}
