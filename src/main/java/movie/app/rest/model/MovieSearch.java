package movie.app.rest.model;

/**
 * 
 * @author Anurak Sirivoravit
 *
 */
public class MovieSearch {
	private String searchBy;
	private String searchString;

	public String getSearchBy() {
		return searchBy;
	}

	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

}
