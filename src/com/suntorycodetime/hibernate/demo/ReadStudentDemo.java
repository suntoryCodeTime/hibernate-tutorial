package com.suntorycodetime.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.suntorycodetime.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save the student object
			System.out.println("Creating a new student object...");
			Student student = new Student("Daffy", "Duck", "daffy@gmail.com");
			
			// start transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			System.out.println(student);
			session.save(student);
			
			//commit transaction
			session.getTransaction().commit();
			
			//Read Student from Database
			
			//Get a new sessions, start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id:primary key
			System.out.println("\nSave student. Generated id: " + student.getId());
			Student rStudent = session.get(Student.class, student.getId());
			
			System.out.println("Get complete: " + rStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
