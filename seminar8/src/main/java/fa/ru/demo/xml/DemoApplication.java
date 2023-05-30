package fa.ru.demo.xml;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("fa/ru/demo/xml/applicationContext.xml");
		SportsPlayer player=context.getBean("benzima",SportsPlayer.class);
		player.print();
		player.train();
		context.close();

	}

}
