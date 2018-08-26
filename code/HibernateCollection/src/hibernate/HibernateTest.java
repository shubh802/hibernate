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
		addr.setStreet("Street Name");
		addr.setCity("Bangalore");
		addr.setPincode("560037");
		
		
		Address addr2 = new Address();
		addr2.setStreet("Street Name");
		addr2.setCity("Varanasi");
		addr2.setPincode("226001");
		
		user.getListofAddress().add(addr);
		user.getListofAddress().add(addr2);
	
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);

		session.getTransaction().commit();
		session.close();
		
		user=null;
		session = sessionFactory.openSession();
		//this will not pull the address list of the collection
		user = (UserDetails) session.get(UserDetails.class, 1);
		session.close();
		//Lazy initialization 
		System.out.println(user.getListofAddress().size());
		
		sessionFactory.close();
		
	}
}
