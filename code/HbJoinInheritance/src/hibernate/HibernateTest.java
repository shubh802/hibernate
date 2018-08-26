package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dto.FourWheeler;
import dto.TwoWheeler;
import dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {

		
		Vehicle vehicle = new Vehicle();	
		vehicle.setVehicleName("Car");

		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Pulsar");
		bike.setSteeringHandle("Bike Steering handle");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("Dzire");
		car.setSteeringWheel("Car steering wheel");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		session.getTransaction().commit();
		session.close();
		
		sessionFactory.close();
		
	}
}
