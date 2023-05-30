package hibernate.using;

import hibernate.using.xml.Person;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CommonMethods {

    public static<T> List<T> getAllEntriesUsingCriteriaApi(Session session,Class<T> myClass)
    {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(myClass);
        Root<T> rootEntry = cq.from(myClass);
        CriteriaQuery<T> all = cq.select(rootEntry);

        TypedQuery<T> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }

    public  static <T> List<T> getAllEntriesUsingHQL(Session session, Class<T> myClass) {
        Query query = session.createQuery("FROM Person", myClass);
        return query.getResultList();
    }

    public  static <T> List<T> getById(Session session, Class<T> myClass, Integer id) {
        Query query = session.createQuery("FROM Person WHERE id = :myParam", myClass);
        query.setParameter("myParam", id);
        return query.getResultList();
    }
    public  static <T> List<T> getByName(Session session, Class<T> myClass, String firstname) {
        Query query = session.createQuery("FROM Person WHERE firstname = :myParam", myClass);
        query.setParameter("myParam", firstname);
        return query.getResultList();
    }
    public  static <T> List<T> getByBirthday(Session session, Class<T> myClass, java.sql.Date birthday) {
        Query query = session.createQuery("FROM Person WHERE birthday = :myParam", myClass);
        query.setParameter("myParam", birthday);
        return query.getResultList();
    }
    public static void update(Session session, Class<hibernate.using.xml.Person> myClass, Integer id) {
        Scanner in = new Scanner(System.in);
        System.out.println("""
                            Введите 1, если хотите поменять имя
                            Введите 2, если хотите поменять фамилию
                            Введите 3, если хотите поменять адрес
                            Введите 4, если хотите поменять дату рождения
                            Введите 5, если хотите поменять зарплату
                            Введите 6, если хотите поменять департамент
                            Введите 0, если уже ничего не хотите""");
        session.getTransaction().begin();
        hibernate.using.xml.Person person = (hibernate.using.xml.Person)session.get(hibernate.using.xml.Person.class, id);
        int ch = in.nextInt();
        System.out.println("Введите новое значение ");
        switch (ch) {
            case 1 -> {
                String new_val = in.next();
                person.setFirstName(new_val);
                session.persist(person);
                session.getTransaction().commit();
            }
            case 2 -> {
                String new_val = in.next();
                person.setSurname(new_val);
                session.persist(person);
                session.getTransaction().commit();
            }
            case 3 -> {
                String new_val = in.next();
                person.setAddress(new_val);
                session.persist(person);
                session.getTransaction().commit();
            }
            case 4 -> {
                String new_val = in.next();
                person.setBirthday(java.sql.Date.valueOf(new_val));
                session.persist(person);
                session.getTransaction().commit();
            }
            case 5 -> {
                int new_val = in.nextInt();
                person.setSalary(new_val);
                session.persist(person);
                session.getTransaction().commit();
            }
            case 6 -> {
                int new_val = in.nextInt();
                person.setDepartment_id(new_val);
                session.persist(person);
                session.getTransaction().commit();
            }
            case 0 -> {
                break;
            }
            default -> {
                System.out.println("Попробуйте ввести другое значение");
            }
        }
    }
    public static void delete(Session session, Class<hibernate.using.xml.Person> myClass, Integer id) {
        session.getTransaction().begin();
        hibernate.using.xml.Person person = (hibernate.using.xml.Person)session.get(hibernate.using.xml.Person.class, id);
        session.remove(person);
        //session.persist(person);
        session.flush();
        session.getTransaction().commit();
    }

    public static void sumSalaries(Session session, Class<hibernate.using.xml.Person> myClass) {
        session.getTransaction().begin();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Integer> cr = cb.createQuery(Integer.class);
        Root<hibernate.using.xml.Person> root = cr.from(Person.class);
        cr.select(cb.sum(root.get("salary")));
        Query<Integer> query = session.createQuery(cr);
        List<Integer> result = query.getResultList();

        for (Iterator res = result.iterator(); res.hasNext();){
            System.out.println("Суммарная зарплата: " + res.next());
        }

        session.getTransaction().commit();
    }
    public static<T> List<T> getAllDepartments(Session session,Class<T> myClass)
    {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(myClass);
        Root<T> rootEntry = cq.from(myClass);
        CriteriaQuery<T> all = cq.select(rootEntry);

        TypedQuery<T> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }
    public static<T> List<T> getEmployeesByDep(Session session,Class<T> myClass, Integer dep_id) {
        session.getTransaction().begin();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<T> cr = cb.createQuery(myClass);
        Root<T> root = cr.from(myClass);
        cr.select(root).where(cb.equal(root.get("department_id"), dep_id));
        TypedQuery<T> allQuery = session.createQuery(cr);
        return allQuery.getResultList();
    }
    public static void update_dep(Session session, Class<hibernate.using.xml.Department> myClass, Integer id) {
        Scanner in = new Scanner(System.in);
        System.out.println("""
                            Введите 1, если хотите поменять название
                            Введите 2, если хотите поменять описание
                            Введите 3, если хотите поменять директора
                            Введите 0, если уже ничего не хотите""");
        session.getTransaction().begin();
        hibernate.using.xml.Department department = (hibernate.using.xml.Department)session.get(hibernate.using.xml.Department.class, id);
        int ch = in.nextInt();
        System.out.println("Введите новое значение ");
        switch (ch) {
            case 1 -> {
                String new_val = in.next();
                department.setDepartment_name(new_val);
                session.persist(department);
                session.getTransaction().commit();
            }
            case 2 -> {
                String new_val = in.next();
                department.setDescription(new_val);
                session.persist(department);
                session.getTransaction().commit();
            }
            case 3 -> {
                int new_val = in.nextInt();
                department.setDirector(new_val);
                session.persist(department);
                session.getTransaction().commit();
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
