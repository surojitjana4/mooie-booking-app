package com.surojit.moviebookingapp.models;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Screen {
	@Id
	private int id;

	@Column(name = "screenType")
	private String type;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "movieId")
	private Movie movie;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, movie, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Screen other = (Screen) obj;
		return id == other.id && movie == other.movie && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Screen [id=" + id + ", type=" + type + ", movie=" + movie + "]";
	}

	public Screen(int id, String type, Movie movie) {
		super();
		this.id = id;
		this.type = type;
		this.movie = movie;
	}

	public Screen() {
		super();
	}

}
