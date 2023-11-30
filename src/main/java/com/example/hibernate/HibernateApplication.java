package com.example.hibernate;

import com.example.hibernate.models.Hibernates;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class HibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
        UpdateLastName();
    }

    public static void Insert() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Hibernates.class).buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            Hibernates hibernate = new Hibernates("Викулин", "Павел", "Батькович");
            session.beginTransaction();
            session.persist(hibernate);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }

    public static void Select() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Hibernates.class).buildSessionFactory();

        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Hibernates hibernates = session.get(Hibernates.class, 1);
        session.getTransaction().commit();

        System.out.println(hibernates);
    }

    public static void SelectSurname() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Hibernates.class).buildSessionFactory();

        Session session = factory.getCurrentSession();
        session.beginTransaction();

        List<Hibernates> list = session.createQuery("from Hibernates where surname = 'Викулин'").getResultList();

        for (Hibernates e : list) {
            System.out.println(e);
        }

        session.getTransaction().commit();

    }

    public static void SelectSurnameLastName() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Hibernates.class).buildSessionFactory();

        Session session = factory.getCurrentSession();
        session.beginTransaction();

        List<Hibernates> list = session.createQuery("from Hibernates where surname = 'Викулин' and lastname = 'Батькович'").getResultList();

        for (Hibernates e : list) {
            System.out.println(e);
        }

        session.getTransaction().commit();

    }

    public static void Update() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Hibernates.class).buildSessionFactory();

        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Hibernates hibernates = session.get(Hibernates.class, 1);
        hibernates.setSurname("Анатольевич");

        session.getTransaction().commit();

    }

    public static void UpdateLastName() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Hibernates.class).buildSessionFactory();

        Session session = factory.getCurrentSession();
        session.beginTransaction();

        session.createQuery("update Hibernates set lastname = 'Анатольевич' where lastname = 'Викулин'").executeUpdate();

        session.getTransaction().commit();

    }

    public static void Delete() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Hibernates.class).buildSessionFactory();

        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Hibernates hibernates = session.get(Hibernates.class, 1);
        session.delete(hibernates);

        session.getTransaction().commit();


    }

    public static void DeleteLastname() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Hibernates.class).buildSessionFactory();

        Session session = factory.getCurrentSession();
        session.beginTransaction();

        session.createQuery("delete Hibernates where lastname = 'Батькович'").executeUpdate();

        session.getTransaction().commit();


    }
}
