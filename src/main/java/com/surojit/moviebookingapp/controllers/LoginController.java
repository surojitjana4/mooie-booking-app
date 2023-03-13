package com.surojit.moviebookingapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.surojit.moviebookingapp.models.Aggregate;
import com.surojit.moviebookingapp.models.User;
import com.surojit.moviebookingapp.services.AppService;

@Controller
public class LoginController {

	@Autowired
	AppService service;

	@GetMapping("/")
	public String showLoginPage() {
		return "index";
	}

	@GetMapping("/dashboard")
	public String renderToDashboard(User user, Model model) {
		User userInfo = service.getUserInfoByUsername(user.getUsername());
		if (userInfo != null) {
			model.addAttribute("timeslot", service.getMovieTimeSlot());
			model.addAttribute("user", userInfo);
			model.addAttribute("cinemaInfo", service.getAllCinema());
			model.addAttribute("bookedMovies", service.getBookedMovieDetails(user.getUsername()));
			model.addAttribute("msg", "");
			return "home";
		}
		model.addAttribute("msg", "Incorrece username. Please enter correct username.");
		return "index";
	}

	@PostMapping("/bookmovie")
	public String getAllMovies(Aggregate agg) {
		service.bookedMovie(agg.getCinemaId() + "", agg.getUsername(), agg.getDate(), agg.getTime());
		return "index";
	}

	@DeleteMapping("/delete_booking")
	public String deleteBooking(Aggregate agg) {
		service.deleteBooking(agg);
		return "index";
	}

}