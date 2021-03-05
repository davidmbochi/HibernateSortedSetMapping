package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;


public class CreateStudentImagesSortedSetDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try {
            //create the object
            Student tempStudent = new Student("john","Doe","john@luv2code.com");
            Set<String> theImages = tempStudent.getImages();

            theImages.add("photo1.jpg");
            theImages.add("photo2.jpg");
            theImages.add("photo3.jpg");
            theImages.add("photo6.jpg");
            theImages.add("photo6.jpg");//Duplicates, filtered at java level by HashSet
            theImages.add("photo7.jpg");
            theImages.add("photo7.jpg");//Duplicates, filtered at java level by HashSet
            //start a transaction
            session.beginTransaction();
            //save the object
            System.out.println("Saving the student and images");
            session.persist(tempStudent);
            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!!");
        }finally {
            //clean up code
            session.close();
            factory.close();
        }

    }
}
