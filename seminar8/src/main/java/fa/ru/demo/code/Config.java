package fa.ru.demo.code;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean(name = "benzima")
    public FootballPlayer benzima(SportsTeam sportsTeam) {
        return new FootballPlayer(sportsTeam);
    }

    @Bean
    public SportsTeam team() {
        return new SportsTeam();
    }
}