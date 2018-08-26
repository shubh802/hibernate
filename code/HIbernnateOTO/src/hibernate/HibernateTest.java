package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dto.UserDetails;
import dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserName("Shubh");
		
		Vehicle vehicle = new Vehicle();
		
		vehicle.setVehicleName("Jaguar");

		user.setVehicle(vehicle);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);

		session.getTransaction().commit();
		session.close();
		
		sessionFactory.close();
		
	}
}
