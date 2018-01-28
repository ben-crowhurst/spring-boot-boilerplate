package messenger.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"messenger"})
public class Daemon {
    public static void main(String[] arguments) {
        SpringApplication.run(Daemon.class, arguments);
    }
}