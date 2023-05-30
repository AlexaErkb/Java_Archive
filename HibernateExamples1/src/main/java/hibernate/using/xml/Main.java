package hibernate.using.xml;

import hibernate.using.CommonMethods;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create Configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate/xml/hibernate.cfg.xml");

        // Create Session Factory
        SessionFactory sessionFactory
                = configuration.buildSessionFactory();
        // Initialize Session Object
        Session session = sessionFactory.openSession();

        // Get all entries using Criteria API
        /*
        System.out.println("Getting all people using the Criteria API");
        List<Person> entriesCriteria=CommonMethods.getAllEntriesUsingCriteriaApi(session,Person.class);
        for(Person entry:entriesCriteria)
        {
            System.out.println(entry);
        }
         */

        // Get all entries using HQL
        /*
        System.out.println("Getting all people using JPQL");
        List<Person> entriesHQL= CommonMethods.getAllEntriesUsingHQL(session,Person.class);
        for(Person entry:entriesHQL)
        {
            System.out.println(entry);
        }
        session.close();
         */
        Scanner in = new Scanner(System.in);
        int choice = -1;
        while (choice!=0) {
            List<Person> entriesHQL;
            List<Department> departments;
            System.out.println("""
                            Введите 1, если хотите вывести информацию обо всех сотрудниках
                            Введите 2, если хотите добавить сотрудника
                            Введите 3, если хотите найти сотрудника по id
                            Введите 4, если хотите найти сотрудника по имени
                            Введите 5, если хотите найти сотрудника по дате рождения
                            Введите 6, если хотите изменить любую информацию о сотруднике
                            Введите 7, если хотите удалить сотрудника
                            Введите 8, если хотите получить общую сумму зарплат всех сотрудников
                            Введите 9, если хотите вывести всю информацию о департамента
                            Введите 10, если хотите найти сотрудника по департаменту
                            Введите 11, если хотите изменить информацию о департаменте
                            Введите 0, если хотите выйти""");
            choice = in.nextInt();
            switch (choice) {
                case 1 -> {
                    entriesHQL = CommonMethods.getAllEntriesUsingHQL(session, Person.class);
                    for(Person entry:entriesHQL)
                    {
                        System.out.println(entry);
                    }
                }
                case 2 -> {
                    //CommonMethods.addNew(session, Person.class, in.next(),
                    //        in.next(), java.sql.Date.valueOf(in.next()), in.next(), in.nextInt(), in.nextInt());
                    session.getTransaction().begin();
                    System.out.println("Введите имя нового пользователя");
                    String firstname = in.next();
                    System.out.println("Введите фамилию нового пользователя");
                    String surname = in.next();
                    System.out.println("Введите дату рождения нового пользователя");
                    java.sql.Date birthday = java.sql.Date.valueOf(in.next());
                    System.out.println("Введите адрес нового пользователя");
                    String address = in.next();
                    System.out.println("Введите зарплату нового пользователя");
                    Integer salary = in.nextInt();
                    System.out.println("Введите id департамента нового пользователя");
                    Integer department_id = in.nextInt();
                    hibernate.using.xml.Person person = new hibernate.using.xml.Person(firstname, surname,
                            address, birthday, salary, department_id);
                    session.persist(person);
                    session.getTransaction().commit();
                }
                case 3 -> {
                    System.out.println("Введите id сотрудника которого хотите найти");
                    entriesHQL = CommonMethods.getById(session, Person.class, in.nextInt());
                    for(Person entry:entriesHQL)
                    {
                        System.out.println(entry);
                    }
                }
                case 4 -> {
                    System.out.println("Введите имя сотрудника которого хотите найти");
                    entriesHQL = CommonMethods.getByName(session, Person.class, in.next());
                    for(Person entry:entriesHQL)
                    {
                        System.out.println(entry);
                    }
                }
                case 5 -> {
                    System.out.println("Введите дату рождения сотрудника которого хотите найти");
                    entriesHQL = CommonMethods.getByBirthday(session, Person.class, java.sql.Date.valueOf(in.next()));
                    for(Person entry:entriesHQL)
                    {
                        System.out.println(entry);
                    }
                }
                case 6 -> {
                    System.out.println("Введите id сотрудника, которому хотите поменять данные");
                    int id_s = in.nextInt();
                    CommonMethods.update(session, Person.class, id_s);
                }
                case  7 -> {
                    System.out.println("Введите id сотрудника, которого хотите удалить");
                    int id_s = in.nextInt();
                    CommonMethods.delete(session, Person.class, id_s);
                }
                case 8 -> {
                    CommonMethods.sumSalaries(session, Person.class);
                }
                case 9 -> {
                    departments = CommonMethods.getAllDepartments(session, Department.class);
                    for(Department entry:departments)
                    {
                        System.out.println(entry);
                    }
                }
                case 10 -> {
                    System.out.println("Введите id департамента: ");
                    entriesHQL = CommonMethods.getEmployeesByDep(session, Person.class, in.nextInt());
                    for(Person entry:entriesHQL)
                    {
                        System.out.println(entry);
                    }
                }
                case 11 -> {
                    System.out.println("Введите id департамента, в котором хотите поменять данные: ");
                    int id_s = in.nextInt();
                    CommonMethods.update_dep(session, Department.class, id_s);
                }
                case 0 -> {
                    break;
                }
                default -> {
                    System.out.println("Попробуйте ввести другое значение");
                }
            }
        }
    }

}