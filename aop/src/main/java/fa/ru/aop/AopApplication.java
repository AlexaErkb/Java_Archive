package fa.ru.aop;

import fa.ru.aop.dao.AccountDAO;
import fa.ru.aop.entities.Account;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		//SpringApplication.run(AopApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		AccountDAO theAccountDAO =context.getBean("accountDAO", AccountDAO.class);
		Account account =context.getBean("account", Account.class);
		//theAccountDAO.addAccount(account);
		//theAccountDAO.nextAccount(account);
		System.out.println(theAccountDAO.makeSomeOperation(-1, 2));

		context.close();

	}



}
