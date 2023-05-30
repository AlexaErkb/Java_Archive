package fa.ru.aop.dao;

import fa.ru.aop.entities.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount(Account account) {
        System.out.println(getClass()+ ": DOING MY DB WORK: ADDING AN....");
    }
    public void nextAccount(Account account) {
        System.out.println(getClass()+ ": WHAT IS IT....");
    }
    public  Integer makeSomeOperation(int a, int b) {
    return a+b;
    }
}
