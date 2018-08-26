package org.shubham.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.shubham.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserId(3);
		user.setUserName("Shayam");
		user.setAddress("Test address");
		user.setJoinedDate(new Date());
		user.setDescription("This is to test the description");
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails)session.get(UserDetails.class, 3);
		System.out.println("user name retrieved is "+user.getUserName());
	}
}
