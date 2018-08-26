package org.shubham.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.shubham.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		
			
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
//		for (int i = 0; i < 10; i++) {
//			UserDetails user = new UserDetails();
//			user.setUserName("User "+ i);
//			session.save(user);
//		}
		
		// To fetch data
		UserDetails user= session.get(UserDetails.class, 6);
		user.setUserName("Updated username");
		// To delete the data
		// session.delete(user);
		
		// To update the data
		session.update(user);
		
		session.getTransaction().commit();
		session.close();
		
//		System.out.println("User name is "+ user.getUserName());
		
		sessionFactory.close();
	}
}
