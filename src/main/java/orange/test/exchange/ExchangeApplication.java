package orange.test.exchange;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

@SpringBootApplication
@EnableR2dbcAuditing
public class ExchangeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
