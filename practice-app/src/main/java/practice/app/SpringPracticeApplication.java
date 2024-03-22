package practice.app;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"practice"})
public class SpringPracticeApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SpringPracticeApplication.class, args);
    }
}
