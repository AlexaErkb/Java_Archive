package fa.ru.demo.xml;

public class FootballPlayer implements SportsPlayer {
    private String name;
    private String position;
    private double salary;
    private SportsTeam sportsTeam;

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
