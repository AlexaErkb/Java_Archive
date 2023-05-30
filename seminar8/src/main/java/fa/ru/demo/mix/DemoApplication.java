package fa.ru.demo.mix;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("fa/ru/demo/mix/applicationContext.xml");
		SportsPlayer player=context.getBean("benzima", SportsPlayer.class);
		player.print();
		player.train();
		context.close();
	}

}
