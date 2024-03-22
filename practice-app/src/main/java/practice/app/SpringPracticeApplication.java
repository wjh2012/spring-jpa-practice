package practice.app;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
    "practice.jpa"}, exclude = SecurityAutoConfiguration.class)
@EntityScan(basePackages = {"practice.jpa"})
@EnableJpaRepositories("practice.jpa")
public class SpringPracticeApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SpringPracticeApplication.class, args);
    }
}
