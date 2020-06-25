package com.suntorycodetime.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.suntorycodetime.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save the student object
			System.out.println("Creating 3 student objects...");
			Student student1 = new Student("Bruce", "Wayne", "bw@gmail.com");
			Student student2 = new Student("Alfred", "Pennyworth", "ap@gmail.com");
			Student student3 = new Student("Harley", "Quinn", "hq@gmail.com");
			
			// start transaction
			session.beginTransaction();
			
			// save the student objects
			System.out.println("Saving the student...");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
