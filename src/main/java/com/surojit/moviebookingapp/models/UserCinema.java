package com.surojit.moviebookingapp.models;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER_CINEMA_MAP")
public class UserCinema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String movieTime;
	private String movieDate;

	public UserCinema(int id, String movieTime, String movieDate, int cinemaId, int userId) {
		super();
		this.id = id;
		this.movieTime = movieTime;
		this.movieDate = movieDate;
		this.cinemaId = cinemaId;
		this.userId = userId;
	}

	public String getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}

	public String getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int cinemaId;

	private int userId;

	public UserCinema() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cinemaId, id, movieDate, movieTime, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserCinema other = (UserCinema) obj;
		return cinemaId == other.cinemaId && id == other.id && Objects.equals(movieDate, other.movieDate)
				&& Objects.equals(movieTime, other.movieTime) && userId == other.userId;
	}

	@Override
	public String toString() {
		return "UserCinema [id=" + id + ", movieTime=" + movieTime + ", movieDate=" + movieDate + ", cinemaId="
				+ cinemaId + ", userId=" + userId + "]";
	}
}
