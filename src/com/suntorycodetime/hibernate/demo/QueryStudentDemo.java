package com.suntorycodetime.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.suntorycodetime.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();

		try {
		
			// start transaction
			session.beginTransaction();
			
			// query students
			List<Student> students = session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudents(students);
			
			// query students: lastName='Duck'
			students = session.createQuery("from Student s where s.lastName='Duck'").getResultList();
			
			// display the students
			System.out.println("\n\n\tStudents who have last name duck");
			displayStudents(students);
			
			
			// Query students: lastName='Pennyworth' OR firstName='Daffy'
			students = session.createQuery("from Student s where s.lastName='Pennyworth' OR s.firstName='Daffy'").getResultList();
			
			// display the students
			System.out.println("\n\n\tStudents whose last name is Pennyworth or First Name is Daffy");
			displayStudents(students);
			
			// Query students where email LIKE '%gmail.com'
			students = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			
			// display the students
			System.out.println("\n\n\tStudents whose email ends in gmail.com");
			displayStudents(students);

			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

	/**
	 * @param students
	 */
	private static void displayStudents(List<Student> students) {
		for(Student student : students) {
			System.out.println(student);
		}
	}

}
