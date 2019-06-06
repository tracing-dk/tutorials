package dk.tracing.tutorial.repository;

import dk.tracing.tutorial.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}