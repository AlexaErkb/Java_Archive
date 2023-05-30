package hibernate.using.annotation;

import jakarta.persistence.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

@Entity
@Table(name = "department")
public class Department {
    public Department()
    {

    }
    public Department(String department_name, String description, Integer director) {
        this.department_name = department_name;
        this.description = description;
        this.director = director;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "department_name")
    String department_name;
    @Column(name = "description")
    String description;

    @Column(name = "director")
    Integer director;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDirector() {
        return director;
    }

    public void setDirector(Integer director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", department_name='" + department_name + '\'' +
                ", description='" + description + '\'' +
                ", director='" + director + '\'' +
                '}';
    }
}
