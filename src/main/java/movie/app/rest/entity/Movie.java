package movie.app.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Anurak Sirivoravit
 *
 */
@Entity
@Table(name = "movies")
public class Movie {
	private long id;
	private long oldId;
	private String title;
	private String genres;

	public Movie() {

	}

	public Movie(long oldId, String title, String genres) {
		this.oldId = oldId;
		this.title = title;
		this.genres = genres;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "old_id", nullable = false)
	public long getOldId() {
		return this.oldId;
	}

	public void setOldId(long oldId) {
		this.oldId = oldId;
	}

	@Column(name = "title", nullable = false)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "genres", nullable = false)
	public String getGenres() {
		return this.genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}
}
