package fa.ru.aop.entities;

import org.springframework.stereotype.Component;

@Component
public class Account {
    private int id;
    private double total;

    public Account() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
