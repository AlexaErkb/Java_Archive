package fa.ru.ioc.demo;

import org.apache.logging.log4j.LogManager;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		//SportsPlayer player=new FootballPlayer();
		//SportsPlayer player=new BasketballPlayer();
		//SportsPlayer player=new GolfPlayer();
		//player.train();

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("fa.ru.ioc.demo/applicationContext.xml");
		context.getBean("player",SportsPlayer.class).train();
	}

}
