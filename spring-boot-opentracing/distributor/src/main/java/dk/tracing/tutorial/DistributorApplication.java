package dk.tracing.tutorial;

import com.google.common.collect.Lists;
import dk.tracing.tutorial.model.Movie;
import dk.tracing.tutorial.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@RestController
@SpringBootApplication
public class DistributorApplication {

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping(value = "/movies")
    public String movieList() {
        return Lists.newArrayList(
                movieRepository.findAll())
                .stream()
                .map(Movie::getTitle)
                .collect(Collectors.joining(", "));
    }

    @RequestMapping(value = "/health")
    public String health() {
        return "OK";
    }

    public static void main(String[] args) {
        SpringApplication.run(DistributorApplication.class, args);
    }
}
