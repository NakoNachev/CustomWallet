package customwallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("customwallet")
//@ComponentScan(basePackages="customwallet")
public class CustomWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomWalletApplication.class, args);
	}

}
