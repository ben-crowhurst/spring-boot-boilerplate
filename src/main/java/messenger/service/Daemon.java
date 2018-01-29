package messenger.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages= {"messenger"})
@EnableJpaRepositories(basePackages= {"messenger"})
@SpringBootApplication(scanBasePackages= {"messenger"})
public class Daemon {
    public static void main(String[] arguments) {
        SpringApplication.run(Daemon.class, arguments);
    }
}