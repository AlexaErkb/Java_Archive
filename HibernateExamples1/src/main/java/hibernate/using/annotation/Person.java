package hibernate.using.annotation;

import jakarta.persistence.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Date;
import java.util.Random;

@Entity
@Table(name = "people")
public class Person {

    public Person()
    {

    }
    public Person(String firstName, String surname, String address, java.sql.Date birthday, Integer salary, Integer department_id) {
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.birthday = birthday;
        this.salary = salary;
        this.department_id = department_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "firstname")
    String firstName;
    @Column(name = "surname")
    String surname;

    @Column(name = "address")
    String address;

    @Column(name = "birthday")
    java.sql.Date birthday;

    @Column(name = "salary")
    Integer salary;

    @Column(name = "department_id")
    Integer department_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public java.sql.Date getBirthday() {
        return birthday;
    }

    public void setBirthday(java.sql.Date birthday) {
        this.birthday = birthday;
    }
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", salary='" + salary + '\'' +
                ", department_id='" + department_id + '\'' +
                '}';
    }

    public static Person generateRandomPerson()
    {
        Random random=new Random();
        return  new Person( RandomStringUtils.randomAlphanumeric(random.nextInt(5,100)),
                            RandomStringUtils.randomAlphanumeric(random.nextInt(5,100)),
                            RandomStringUtils.randomAlphanumeric(random.nextInt(5,100)),
                            java.sql.Date.valueOf(RandomStringUtils.randomAlphanumeric(random.nextInt(5,100))),
                            Integer.valueOf(RandomStringUtils.randomAlphanumeric(random.nextInt(5,100))),
                            Integer.valueOf(RandomStringUtils.randomAlphanumeric(random.nextInt(5,100))));

    }
}
