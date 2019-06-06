package dk.tracing.tutorial;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class MovieService {

    private final RestTemplate restTemplate;

    public MovieService(RestTemplate rest) {
        this.restTemplate = rest;
    }

    @HystrixCommand(fallbackMethod = "reliable")
    public String movieList() {
        URI uri = URI.create("http://localhost:8090/movies");

        return this.restTemplate.getForObject(uri, String.class);
    }

    public String reliable() {
        return "Sound of Music";
    }

}
