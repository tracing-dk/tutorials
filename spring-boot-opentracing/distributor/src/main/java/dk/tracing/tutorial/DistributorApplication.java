package dk.tracing.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
public class DistributorApplication {

    @RequestMapping(value = "/movies")
    public String movieList() {
        return "Full Metal Jacket, Barry Lyndon, Paths of Glory";
    }

    @RequestMapping(value = "/health")
    public String health() {
        return "OK";
    }

    public static void main(String[] args) {
        SpringApplication.run(DistributorApplication.class, args);
    }
}
