package fa.ru.demo.mix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@ComponentScan
public interface SportsPlayer {

    void train();
    void print();
}
