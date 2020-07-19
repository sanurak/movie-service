package movie.app.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import movie.app.BaseService;
import movie.app.MessageKey;
import movie.app.Response;
import movie.app.rest.entity.Movie;
import movie.app.rest.model.MovieSearch;
import movie.app.rest.repository.MovieRepository;

@Service
public class MovieService extends BaseService implements IMovieService {
	private static final String SEARCH_BY_TITLE = "TITLE";
	private static final String SEARCH_BY_GENRE = "GENRE";
	private static final String SEARCH_BY_YEAR = "YEAR";
	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	public MovieService(MessageSource messageSource) {
		super(messageSource);
	}

	@Override
	public Response<List<Movie>> search(MovieSearch movieSearch) {
		if (StringUtils.isEmpty(movieSearch.getSearchBy())) {
			Response.createError(getMessage(MessageKey.INVALID_SEARCH_TYPE));
		}
		List<Movie> movieList = new ArrayList<Movie>();

		if (SEARCH_BY_TITLE.equalsIgnoreCase(movieSearch.getSearchBy())) {
			movieList = movieRepository.findByTitleStartsWith(movieSearch.getSearchString());
		} else if (SEARCH_BY_GENRE.equalsIgnoreCase(movieSearch.getSearchBy())) {
			movieList = movieRepository.findByGenresContaining(movieSearch.getSearchString());
		} else if (SEARCH_BY_YEAR.equalsIgnoreCase(movieSearch.getSearchBy())) {
			try {
				int year = Integer.parseInt(movieSearch.getSearchString());

				movieList = movieRepository.findByTitleEndsWith("(" + movieSearch.getSearchString() + ")");

			} catch (NumberFormatException e) {
				return Response.createError(
						getMessage(MessageKey.SEARCH_YEAR_NOT_NUMBER, new Object[] { movieSearch.getSearchString() }));
			}

		} else {
			return Response.createError(getMessage(MessageKey.INVALID_SEARCH_TYPE));
		}

		if (movieList.isEmpty()) {
			Response.createSuccess(movieList, getMessage(MessageKey.MOVIES_NOT_FOUND));
		}
		return Response.createSuccess(movieList,
				getMessage(MessageKey.MOVIES_FOUND, new Object[] { movieList.size() }));
	}

}
