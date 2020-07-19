package movie.app.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import movie.app.rest.entity.Movie;

/**
 * 
 * @author Anurak Sirivoravit
 *
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	List<Movie> findByTitleEndsWith(String title);

	List<Movie> findByTitleStartsWith(String title);

	List<Movie> findByGenresContaining(String genre);
}
