package fa.ru.demo.mix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Target;

@Component("benzima")
public class FootballPlayer implements SportsPlayer {
    @Value("benzima")
    private String name;
    private String position;
    private double salary;

    private SportsTeam sportsTeam;
    @Autowired
    public FootballPlayer(SportsTeam sportsTeam)
    {
        this.sportsTeam=sportsTeam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public SportsTeam getSportsTeam() {
        return sportsTeam;
    }

    public void setSportsTeam(SportsTeam sportsTeam) {
        this.sportsTeam = sportsTeam;
    }

    @Override
    public void train() {
        System.out.println("I am trainig on football!");
    }

    @Override
    public void print() {
        System.out.println(String.format("name:%s\nposition:%s\nsalary: %f\nteam: %s",name,position,salary,sportsTeam.getName()));
    }
}
