package fa.ru.demo.code;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		SportsPlayer player=context.getBean("benzima", SportsPlayer.class);
		player.print();
		player.train();
		context.close();

	}

}
