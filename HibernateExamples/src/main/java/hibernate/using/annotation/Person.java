package hibernate.using.annotation;

import jakarta.persistence.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

@Entity
@Table(name = "people")
public class Person {
    public Person()
    {

    }
    public Person(String firstName, String surname, String address) {
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
    }

    @Id
    //@GeneratedValue
    @Column(name = "id")
    int id;
    @Column(name = "firstname")
    String firstName;
    @Column(name = "surname")
    String surname;

    @Column(name = "address")
    String address;

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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static Person generateRandomPerson()
    {
        Random random=new Random();
        return  new Person( RandomStringUtils.randomAlphanumeric(random.nextInt(5,100)),
                            RandomStringUtils.randomAlphanumeric(random.nextInt(5,100)),
                            RandomStringUtils.randomAlphanumeric(random.nextInt(5,100)));

    }
}
