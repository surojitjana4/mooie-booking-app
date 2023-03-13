package com.surojit.moviebookingapp.models;

import java.util.Objects;

public class Aggregate {

	private int movieId;
	private String title;
	private String releaseDate;
	private String showCycle;

	private int cinemaId;
	private String CinemaType;
	private int screenId;

	private String screenType;

	private int userId;
	private String username;
	private int bookedCinemas;

	private String date;
	private String time;

	public Aggregate(int movieId, String title, String releaseDate, String showCycle, int cinemaId, String cinemaType,
			int screenId, String screenType, int userId, String username, int bookedCinemas, String date, String time) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.releaseDate = releaseDate;
		this.showCycle = showCycle;
		this.cinemaId = cinemaId;
		CinemaType = cinemaType;
		this.screenId = screenId;
		this.screenType = screenType;
		this.userId = userId;
		this.username = username;
		this.bookedCinemas = bookedCinemas;
		this.date = date;
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
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

	public int getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}

	public String getCinemaType() {
		return CinemaType;
	}

	public void setCinemaType(String cinemaType) {
		CinemaType = cinemaType;
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public String getScreenType() {
		return screenType;
	}

	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getBookedCinemas() {
		return bookedCinemas;
	}

	public void setBookedCinemas(int bookedCinemas) {
		this.bookedCinemas = bookedCinemas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CinemaType, bookedCinemas, cinemaId, date, movieId, releaseDate, screenId, screenType,
				showCycle, time, title, userId, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aggregate other = (Aggregate) obj;
		return Objects.equals(CinemaType, other.CinemaType) && bookedCinemas == other.bookedCinemas
				&& cinemaId == other.cinemaId && Objects.equals(date, other.date) && movieId == other.movieId
				&& Objects.equals(releaseDate, other.releaseDate) && screenId == other.screenId
				&& Objects.equals(screenType, other.screenType) && Objects.equals(showCycle, other.showCycle)
				&& Objects.equals(time, other.time) && Objects.equals(title, other.title) && userId == other.userId
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Aggregate [movieId=" + movieId + ", title=" + title + ", releaseDate=" + releaseDate + ", showCycle="
				+ showCycle + ", cinemaId=" + cinemaId + ", CinemaType=" + CinemaType + ", screenId=" + screenId
				+ ", screenType=" + screenType + ", userId=" + userId + ", username=" + username + ", bookedCinemas="
				+ bookedCinemas + ", date=" + date + ", time=" + time + "]";
	}

	public Aggregate(int movieId, String title, String releaseDate, String showCycle, int cinemaId, String cinemaType,
			int screenId, String screenType, int userId, String username, int bookedCinemas) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.releaseDate = releaseDate;
		this.showCycle = showCycle;
		this.cinemaId = cinemaId;
		CinemaType = cinemaType;
		this.screenId = screenId;
		this.screenType = screenType;
		this.userId = userId;
		this.username = username;
		this.bookedCinemas = bookedCinemas;
	}

	public Aggregate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aggregate(String title, int cinemaId, String date, String time) {
		super();
		this.title = title;
		this.cinemaId = cinemaId;
		this.date = date;
		this.time = time;
	}
}
