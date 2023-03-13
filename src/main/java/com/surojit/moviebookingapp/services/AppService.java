package com.surojit.moviebookingapp.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.surojit.moviebookingapp.models.Aggregate;
import com.surojit.moviebookingapp.models.Cinema;
import com.surojit.moviebookingapp.models.TimeSlot;
import com.surojit.moviebookingapp.models.User;
import com.surojit.moviebookingapp.models.UserCinema;
import com.surojit.moviebookingapp.repositories.CinemaRepo;
import com.surojit.moviebookingapp.repositories.UserCinemaRepo;
import com.surojit.moviebookingapp.repositories.UserRepo;

@Service
@Transactional
public class AppService {
	@Autowired
	CinemaRepo cinemaRepo;

	@Autowired
	UserCinemaRepo userCinemaRepo;

	@Autowired
	UserRepo userRepo;

	public List<Cinema> getAllCinema() {
		List<Cinema> cinemaList = new ArrayList<Cinema>();
		cinemaRepo.findAll().forEach(cinema -> cinemaList.add(cinema));
		return cinemaList;
	}

	public User getUserInfoByUsername(String username) {
		User userInfo = userRepo.findByUsername(username);
		return userInfo;
	}

	public List<UserCinema> getUserCinemaInfoByUsername(String username) {
		User userInfo = userRepo.findByUsername(username);
		if (userInfo != null)
			return this.getUserByUserId(userInfo.getId());

		return new ArrayList<UserCinema>();
	}

	public List<UserCinema> getUserByUserId(int userId) {
		List<UserCinema> userCinemaList = userCinemaRepo.findByUserId(userId);
		return userCinemaList;
	}

	public HashSet<Aggregate> getBookedMovieDetails(String username) {
		List<UserCinema> userCinemaList = this.getUserCinemaInfoByUsername(username);
		HashSet<Aggregate> bookedMovieList = new HashSet<Aggregate>();
		for (UserCinema userCinema : userCinemaList) {
			Cinema cinema = cinemaRepo.findById(userCinema.getCinemaId()).get();
			bookedMovieList.add(new Aggregate(cinema.getScreen().getMovie().getTitle(), userCinema.getCinemaId(),
					userCinema.getMovieDate(),
					this.getMovieTimeSlotMap().get(Integer.parseInt(userCinema.getMovieTime()))));
		}

		return bookedMovieList;
	}

	public void bookedMovie(String cinemaId, String username, String date, String time) {
		User userInfo = userRepo.findByUsername(username);
		UserCinema uc = new UserCinema();
		uc.setCinemaId(Integer.parseInt(cinemaId));
		uc.setUserId(userInfo.getId());
		uc.setMovieDate(date);
		uc.setMovieTime(time);
		userCinemaRepo.save(uc);
	}

	public List<TimeSlot> getMovieTimeSlot() {
		List<TimeSlot> movieSlotList = new ArrayList<TimeSlot>();
		movieSlotList.add(new TimeSlot(9, "9 AM"));
		movieSlotList.add(new TimeSlot(11, "11 AM"));
		movieSlotList.add(new TimeSlot(1, "1 PM"));
		movieSlotList.add(new TimeSlot(3, "3 PM"));
		movieSlotList.add(new TimeSlot(5, "5 PM"));
		movieSlotList.add(new TimeSlot(7, "7 PM"));
		movieSlotList.add(new TimeSlot(10, "10 PM"));
		return movieSlotList;
	}

	public Map<Integer, String> getMovieTimeSlotMap() {

		Map<Integer, String> timeslot = new HashMap<Integer, String>();
		timeslot.put(9, "9 AM");
		timeslot.put(11, "11 AM");
		timeslot.put(1, "1 PM");
		timeslot.put(3, "3 PM");
		timeslot.put(5, "5 PM");
		timeslot.put(7, "7 PM");
		timeslot.put(10, "10 PM");
		return timeslot;
	}

	public void deleteBooking(Aggregate agg) {
		System.out.println("userId-----------"+agg.getUserId());
		System.out.println("cinemaId-----------"+agg.getCinemaId());
		int deleted = userCinemaRepo.deleteByUserIdAndCinemaId(agg.getUserId(), agg.getCinemaId());
		System.out.println("-------======---------" + deleted);
	}

}