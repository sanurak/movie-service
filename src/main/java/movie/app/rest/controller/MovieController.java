package movie.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import movie.app.Response;
import movie.app.rest.entity.Movie;
import movie.app.rest.model.MovieSearch;
import movie.app.rest.service.MovieService;

/**
 * RestController for Movie.
 * 
 * @author Anurak Sirivoravit
 *
 */
@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
	@Autowired
	private MovieService movieService;

	@GetMapping(consumes = "application/json", produces = "application/json")
	public Response<List<Movie>> jsonMovieSearch(@RequestBody MovieSearch movieSearch) {
		return movieService.search(movieSearch);
	}
}
