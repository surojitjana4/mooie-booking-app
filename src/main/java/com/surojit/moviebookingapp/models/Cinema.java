package com.surojit.moviebookingapp.models;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Cinema {
	@Id
	private int id;

	@Column(name = "screenType")
	private String type;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "screenId")
	private Screen screen;

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

	@Override
	public int hashCode() {
		return Objects.hash(id, screen, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cinema other = (Cinema) obj;
		return id == other.id && screen == other.screen && Objects.equals(type, other.type);
	}

	public Cinema(int id, String type, Screen screen) {
		super();
		this.id = id;
		this.type = type;
		this.screen = screen;
	}

	@Override
	public String toString() {
		return "Cinema [id=" + id + ", type=" + type + ", screen=" + screen + "]";
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Cinema() {
		super();
	}

}
