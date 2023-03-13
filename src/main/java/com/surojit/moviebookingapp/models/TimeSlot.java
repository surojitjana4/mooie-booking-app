package com.surojit.moviebookingapp.models;

public class TimeSlot {

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TimeSlot(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public TimeSlot() {
		super();
		// TODO Auto-generated constructor stub
	}

}
