package hibernate.using.annotation;
import hibernate.using.CommonMethods;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Create Configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.annotation/hibernate.cfg.xml");

        // Create Session Factory
        SessionFactory sessionFactory
                = configuration.buildSessionFactory();

        // Initialize Session Object
        Session session = sessionFactory.openSession();

        // Get all entries using Criteria API
        System.out.println("Getting all people using the Criteria API");
        List<Person> entriesCriteria=CommonMethods.getAllEntriesUsingCriteriaApi(session,Person.class);
        for(Person entry:entriesCriteria)
        {
            System.out.println(entry);
        }

        // Get all entries using HQL
        System.out.println("Getting all people using JPQL");
        List<hibernate.using.xml.Person> entriesHQL= CommonMethods.getAllEntriesUsingHQL(session, hibernate.using.xml.Person.class);
        for(hibernate.using.xml.Person entry:entriesHQL)
        {
            System.out.println(entry);
        }

        // add new Person
        Transaction transaction= session.beginTransaction();
        session.persist(Person.generateRandomPerson());
        transaction.commit();

        session.close();
    }
}