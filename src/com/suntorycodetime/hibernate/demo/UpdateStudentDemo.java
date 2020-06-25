package com.suntorycodetime.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.suntorycodetime.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();

		try {
			// start transaction
			session.beginTransaction();
			
			// Update Student with id='1'
			Student student = session.get(Student.class, 1);
			student.setFirstName("Scooby");
			
			//commit transaction
			session.getTransaction().commit();
			
			// New code
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			// Update email for all students
			System.out.println("Update email for all students");
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
