package com.surojit.moviebookingapp.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MOVIE")
public class Movie {
	@Id
	private int id;
	private String title;
	
	@Column(name = "releaseDate")
	private String releaseDate;
	
	@Column(name = "showCycle")
	private String showCycle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getShowCycle() {
		return showCycle;
	}

	public void setShowCycle(String showCycle) {
		this.showCycle = showCycle;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, releaseDate, showCycle, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return id == other.id && Objects.equals(releaseDate, other.releaseDate)
				&& Objects.equals(showCycle, other.showCycle) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", releaseDate=" + releaseDate + ", showCycle=" + showCycle
				+ "]";
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(int id, String title, String releaseDate, String showCycle) {
		super();
		this.id = id;
		this.title = title;
		this.releaseDate = releaseDate;
		this.showCycle = showCycle;
	}

}
