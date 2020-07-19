package movie.app.rest.service;

import java.util.List;

import movie.app.Response;
import movie.app.rest.entity.Movie;
import movie.app.rest.model.MovieSearch;

/**
 * 
 * @author Anurak Sirivoravit
 *
 */
public interface IMovieService {
	public Response<List<Movie>> search(MovieSearch movieSearch);
}
