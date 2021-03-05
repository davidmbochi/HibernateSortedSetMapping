package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetStudentImagesDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            int theId = 1;

            Student student = session.get(Student.class,theId);

            System.out.println("Student details: "+student);

            System.out.println("The associated images: "+student.getImages());

            session.getTransaction().commit();

            System.out.println("Done!!!");
        }finally {
            session.close();
            factory.close();

        }
    }
}
